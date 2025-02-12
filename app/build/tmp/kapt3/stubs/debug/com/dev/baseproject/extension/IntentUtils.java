package com.dev.baseproject.extension;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bJ(\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0016\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Lcom/dev/baseproject/extension/IntentUtils;", "", "()V", "openById", "", "context", "Landroid/content/Context;", "id", "", "is", "Ljava/io/InputStream;", "share", "", "activity", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "mineType", "name", "shareText", "title", "text", "shareUrl", "url", "app_debug"})
public final class IntentUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.extension.IntentUtils INSTANCE = null;
    
    private IntentUtils() {
        super();
    }
    
    public final void openById(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    private final void openById(android.content.Context context, java.lang.String id, java.io.InputStream is) {
    }
    
    public final boolean share(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    java.lang.String mineType, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
        return false;
    }
    
    public final void shareUrl(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public final void shareText(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
    }
}