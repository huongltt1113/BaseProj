package com.dev.baseproject.di;

import com.dev.baseproject.local.LocalData;
import com.dev.baseproject.local.LocalStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class StorageModule_ProvideLocalRepositoryFactory implements Factory<LocalStorage> {
  private final StorageModule module;

  private final Provider<LocalData> localStorageProvider;

  public StorageModule_ProvideLocalRepositoryFactory(StorageModule module,
      Provider<LocalData> localStorageProvider) {
    this.module = module;
    this.localStorageProvider = localStorageProvider;
  }

  @Override
  public LocalStorage get() {
    return provideLocalRepository(module, localStorageProvider.get());
  }

  public static StorageModule_ProvideLocalRepositoryFactory create(StorageModule module,
      Provider<LocalData> localStorageProvider) {
    return new StorageModule_ProvideLocalRepositoryFactory(module, localStorageProvider);
  }

  public static LocalStorage provideLocalRepository(StorageModule instance,
      LocalData localStorage) {
    return Preconditions.checkNotNullFromProvides(instance.provideLocalRepository(localStorage));
  }
}
