package com.dev.baseproject.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "com.dev.baseproject.local.MobileIdInfo",
    "dagger.hilt.android.qualifiers.ApplicationContext"
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
public final class AppModule_ProviderMobileIdFactory implements Factory<String> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProviderMobileIdFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public String get() {
    return providerMobileId(module, contextProvider.get());
  }

  public static AppModule_ProviderMobileIdFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProviderMobileIdFactory(module, contextProvider);
  }

  public static String providerMobileId(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.providerMobileId(context));
  }
}
