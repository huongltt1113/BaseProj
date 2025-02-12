package com.dev.baseproject;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020(H\u0017J\b\u0010/\u001a\u00020(H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/dev/baseproject/App;", "Landroid/app/Application;", "()V", "androidId", "", "getAndroidId$annotations", "getAndroidId", "()Ljava/lang/String;", "setAndroidId", "(Ljava/lang/String;)V", "googleMobileAdsConsentManager", "Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager;", "getGoogleMobileAdsConsentManager", "()Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager;", "setGoogleMobileAdsConsentManager", "(Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager;)V", "isInitMobileAdsComplete", "", "()Z", "setInitMobileAdsComplete", "(Z)V", "localStorage", "Lcom/dev/baseproject/local/LocalStorage;", "getLocalStorage", "()Lcom/dev/baseproject/local/LocalStorage;", "setLocalStorage", "(Lcom/dev/baseproject/local/LocalStorage;)V", "network", "Lcom/dev/baseproject/server/Network;", "getNetwork", "()Lcom/dev/baseproject/server/Network;", "setNetwork", "(Lcom/dev/baseproject/server/Network;)V", "onHasConfig", "Landroidx/lifecycle/MutableLiveData;", "getOnHasConfig", "()Landroidx/lifecycle/MutableLiveData;", "setOnHasConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "attachBaseContext", "", "base", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "setupRemoteConfig", "Companion", "app_debug"})
public final class App extends android.app.Application {
    @javax.inject.Inject()
    public com.dev.baseproject.ads.GoogleMobileAdsConsentManager googleMobileAdsConsentManager;
    @javax.inject.Inject()
    public com.dev.baseproject.local.LocalStorage localStorage;
    @javax.inject.Inject()
    public com.dev.baseproject.server.Network network;
    @javax.inject.Inject()
    public java.lang.String androidId;
    private boolean isInitMobileAdsComplete = false;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> onHasConfig;
    public static com.dev.baseproject.App instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.App.Companion Companion = null;
    
    public App() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.ads.GoogleMobileAdsConsentManager getGoogleMobileAdsConsentManager() {
        return null;
    }
    
    public final void setGoogleMobileAdsConsentManager(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.ads.GoogleMobileAdsConsentManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.local.LocalStorage getLocalStorage() {
        return null;
    }
    
    public final void setLocalStorage(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.local.LocalStorage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.server.Network getNetwork() {
        return null;
    }
    
    public final void setNetwork(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.server.Network p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAndroidId() {
        return null;
    }
    
    @com.dev.baseproject.local.MobileIdInfo()
    @java.lang.Deprecated()
    public static void getAndroidId$annotations() {
    }
    
    public final void setAndroidId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isInitMobileAdsComplete() {
        return false;
    }
    
    public final void setInitMobileAdsComplete(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getOnHasConfig() {
        return null;
    }
    
    public final void setOnHasConfig(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    public void onCreate() {
    }
    
    private final void setupRemoteConfig() {
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/dev/baseproject/App$Companion;", "", "()V", "instance", "Lcom/dev/baseproject/App;", "getInstance", "()Lcom/dev/baseproject/App;", "setInstance", "(Lcom/dev/baseproject/App;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dev.baseproject.App getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.App p0) {
        }
    }
}