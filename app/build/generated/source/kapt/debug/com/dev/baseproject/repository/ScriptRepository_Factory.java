package com.dev.baseproject.repository;

import com.dev.baseproject.data.dao.ClickerDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ScriptRepository_Factory implements Factory<ScriptRepository> {
  private final Provider<ClickerDao> clickerDaoProvider;

  public ScriptRepository_Factory(Provider<ClickerDao> clickerDaoProvider) {
    this.clickerDaoProvider = clickerDaoProvider;
  }

  @Override
  public ScriptRepository get() {
    return newInstance(clickerDaoProvider.get());
  }

  public static ScriptRepository_Factory create(Provider<ClickerDao> clickerDaoProvider) {
    return new ScriptRepository_Factory(clickerDaoProvider);
  }

  public static ScriptRepository newInstance(ClickerDao clickerDao) {
    return new ScriptRepository(clickerDao);
  }
}
