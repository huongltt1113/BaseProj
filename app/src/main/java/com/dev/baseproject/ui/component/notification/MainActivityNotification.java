package com.dev.baseproject.ui.component.notification;

import android.app.NotificationChannel;
import android.os.Build;

public final class MainActivityNotification {
    public static  NotificationChannel m(String str, CharSequence charSequence, int i) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new NotificationChannel(str, charSequence, i);
        }
        return null;
    }

    public static  void m() {

    }
}
