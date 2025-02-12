package com.dev.baseproject.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/dev/baseproject/data/ResponseModel;", "T", "", "data", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "nextOffset", "", "getNextOffset", "()Ljava/lang/Integer;", "setNextOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageId", "getPageId", "setPageId", "status", "getStatus", "setStatus", "app_debug"})
public final class ResponseModel<T extends java.lang.Object> {
    @com.google.gson.annotations.SerializedName(value = "data")
    @org.jetbrains.annotations.NotNull()
    private java.util.List<T> data;
    @com.google.gson.annotations.SerializedName(value = "message")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String message;
    @com.google.gson.annotations.SerializedName(value = "status")
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer status;
    @com.google.gson.annotations.SerializedName(value = "pageId")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String pageId;
    @com.google.gson.annotations.SerializedName(value = "hasnext")
    private boolean hasNext = false;
    @com.google.gson.annotations.SerializedName(value = "nextoffset")
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer nextOffset;
    
    public ResponseModel(@org.jetbrains.annotations.NotNull()
    java.util.List<T> data) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<T> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPageId() {
        return null;
    }
    
    public final void setPageId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getHasNext() {
        return false;
    }
    
    public final void setHasNext(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNextOffset() {
        return null;
    }
    
    public final void setNextOffset(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public ResponseModel() {
        super();
    }
}