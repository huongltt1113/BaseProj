package com.dev.baseproject.ads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020!H\u0007J\u001a\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u001dH\u0002J\b\u0010\'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\u0006\u0010)\u001a\u00020!J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\rJ\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001dH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/dev/baseproject/ads/OpenAdManager;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "_adFLow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/dev/baseproject/ads/AdModel;", "adFLow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAdFLow", "()Lkotlinx/coroutines/flow/SharedFlow;", "appOpenAd", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "canShowAd", "", "currentActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentAdMobTag", "", "isDestroyWhenChangeScreen", "()Z", "setDestroyWhenChangeScreen", "(Z)V", "isShowingAd", "setShowingAd", "isTurnOn", "lifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "loadTime", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchAd", "", "isAdAvailable", "onStart", "postData", "model", "delay", "removeLifecycleCallbacks", "showAdIfAvailable", "start", "switchOnOff", "turnOn", "wasLoadTimeLessThanNHoursAgo", "numHours", "app_debug"})
public final class OpenAdManager implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.Nullable()
    private static com.google.android.gms.ads.appopen.AppOpenAd appOpenAd;
    private static boolean isShowingAd = false;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.ref.WeakReference<android.app.Activity> currentActivity;
    private static long loadTime = 0L;
    private static boolean isTurnOn = true;
    private static boolean canShowAd = false;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope mainScope = null;
    private static boolean isDestroyWhenChangeScreen = false;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.MutableSharedFlow<com.dev.baseproject.ads.AdModel> _adFLow = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String currentAdMobTag = "";
    @org.jetbrains.annotations.NotNull()
    private static final android.app.Application.ActivityLifecycleCallbacks lifecycleCallbacks = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ads.OpenAdManager INSTANCE = null;
    
    private OpenAdManager() {
        super();
    }
    
    public final boolean isShowingAd() {
        return false;
    }
    
    public final void setShowingAd(boolean p0) {
    }
    
    public final boolean isDestroyWhenChangeScreen() {
        return false;
    }
    
    public final void setDestroyWhenChangeScreen(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.dev.baseproject.ads.AdModel> getAdFLow() {
        return null;
    }
    
    public final void start() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_RESUME)
    public final void onStart() {
    }
    
    public final void switchOnOff(boolean turnOn) {
    }
    
    private final void postData(com.dev.baseproject.ads.AdModel model, long delay) {
    }
    
    private final void showAdIfAvailable() {
    }
    
    private final void fetchAd() {
    }
    
    private final boolean isAdAvailable() {
        return false;
    }
    
    /**
     * Utility method to check if ad was loaded more than n hours ago.
     */
    private final boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        return false;
    }
    
    private final void removeLifecycleCallbacks() {
    }
}