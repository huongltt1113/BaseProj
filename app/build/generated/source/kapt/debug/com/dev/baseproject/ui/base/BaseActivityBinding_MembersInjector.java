package com.dev.baseproject.ui.base;

import androidx.databinding.ViewDataBinding;
import com.dev.baseproject.data.AppDatabase;
import com.dev.baseproject.local.LocalStorage;
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
public final class BaseActivityBinding_MembersInjector<T extends ViewDataBinding, V extends BaseViewModel> implements MembersInjector<BaseActivityBinding<T, V>> {
  private final Provider<AppDatabase> databaseProvider;

  private final Provider<LocalStorage> localStorageProvider;

  public BaseActivityBinding_MembersInjector(Provider<AppDatabase> databaseProvider,
      Provider<LocalStorage> localStorageProvider) {
    this.databaseProvider = databaseProvider;
    this.localStorageProvider = localStorageProvider;
  }

  public static <T extends ViewDataBinding, V extends BaseViewModel> MembersInjector<BaseActivityBinding<T, V>> create(
      Provider<AppDatabase> databaseProvider, Provider<LocalStorage> localStorageProvider) {
    return new BaseActivityBinding_MembersInjector<T, V>(databaseProvider, localStorageProvider);
  }

  @Override
  public void injectMembers(BaseActivityBinding<T, V> instance) {
    BaseActivity_MembersInjector.injectDatabase(instance, databaseProvider.get());
    injectLocalStorage(instance, localStorageProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.ui.base.BaseActivityBinding.localStorage")
  public static <T extends ViewDataBinding, V extends BaseViewModel> void injectLocalStorage(
      BaseActivityBinding<T, V> instance, LocalStorage localStorage) {
    instance.localStorage = localStorage;
  }
}
