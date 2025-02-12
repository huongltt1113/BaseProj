package com.dev.baseproject.services;

import static com.dev.baseproject.utils.Constants.Pocket.LIGHT_SENSOR_THRESHOLD;

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
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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


import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

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
public class PocketDetectionService extends Service implements SensorEventListener {
    @Inject
    LocalStorage localStorage;

    private static final String CHANNEL_ID = "Pocket_Service";
    private static final int NOTIFICATION_ID = 11;
    private static final String TAG = "PocketDetectionService";
    public static boolean isServiceRunning = false;
    // Cảm biến độ gần, cảm biến ánh sáng
    private Sensor proximitySensor, lightSensor, accelerometerSensor;
    private Boolean isLightSensorAvailable = false, isProximitySensorAvailable = false, isAccelerometerSensorAvailable = false;
    private Boolean isInPocket = false, isLightOff = false;
    private long lastTimeRecord = 0;
    CameraManager cameraManager;
    PowerManager.WakeLock wakeLock;
    private Thread blinkingThread;
    //rp: proximity sensor value, rl: light sensor value
    float rp = -1;
    float rl = -1;

    float accelCurrent = 0f;
    float maxProximity = 5f;
    int pocket = 0;

    boolean isLight = true;
    float sensitivity = 9.8f;

    public void setLightAndSensitivity(boolean isLight, float sensitivity){
        this.isLight = isLight;
        this.sensitivity = sensitivity;
    }

    private Intent intent;

    private Runnable checkPlaybackStatusRunnable = new Runnable() {
        @Override
        public void run() {
            PocketDetectionService.this.broadcastPlaybackStatus(PocketDetectionService.this.mediaPlayer != null && PocketDetectionService.this.mediaPlayer.isPlaying());
            PocketDetectionService.this.handlerformediaplayer.postDelayed(this, 1000);
        }
    };

    int delay = 1200;
    long duration = 15000;
    private Handler handler = new Handler();

    public Handler handlerformediaplayer = new Handler();
    private Handler handlerforsound;

    public boolean isBlinking = false;
    private boolean isTorchOn = false;
    public MediaPlayer mediaPlayer;
    private Runnable runnable;
    private SensorManager sensorManager;
    Context localizeContext;

    private Runnable stopPlaybackRunnable = () -> {
        stopPlayback();
        stopBlinking();
        stopVibration();
    };

    public Vibrator vibrator;

