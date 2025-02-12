package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/dev/baseproject/ui/base/AutoDisposable;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "add", "", "disposable", "Lio/reactivex/disposables/Disposable;", "bindTo", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onDestroy", "app_debug"})
public final class AutoDisposable implements androidx.lifecycle.LifecycleObserver {
    private io.reactivex.disposables.CompositeDisposable compositeDisposable;
    
    public AutoDisposable() {
        super();
    }
    
    public final void bindTo(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable disposable) {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
    }
}