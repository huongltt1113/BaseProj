package com.dev.baseproject.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.dev.baseproject.local.PreferenceInfo")
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
public final class AppModule_PreferencesNameFactory implements Factory<String> {
  private final AppModule module;

  public AppModule_PreferencesNameFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return preferencesName(module);
  }

  public static AppModule_PreferencesNameFactory create(AppModule module) {
    return new AppModule_PreferencesNameFactory(module);
  }

  public static String preferencesName(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.preferencesName());
  }
}
