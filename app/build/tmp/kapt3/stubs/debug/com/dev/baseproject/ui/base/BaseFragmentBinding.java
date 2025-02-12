package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/dev/baseproject/ui/base/BaseFragmentBinding;", "T", "Landroidx/databinding/ViewDataBinding;", "Lcom/dev/baseproject/ui/base/BaseFragment;", "()V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "isInitialized", "", "()Z", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public abstract class BaseFragmentBinding<T extends androidx.databinding.ViewDataBinding> extends com.dev.baseproject.ui.base.BaseFragment {
    public T dataBinding;
    
    public BaseFragmentBinding() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public T getDataBinding() {
        return null;
    }
    
    public void setDataBinding(@org.jetbrains.annotations.NotNull()
    T p0) {
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