package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u001dH\u0014J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001c\u0010\u0007\u001a\u00028\u0000X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00028\u0001X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/dev/baseproject/ui/base/BaseActivityBinding;", "T", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/dev/baseproject/ui/base/BaseViewModel;", "Lcom/dev/baseproject/ui/base/BaseActivity;", "()V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "isInitialized", "", "()Z", "localStorage", "Lcom/dev/baseproject/local/LocalStorage;", "getLocalStorage", "()Lcom/dev/baseproject/local/LocalStorage;", "setLocalStorage", "(Lcom/dev/baseproject/local/LocalStorage;)V", "viewModel", "getViewModel", "()Lcom/dev/baseproject/ui/base/BaseViewModel;", "setViewModel", "(Lcom/dev/baseproject/ui/base/BaseViewModel;)V", "Lcom/dev/baseproject/ui/base/BaseViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewCreated", "app_debug"})
public abstract class BaseActivityBinding<T extends androidx.databinding.ViewDataBinding, V extends com.dev.baseproject.ui.base.BaseViewModel> extends com.dev.baseproject.ui.base.BaseActivity {
    public T dataBinding;
    public V viewModel;
    @javax.inject.Inject()
    public com.dev.baseproject.local.LocalStorage localStorage;
    
    public BaseActivityBinding() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public T getDataBinding() {
        return null;
    }
    
    public void setDataBinding(@org.jetbrains.annotations.NotNull()
    T p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public V getViewModel() {
        return null;
    }
    
    public void setViewModel(@org.jetbrains.annotations.NotNull()
    V p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.local.LocalStorage getLocalStorage() {
        return null;
    }
    
    public final void setLocalStorage(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.local.LocalStorage p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public void onViewCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    protected final boolean isInitialized() {
        return false;
    }
}