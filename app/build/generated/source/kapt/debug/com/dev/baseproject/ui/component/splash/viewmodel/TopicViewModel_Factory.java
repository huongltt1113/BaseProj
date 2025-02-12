package com.dev.baseproject.ui.component.splash.viewmodel;

import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.server.ApiClient;
import com.dev.baseproject.ui.base.BaseViewModel_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class TopicViewModel_Factory implements Factory<TopicViewModel> {
  private final Provider<ApiClient> apiClientProvider;

  private final Provider<LocalStorage> localStorageProvider;

  private final Provider<FileHelper> fileHelperProvider;

  public TopicViewModel_Factory(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    this.apiClientProvider = apiClientProvider;
    this.localStorageProvider = localStorageProvider;
    this.fileHelperProvider = fileHelperProvider;
  }

  @Override
  public TopicViewModel get() {
    TopicViewModel instance = newInstance();
    BaseViewModel_MembersInjector.injectApiClient(instance, apiClientProvider.get());
    BaseViewModel_MembersInjector.injectLocalStorage(instance, localStorageProvider.get());
    BaseViewModel_MembersInjector.injectFileHelper(instance, fileHelperProvider.get());
    return instance;
  }

  public static TopicViewModel_Factory create(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    return new TopicViewModel_Factory(apiClientProvider, localStorageProvider, fileHelperProvider);
  }

  public static TopicViewModel newInstance() {
    return new TopicViewModel();
  }
}
