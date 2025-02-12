package com.dev.baseproject.ui.component.findphone;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0014J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/dev/baseproject/ui/component/findphone/PhoneFoundActivity;", "Lcom/dev/baseproject/ui/base/BaseActivityBinding;", "Lcom/dev/baseproject/databinding/ActivityPhoneFoundBinding;", "Lcom/dev/baseproject/ui/MainViewModel;", "()V", "animation", "Landroid/view/animation/Animation;", "animation2", "animationRotate", "durationCompleteReceiver", "Landroid/content/BroadcastReceiver;", "isFromHome", "", "playbackStatusReceiver", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "acquireWakeLock", "", "getContentViewId", "", "initializeData", "initializeViews", "navigateToCountDown", "navigateToHome", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStop", "registerListeners", "releaseWakeLock", "stopService", "app_debug"})
public final class PhoneFoundActivity extends com.dev.baseproject.ui.base.BaseActivityBinding<com.dev.baseproject.databinding.ActivityPhoneFoundBinding, com.dev.baseproject.ui.MainViewModel> {
    @org.jetbrains.annotations.Nullable()
    private android.view.animation.Animation animation;
    @org.jetbrains.annotations.Nullable()
    private android.view.animation.Animation animation2;
    @org.jetbrains.annotations.Nullable()
    private android.view.animation.Animation animationRotate;
    private boolean isFromHome = true;
    @org.jetbrains.annotations.NotNull()
    private final android.content.BroadcastReceiver durationCompleteReceiver = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.BroadcastReceiver playbackStatusReceiver = null;
    @org.jetbrains.annotations.Nullable()
    private android.os.PowerManager.WakeLock wakeLock;
    
    public PhoneFoundActivity() {
        super();
    }
    
    @java.lang.Override()
    public int getContentViewId() {
        return 0;
    }
    
    private final void acquireWakeLock() {
    }
    
    private final void releaseWakeLock() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    @java.lang.Override()
    public void registerListeners() {
    }
    
    @java.lang.Override()
    public void initializeData() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void stopService() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void navigateToCountDown() {
    }
    
    private final void navigateToHome() {
    }
}