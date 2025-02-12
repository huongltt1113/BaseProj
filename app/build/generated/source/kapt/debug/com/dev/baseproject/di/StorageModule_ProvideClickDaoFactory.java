package com.dev.baseproject.di;

import com.dev.baseproject.data.AppDatabase;
import com.dev.baseproject.data.dao.ClickerDao;
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
public final class StorageModule_ProvideClickDaoFactory implements Factory<ClickerDao> {
  private final StorageModule module;

  private final Provider<AppDatabase> dbProvider;

  public StorageModule_ProvideClickDaoFactory(StorageModule module,
      Provider<AppDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public ClickerDao get() {
    return provideClickDao(module, dbProvider.get());
  }

  public static StorageModule_ProvideClickDaoFactory create(StorageModule module,
      Provider<AppDatabase> dbProvider) {
    return new StorageModule_ProvideClickDaoFactory(module, dbProvider);
  }

  public static ClickerDao provideClickDao(StorageModule instance, AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideClickDao(db));
  }
}
