package com.dev.baseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class LocaleManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LANGUAGE_KEY = "languageKey";
    private static final String PREF_NAME = "LocaleManager";
    private final Context context;
    private final SharedPreferences preferences;

    public LocaleManager(Context context2) {
        this.context = context2;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(PREF_NAME, 0);
        this.preferences = sharedPreferences;
    }

    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void saveLocale(String str) {
        this.preferences.edit().putString(LANGUAGE_KEY, str).apply();
    }

    public Locale getLocale() {
        String string = this.preferences.getString(LANGUAGE_KEY, "en");
        if (string == null) {
            string = "";
        }
        if (string.length() > 0) {
            return new Locale(string);
        }
        Locale locale = Locale.getDefault();
        return locale;
    }
}
