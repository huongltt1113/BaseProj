package com.dev.baseproject.ads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u001a\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\'\u001a\u00020\u001cH\u0002J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020$J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001cH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/dev/baseproject/ads/OpenAdsOnStartManager;", "", "()V", "_adFLowStart", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/dev/baseproject/ads/AdModel;", "get_adFLowStart", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "adFLowStart", "Lkotlinx/coroutines/flow/SharedFlow;", "getAdFLowStart", "()Lkotlinx/coroutines/flow/SharedFlow;", "appOpenAd", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "getAppOpenAd", "()Lcom/google/android/gms/ads/appopen/AppOpenAd;", "setAppOpenAd", "(Lcom/google/android/gms/ads/appopen/AppOpenAd;)V", "currentAdMobTag", "", "isAdShowing", "", "()Z", "setAdShowing", "(Z)V", "isSplashScreen", "setSplashScreen", "loadTime", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "isAdAvailable", "isCanLoadAd", "loadAppOpenAd", "", "activity", "Landroid/app/Activity;", "postData", "model", "delay", "showAdIfAvailable", "ativity", "wasLoadTimeLessThanNHoursAgo", "numHours", "app_debug"})
public final class OpenAdsOnStartManager {
    @org.jetbrains.annotations.Nullable()
    private static com.google.android.gms.ads.appopen.AppOpenAd appOpenAd;
    private static boolean isAdShowing = false;
    private static boolean isSplashScreen = true;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope mainScope = null;
    private static long loadTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.MutableSharedFlow<com.dev.baseproject.ads.AdModel> _adFLowStart = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String currentAdMobTag = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ads.OpenAdsOnStartManager INSTANCE = null;
    
    private OpenAdsOnStartManager() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.ads.appopen.AppOpenAd getAppOpenAd() {
        return null;
    }
    
    public final void setAppOpenAd(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.ads.appopen.AppOpenAd p0) {
    }
    
    public final boolean isAdShowing() {
        return false;
    }
    
    public final void setAdShowing(boolean p0) {
    }
    
    public final boolean isSplashScreen() {
        return false;
    }
    
    public final void setSplashScreen(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableSharedFlow<com.dev.baseproject.ads.AdModel> get_adFLowStart() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.dev.baseproject.ads.AdModel> getAdFLowStart() {
        return null;
    }
    
    private final void postData(com.dev.baseproject.ads.AdModel model, long delay) {
    }
    
    public final void loadAppOpenAd(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void showAdIfAvailable(@org.jetbrains.annotations.NotNull()
    android.app.Activity ativity) {
    }
    
    private final boolean isAdAvailable() {
        return false;
    }
    
    private final boolean isCanLoadAd() {
        return false;
    }
    
    private final boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        return false;
    }
}