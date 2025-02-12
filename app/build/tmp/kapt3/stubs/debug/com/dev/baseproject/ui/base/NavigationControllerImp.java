package com.dev.baseproject.ui.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\fH\u0016J<\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\'2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\fH\u0016J1\u0010(\u001a\u0004\u0018\u0001H)\"\b\b\u0000\u0010)*\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H)0\'2\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\fH\u0002J\u0018\u0010,\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\fH\u0016J,\u0010,\u001a\u00020\f2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\'2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020\fH\u0016J6\u0010.\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\'2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010/\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\fJ(\u00102\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0010H\u0002JF\u00103\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010%\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016JD\u00103\u001a\u00020\u001f2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\'2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0018\u00105\u001a\u00020\u001f2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\'H\u0016J,\u00106\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016J4\u00106\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\'2\b\u0010$\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00067"}, d2 = {"Lcom/dev/baseproject/ui/base/NavigationControllerImp;", "Lcom/dev/baseproject/ui/base/NavigationController;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "callback", "Lcom/dev/baseproject/ui/base/NavigationCallback;", "getCallback", "()Lcom/dev/baseproject/ui/base/NavigationCallback;", "setCallback", "(Lcom/dev/baseproject/ui/base/NavigationCallback;)V", "isEmptyFragments", "", "()Z", "listTagFragments", "Ljava/util/ArrayDeque;", "", "peek", "getPeek", "()Ljava/lang/String;", "poll", "getPoll", "sizeListFragments", "", "getSizeListFragments", "()I", "topFragment", "Landroidx/fragment/app/Fragment;", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "addFragment", "", "viewId", "fragment", "bundle", "Landroid/os/Bundle;", "tag", "singleton", "clazz", "Lkotlin/reflect/KClass;", "findFragment", "T", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "getLastTag", "popFragment", "animate", "popFragment2", "animateRightOrLeft", "popToRoot", "popTopFragment", "push", "pushFragment", "parentTag", "removeFragment", "replaceFragment", "app_debug"})
public final class NavigationControllerImp implements com.dev.baseproject.ui.base.NavigationController {
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.FragmentManager fragmentManager = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayDeque<java.lang.String> listTagFragments = null;
    @org.jetbrains.annotations.Nullable()
    private com.dev.baseproject.ui.base.NavigationCallback callback;
    
    public NavigationControllerImp(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.dev.baseproject.ui.base.NavigationCallback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.Nullable()
    com.dev.baseproject.ui.base.NavigationCallback p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getPeek() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPoll() {
        return null;
    }
    
    @java.lang.Override()
    public void popToRoot(boolean animate) {
    }
    
    public final boolean popTopFragment(boolean animate) {
        return false;
    }
    
    @java.lang.Override()
    public boolean popFragment(@org.jetbrains.annotations.Nullable()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean animate) {
        return false;
    }
    
    @java.lang.Override()
    public boolean popFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, boolean animate) {
        return false;
    }
    
    @java.lang.Override()
    public boolean popFragment2(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.Nullable()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean animateRightOrLeft) {
        return false;
    }
    
    @java.lang.Override()
    public void pushFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean animate, int viewId, boolean singleton, @org.jetbrains.annotations.Nullable()
    java.lang.String parentTag) {
    }
    
    @java.lang.Override()
    public void pushFragment(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean animate, int viewId, boolean singleton) {
    }
    
    private final boolean push(androidx.fragment.app.Fragment fragment, boolean animate, int viewId, java.lang.String tag) {
        return false;
    }
    
    @java.lang.Override()
    public void addFragment(int viewId, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean singleton) {
    }
    
    @java.lang.Override()
    public void addFragment(int viewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, boolean singleton) {
    }
    
    private final java.lang.String getLastTag(boolean singleton) {
        return null;
    }
    
    @java.lang.Override()
    public void removeFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override()
    public void removeFragment(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    @java.lang.Override()
    public void removeFragment(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz) {
    }
    
    @java.lang.Override()
    public void replaceFragment(int viewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.Nullable()
    java.lang.String parentTag) {
    }
    
    @java.lang.Override()
    public void replaceFragment(int viewId, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<? extends androidx.fragment.app.Fragment> clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.Nullable()
    java.lang.String parentTag) {
    }
    
    @java.lang.Override()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @org.jetbrains.annotations.Nullable()
    public <T extends androidx.fragment.app.Fragment>T findFragment(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<T> clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String tag) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.fragment.app.Fragment getTopFragment() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isEmptyFragments() {
        return false;
    }
    
    @java.lang.Override()
    public int getSizeListFragments() {
        return 0;
    }
}