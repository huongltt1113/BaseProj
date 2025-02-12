package com.dev.baseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("config_prefs", 0);
        this.sharedPreferences = sharedPreferences2;
    }

    public void saveBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static  boolean getBooleandefault(SharedPreferencesHelper sharedPreferencesHelper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return sharedPreferencesHelper.getBoolean(str, z);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sharedPreferences.getBoolean(str, z);
    }
}
