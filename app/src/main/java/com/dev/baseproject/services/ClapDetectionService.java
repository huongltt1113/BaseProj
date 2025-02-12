package com.dev.baseproject.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.dev.baseproject.App;
import com.dev.baseproject.R;
import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.ui.MainActivity;
import com.dev.baseproject.ui.component.findphone.PhoneFoundActivity;
import com.dev.baseproject.ui.component.notification.MainActivityNotification;
import com.dev.baseproject.utils.Constants;

import java.util.Locale;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ClapDetectionService extends Service {
    @Inject
    LocalStorage localStorage;
    private static final String CHANNEL_ID = "ClapDetectionChannel";
    private static final String TAG = "ClapDetectionService";
    public static Boolean isservicerunning = false;
    private Thread blinkingThread;
    CameraManager cameraManager;
    private final Runnable checkPlaybackStatusRunnable = new Runnable() {
        @Override
        public void run() {
            ClapDetectionService.this.broadcastPlaybackStatus(ClapDetectionService.this.mediaPlayer != null && ClapDetectionService.this.mediaPlayer.isPlaying());
            ClapDetectionService.this.handlerformediaplayer.postDelayed(this, 1000);
        }
    };
    private LocalStorage getLocalStorage() {
        return ((App) getApplicationContext()).localStorage;
    }
    int delay = 1200;
    private DetectorThread detectorThread;
    long duration = 15000L;
    private final Handler handler = new Handler();

    public Handler handlerformediaplayer = new Handler();
    private Handler handlerforsound;

    public boolean isBlinking = false;
    private boolean isTorchOn = false;
    private Boolean isclapping = false;
    Camera.Parameters mParams;
    MediaPlayer mediaPlayer;
    private RecorderThread recorderThread;
    private Runnable runnable;
    Camera screen_camera;
    private Intent intent;
    private final Runnable stopPlaybackRunnable = new Runnable() {
        @Override
        public void run() {
            stopPlayback();
            stopBlinking();
            stopVibration();
        }
    };
    public Vibrator vibrator;
    private DetectorThread detectorThread2;
    PowerManager.WakeLock wakeLock;
    Context localizeContext;

    private boolean isBroadcastReceived = false;
    private BroadcastReceiver stopMusicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(isBroadcastReceived){
                return;
            }
            isBroadcastReceived = true;
            if (Constants.INTENT_CLAP_STOP_MUSIC.equals(intent.getAction())
                    || Constants.INTENT_CLAP_DURATION_COMPLETE.equals(intent.getAction())) {
                stopPlayback();
                stopBlinking();
                stopVibration();
                if(isservicerunning){
                    updateNotificationToMain();
//                    initDetectorThread();
//                    if(recorderThread != null) {
//                        recorderThread.startRecording();
//                    }
//                    if(detectorThread2 != null) {
//                        detectorThread2.start();
//                    }
                    detectorThread2.restartDetection();
                }
                handlerforsound.removeCallbacks(stopPlaybackRunnable);
            }
        }
    };

    private BroadcastReceiver updateLocale = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateLocalizeContext();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void broadcastPlaybackStatus(boolean z) {
        Intent intent = new Intent("com.dev.baseproject.services.PLAYBACK_STATUS");
        intent.putExtra("is_playing", z);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void broadcastDurationComplete() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Constants.INTENT_CLAP_DURATION_COMPLETE));
    }
    private void updateNotificationToMain() {
        intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(localizeContext.getString(R.string.app_name))
                .setContentText(localizeContext.getString(R.string.clap_service_is_running))
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setOngoing(true);

        notificationManager.notify(1, builder.build());
    }
    private void updateNotificationToPhoneFound() {
        intent = new Intent(this, PhoneFoundActivity.class);
        intent.putExtra("SOURCE", "FROM_NOTIFICATION");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(localizeContext.getString(R.string.app_name))
                .setContentText(localizeContext.getString(R.string.congratulations_nyou_have_found_your_phone))
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                .setOngoing(true);

        notificationManager.notify(1, builder.build());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("OnCreate ClapDetectionService called");
        updateLocalizeContext();
        intent = new Intent(this, MainActivity.class);
        this.handlerforsound = new Handler();
        isservicerunning = true;
        this.handlerformediaplayer.post(this.checkPlaybackStatusRunnable);
        this.duration = getLocalStorage().getTimeDuration();
        this.delay = getLocalStorage().getFlashSpeed();
        initDetectorThread();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.INTENT_CLAP_STOP_MUSIC);
        LocalBroadcastManager.getInstance(this).registerReceiver(stopMusicReceiver, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(updateLocale, new IntentFilter(Constants.SERVICE_CLAP_UPDATE_LOCALE));

        Vibrator vibrator2;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            VibratorManager vibratorManager =
                    (VibratorManager) getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
            vibrator2 = vibratorManager.getDefaultVibrator();
        } else {
            vibrator2 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        }
        this.vibrator = vibrator2;
    }

    private void initDetectorThread(){
//        if(detectorThread2 != null){
//            detectorThread2.stopDetection();
//            detectorThread2.interrupt();
//            try{
//                detectorThread2.join(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            detectorThread2 = null;
//        }
//        if(recorderThread != null){
//            recorderThread.stopRecording();
//            recorderThread.interrupt();
//            try {
//                recorderThread.join(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            recorderThread = null;
//        }
        this.recorderThread = new RecorderThread();
        detectorThread2 = new DetectorThread(this.recorderThread, "YES", this);
//        detectorThread2.initBuffer();
        this.detectorThread = detectorThread2;
        detectorThread2.setOnSignalsDetectedListener(() -> {
            if (!isclapping) {
                isBroadcastReceived = false;
                Log.d(TAG, "c: detectorThread = new DetectorThread(recorderThread, \"YES\");");
                playSound(duration);
                startblinking(duration);
                startvibration(duration);
                LocalBroadcastManager.getInstance(ClapDetectionService.this).sendBroadcast(new Intent(Constants.INTENT_SERVICE_EVENT));
                getLocalStorage().setClapServiceDetected(true);
                showNoti2();
                detectorThread2.stopDetection();
//                detectorThread2.interrupt();
//                detectorThread2 = null;
                this.detectorThread.stopDetection();
            }
        });
        this.detectorThread.setOnRestartListener(() -> detectorThread.restartDetection());
    }

    private void startvibration(long i) {
        if (getLocalStorage().isVibrationEnabled()) {
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.vibrator.vibrate(VibrationEffect.createWaveform(new long[]{1000, 1000, 1000, 1000}, 0));
                } else {
                    this.vibrator.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                }
                if (i != Constants.VALUE_DURATION_LOOP) {
                    Runnable run1 = new Runnable() {
                        @Override
                        public void run() {
                            ClapDetectionService.this.vibrator.cancel();
                        }
                    };
                    this.runnable = run1;
                    this.handler.postDelayed(run1, (long) i);
                }
            }
        }
    }

    private void startblinking(final long i1) {
        Thread thread = this.blinkingThread;
        if (thread == null || !thread.isAlive()) {
            this.isBlinking = true;
            this.blinkingThread = new Thread() {
                @Override
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = 0;
                    while (blinkingThread != null && !blinkingThread.isInterrupted()) {
                        int i = 0;
                        if (i1 != Constants.VALUE_DURATION_LOOP && !ClapDetectionService.this.isBlinking || j >= ((long) i1)) {
                            ClapDetectionService.this.turnOff();
                        } else {
                            try {
                                ClapDetectionService clapDetectionService = ClapDetectionService.this;
                                clapDetectionService.cameraManager = (CameraManager) clapDetectionService.getSystemService(Context.CAMERA_SERVICE);
                                while (true) {
                                    if (i >= 3 || !ClapDetectionService.this.isBlinking) {
                                        break;
                                    } else if (i1 != Constants.VALUE_DURATION_LOOP && System.currentTimeMillis() - currentTimeMillis >= ((long) i1)) {
                                        break;
                                    } else {
                                        ClapDetectionService.this.toggleFlashLight();
                                        sleep(ClapDetectionService.this.delay);
                                        i++;
                                    }
                                }
                                ClapDetectionService.this.turnOff();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                }
            };
            blinkingThread.start();
        }
    }

    public void toggleFlashLight() {
        if (!getLocalStorage().isFlashEnabled()) {
            stopBlinking();
        } else if (!this.isTorchOn) {
            turnOn();
        } else {
            turnOff();
        }
    }

    public void stopBlinking() {
        turnOff();
        this.isBlinking = false;
        if (blinkingThread != null && blinkingThread.isAlive()) {
            try {
                blinkingThread.interrupt();
                blinkingThread.join(500); // Giới hạn thời gian join để tránh treo ứng dụng
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blinkingThread = null; // Đặt về null sau khi xử lý xong
    }

    public void turnOn() {
        if (!this.isTorchOn) {
            try {
                CameraManager cameraManager2 = this.cameraManager;
                if (cameraManager2 != null) {
                    cameraManager2.setTorchMode(cameraManager2.getCameraIdList()[0], true);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e3) {
                e3.printStackTrace();
            }
            this.isTorchOn = true;
        }
    }

    public void turnOff() {
        if (this.isTorchOn) {
            try {
                CameraManager cameraManager2 = this.cameraManager;
                if (cameraManager2 != null) {
                    cameraManager2.setTorchMode(cameraManager2.getCameraIdList()[0], false);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e3) {
                e3.printStackTrace();
            }
            this.isTorchOn = false;
        }
    }

    private void playSound(long i) {
        AudioManager audioManager2 = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager2.getStreamMaxVolume(3);
        audioManager2.setStreamVolume(3, (int) (localStorage.getDefaultSoundVolume() * ((float) maxVolume)), 0);
        int savedResourceId = getLocalStorage().getResourceId();
        if (savedResourceId == R.drawable.dog) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.dogbarking);
        } else if (savedResourceId == R.drawable.cat) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.catmeow);
        } else if (savedResourceId == R.drawable.rifle) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.rifle);
        } else if (savedResourceId == R.drawable.calvelry) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.calvery);
        } else if (savedResourceId == R.drawable.trumpet) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.trumpet);
        } else if (savedResourceId == R.drawable.whistle) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.whistle);
        } else if (savedResourceId == R.drawable.thunder) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.thunder);
        } else if (savedResourceId == R.drawable.policewhistle) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.policewhistle);
        } else if (savedResourceId == R.drawable.car) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.carhonk);
        } else if (savedResourceId == R.drawable.doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.doorbell);
        } else if (savedResourceId == R.drawable.birds) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.birdssound);
        } else if (savedResourceId == R.drawable.partyhorn) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.partyhorn);
        } else if(savedResourceId == R.drawable.beast_roar) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.beast_roar);
        } else if(savedResourceId == R.drawable.greeting) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.greeting);
        } else if(savedResourceId == R.drawable.christmas_themed) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.christmas_themed);
        } else if(savedResourceId == R.drawable.halloween_doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.halloween_doorbell);
        } else if(savedResourceId == R.drawable.police_siren_loop) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.police_siren_loop);
        } else if(savedResourceId == R.drawable.oh_my_god) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.oh_my_god);
        } else if(savedResourceId == R.drawable.happy_birthday_doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.happy_birthday_doorbell);
        } else if(savedResourceId == R.drawable.single_cat_meow){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.single_cat_meow);
        } else if(savedResourceId == R.drawable.toy_dog_barking){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.toy_dog_barking);
        } else if(savedResourceId == R.drawable.intercom_doorbell){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.intercom_doorbell);
        } else if(savedResourceId == R.drawable.sad_trumpet){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.sad_trumpet);
        } else if(savedResourceId == R.drawable.solitude_ringtone){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.perfect_solitude_music_ringtone);
        } else if(savedResourceId == R.drawable.ballerina_music){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.ballerina_music_box_song);
        } else if(savedResourceId == R.drawable.peaceful_piano_melody){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.peaceful_piano_melody_ident);
        } else if(savedResourceId == R.drawable.ding_dong_merrily){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.ding_dong_merrily_on_high_doorbell_sound);
        } else if (savedResourceId == R.drawable.ic_winning_horn) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.winning_horn_sound);
        } else if (savedResourceId == R.drawable.ic_loading_sound) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.loading_sound_effect);
        } else if (savedResourceId == R.drawable.ic_oh_no) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.whispered_oh_no_sound_effect);
        } else if (savedResourceId == R.drawable.ic_80s_alarm_clock) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.alarm_clock_80s_sound);
        } else if (savedResourceId == R.drawable.ic_clock_ticking_fast) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.clock_ticking_fast_sound_effect);
        } else if (savedResourceId == R.drawable.ic_aggressive_male_laugh) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.aggressive_male_laugh_sound_effect);
        } else if (savedResourceId == R.drawable.ic_applause) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.applause_and_standing_ovation_sound_effect);
        } else if (savedResourceId == R.drawable.ic_cartoon_steps) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.cartoon_steps_sound_effect);
        } else if (savedResourceId == R.drawable.ic_cartoon_run) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.cartoon_run_sound_effect);
        } else if (savedResourceId == R.drawable.ic_funny_footsteps) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.funny_footsteps_sound_effect);
        } else if (savedResourceId == R.drawable.ic_funny_laugh) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.funny_laugh_sound_effect);
        } else if (savedResourceId == R.drawable.ic_glitch_button) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.glitch_button_click_sound_effect);
        } else if (savedResourceId == R.drawable.ic_glitching) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.glitching_sound_effect);
        } else if (savedResourceId == R.drawable.ic_glitchy) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.glitchy_sound_effect);
        } else if (savedResourceId == R.drawable.hurry_up_game_movement) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.hurry_up_game_movement_sound_effect);
        } else if (savedResourceId == R.drawable.ic_hand_bell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.hand_bell_chiming_sound_effect);
        } else if (savedResourceId == R.drawable.mallet_notification) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.mallet_notification_sound_effect);
        } else if (savedResourceId == R.drawable.ic_whistle_noise) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.whistle_noise);
        } else if (savedResourceId == R.drawable.ghost_of_christmas_past) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.ghost_of_the_christmas_past_sound_effect);
        } else if (savedResourceId == R.drawable.ic_festival_cheers) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.festival_cheers_and_applause_sound_effect);
        }
        if (this.mediaPlayer != null && getLocalStorage().isSoundEnabled()) {
            this.mediaPlayer.setLooping(true);
            this.mediaPlayer.start();
            this.isclapping = true;
        }
        if(i != Constants.VALUE_DURATION_LOOP) {
            this.handlerforsound.postDelayed(this.stopPlaybackRunnable, (long) i);
        }
    }


    public void stopPlayback() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
            this.isclapping = false;
        }
        broadcastDurationComplete();
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Toast.makeText(this, localizeContext.getString(R.string.clap_service_is_running), Toast.LENGTH_SHORT).show();
        updateNotificationToMain();
        isservicerunning = true;
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MotionService::lock");
        wakeLock.acquire();

        this.recorderThread.startRecording();
        this.detectorThread.start();
        showNotification();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isservicerunning = false;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
        }
        // Stop foreground service
        stopForeground(true);
        // Safely stop and interrupt the DetectorThread
        if (detectorThread != null) {
            detectorThread.stopDetection();
            try {
                detectorThread.interrupt();
                detectorThread.join(1000);  // Wait for the thread to finish with a timeout
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (detectorThread2 != null) {
            detectorThread2.stopDetection();
            try {
                detectorThread2.interrupt();
                detectorThread2.join(500);  // Wait for the thread to finish with a timeout
                detectorThread2 = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Safely stop and interrupt the RecorderThread
        if (recorderThread != null) {
            recorderThread.stopRecording();
            try {
                recorderThread.interrupt();
                recorderThread.join(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Remove playback status Runnable callback
        if (handlerformediaplayer != null && checkPlaybackStatusRunnable != null) {
            handlerformediaplayer.removeCallbacks(checkPlaybackStatusRunnable);
        }
        // Stop playback if active
        stopPlayback();
        // Disable blinking and wait for the blinkingThread to finish
        isBlinking = false;
        if (blinkingThread != null && blinkingThread.isAlive()) {
            try {
                blinkingThread.interrupt();
                blinkingThread.join(1000); // Giới hạn thời gian join để tránh treo ứng dụng
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Cancel vibrator if active
        if (vibrator != null) {
            vibrator.cancel();
        }

        // Remove other Runnable callback
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(stopMusicReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(updateLocale);
    }

    private void showNoti2(){
        localStorage.setPhoneFoundActivityActiveFromNoti(true);
        updateNotificationToPhoneFound();
//        showNotification();
    }
    private void showNotification(){
        createNotificationChannel();
        intent.putExtra("SOURCE", "FROM_NOTIFICATION");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        TaskStackBuilder create = TaskStackBuilder.create(this);
        create.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = create.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(MainActivityNotification.m(CHANNEL_ID, localizeContext.getString(R.string.app_name), 3));
        }
        Notification noti = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(localizeContext.getString(R.string.app_name))
                .setContentText(localizeContext.getString(R.string.clap_service_is_running))
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .setSilent(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                .setPriority(1)
                .setOngoing(true).build();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            startForeground(1, noti);
        } else {
            startForeground(1, noti,
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_MICROPHONE);
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = localizeContext.getString(R.string.channel_name);
            String string2 = localizeContext.getString(R.string.channel_description);
            NotificationChannel m = MainActivityNotification.m(CHANNEL_ID, (CharSequence) string, NotificationManager.IMPORTANCE_HIGH);
            m.setDescription(string2);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(m);
            }
        }
    }

    private void stopVibration(){
        if (this.handler != null && this.runnable != null) {
            this.handler.removeCallbacks(this.runnable); // Hủy callback
        }
        if (this.vibrator != null) {
            this.vibrator.cancel(); // Dừng rung
        }
    }
    private Context getLocalizedContext(Context context, Locale locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }
    private void updateLocalizeContext(){
        Locale current = new Locale(localStorage.getLangCode());
        localizeContext = getLocalizedContext(this, current);
    }
}
