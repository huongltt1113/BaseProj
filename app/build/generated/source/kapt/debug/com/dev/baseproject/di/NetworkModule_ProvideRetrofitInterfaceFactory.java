package com.dev.baseproject.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class NetworkModule_ProvideRetrofitInterfaceFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> httpClientProvider;

  public NetworkModule_ProvideRetrofitInterfaceFactory(Provider<OkHttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofitInterface(httpClientProvider.get());
  }

  public static NetworkModule_ProvideRetrofitInterfaceFactory create(
      Provider<OkHttpClient> httpClientProvider) {
    return new NetworkModule_ProvideRetrofitInterfaceFactory(httpClientProvider);
  }

  public static Retrofit provideRetrofitInterface(OkHttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRetrofitInterface(httpClient));
  }
}
