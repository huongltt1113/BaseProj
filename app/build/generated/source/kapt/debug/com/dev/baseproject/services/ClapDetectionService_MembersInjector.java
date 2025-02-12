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
public final class ClapDetectionService_MembersInjector implements MembersInjector<ClapDetectionService> {
  private final Provider<LocalStorage> localStorageProvider;

  public ClapDetectionService_MembersInjector(Provider<LocalStorage> localStorageProvider) {
    this.localStorageProvider = localStorageProvider;
  }

  public static MembersInjector<ClapDetectionService> create(
      Provider<LocalStorage> localStorageProvider) {
    return new ClapDetectionService_MembersInjector(localStorageProvider);
  }

  @Override
  public void injectMembers(ClapDetectionService instance) {
    injectLocalStorage(instance, localStorageProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.services.ClapDetectionService.localStorage")
  public static void injectLocalStorage(ClapDetectionService instance, LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }
}
