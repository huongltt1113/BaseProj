package com.dev.baseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/dev/baseproject/di/StorageModule;", "", "()V", "appDatabase", "Lcom/dev/baseproject/data/AppDatabase;", "context", "Landroid/content/Context;", "dbName", "", "fileHelper", "Lcom/dev/baseproject/repository/FileHelper;", "Lcom/dev/baseproject/repository/FileHelperImpl;", "provideClickDao", "Lcom/dev/baseproject/data/dao/ClickerDao;", "db", "provideLocalRepository", "Lcom/dev/baseproject/local/LocalStorage;", "localStorage", "Lcom/dev/baseproject/local/LocalData;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class StorageModule {
    
    public StorageModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.repository.FileHelper fileHelper(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.repository.FileHelperImpl fileHelper) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.data.AppDatabase appDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @com.dev.baseproject.data.DatabaseInfo()
    @org.jetbrains.annotations.NotNull()
    java.lang.String dbName) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.local.LocalStorage provideLocalRepository(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.local.LocalData localStorage) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.data.dao.ClickerDao provideClickDao(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.data.AppDatabase db) {
        return null;
    }
}