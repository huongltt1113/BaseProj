package com.dev.baseproject.server;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class Network_Factory implements Factory<Network> {
  private final Provider<Context> contextProvider;

  public Network_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Network get() {
    return newInstance(contextProvider.get());
  }

  public static Network_Factory create(Provider<Context> contextProvider) {
    return new Network_Factory(contextProvider);
  }

  public static Network newInstance(Context context) {
    return new Network(context);
  }
}