    private BroadcastReceiver stopMusicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Constants.INTENT_POCKET_STOP_MUSIC.equals(intent.getAction())
                    || Constants.INTENT_POCKET_DURATION_COMPLETE.equals(intent.getAction())) {
                stopPlayback(); // Dừng nhạc ngay lập tức
                stopBlinking();
                stopVibration();
                handlerforsound.removeCallbacks(stopPlaybackRunnable);
                if(isServiceRunning){
                    updateNotificationToMain();
                }
                // Hủy hẹn giờ dừng nhạc
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

    public void broadcastDurationComplete() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Constants.INTENT_POCKET_DURATION_COMPLETE));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        updateLocalizeContext();
        intent = new Intent(this, MainActivity.class);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            startMyOwnForeground();
        } else {
            startForeground(NOTIFICATION_ID, new Notification());
        }
        SensorManager sensorManager2 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.sensorManager = sensorManager2;
        if(isLight){
            this.lightSensor = sensorManager2.getDefaultSensor(Sensor.TYPE_LIGHT);
        }
        this.proximitySensor = sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        this.accelerometerSensor = sensorManager2.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accelCurrent = SensorManager.GRAVITY_EARTH;
        this.handlerforsound = new Handler();
        this.handlerformediaplayer.post(this.checkPlaybackStatusRunnable);
        this.duration = localStorage.getTimeDuration();
        //showNotification();
        this.delay = localStorage.getFlashSpeed();
        initializemediaplayer(localStorage.getResourceId());
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.INTENT_POCKET_STOP_MUSIC);
        LocalBroadcastManager.getInstance(this).registerReceiver(stopMusicReceiver, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(updateLocale, new IntentFilter(Constants.SERVICE_POCKET_UPDATE_LOCALE));

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

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Toast.makeText(this, localizeContext.getString(R.string.pocket_detection_service_started), Toast.LENGTH_SHORT).show();
        updateNotificationToMain();
        isServiceRunning = true;
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = powerManager.isInteractive();
        if (!isScreenOn) {
//            wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP |
//                    PowerManager.ON_AFTER_RELEASE, "PocketService::lock");
//            KeyguardManager keyguardManager =(KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//            KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("YourApp:KeyguardLockTag");
//            wakeLock.acquire(1000L);
//            keyguardLock.disableKeyguard();

            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "PocketService::lock");
            wakeLock.acquire();
        } else {
            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "PocketService::lock");
            wakeLock.acquire();
        }
        if (this.proximitySensor != null) {
            isProximitySensorAvailable = true;
            sensorManager.registerListener(this, this.proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            maxProximity = this.proximitySensor.getMaximumRange();
        }
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceRunning = false;
        // Hủy đăng ký listener cho cảm biến
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
        }
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }

        // Dừng và giải phóng MediaPlayer nếu nó đang phát
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // Ngừng trạng thái nhấp nháy và kết thúc Thread nhấp nháy nếu đang chạy
        isBlinking = false;
        if (blinkingThread != null && blinkingThread.isAlive()) {
            try {
                blinkingThread.interrupt();
                blinkingThread.join(500); // Giới hạn thời gian join để tránh treo ứng dụng
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blinkingThread = null; // Đặt về null sau khi xử lý xong

        // Hủy rung nếu Vibrator đang hoạt động
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.cancel();
        }

        // Loại bỏ callbacks của Runnable khỏi các Handler
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
        if (handlerformediaplayer != null && checkPlaybackStatusRunnable != null) {
            handlerformediaplayer.removeCallbacks(checkPlaybackStatusRunnable);
        }

        // Giải phóng Handler và Runnable để tránh memory leak
        handler = null;
        handlerformediaplayer = null;
        runnable = null;
        checkPlaybackStatusRunnable = null;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
        stopForeground(true);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(stopMusicReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(updateLocale);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long current = System.currentTimeMillis();
        if(localStorage.getWithLightPK() != isLight){
            isLight = localStorage.getWithLightPK();
        }
        if(localStorage.getSensitivityPK() != sensitivity){
            sensitivity = localStorage.getSensitivityPK();
        }
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            rp = event.values[0];
            if(rp < maxProximity && !isInPocket){
                isInPocket = true;
                if (this.lightSensor != null && isLight) {
                    isLightSensorAvailable = true;
                    sensorManager.registerListener(this, this.lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
                }
                if(this.accelerometerSensor != null){
                    isAccelerometerSensorAvailable = true;
                    sensorManager.registerListener(this, this.accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
                }
            }
        }
        System.out.println("PocketDetectionService.onSensorChanged: rp = " + rp + "; isInPocket: " + isInPocket);
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            rl = event.values[0];
            if(rl == 0){
                isLightOff = true;
            }
        }
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float f = event.values[0];
            float f2 = event.values[1];
            float f3 = event.values[2];

            accelCurrent = (float) Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3));
        }
        System.out.println("PocketDetectionService.onSensorChanged: accelCurrent = " + accelCurrent + ", light = " + rl );
        if (isInPocket && isLight && isLightOff && (accelCurrent > sensitivity || !isAccelerometerSensorAvailable) && (rl >= LIGHT_SENSOR_THRESHOLD || !isLightSensorAvailable)) {
            this.detect();
        } else if(isInPocket && !isLight && (accelCurrent > sensitivity || !isAccelerometerSensorAvailable) && (rp >= maxProximity || !isProximitySensorAvailable)){
            this.detect();
        }
    }

    public void detect() {
        if(!isAccelerometerSensorAvailable && !isLightSensorAvailable){
            return;
        }
        Log.d(TAG, "onSensorChanged: Called");
        // prox: How far away an object is from the phone: Khoảng cách giữa điện thoại và vật thể -> 0: gần, 5: xa
        // light: How much light is in the environment: Mức độ ánh sáng trong môi trường, trong túi -> 0: tối
        // Out of pocket
        isInPocket = false;
        isLightOff = false;
        playSound(this.duration);
        startvibration(this.duration);
        startblinking(this.duration);
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Constants.INTENT_SERVICE_EVENT));
        localStorage.setPocketServiceDetected(true);
        showNoti2();
    }

    private void showNoti2(){
        localStorage.setPhoneFoundActivityActiveFromNoti(true);
        updateNotificationToPhoneFound();
        //showNotification();
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//            startMyOwnForeground();
//        } else {
//            startForeground(NOTIFICATION_ID, new Notification());
//        }
    }
    private void showNotification(){
        intent.putExtra("SOURCE", "FROM_NOTIFICATION");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        TaskStackBuilder create = TaskStackBuilder.create(this);
        create.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = create.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(MainActivityNotification.m(CHANNEL_ID, getString(R.string.app_name), 3));
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            startForeground(NOTIFICATION_ID, new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.app_name)).setContentText(getString(R.string.pocket_service_is_running)).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).setVisibility(NotificationCompat.VISIBILITY_PUBLIC).setPriority(1).setOngoing(true).build());
        } else {
            startForeground(NOTIFICATION_ID, new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.app_name)).setContentText(getString(R.string.pocket_service_is_running)).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).setVisibility(NotificationCompat.VISIBILITY_PUBLIC).setPriority(1).setOngoing(true).build(),
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private void startMyOwnForeground(){
        intent.putExtra("SOURCE", "FROM_NOTIFICATION");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        TaskStackBuilder create = TaskStackBuilder.create(this);
        create.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = create.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//        if (Build.VERSION.SDK_INT >= 26) {
//            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(MainActivityNotification.m(CHANNEL_ID, getString(R.string.app_name), 3));
//        }
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
//            startForeground(11, new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.app_name)).setContentText(getString(R.string.don_t_touch_my_phone_service_is_running)).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).setVisibility(NotificationCompat.VISIBILITY_PUBLIC).setPriority(1).setOngoing(true).build());
//        } else {
//            startForeground(11, new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.app_name)).setContentText(getString(R.string.don_t_touch_my_phone_service_is_running)).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).setVisibility(NotificationCompat.VISIBILITY_PUBLIC).setPriority(1).setOngoing(true).build(),
//                    ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);
//        }
        NotificationChannel channel = new NotificationChannel(
                getApplicationContext().getPackageName(),
                localizeContext.getString(R.string.don_t_touch_my_phone),
                NotificationManager.IMPORTANCE_HIGH
        );
        channel.setLightColor(Color.YELLOW);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.createNotificationChannel(channel);

            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat.Builder(this, getApplicationContext().getPackageName());
            Notification notification = notificationBuilder
                    .setOngoing(true)
                    .setContentTitle(localizeContext.getString(R.string.pocket_service_is_running))
                    .setContentText(localizeContext.getString(R.string.pocket_detection_service_started))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                    .setChannelId(getApplicationContext().getPackageName())
                    .build();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//                startForegroundService(intent);
                ServiceCompat.startForeground(
                        this,
                        NOTIFICATION_ID,
                        notification,
                        ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE
                );
            } else {
//                startForegroundService(intent);
                startForeground(NOTIFICATION_ID, notification);
            }
        }
    }

    private void updateNotificationToPhoneFound() {
        intent = new Intent(this, PhoneFoundActivity.class);
        intent.putExtra("SOURCE", "FROM_NOTIFICATION");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getApplicationContext().getPackageName())
                .setContentTitle(localizeContext.getString(R.string.pocket_service_is_running))
                .setContentText(localizeContext.getString(R.string.phone_found_pocket_detected))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(Notification.CATEGORY_SERVICE)
                .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                .setOngoing(true);

        notificationManager.cancelAll();
        if(notificationManager.getActiveNotifications().length == 0){
            notificationManager.notify("motion", NOTIFICATION_ID, builder.build());
        } else {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    private void startvibration(long i) {
        if (localStorage.isVibrationEnabled()) {
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
                            PocketDetectionService.this.vibrator.cancel();
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
            Thread run2 = new Thread() {
                @Override
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = 0;
                    while (true) {
                        int i = 0;
                        if (i1 != Constants.VALUE_DURATION_LOOP &&!PocketDetectionService.this.isBlinking || j >= ((long) i1) && i1 != Constants.VALUE_DURATION_LOOP) {
                            PocketDetectionService.this.turnOff();
                        } else {
                            try {
                                PocketDetectionService PocketDetectionService = PocketDetectionService.this;
                                PocketDetectionService.cameraManager = (CameraManager) PocketDetectionService.getSystemService(Context.CAMERA_SERVICE);

                                while (true) {
                                    if (i >= 3 || !PocketDetectionService.this.isBlinking) {
                                        break;
                                    } else if (i1 != Constants.VALUE_DURATION_LOOP && System.currentTimeMillis() - currentTimeMillis >= ((long) i1)) {
                                        break;
                                    } else {
                                        PocketDetectionService.this.toggleFlashLight();
                                        sleep(PocketDetectionService.this.delay);
                                        i++;
                                    }
                                }
                                PocketDetectionService.this.turnOff();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                }
            };
            this.blinkingThread = run2;
            run2.start();
        }
    }

    public void toggleFlashLight() {
        if (!localStorage.isFlashEnabled()) {
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
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && !mediaPlayer2.isPlaying() && localStorage.isSoundEnabled()) {
            this.mediaPlayer.setLooping(true);
            this.mediaPlayer.start();
        }
        if (i != Constants.VALUE_DURATION_LOOP) {
            this.handlerforsound.postDelayed(this.stopPlaybackRunnable, (long) i);
        }
    }

    private void initializemediaplayer(int i) {
        int savedResourceId = i;
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
        } else if (savedResourceId == R.drawable.beast_roar) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.beast_roar);
        } else if (savedResourceId == R.drawable.greeting) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.greeting);
        } else if (savedResourceId == R.drawable.christmas_themed) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.christmas_themed);
        } else if (savedResourceId == R.drawable.halloween_doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.halloween_doorbell);
        } else if (savedResourceId == R.drawable.police_siren_loop) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.police_siren_loop);
        } else if (savedResourceId == R.drawable.oh_my_god) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.oh_my_god);
        } else if (savedResourceId == R.drawable.happy_birthday_doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.happy_birthday_doorbell);
        } else if (savedResourceId == R.drawable.single_cat_meow) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.single_cat_meow);
        } else if (savedResourceId == R.drawable.toy_dog_barking) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.toy_dog_barking);
        } else if (savedResourceId == R.drawable.intercom_doorbell) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.intercom_doorbell);
        } else if (savedResourceId == R.drawable.sad_trumpet) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.sad_trumpet);
        } else if (savedResourceId == R.drawable.solitude_ringtone) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.perfect_solitude_music_ringtone);
        } else if (savedResourceId == R.drawable.ballerina_music) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.ballerina_music_box_song);
        } else if (savedResourceId == R.drawable.peaceful_piano_melody) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.peaceful_piano_melody_ident);
        } else if (savedResourceId == R.drawable.ding_dong_merrily) {
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
        if(this.mediaPlayer != null){
            this.mediaPlayer.setLooping(true);
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            try {
                mediaPlayer2.stop();
            } catch (IllegalStateException unused) {
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
            initializemediaplayer(localStorage.getResourceId());
        }
        broadcastDurationComplete();
    }

    private void stopVibration(){
        if (this.handler != null && this.runnable != null) {
            this.handler.removeCallbacks(this.runnable); // Hủy callback
        }
        if (this.vibrator != null) {
            this.vibrator.cancel(); // Dừng rung
        }
    }

    private void updateNotificationToMain() {
        intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getApplicationContext().getPackageName())
                .setContentTitle(localizeContext.getString(R.string.pocket_service_is_running))
                .setContentText(localizeContext.getString(R.string.pocket_detection_service_started))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(Notification.CATEGORY_SERVICE)
                .addAction(R.drawable.icon_howtouse_clap_1, localizeContext.getString(R.string.turn_off), pendingIntent)
                .setOngoing(true);

        if(notificationManager.getActiveNotifications().length == 0){
            notificationManager.notify("pocket", NOTIFICATION_ID, builder.build());
        } else {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
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