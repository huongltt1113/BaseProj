package com.dev.baseproject.ui.component.home.viewmodel;

import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.repository.ScriptRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ScriptRepository> scriptRepositoryProvider;

  private final Provider<ApiClient> apiClientProvider;

  private final Provider<LocalStorage> localStorageProvider;

  private final Provider<FileHelper> fileHelperProvider;

  public HomeViewModel_Factory(Provider<ScriptRepository> scriptRepositoryProvider,
      Provider<ApiClient> apiClientProvider, Provider<LocalStorage> localStorageProvider,
      Provider<FileHelper> fileHelperProvider) {
    this.scriptRepositoryProvider = scriptRepositoryProvider;
    this.apiClientProvider = apiClientProvider;
    this.localStorageProvider = localStorageProvider;
    this.fileHelperProvider = fileHelperProvider;
  }

  @Override
  public HomeViewModel get() {
    HomeViewModel instance = newInstance(scriptRepositoryProvider.get());
    BaseViewModel_MembersInjector.injectApiClient(instance, apiClientProvider.get());
    BaseViewModel_MembersInjector.injectLocalStorage(instance, localStorageProvider.get());
    BaseViewModel_MembersInjector.injectFileHelper(instance, fileHelperProvider.get());
    return instance;
  }

  public static HomeViewModel_Factory create(Provider<ScriptRepository> scriptRepositoryProvider,
      Provider<ApiClient> apiClientProvider, Provider<LocalStorage> localStorageProvider,
      Provider<FileHelper> fileHelperProvider) {
    return new HomeViewModel_Factory(scriptRepositoryProvider, apiClientProvider, localStorageProvider, fileHelperProvider);
  }

  public static HomeViewModel newInstance(ScriptRepository scriptRepository) {
    return new HomeViewModel(scriptRepository);
  }
}
