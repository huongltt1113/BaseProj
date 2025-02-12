package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0014J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/dev/baseproject/ui/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_toastLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "apiClient", "Lcom/dev/baseproject/server/ApiClient;", "getApiClient", "()Lcom/dev/baseproject/server/ApiClient;", "setApiClient", "(Lcom/dev/baseproject/server/ApiClient;)V", "composite", "Lio/reactivex/disposables/CompositeDisposable;", "getComposite", "()Lio/reactivex/disposables/CompositeDisposable;", "fileHelper", "Lcom/dev/baseproject/repository/FileHelper;", "getFileHelper", "()Lcom/dev/baseproject/repository/FileHelper;", "setFileHelper", "(Lcom/dev/baseproject/repository/FileHelper;)V", "localStorage", "Lcom/dev/baseproject/local/LocalStorage;", "getLocalStorage", "()Lcom/dev/baseproject/local/LocalStorage;", "setLocalStorage", "(Lcom/dev/baseproject/local/LocalStorage;)V", "toastLiveData", "getToastLiveData", "()Landroidx/lifecycle/MutableLiveData;", "onCleared", "", "showToast", "any", "app_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    @javax.inject.Inject()
    public com.dev.baseproject.server.ApiClient apiClient;
    @javax.inject.Inject()
    public com.dev.baseproject.local.LocalStorage localStorage;
    @javax.inject.Inject()
    public com.dev.baseproject.repository.FileHelper fileHelper;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable composite = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Object> _toastLiveData = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.server.ApiClient getApiClient() {
        return null;
    }
    
    public final void setApiClient(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.server.ApiClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.local.LocalStorage getLocalStorage() {
        return null;
    }
    
    public final void setLocalStorage(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.local.LocalStorage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.repository.FileHelper getFileHelper() {
        return null;
    }
    
    public final void setFileHelper(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.repository.FileHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.disposables.CompositeDisposable getComposite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Object> getToastLiveData() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.Object any) {
    }
}