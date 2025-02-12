package com.dev.baseproject.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/dev/baseproject/notification/NotifyConstants;", "", "()V", "NOTIFICATION_ACTION_KEY", "", "NOTIFICATION_INTENT_KEY", "NOTIFICATION_TRACKING_TAG", "NotifyType", "TrackingTag", "app_debug"})
public final class NotifyConstants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_ACTION_KEY = "local_notify_action";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_INTENT_KEY = "notificationIntentKey";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_TRACKING_TAG = "notify_tracking_tag";
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.notification.NotifyConstants INSTANCE = null;
    
    private NotifyConstants() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/dev/baseproject/notification/NotifyConstants$NotifyType;", "", "()V", "NOTIFY_TYPE_AFTER_10M", "", "NOTIFY_TYPE_D1", "NOTIFY_TYPE_D2", "NOTIFY_TYPE_D7", "NOTIFY_TYPE_FAVORITE_DOC", "NOTIFY_TYPE_RECENT_DOC", "NOTIFY_TYPE_SATURDAY", "app_debug"})
    public static final class NotifyType {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_D1 = "D1";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_D2 = "D2";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_D7 = "D7";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_SATURDAY = "weekly";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_AFTER_10M = "10m";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_FAVORITE_DOC = "D4";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_TYPE_RECENT_DOC = "recent";
        @org.jetbrains.annotations.NotNull()
        public static final com.dev.baseproject.notification.NotifyConstants.NotifyType INSTANCE = null;
        
        private NotifyType() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/dev/baseproject/notification/NotifyConstants$TrackingTag;", "", "()V", "NOTIFY_AFTER_10M", "", "NOTIFY_AFTER_12H_RECENT_DOC", "NOTIFY_AFTER_4D_FAVORITE_DOC", "NOTIFY_D1", "NOTIFY_D2", "NOTIFY_D7", "NOTIFY_SATURDAY", "NOTIFY_UNKNOW_TAG", "app_debug"})
    public static final class TrackingTag {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_D1 = "notify_d1";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_D2 = "notify_d2";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_D7 = "notify_d7";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_SATURDAY = "notify_saturday";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_AFTER_10M = "notify_after_10m";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_UNKNOW_TAG = "notify_unknow_tag";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_AFTER_4D_FAVORITE_DOC = "notify_after_4d_favorite_doc";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOTIFY_AFTER_12H_RECENT_DOC = "notify_after_1d_recent_doc";
        @org.jetbrains.annotations.NotNull()
        public static final com.dev.baseproject.notification.NotifyConstants.TrackingTag INSTANCE = null;
        
        private TrackingTag() {
            super();
        }
    }
}