package com.dev.baseproject.di;

import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.repository.FileHelperImpl;
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
public final class StorageModule_FileHelperFactory implements Factory<FileHelper> {
  private final StorageModule module;

  private final Provider<FileHelperImpl> fileHelperProvider;

  public StorageModule_FileHelperFactory(StorageModule module,
      Provider<FileHelperImpl> fileHelperProvider) {
    this.module = module;
    this.fileHelperProvider = fileHelperProvider;
  }

  @Override
  public FileHelper get() {
    return fileHelper(module, fileHelperProvider.get());
  }

  public static StorageModule_FileHelperFactory create(StorageModule module,
      Provider<FileHelperImpl> fileHelperProvider) {
    return new StorageModule_FileHelperFactory(module, fileHelperProvider);
  }

  public static FileHelper fileHelper(StorageModule instance, FileHelperImpl fileHelper) {
    return Preconditions.checkNotNullFromProvides(instance.fileHelper(fileHelper));
  }
}
