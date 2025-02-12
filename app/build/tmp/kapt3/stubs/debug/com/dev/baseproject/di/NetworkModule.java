package com.dev.baseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J:\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u001eH\u0007J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\'H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/dev/baseproject/di/NetworkModule;", "", "()V", "EXPIRED_TIME_CACHE", "", "TIME_OUT", "userAgent", "", "connect", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "request", "Lokhttp3/Request;", "localStorage", "Lcom/dev/baseproject/local/LocalStorage;", "get", "", "url", "response", "Lkotlin/Function1;", "failure", "", "getCachedResponse", "cachedData", "getErrorResponse", "getFailedDomain", "getMoshi", "Lcom/squareup/moshi/Moshi;", "listenerResponse", "Lokhttp3/Interceptor;", "storage", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideNetworkConnectivity", "Lcom/dev/baseproject/server/NetworkConnectivity;", "netWork", "Lcom/dev/baseproject/server/Network;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptor", "providePostApi", "Lcom/dev/baseproject/server/ApiClient;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofitInterface", "httpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    public static final long TIME_OUT = 30000L;
    public static final long EXPIRED_TIME_CACHE = 86400000L;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String userAgent = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.server.NetworkConnectivity provideNetworkConnectivity(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.server.Network netWork) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.server.ApiClient providePostApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofitInterface(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient httpClient) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor interceptor, @org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor request) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.logging.HttpLoggingInterceptor provideLoggingInterceptor() {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Interceptor listenerResponse(@org.jetbrains.annotations.Nullable()
    com.dev.baseproject.local.LocalStorage storage) {
        return null;
    }
    
    private final com.squareup.moshi.Moshi getMoshi() {
        return null;
    }
    
    private final okhttp3.Response connect(okhttp3.Interceptor.Chain chain, okhttp3.Request request, com.dev.baseproject.local.LocalStorage localStorage) {
        return null;
    }
    
    private final java.lang.String getFailedDomain(java.lang.String url, com.dev.baseproject.local.LocalStorage localStorage) {
        return null;
    }
    
    private final okhttp3.Response getCachedResponse(java.lang.String cachedData, okhttp3.Request request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Response getErrorResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.Request request) {
        return null;
    }
    
    public final void get(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> response, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> failure) {
    }
}