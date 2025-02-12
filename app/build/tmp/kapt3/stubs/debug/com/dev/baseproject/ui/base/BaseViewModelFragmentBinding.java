package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001c\u0010\u0007\u001a\u00028\u0000X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001c\u0010\u0010\u001a\u00028\u0001X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/dev/baseproject/ui/base/BaseViewModelFragmentBinding;", "T", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/dev/baseproject/ui/base/BaseViewModel;", "Lcom/dev/baseproject/ui/base/BaseFragment;", "()V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "isInitialized", "", "()Z", "viewModel", "getViewModel", "()Lcom/dev/baseproject/ui/base/BaseViewModel;", "setViewModel", "(Lcom/dev/baseproject/ui/base/BaseViewModel;)V", "Lcom/dev/baseproject/ui/base/BaseViewModel;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public abstract class BaseViewModelFragmentBinding<T extends androidx.databinding.ViewDataBinding, V extends com.dev.baseproject.ui.base.BaseViewModel> extends com.dev.baseproject.ui.base.BaseFragment {
    public T dataBinding;
    public V viewModel;
    
    public BaseViewModelFragmentBinding() {
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected final boolean isInitialized() {
        return false;
    }
}