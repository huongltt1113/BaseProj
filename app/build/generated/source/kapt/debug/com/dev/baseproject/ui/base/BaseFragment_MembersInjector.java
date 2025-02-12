package com.dev.baseproject.ui.base;

import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.server.ApiClient;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class BaseFragment_MembersInjector implements MembersInjector<BaseFragment> {
  private final Provider<ApiClient> apiClientProvider;

  private final Provider<LocalStorage> localStorageProvider;

  private final Provider<FileHelper> fileHelperProvider;

  public BaseFragment_MembersInjector(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    this.apiClientProvider = apiClientProvider;
    this.localStorageProvider = localStorageProvider;
    this.fileHelperProvider = fileHelperProvider;
  }

  public static MembersInjector<BaseFragment> create(Provider<ApiClient> apiClientProvider,
      Provider<LocalStorage> localStorageProvider, Provider<FileHelper> fileHelperProvider) {
    return new BaseFragment_MembersInjector(apiClientProvider, localStorageProvider, fileHelperProvider);
  }

  @Override
  public void injectMembers(BaseFragment instance) {
    injectApiClient(instance, apiClientProvider.get());
    injectLocalStorage(instance, localStorageProvider.get());
    injectFileHelper(instance, fileHelperProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.ui.base.BaseFragment.apiClient")
  public static void injectApiClient(BaseFragment instance, ApiClient apiClient) {
    instance.apiClient = apiClient;
  }

  @InjectedFieldSignature("com.dev.baseproject.ui.base.BaseFragment.localStorage")
  public static void injectLocalStorage(BaseFragment instance, LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }

  @InjectedFieldSignature("com.dev.baseproject.ui.base.BaseFragment.fileHelper")
  public static void injectFileHelper(BaseFragment instance, FileHelper fileHelper) {
    instance.fileHelper = fileHelper;
  }
}
