package com.dev.baseproject.ui.base;

import com.dev.baseproject.data.AppDatabase;
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
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final Provider<AppDatabase> databaseProvider;

  public BaseActivity_MembersInjector(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  public static MembersInjector<BaseActivity> create(Provider<AppDatabase> databaseProvider) {
    return new BaseActivity_MembersInjector(databaseProvider);
  }

  @Override
  public void injectMembers(BaseActivity instance) {
    injectDatabase(instance, databaseProvider.get());
  }

  @InjectedFieldSignature("com.dev.baseproject.ui.base.BaseActivity.database")
  public static void injectDatabase(BaseActivity instance, AppDatabase database) {
    instance.database = database;
  }
}
