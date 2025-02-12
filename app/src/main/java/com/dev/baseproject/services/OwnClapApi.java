package com.dev.baseproject.services;

import com.musicg.api.DetectionApi;
import com.musicg.math.rank.ArrayRankDouble;
import com.musicg.math.statistics.StandardDeviation;
import com.musicg.wave.WaveHeader;

public class OwnClapApi extends DetectionApi {
    private double currentAmbientNoise;

    public OwnClapApi(WaveHeader waveHeader) {
        super(waveHeader);
    }

    @Override
    protected void init() {
        minFrequency = 100.0f;
        maxFrequency = 10000.0f;

        minIntensity = 10000.0f;
        maxIntensity = 100000.0f;

        minStandardDeviation = 0.0f;
        maxStandardDeviation = 0.1f;

        highPass = 500;
        lowPass = 10000;

        minNumZeroCross = 50;
        maxNumZeroCross = 600;

        numRobust = 5;
    }

    @Override
    protected boolean isPassedFrequency(double[] spectrum) {
        // find the robust frequency
        ArrayRankDouble arrayRankDouble = new ArrayRankDouble();
        double robustFrequency = arrayRankDouble.getMaxValueIndex(spectrum) * unitFrequency;

        // frequency of the sound should not be too low or too high
        boolean result = (robustFrequency >= minFrequency && robustFrequency <= maxFrequency);
        System.out.println("ownclap: freq: " + robustFrequency + " " + result);
        return result;
    }

    @Override
    protected boolean isPassedIntensity(double[] spectrum) {
        // get the average intensity of the signal
        double intensity = 0;
        for (int i = 0; i < spectrum.length; i++) {
            intensity += spectrum[i];
        }
        intensity /= spectrum.length;
        // end get the average intensity of the signal

        // intensity of the whistle should not be too soft
        boolean result = (intensity > minIntensity && intensity <= maxIntensity);
        System.out.println("ownclap: intensity: " + intensity + ",  min: " + minIntensity + ", max: " + maxIntensity + ", result:" + result);

        return result;

    }

    @Override
    protected boolean isPassedStandardDeviation(double[][] spectrogramData) {
        // normalize the spectrogramData (with all frames in the spectrogram)
        normalizeSpectrogramData(spectrogramData);

        // analyst data in this frame
        // since fftSampleSize==numSamples, there're only one spectrum which is spectrogramData[last]
        double[] spectrum = spectrogramData[spectrogramData.length - 1];
        // find top most robust frequencies in this frame
        double[] robustFrequencies = new double[numRobust];
        ArrayRankDouble arrayRankDouble = new ArrayRankDouble();
        double nthValue = arrayRankDouble.getNthOrderedValue(spectrum, numRobust, false);
        // end analyst data in this frame

        int count = 0;
        for (int i = 0; i < spectrum.length; i++) {
            if (spectrum[i] >= nthValue) {
                robustFrequencies[count++] = spectrum[i];
                if (count >= numRobust) {
                    break;
                }
            }
        }
        // end find top most robust frequencies

        StandardDeviation standardDeviation = new StandardDeviation();
        standardDeviation.setValues(robustFrequencies);
        double sd = standardDeviation.evaluate();

        // range of standard deviation
        boolean result = (sd >= minStandardDeviation && sd <= maxStandardDeviation);
        System.out.println("ownclap: sd: " + sd + " min: " + minStandardDeviation + " max: " + maxStandardDeviation + " and result: " + result);
        return result;
    }

    /**
     * Detects if the audio buffer contains a valid clap sound as part of a double-clap pattern
     */
    public boolean isClap(byte[] audioBytes) {
        byte[] processedSignal = preProcessSignal(audioBytes);

        updateAmbientNoise(processedSignal);

        if (isSpecificSound(audioBytes)) {
            return true;
        }
        return false;
    }

    private byte[] preProcessSignal(byte[] input) {
        // Convert to shorts for processing
        short[] samples = new short[input.length / 2];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = (short)((input[2*i] & 0xFF) | (input[2*i+1] << 8));
        }

        // Apply noise reduction
        removeBackgroundNoise(samples);

        // Convert back to bytes
        byte[] processed = new byte[input.length];
        for (int i = 0; i < samples.length; i++) {
            processed[2*i] = (byte)(samples[i] & 0xFF);
            processed[2*i+1] = (byte)((samples[i] >> 8) & 0xFF);
        }

        return processed;
    }

    private void removeBackgroundNoise(short[] samples) {
        double noiseThreshold = currentAmbientNoise * 1.2; // 20% above ambient
        for (int i = 0; i < samples.length; i++) {
            if (Math.abs(samples[i]) < noiseThreshold) {
                samples[i] = 0;
            }
        }
    }

    private void updateAmbientNoise(byte[] signal) {
        // Calculate RMS of the signal
        double sum = 0;
        for (int i = 0; i < signal.length; i += 2) {
            short sample = (short)((signal[i] & 0xFF) | (signal[i+1] << 8));
            sum += sample * sample;
        }
        double rms = Math.sqrt(sum / (signal.length / 2));

        // Smooth the ambient noise level
        currentAmbientNoise = currentAmbientNoise * 0.9 + rms * 0.1;
    }
}
