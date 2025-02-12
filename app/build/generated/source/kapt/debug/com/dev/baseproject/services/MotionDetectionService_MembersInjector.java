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
public final class MotionDetectionService_MembersInjector implements MembersInjector<MotionDetectionService> {
  private final Provider<LocalStorage> localStorageProvider;

  public MotionDetectionService_MembersInjector(Provider<LocalStorage> localStorageProvider) {
    this.localStorageProvider = localStorageProvider;
  }

  public static MembersInjector<MotionDetectionService> create(
      Provider<LocalStorage> localStorageProvider) {
    return new MotionDetectionService_MembersInjector(localStorageProvider);
  }

  @Override
  public void injectMembers(MotionDetectionService instance) {
    injectLocalStorage(instance, localStorageProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.services.MotionDetectionService.localStorage")
  public static void injectLocalStorage(MotionDetectionService instance,
      LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }
}
