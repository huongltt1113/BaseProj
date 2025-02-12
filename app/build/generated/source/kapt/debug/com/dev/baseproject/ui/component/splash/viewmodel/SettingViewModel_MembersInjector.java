package com.dev.baseproject.ui.component.splash.viewmodel;

import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.server.ApiClient;
import com.dev.baseproject.ui.base.BaseViewModel_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SettingViewModel_MembersInjector implements MembersInjector<SettingViewModel> {
  private final Provider<ApiClient> apiClientProvider;

  private final Provider<LocalStorage> localStorageProvider;

  private final Provider<FileHelper> fileHelperProvider;

  public SettingViewModel_MembersInjector(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    this.apiClientProvider = apiClientProvider;
    this.localStorageProvider = localStorageProvider;
    this.fileHelperProvider = fileHelperProvider;
  }

  public static MembersInjector<SettingViewModel> create(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    return new SettingViewModel_MembersInjector(apiClientProvider, localStorageProvider, fileHelperProvider);
  }

  @Override
  public void injectMembers(SettingViewModel instance) {
    BaseViewModel_MembersInjector.injectApiClient(instance, apiClientProvider.get());
    BaseViewModel_MembersInjector.injectLocalStorage(instance, localStorageProvider.get());
    BaseViewModel_MembersInjector.injectFileHelper(instance, fileHelperProvider.get());
  }
}
