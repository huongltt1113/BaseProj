package com.dev.baseproject.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J9\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020\nH\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u0002032\u0006\u0010.\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl;", "Lcom/dev/baseproject/repository/FileHelper;", "()V", "cancelDownload", "", "", "checkPermission", "context", "Landroid/content/Context;", "convertFileTypeToText", "", "type", "downloadFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "url", "filename", "getDataColumn", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getDirFile", "Ljava/io/File;", "getFilePath", "getFileType", "path", "getRealPath", "fileUri", "getRealPathFromURI_API19", "getStringCountRoundingFile", "count", "", "getStringFromStream", "_is", "Ljava/io/InputStream;", "getStringSizeLengthFile", "size", "", "isDownloadsDocument", "isExternalStorageDocument", "isGooglePhotosUri", "isMediaDocument", "shareFile", "filePath", "sharePdfFile", "activity", "Landroid/app/Activity;", "saveFile", "Lokhttp3/ResponseBody;", "DownloadState", "app_debug"})
public final class FileHelperImpl implements com.dev.baseproject.repository.FileHelper {
    private boolean cancelDownload = false;
    
    @javax.inject.Inject()
    public FileHelperImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getStringFromStream(@org.jetbrains.annotations.Nullable()
    java.io.InputStream _is) {
        return null;
    }
    
    @java.lang.Override()
    public boolean checkPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @java.lang.Override()
    public void shareFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
    }
    
    @java.lang.Override()
    public void sharePdfFile(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getFileType(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String convertFileTypeToText(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getStringSizeLengthFile(long size) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getStringCountRoundingFile(int count) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.io.File getDirFile() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public kotlinx.coroutines.flow.Flow<com.dev.baseproject.repository.FileHelperImpl.DownloadState> downloadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
        return null;
    }
    
    public final void cancelDownload() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRealPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri fileUri) {
        return null;
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"NewApi"})
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRealPathFromURI_API19(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getDataColumn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getFilePath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    @java.lang.Override()
    public boolean isExternalStorageDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    @java.lang.Override()
    public boolean isDownloadsDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    @java.lang.Override()
    public boolean isMediaDocument(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    @java.lang.Override()
    public boolean isGooglePhotosUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return false;
    }
    
    private final kotlinx.coroutines.flow.Flow<com.dev.baseproject.repository.FileHelperImpl.DownloadState> saveFile(okhttp3.ResponseBody $this$saveFile, java.lang.String filePath) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "", "()V", "CancelDownload", "Downloading", "Failed", "Finished", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$CancelDownload;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Downloading;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Failed;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Finished;", "app_debug"})
    public static abstract class DownloadState {
        
        private DownloadState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$CancelDownload;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "()V", "app_debug"})
        public static final class CancelDownload extends com.dev.baseproject.repository.FileHelperImpl.DownloadState {
            @org.jetbrains.annotations.NotNull()
            public static final com.dev.baseproject.repository.FileHelperImpl.DownloadState.CancelDownload INSTANCE = null;
            
            private CancelDownload() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Downloading;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "progress", "", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
        public static final class Downloading extends com.dev.baseproject.repository.FileHelperImpl.DownloadState {
            private final int progress = 0;
            
            public Downloading(int progress) {
            }
            
            public final int getProgress() {
                return 0;
            }
            
            public final int component1() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.dev.baseproject.repository.FileHelperImpl.DownloadState.Downloading copy(int progress) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Failed;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Failed extends com.dev.baseproject.repository.FileHelperImpl.DownloadState {
            @org.jetbrains.annotations.Nullable()
            private final java.lang.Throwable error = null;
            
            public Failed(@org.jetbrains.annotations.Nullable()
            java.lang.Throwable error) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Throwable getError() {
                return null;
            }
            
            public Failed() {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Throwable component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.dev.baseproject.repository.FileHelperImpl.DownloadState.Failed copy(@org.jetbrains.annotations.Nullable()
            java.lang.Throwable error) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState$Finished;", "Lcom/dev/baseproject/repository/FileHelperImpl$DownloadState;", "()V", "app_debug"})
        public static final class Finished extends com.dev.baseproject.repository.FileHelperImpl.DownloadState {
            @org.jetbrains.annotations.NotNull()
            public static final com.dev.baseproject.repository.FileHelperImpl.DownloadState.Finished INSTANCE = null;
            
            private Finished() {
            }
        }
    }
}