package com.dev.baseproject.notification.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/dev/baseproject/notification/model/NotifyData;", "", "clickAction", "", "notifyContent", "", "Lcom/dev/baseproject/notification/model/NotifyContent;", "id", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getClickAction", "()Ljava/lang/String;", "setClickAction", "(Ljava/lang/String;)V", "getId", "setId", "getNotifyContent", "()Ljava/util/List;", "setNotifyContent", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class NotifyData {
    @com.google.gson.annotations.SerializedName(value = "a")
    @com.google.gson.annotations.Expose()
    @org.jetbrains.annotations.Nullable()
    private java.lang.String clickAction;
    @com.google.gson.annotations.SerializedName(value = "nc")
    @com.google.gson.annotations.Expose()
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.dev.baseproject.notification.model.NotifyContent> notifyContent;
    @com.google.gson.annotations.SerializedName(value = "id")
    @com.google.gson.annotations.Expose()
    @org.jetbrains.annotations.Nullable()
    private java.lang.String id;
    
    public NotifyData(@org.jetbrains.annotations.Nullable()
    java.lang.String clickAction, @org.jetbrains.annotations.Nullable()
    java.util.List<com.dev.baseproject.notification.model.NotifyContent> notifyContent, @org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClickAction() {
        return null;
    }
    
    public final void setClickAction(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.dev.baseproject.notification.model.NotifyContent> getNotifyContent() {
        return null;
    }
    
    public final void setNotifyContent(@org.jetbrains.annotations.Nullable()
    java.util.List<com.dev.baseproject.notification.model.NotifyContent> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.dev.baseproject.notification.model.NotifyContent> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dev.baseproject.notification.model.NotifyData copy(@org.jetbrains.annotations.Nullable()
    java.lang.String clickAction, @org.jetbrains.annotations.Nullable()
    java.util.List<com.dev.baseproject.notification.model.NotifyContent> notifyContent, @org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}