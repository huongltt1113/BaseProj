package com.dev.baseproject.di;

import com.dev.baseproject.server.Network;
import com.dev.baseproject.server.NetworkConnectivity;
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
public final class NetworkModule_ProvideNetworkConnectivityFactory implements Factory<NetworkConnectivity> {
  private final Provider<Network> netWorkProvider;

  public NetworkModule_ProvideNetworkConnectivityFactory(Provider<Network> netWorkProvider) {
    this.netWorkProvider = netWorkProvider;
  }

  @Override
  public NetworkConnectivity get() {
    return provideNetworkConnectivity(netWorkProvider.get());
  }

  public static NetworkModule_ProvideNetworkConnectivityFactory create(
      Provider<Network> netWorkProvider) {
    return new NetworkModule_ProvideNetworkConnectivityFactory(netWorkProvider);
  }

  public static NetworkConnectivity provideNetworkConnectivity(Network netWork) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideNetworkConnectivity(netWork));
  }
}
