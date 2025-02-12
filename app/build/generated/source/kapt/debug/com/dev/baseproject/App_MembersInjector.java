package com.dev.baseproject;

import com.dev.baseproject.ads.GoogleMobileAdsConsentManager;
import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.local.MobileIdInfo;
import com.dev.baseproject.server.Network;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata("com.dev.baseproject.local.MobileIdInfo")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<GoogleMobileAdsConsentManager> googleMobileAdsConsentManagerProvider;

  private final Provider<LocalStorage> localStorageProvider;

  private final Provider<Network> networkProvider;

  private final Provider<String> androidIdProvider;

  public App_MembersInjector(
      Provider<GoogleMobileAdsConsentManager> googleMobileAdsConsentManagerProvider,
      Provider<LocalStorage> localStorageProvider, Provider<Network> networkProvider,
      Provider<String> androidIdProvider) {
    this.googleMobileAdsConsentManagerProvider = googleMobileAdsConsentManagerProvider;
    this.localStorageProvider = localStorageProvider;
    this.networkProvider = networkProvider;
    this.androidIdProvider = androidIdProvider;
  }

  public static MembersInjector<App> create(
      Provider<GoogleMobileAdsConsentManager> googleMobileAdsConsentManagerProvider,
      Provider<LocalStorage> localStorageProvider, Provider<Network> networkProvider,
      Provider<String> androidIdProvider) {
    return new App_MembersInjector(googleMobileAdsConsentManagerProvider, localStorageProvider, networkProvider, androidIdProvider);
  }

  @Override
  public void injectMembers(App instance) {
    injectGoogleMobileAdsConsentManager(instance, googleMobileAdsConsentManagerProvider.get());
    injectLocalStorage(instance, localStorageProvider.get());
    injectNetwork(instance, networkProvider.get());
    injectAndroidId(instance, androidIdProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.App.googleMobileAdsConsentManager")
  public static void injectGoogleMobileAdsConsentManager(App instance,
      GoogleMobileAdsConsentManager googleMobileAdsConsentManager) {
    instance.googleMobileAdsConsentManager = googleMobileAdsConsentManager;
  }

  @InjectedFieldSignature("com.dev.baseproject.App.localStorage")
  public static void injectLocalStorage(App instance, LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }

  @InjectedFieldSignature("com.dev.baseproject.App.network")
  public static void injectNetwork(App instance, Network network) {
    instance.network = network;
  }

  @InjectedFieldSignature("com.dev.baseproject.App.androidId")
  @MobileIdInfo
  public static void injectAndroidId(App instance, String androidId) {
    instance.androidId = androidId;
  }
}
