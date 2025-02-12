package com.dev.baseproject.services;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.util.Log;

import com.musicg.wave.WaveHeader;

import java.util.LinkedList;
import java.util.Vector;

public class DetectorThread extends Thread {
    private volatile Thread _thread;
    private final OwnClapApi clapApi;
    private final int clapCheckLength = 2;
    private final int clapPassScore = 2;
    private final LinkedList<Boolean> clapResultList = new LinkedList<>();
    String clapValue;
    private int numClaps;

    int requiredClapCount = 2;
    private OnServiceRestartListener onRestartListener;
    private OnSignalsDetectedListener onSignalsDetectedListener;
    private final RecorderThread recorder;
    private final WaveHeader waveHeader;
    private final AudioManager audioManager;

    Vector<Long> claps;
    int maxDistance = 800;
    int minDistance = 50;

    private final long lastTimeDetectClap = 0L;

    public void setOnRestartListener(OnServiceRestartListener onServiceRestartListener) {
        if (this.onRestartListener == null) {
            this.onRestartListener = onServiceRestartListener;
        }
    }

    public void setOnSignalsDetectedListener(OnSignalsDetectedListener onSignalsDetectedListener2) {
        if (this.onSignalsDetectedListener == null) {
            this.onSignalsDetectedListener = onSignalsDetectedListener2;
        }
    }

    public void stopDetection() {
        this._thread = null;
    }

    public DetectorThread(RecorderThread recorderThread, String str, Context context) {
        int i = 1;
        this.clapValue = str;
        this.recorder = recorderThread;
        AudioRecord audioRecord = recorderThread.getAudioRecord();
        int i2 = audioRecord.getAudioFormat() == 2 ? 16 : audioRecord.getAudioFormat() == 3 ? 8 : 0;
        WaveHeader waveHeader2 = new WaveHeader();
        this.waveHeader = waveHeader2;
        this.audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        waveHeader2.setChannels(audioRecord.getChannelConfiguration() != 16 ? 0 : i);
        this.waveHeader.setBitsPerSample(i2);
        this.waveHeader.setSampleRate(audioRecord.getSampleRate());
        this.clapApi = new OwnClapApi(this.waveHeader);

        claps = new Vector<Long>();
    }

    void initBuffer() {
        this.numClaps = 0;
        this.clapResultList.clear();
        for (int i = 0; i < this.clapCheckLength; i++) {
            this.clapResultList.add(false);
        }
    }

    @Override
    public void start() {
//        this._thread = null;
        this._thread = new Thread(this);
        this._thread.start();
    }

    @Override
    public void run() {
        try {
            byte[] buffer;

            Thread thisThread = Thread.currentThread();
            while (_thread == thisThread && _thread != null) {
                if(audioManager.isMusicActive()){
                    continue;
                }
                //detect sound
                buffer = recorder.getFrameBytes();
                if (buffer != null) {
                    //check for claps!
                    boolean isClap = clapApi.isClap(buffer);
                    long currentTime = System.currentTimeMillis();
                    Log.e("Mitch", "isClap = " + isClap + " currentTime = " + currentTime);
                    if (isClap) {
                        claps.add(currentTime);
                    }
                    //if last clap is expired clear list
                    if (claps.size() > 0) {
                        if (currentTime - claps.get(claps.size() - 1) > maxDistance) {
                            claps.clear();
                        }
                    }

                    for (int i = 0; i < claps.size() - 1; i++) {
                        if (claps.get(i + 1) - claps.get(i) < minDistance) {
                            claps.remove(i);
                            break;
                        }
                        if (claps.get(i + 1) - claps.get(i) > maxDistance) {
                            claps.remove(i);
                            break;
                        }
                    }

                    Log.e("Mitch", "claps = " + claps.size());
                    if (claps.size() >= requiredClapCount) {
                        stopDetection();
                        claps.clear();
                        onClapDetected();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.onRestartListener.onRestart();
        }
    }


    private void onClapDetected() {
        OnSignalsDetectedListener onSignalsDetectedListener2 = this.onSignalsDetectedListener;
        if (onSignalsDetectedListener2 != null) {
            onSignalsDetectedListener2.onClapDetected();
        }
    }


    public void restartDetection() {
        System.out.println("Restarting detection");
        stopDetection();
        initBuffer();
        this._thread = new Thread(this);
        this._thread.start();
    }

    public boolean isRunning() {
        return this._thread != null && this._thread.isAlive();
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
