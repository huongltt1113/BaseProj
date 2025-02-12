package com.dev.baseproject.server;

import com.musicg.api.DetectionApi;
import com.musicg.wave.WaveHeader;

public class ClapApi extends DetectionApi {

    public ClapApi(WaveHeader waveHeader) {
        super(waveHeader);
    }

    protected void init(){
        minFrequency = 600.0f;
        maxFrequency = Double.MAX_VALUE;

        minIntensity = 10000.0f;
        maxIntensity = 100000.0f;

        minStandardDeviation = 0.0f;
        maxStandardDeviation = 0.05f;

        highPass = 300;
        lowPass = 10000;

        minNumZeroCross = 50;
        maxNumZeroCross = 800;

        numRobust = 4;
    }

    public boolean isClap(byte[] audioBytes){
        return isSpecificSound(audioBytes);
    }
}