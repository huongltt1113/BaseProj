package com.dev.baseproject.ui.component.home.fragment;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0002J\u0014\u0010\"\u001a\u00020\u00192\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/dev/baseproject/ui/component/home/fragment/CountDownFragment;", "Lcom/dev/baseproject/ui/base/BaseFragmentBinding;", "Lcom/dev/baseproject/databinding/FragmentCountDownBinding;", "()V", "backgroundThread", "Ljava/lang/Thread;", "countDown", "Landroid/os/CountDownTimer;", "currentTimer", "", "hadStartedService", "", "handlerThread", "Landroid/os/HandlerThread;", "mode", "Ljava/lang/Integer;", "needNavigateUp", "newHandler", "Landroid/os/Handler;", "runnable", "Ljava/lang/Runnable;", "serviceClassName", "", "getContentViewId", "initializeData", "", "initializeViews", "navigateBackAndStartService", "needStartService", "onDestroy", "onPause", "onResume", "registerListeners", "startCountDown", "startService", "serviceClass", "Ljava/lang/Class;", "stopCountDownAndStartService", "stopCountDownWithoutService", "app_debug"})
public final class CountDownFragment extends com.dev.baseproject.ui.base.BaseFragmentBinding<com.dev.baseproject.databinding.FragmentCountDownBinding> {
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer countDown;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer mode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String serviceClassName;
    private boolean needNavigateUp = false;
    private android.os.HandlerThread handlerThread;
    private android.os.Handler newHandler;
    private java.lang.Runnable runnable;
    private java.lang.Thread backgroundThread;
    private int currentTimer = 10;
    private boolean hadStartedService = false;
    
    public CountDownFragment() {
        super();
    }
    
    @java.lang.Override()
    public int getContentViewId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    private final void stopCountDownWithoutService() {
    }
    
    @java.lang.Override()
    public void registerListeners() {
    }
    
    private final void startCountDown() {
    }
    
    private final void navigateBackAndStartService(boolean needStartService) {
    }
    
    private final void stopCountDownAndStartService() {
    }
    
    private final void startService(java.lang.Class<?> serviceClass) {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void initializeData() {
    }
}