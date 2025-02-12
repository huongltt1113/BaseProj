package com.dev.baseproject.services;

import android.annotation.SuppressLint;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

public class RecorderThread extends Thread {
    private int audioEncoding = 2;
    private AudioRecord audioRecord;
    byte[] buffer;
    private int channelConfiguration = AudioFormat.CHANNEL_IN_MONO;
    private int frameByteSize = 2048;
    private boolean isRecording = false;
    private int sampleRate = 44100;
    int audioFormat = AudioFormat.ENCODING_PCM_16BIT; // PCM 16-bit

    // Lấy kích thước tối thiểu của bộ đệm
    int bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfiguration, audioFormat);

    public AudioRecord getAudioRecord() {
        return this.audioRecord;
    }

    @SuppressLint("MissingPermission")
    public RecorderThread() {
        try {
            this.audioRecord = new AudioRecord(
                    MediaRecorder.AudioSource.MIC,
                    44100, // Tần số lấy mẫu
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    bufferSize
            );
//            this.audioRecord = new AudioRecord(1, 44100, channelConfiguration, 2, AudioRecord.getMinBufferSize(44100, channelConfiguration, 2));
            this.buffer = new byte[this.frameByteSize];
        } catch (Exception unused) {
        }
    }

    public boolean isRecording() {
        return isAlive() && this.isRecording;
    }

    public void startRecording() {
        try {
            this.audioRecord.startRecording();
            this.isRecording = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        try {
            this.audioRecord.stop();
            this.audioRecord.release();
            this.isRecording = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getFrameBytes() {
        int i;
        int i2 = 0;
        this.audioRecord.read(this.buffer, 0, this.frameByteSize);
        int i3 = 0;
        while (true) {
            i = this.frameByteSize;
            if (i2 >= i) {
                break;
            }
            byte[] bArr = this.buffer;
            i3 += Math.abs((short) (bArr[i2] | (bArr[i2 + 1] << 8)));
            i2 += 2;
        }
        Log.e("Mitch", "buffer = " + ((float) ((i3 / i) / 2)));
        if (((float) ((i3 / i) / 2)) < 80.0f) {
            return null;
        }
        return this.buffer;
    }

//    public byte[] getFrameBytes() {
//        int i2 = 0;
//        this.audioRecord.read(this.buffer, 0, this.frameByteSize);
//
//        // Tính năng lượng RMS
//        int i3 = 0;
//        while (i2 < this.frameByteSize) {
//            byte[] bArr = this.buffer;
//            short sample = (short) (bArr[i2] | (bArr[i2 + 1] << 8));
//            i3 += sample * sample;
//            i2 += 2;
//        }
//        float rms = (float) Math.sqrt(i3 / (this.frameByteSize / 2));
//
//        // Ngưỡng RMS động
//        float noiseThreshold = calculateNoiseThreshold();
//        if (rms < noiseThreshold) {
//            return null;
//        }
//
//        // Xử lý thêm: Phát hiện đột biến biên độ
//        float currentAmplitude = calculateAmplitudeDelta(this.buffer, this.frameByteSize);
//        if (Math.abs(currentAmplitude - previousAmplitude) > AMPLITUDE_THRESHOLD) {
//            long currentTime = System.currentTimeMillis();
//            if (currentTime - lastClapTime < 500) {
//                clapCount++;
//            } else {
//                clapCount = 1;
//            }
//            lastClapTime = currentTime;
//
//            if (clapCount >= 2) {
//                // Xác nhận tiếng vỗ tay
//                return this.buffer;
//            }
//        }
//        previousAmplitude = currentAmplitude;
//
//        return null;
//    }
//
//    private float calculateAmplitudeDelta(byte[] buffer, int frameSize) {
//        int i = 0;
//        int sum = 0;
//        for (int j = 0; j < frameSize; j += 2) {
//            short sample = (short) (buffer[j] | (buffer[j + 1] << 8));
//            sum += Math.abs(sample);
//        }
//        return (float) sum / (frameSize / 2); // Tính trung bình biên độ
//    }
//
//    private float calculateNoiseThreshold() {
//        int noiseSamples = 5; // Số lần lấy mẫu
//        int bufferSize = this.frameByteSize;
//        byte[] tempBuffer = new byte[bufferSize];
//        int totalEnergy = 0;
//
//        for (int i = 0; i < noiseSamples; i++) {
//            this.audioRecord.read(tempBuffer, 0, bufferSize); // Đọc tiếng ồn nền
//            totalEnergy += calculateEnergy(tempBuffer, bufferSize); // Tính năng lượng
//        }
//
//        return (float) totalEnergy / noiseSamples; // Trả về ngưỡng trung bình
//    }
//
//    private int calculateEnergy(byte[] buffer, int frameSize) {
//        int sum = 0;
//        for (int i = 0; i < frameSize; i += 2) {
//            short sample = (short) (buffer[i] | (buffer[i + 1] << 8)); // Lấy giá trị mẫu âm thanh
//            sum += sample * sample; // Tính năng lượng (square sum)
//        }
//        return sum / (frameSize / 2); // Trả về năng lượng trung bình
//    }

    @Override
    public void run() {
        startRecording();
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
