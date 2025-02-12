package com.dev.baseproject.local

import android.content.Context
import com.dev.baseproject.R
import com.dev.baseproject.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.reflect.KClass

class LocalData @Inject constructor(
    @ApplicationContext context: Context, @PreferenceInfo val fileName: String,

    ) : LocalStorage {

    private val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    override fun putString(key: String, value: String?) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override var authorization: String?
        get() = getString("authorization")
        set(value) {
            putString("authorization", value)
        }

    override fun <T : Any> putData(key: String, t: T?) {
        if (t != null) {
            val str = Gson().toJson(t)
            putString(key, str)
        } else putString(key, null)
    }

    override fun <T : Any> getData(key: String): T? {
        val string = getString(key) ?: return null
        try {
            return Gson().fromJson(string, object : TypeToken<T>() {}.type)
        } catch (e: Exception) {
        }
        return null
    }

    override fun <T : Any> getData(key: String, clazz: KClass<T>): T? {
        val string = getString(key) ?: return null
        try {
            return Gson().fromJson(string, clazz.java)
        } catch (e: Exception) {
        }
        return null
    }

    override var isFirstOpen: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN, value)
        }

    override var langCode: String
        get() = getData(Constants.PreferencesKey.LANG_CODE, String::class) ?: "en"
        set(value) {
            putData(Constants.PreferencesKey.LANG_CODE, value)
        }
    override var flashSpeed: Int
        get() = getData(Constants.PreferencesKey.FLASH_SPEED, Int::class) ?: 1200
        set(value) {
            putData(Constants.PreferencesKey.FLASH_SPEED, value)
        }
    override var isFirstRadioSettingClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_RADIO_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_RADIO_SETTING, value)
        }
    override var isFirstFeedbackSettingClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_FEEDBACK_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_FEEDBACK_SETTING, value)
        }
    override var isFirstRateUsSettingClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_RATEUS_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_RATEUS_SETTING, value)
        }
    override var isFirstPrivacySettingClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_PRIVACY_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_PRIVACY_SETTING, value)
        }
    override var isFirstLanguageSetting: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_LANGUAGE_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_LANGUAGE_SETTING, value)
        }
    override var languageScrollPosition: Int
        get() = getData(Constants.PreferencesKey.LANGUAGE_SCROLL_POSITION, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LANGUAGE_SCROLL_POSITION, value)
        }
    override var isFirstOpenSetting: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_SETTING, value)
        }
    override var isFirstOpenLanguage: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_LANGUAGE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_LANGUAGE, value)
        }
    override var voiceLocal: String
        get() = getData(Constants.PreferencesKey.VOICE_LOCAL, String::class) ?: "en"
        set(value) {
            putData(Constants.PreferencesKey.VOICE_LOCAL, value)
        }
    override var firstTimeOpenApp: Long
        get() = getData(Constants.PreferencesKey.FIRST_TIME_OPEN_APP, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.FIRST_TIME_OPEN_APP, value)
        }
    override var isFirstOpenIntro1: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_1, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_1, value)
        }
    override var isFirstOpenIntro2: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_2, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_2, value)
        }
    override var isFirstOpenIntro3: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_3, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_INTRO_3, value)
        }
    override var isFirstInstall: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_INSTALL, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_INSTALL, value)
        }
}
