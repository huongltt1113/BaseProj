package com.dev.baseproject.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.dev.baseproject.data.DatabaseInfo")
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
public final class AppModule_DatabaseNameFactory implements Factory<String> {
  private final AppModule module;

  public AppModule_DatabaseNameFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return databaseName(module);
  }

  public static AppModule_DatabaseNameFactory create(AppModule module) {
    return new AppModule_DatabaseNameFactory(module);
  }

  public static String databaseName(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.databaseName());
  }
}
