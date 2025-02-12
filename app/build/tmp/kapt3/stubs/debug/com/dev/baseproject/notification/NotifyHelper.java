package com.dev.baseproject.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/dev/baseproject/notification/NotifyHelper;", "", "()V", "clearAllNotifyWorker", "", "context", "Landroid/content/Context;", "getAllowNotifyHour", "Ljava/time/LocalDateTime;", "time", "readNotifyFromFile", "", "Lcom/dev/baseproject/notification/model/NotifyData;", "fileResId", "", "app_debug"})
public final class NotifyHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.notification.NotifyHelper INSTANCE = null;
    
    private NotifyHelper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getAllowNotifyHour(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime time) {
        return null;
    }
    
    public final void clearAllNotifyWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.dev.baseproject.notification.model.NotifyData> readNotifyFromFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int fileResId) {
        return null;
    }
}