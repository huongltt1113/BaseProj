package com.dev.baseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class DialogTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_CLAP_DIALOG_SEEN = "clapDialogSeen";
    private static final String KEY_DONT_TOUCH_DIALOG_SEEN = "dontTouchDialogSeen";
    private static final String KEY_VOICE_DIALOG_SEEN = "voiceDialogSeen";
    private static final String PREFS_NAME = "DialogTrackerPrefs";
    private final SharedPreferences sharedPreferences;

    public DialogTracker(Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(PREFS_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
    }

    public boolean isClapDialogSeen() {
        return this.sharedPreferences.getBoolean(KEY_CLAP_DIALOG_SEEN, false);
    }

    public void setClapDialogSeen(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(KEY_CLAP_DIALOG_SEEN, z);
        edit.apply();
    }

    public boolean isDontTouchDialogSeen() {
        return this.sharedPreferences.getBoolean(KEY_DONT_TOUCH_DIALOG_SEEN, false);
    }

    public void setDontTouchDialogSeen(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(KEY_DONT_TOUCH_DIALOG_SEEN, z);
        edit.apply();
    }

    public boolean isVoiceDialogSeen() {
        return this.sharedPreferences.getBoolean(KEY_VOICE_DIALOG_SEEN, false);
    }

    public void setVoiceDialogSeen(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(KEY_VOICE_DIALOG_SEEN, z);
        edit.apply();
    }

    public boolean haveAllDialogsBeenSeen() {
        return isClapDialogSeen() && isDontTouchDialogSeen() && isVoiceDialogSeen();
    }

    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
