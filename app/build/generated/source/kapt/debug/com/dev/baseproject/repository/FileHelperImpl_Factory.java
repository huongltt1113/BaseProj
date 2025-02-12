package com.dev.baseproject.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FileHelperImpl_Factory implements Factory<FileHelperImpl> {
  @Override
  public FileHelperImpl get() {
    return newInstance();
  }

  public static FileHelperImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FileHelperImpl newInstance() {
    return new FileHelperImpl();
  }

  private static final class InstanceHolder {
    private static final FileHelperImpl_Factory INSTANCE = new FileHelperImpl_Factory();
  }
}
