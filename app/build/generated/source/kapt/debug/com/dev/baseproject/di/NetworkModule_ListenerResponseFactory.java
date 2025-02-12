package com.dev.baseproject.di;

import com.dev.baseproject.local.LocalStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata
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
public final class NetworkModule_ListenerResponseFactory implements Factory<Interceptor> {
  private final Provider<LocalStorage> storageProvider;

  public NetworkModule_ListenerResponseFactory(Provider<LocalStorage> storageProvider) {
    this.storageProvider = storageProvider;
  }

  @Override
  public Interceptor get() {
    return listenerResponse(storageProvider.get());
  }

  public static NetworkModule_ListenerResponseFactory create(
      Provider<LocalStorage> storageProvider) {
    return new NetworkModule_ListenerResponseFactory(storageProvider);
  }

  public static Interceptor listenerResponse(LocalStorage storage) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.listenerResponse(storage));
  }
}
