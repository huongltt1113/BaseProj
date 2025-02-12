package com.dev.baseproject.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H&J9\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013H&\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H&J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0010H&J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0012\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\'\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0007H&J\u0018\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u00060"}, d2 = {"Lcom/dev/baseproject/repository/FileHelper;", "", "checkPermission", "", "context", "Landroid/content/Context;", "convertFileTypeToText", "", "type", "downloadFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "url", "filename", "getDataColumn", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getDirFile", "Ljava/io/File;", "getFilePath", "getFileType", "path", "getRealPath", "fileUri", "getRealPathFromURI_API19", "getStringCountRoundingFile", "count", "", "getStringFromStream", "_is", "Ljava/io/InputStream;", "getStringSizeLengthFile", "size", "", "isDownloadsDocument", "isExternalStorageDocument", "isGooglePhotosUri", "isMediaDocument", "shareFile", "", "filePath", "sharePdfFile", "activity", "Landroid/app/Activity;", "app_debug"})
public abstract interface FileHelper {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStringFromStream(@org.jetbrains.annotations.Nullable()
    java.io.InputStream _is);
    
    public abstract boolean checkPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void shareFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath);
    
    public abstract void sharePdfFile(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFileType(@org.jetbrains.annotations.NotNull()
    java.lang.String path);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String convertFileTypeToText(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStringSizeLengthFile(long size);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStringCountRoundingFile(int count);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.io.File getDirFile();
    
    @org.jetbrains.annotations.Nullable()
    public abstract kotlinx.coroutines.flow.Flow<com.dev.baseproject.repository.FileHelperImpl.DownloadState> downloadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getRealPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri fileUri);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getRealPathFromURI_API19(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getDataColumn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getFilePath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract boolean isExternalStorageDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract boolean isDownloadsDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract boolean isMediaDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract boolean isGooglePhotosUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
}