package com.dev.baseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/dev/baseproject/di/AppModule;", "", "()V", "databaseName", "", "preferencesName", "providerAppId", "providerCMP", "Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager;", "context", "Landroid/content/Context;", "providerMobileId", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @com.dev.baseproject.local.PreferenceInfo()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String preferencesName() {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @com.dev.baseproject.data.DatabaseInfo()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String databaseName() {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @com.dev.baseproject.local.MobileIdInfo()
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String providerMobileId(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "AppId")
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String providerAppId() {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.ads.GoogleMobileAdsConsentManager providerCMP(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}