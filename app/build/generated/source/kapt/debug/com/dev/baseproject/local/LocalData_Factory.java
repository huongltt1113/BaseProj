package com.dev.baseproject.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata({
    "dagger.hilt.android.qualifiers.ApplicationContext",
    "com.dev.baseproject.local.PreferenceInfo"
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
public final class LocalData_Factory implements Factory<LocalData> {
  private final Provider<Context> contextProvider;

  private final Provider<String> fileNameProvider;

  public LocalData_Factory(Provider<Context> contextProvider, Provider<String> fileNameProvider) {
    this.contextProvider = contextProvider;
    this.fileNameProvider = fileNameProvider;
  }

  @Override
  public LocalData get() {
    return newInstance(contextProvider.get(), fileNameProvider.get());
  }

  public static LocalData_Factory create(Provider<Context> contextProvider,
      Provider<String> fileNameProvider) {
    return new LocalData_Factory(contextProvider, fileNameProvider);
  }

  public static LocalData newInstance(Context context, String fileName) {
    return new LocalData(context, fileName);
  }
}
