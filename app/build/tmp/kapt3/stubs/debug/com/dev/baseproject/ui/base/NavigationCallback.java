package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/dev/baseproject/ui/base/NavigationCallback;", "", "didPushFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "didRemoveFragment", "prepareToPushFragment", "app_debug"})
public abstract interface NavigationCallback {
    
    public abstract void prepareToPushFragment();
    
    public abstract void didPushFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment);
    
    public abstract void didRemoveFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment);
}