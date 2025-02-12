package com.dev.baseproject.di;

import android.content.Context;
import com.dev.baseproject.data.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "dagger.hilt.android.qualifiers.ApplicationContext",
    "com.dev.baseproject.data.DatabaseInfo"
})
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
public final class StorageModule_AppDatabaseFactory implements Factory<AppDatabase> {
  private final StorageModule module;

  private final Provider<Context> contextProvider;

  private final Provider<String> dbNameProvider;

  public StorageModule_AppDatabaseFactory(StorageModule module, Provider<Context> contextProvider,
      Provider<String> dbNameProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.dbNameProvider = dbNameProvider;
  }

  @Override
  public AppDatabase get() {
    return appDatabase(module, contextProvider.get(), dbNameProvider.get());
  }

  public static StorageModule_AppDatabaseFactory create(StorageModule module,
      Provider<Context> contextProvider, Provider<String> dbNameProvider) {
    return new StorageModule_AppDatabaseFactory(module, contextProvider, dbNameProvider);
  }

  public static AppDatabase appDatabase(StorageModule instance, Context context, String dbName) {
    return Preconditions.checkNotNullFromProvides(instance.appDatabase(context, dbName));
  }
}
