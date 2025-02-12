package com.dev.baseproject.di;

import com.dev.baseproject.server.ApiClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvidePostApiFactory implements Factory<ApiClient> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvidePostApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiClient get() {
    return providePostApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvidePostApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvidePostApiFactory(retrofitProvider);
  }

  public static ApiClient providePostApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providePostApi(retrofit));
  }
}
