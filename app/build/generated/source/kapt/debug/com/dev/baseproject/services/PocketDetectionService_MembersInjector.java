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
public final class PocketDetectionService_MembersInjector implements MembersInjector<PocketDetectionService> {
  private final Provider<LocalStorage> localStorageProvider;

  public PocketDetectionService_MembersInjector(Provider<LocalStorage> localStorageProvider) {
    this.localStorageProvider = localStorageProvider;
  }

  public static MembersInjector<PocketDetectionService> create(
      Provider<LocalStorage> localStorageProvider) {
    return new PocketDetectionService_MembersInjector(localStorageProvider);
  }

  @Override
  public void injectMembers(PocketDetectionService instance) {
    injectLocalStorage(instance, localStorageProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.services.PocketDetectionService.localStorage")
  public static void injectLocalStorage(PocketDetectionService instance,
      LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }
}
