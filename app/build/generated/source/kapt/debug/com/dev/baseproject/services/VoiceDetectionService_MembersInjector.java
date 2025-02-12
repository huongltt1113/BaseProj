package com.dev.baseproject.services;

import com.dev.baseproject.local.LocalStorage;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
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
public final class VoiceDetectionService_MembersInjector implements MembersInjector<VoiceDetectionService> {
  private final Provider<LocalStorage> localStorageProvider;

  public VoiceDetectionService_MembersInjector(Provider<LocalStorage> localStorageProvider) {
    this.localStorageProvider = localStorageProvider;
  }

  public static MembersInjector<VoiceDetectionService> create(
      Provider<LocalStorage> localStorageProvider) {
    return new VoiceDetectionService_MembersInjector(localStorageProvider);
  }

  @Override
  public void injectMembers(VoiceDetectionService instance) {
    injectLocalStorage(instance, localStorageProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.services.VoiceDetectionService.localStorage")
  public static void injectLocalStorage(VoiceDetectionService instance, LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }
}
