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

    override var userBalance: Int
        get() = getData(Constants.PreferencesKey.USER_BALANCE, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.USER_BALANCE, value)
        }

    override var appOpen: String
        get() = getData(Constants.PreferencesKey.APP_OPEN, String::class) ?: "ca-app-pub-3940256099942544/9257395921"
        set(value) {
            putData(Constants.PreferencesKey.APP_OPEN, value)
        }

    override var userOneTime: Int
        get() = getData(Constants.PreferencesKey.USER_ONE_TIME, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.USER_ONE_TIME, value)
        }

    override var isFirstAccectPrivacyTerms: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_ACCEPT_PRIVACY_TERMS, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_ACCEPT_PRIVACY_TERMS, value)
        }

    override var goToHome: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_HOME, value)
        }

    override var goToPrivacy: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_PRIVACY, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_PRIVACY, value)
        }

    override var isFirstShowCheckInternetDialog: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SHOW_CHECK_INTERNET_DIALOG, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SHOW_CHECK_INTERNET_DIALOG, value)
        }
    override var isFirstConfirmYesCheckInternetDialog: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_CONFIRM_YES_CHECK_INTERNET_DIALOG, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_CONFIRM_YES_CHECK_INTERNET_DIALOG, value)
        }
    override var isFirstConfirmCancelCheckInternetDialog: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG, value)
        }
    override var isNotificationPermissionDeniedOnce: Boolean
        get() = getData(Constants.PreferencesKey.IS_NOTIFICATION_PERMISSION_DENIED, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_NOTIFICATION_PERMISSION_DENIED, value)
        }
    override var goToRecordPasscode: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_RECORD_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_RECORD_PASSCODE, value)
        }
    override var goToTextToVoice: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_TEXT_TO_VOICE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_TEXT_TO_VOICE, value)
        }
    override var goToCreatePasscode: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_CREATE_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_CREATE_PASSCODE, value)
        }
    override var isSoundEnabled: Boolean
        get() = getData(Constants.PreferencesKey.IS_SOUND_ENABLED, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_SOUND_ENABLED, value)
        }
    override var isVibrationEnabled: Boolean
        get() = getData(Constants.PreferencesKey.IS_VIBRATION_ENABLED, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_VIBRATION_ENABLED, value)
        }
    override var isFlashEnabled: Boolean
        get() = getData(Constants.PreferencesKey.IS_FLASH_ENABLED, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FLASH_ENABLED, value)
        }
    override var timeDuration: Long
        get() = getData(Constants.PreferencesKey.TIME_DURATION, Long::class) ?: 15000L
        set(value) {
            putData(Constants.PreferencesKey.TIME_DURATION, value)
        }
    override var durationAdded: String
        get() = getData(Constants.PreferencesKey.DURATION_ADDED, String::class) ?: ""
        set(value) {
            putData(Constants.PreferencesKey.DURATION_ADDED, value)
        }
    override var resourceId: Int
        get() = getData(Constants.PreferencesKey.RESOURCE_ID, Int::class) ?: R.drawable.ballerina_music
        set(value) {
            putData(Constants.PreferencesKey.RESOURCE_ID, value)
        }
    override var flashSpeed: Int
        get() = getData(Constants.PreferencesKey.FLASH_SPEED, Int::class) ?: 1200
        set(value) {
            putData(Constants.PreferencesKey.FLASH_SPEED, value)
        }
    override var voiceLocal: String
        get() = getData(Constants.PreferencesKey.VOICE_LOCAL, String::class) ?: "en"
        set(value) {
            putData(Constants.PreferencesKey.VOICE_LOCAL, value)
        }
    override var voicePasscode: String
        get() = getData(Constants.PreferencesKey.VOICE_PASSCODE, String::class) ?: ""
        set(value) {
            putData(Constants.PreferencesKey.VOICE_PASSCODE, value)
        }
    override var isFirstSwitchSoundClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SWITCH_SOUND, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SWITCH_SOUND, value)
        }
    override var isFirstSwitchVibrateClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SWITCH_VIBRATE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SWITCH_VIBRATE, value)
        }
    override var isFirstSwitchFlashClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SWITCH_FLASH, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SWITCH_FLASH, value)
        }
    override var isFirstVoiceMaxClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_VOICE_MAX, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_VOICE_MAX, value)
        }
    override var isFirstVoiceMuteClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_VOICE_MUTE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_VOICE_MUTE, value)
        }
    override var isFirstPlaySoundDetailClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_PLAY_SOUND, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_PLAY_SOUND, value)
        }
    override var isFirstApplySoundDetailClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_APPLY_SOUND, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_APPLY_SOUND, value)
        }
    override var goToSetting: Boolean
        get() = getData(Constants.PreferencesKey.GO_TO_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.GO_TO_SETTING, value)
        }
    override var goToHowtoUse: Boolean
        get() = getData(Constants.PreferencesKey. GO_TO_HOW_TO_USE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey. GO_TO_HOW_TO_USE, value)
        }
    override var goToChooseSound: Boolean
        get() = getData(Constants.PreferencesKey. GO_TO_CHOOSE_SOUND, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey. GO_TO_CHOOSE_SOUND, value)
        }
    override var goToSoundDetail: Boolean
        get() = getData(Constants.PreferencesKey. GO_TO_SOUND_DETAIL, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey. GO_TO_SOUND_DETAIL, value)
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

    override var isFirstActiveHomeClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_ACTIVE_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_ACTIVE_HOME, value)
        }
    override var isFirstChangeVoicePasscodeHomeClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_CHANGE_VOICE_PASSCODE_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_CHANGE_VOICE_PASSCODE_HOME, value)
        }
    override var isFirstDontTouchClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_DONT_TOUCH_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_DONT_TOUCH_HOME, value)
        }
    override var isFirstPocketClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_POCKET_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_POCKET_HOME, value)
        }
    override var isFirstClapClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_CLAP_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_CLAP_HOME, value)
        }
    override var isFirstVoiceClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_VOICE_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_VOICE_HOME, value)
        }
    override var isFirstRecordVoiceClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_RECORD_VOICE_RECORD_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_RECORD_VOICE_RECORD_PASSCODE, value)
        }
    override var isFirstSavePasscodeClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SAVE_RECORD_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SAVE_RECORD_PASSCODE, value)
        }
    override var isFirstSelectLanguageRecordPasscodeClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SELECT_LANGUAGE_RECORD_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SELECT_LANGUAGE_RECORD_PASSCODE, value)
        }
    override var isFirstSavePasscodeTexttoVoiceClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SAVE_TEXT_TO_VOICE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SAVE_TEXT_TO_VOICE, value)
        }
    override var isFirstListenTexttoVoiceClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_LISTEN_TEXT_TO_VOICE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_LISTEN_TEXT_TO_VOICE, value)
        }
    override var isFirstSelectLanguageTexttoVoiceClick: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_SELECT_LANGUAGE_TEXT_TO_VOICE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_SELECT_LANGUAGE_TEXT_TO_VOICE, value)
        }
    override var isFirstInstall: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_INSTALL, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_INSTALL, value)
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
    override var lastTimeExitApp: Long
        get() = getData(Constants.PreferencesKey.LAST_TIME_EXIT_APP, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LAST_TIME_EXIT_APP, value)
        }
    override var countClickNoBeforeUpdate: Int
        get() = getData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_UPDATE, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_UPDATE, value)
        }
    override var isFirstOpenLanguage: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_LANGUAGE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_LANGUAGE, value)
        }
    override var countTotalExitAppToShowRating: Int
        get() = getData(Constants.PreferencesKey.COUNT_TOTAL_EXIST_TO_SHOW_RATING_APP, Int::class)
            ?: 0
        set(value) {
            putData(Constants.PreferencesKey.COUNT_TOTAL_EXIST_TO_SHOW_RATING_APP, value)
        }

    override var isShowRating: Boolean
        get() = getData(Constants.PreferencesKey.IS_SHOW_RATING, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_SHOW_RATING, value)
        }
    override var isStartService300s: Boolean
        get() = getData(Constants.PreferencesKey.IS_START_SERVICE_300S, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_START_SERVICE_300S, value)
        }
    override var countShowRating: Int
        get() = getData(Constants.PreferencesKey.COUNT_SHOW_RATING, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.COUNT_SHOW_RATING, value)
        }
    override var timeShowRatingFirst: Long
        get() = getData(Constants.PreferencesKey.TIME_SHOW_RATING_FIRST, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.TIME_SHOW_RATING_FIRST, value)
        }
    override var countClickNoBeforeRating: Int
        get() = getData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_RATING_APP, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_RATING_APP, value)
        }
    override var isDontShowConfirmNotificationPermission: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_DONT_SHOW_CONFIRM_NOTIFICATION_PERMISSION,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_DONT_SHOW_CONFIRM_NOTIFICATION_PERMISSION, value)
        }
    override var isGoToPermissionNotificaton: Boolean
        get() = getData(Constants.PreferencesKey.IS_GRANT_GO_TO_NOTIFICATION, Boolean::class)
            ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_GRANT_GO_TO_NOTIFICATION, value)
        }
    override var countClickNoBeforeNotification: Int
        get() = getData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_NOTIFICATION, Int::class)
            ?: 0
        set(value) {
            putData(Constants.PreferencesKey.COUNT_CLICK_NO_BEFORE_NOTIFICATION, value)
        }
    override var isDenyNotificationPermissionFirst: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_DENY_NOTIFICATION_PERMISSION_FIRST,
            Boolean::class
        ) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_DENY_NOTIFICATION_PERMISSION_FIRST, value)
        }
    override var lastStartTimeMotion: Long
        get() = getData(Constants.PreferencesKey.LAST_START_TIME_MOTION, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LAST_START_TIME_MOTION, value)
        }
    override var lastStartTimeClap: Long
        get() = getData(Constants.PreferencesKey.LAST_START_TIME_CLAP, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LAST_START_TIME_CLAP, value)
        }
    override var lastStartTimeVoice: Long
        get() = getData(Constants.PreferencesKey.LAST_START_TIME_VOICE, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LAST_START_TIME_VOICE, value)
        }
    override var lastStartTimePocket: Long
        get() = getData(Constants.PreferencesKey.LAST_START_TIME_POCKET, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LAST_START_TIME_POCKET, value)
        }
    override var isPhoneFoundActivityActive: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_PHONE_FOUND_ACTIVE,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_PHONE_FOUND_ACTIVE, value)
        }
    override var isClapServiceDetected: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_CLAP_SERVICE_DETECTED,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_CLAP_SERVICE_DETECTED, value)
        }
    override var isDontTouchServiceDetected: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_DONT_TOUCH_SERVICE_DETECTED,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_DONT_TOUCH_SERVICE_DETECTED, value)
        }
    override var isPocketServiceDetected: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_POCKET_SERVICE_DETECTED,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_POCKET_SERVICE_DETECTED, value)
        }
    override var isVoiceServiceDetected: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_VOICE_SERVICE_DETECTED,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_VOICE_SERVICE_DETECTED, value)
        }
    override var isFirstAudioPermissionRequire: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_AUDIO_PERMISSION_REQUIRE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_AUDIO_PERMISSION_REQUIRE, value)
        }

    override var isFirstNotificationPermissionRequire: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_NOTIFICATION_PERMISSION_REQUIRE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_NOTIFICATION_PERMISSION_REQUIRE, value)
        }
    override var isShowClapIntro: Boolean
        get() = getData(Constants.PreferencesKey.IS_SHOW_CLAP_INTRO, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_SHOW_CLAP_INTRO, value)
        }
    override var isShowVoiceIntro: Boolean
        get() = getData(Constants.PreferencesKey.IS_SHOW_VOICE_INTRO, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_SHOW_VOICE_INTRO, value)
        }
    override var isShowDontTouchIntro: Boolean
        get() = getData(Constants.PreferencesKey.IS_SHOW_DONT_TOUCH_INTRO, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_SHOW_DONT_TOUCH_INTRO, value)
        }
    override var isShowPocketIntro: Boolean
        get() = getData(Constants.PreferencesKey.IS_SHOW_POCKET_INTRO, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_SHOW_POCKET_INTRO, value)
        }
    override var lastMode: Int
        get() = getData(Constants.PreferencesKey.LAST_MODE, Int::class) ?: 1
        set(value) {
            putData(Constants.PreferencesKey.LAST_MODE, value)
        }
    override var recentSounds: String
        get() = getData(Constants.PreferencesKey.RECENT_SOUNDS, String::class) ?: ""
        set(value) {
            putData(Constants.PreferencesKey.RECENT_SOUNDS, value)
        }
    override var isPhoneFoundActivityActiveFromNoti: Boolean
        get() = getData(
            Constants.PreferencesKey.IS_PHONE_FOUND_ACTIVE_FROM_NOTI,
            Boolean::class
        ) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_PHONE_FOUND_ACTIVE_FROM_NOTI, value)
        }
    override var isFirstOpenSetting: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_SETTING, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_SETTING, value)
        }
    override var isChangeSettingSoundDetail: Boolean
        get() = getData(Constants.PreferencesKey.IS_CHANGE_SETTING_SOUND_DETAIL, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.IS_CHANGE_SETTING_SOUND_DETAIL, value)
        }
    override var defaultSoundVolume: Float
        get() = getData(Constants.PreferencesKey.DEFAULT_SOUND_VOLUME, Float::class) ?: 0.6f
        set(value) {
            putData(Constants.PreferencesKey.DEFAULT_SOUND_VOLUME, value)
        }
    override var sensitivityPK: Float
        get() = getData(Constants.PreferencesKey.SENSITIVITY_PK, Float::class) ?: Constants.SENSITIVITY_PK_FAST
        set(value) {
            putData(Constants.PreferencesKey.SENSITIVITY_PK, value)
        }
    override var withLightPK: Boolean
        get() = getData(Constants.PreferencesKey.WITH_LIGHT_PK, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.WITH_LIGHT_PK, value)
        }
    override var sensitivityDT: Float
        get() = getData(Constants.PreferencesKey.SENSITIVITY_DT, Float::class) ?: Constants.SENSITIVITY_DT_FAST
        set(value) {
            putData(Constants.PreferencesKey.SENSITIVITY_DT, value)
        }
    override var shouldShowBatteryDialog: Boolean
        get() = getData(Constants.PreferencesKey.SHOULD_SHOW_BATTERY_DIALOG, Boolean::class) ?: false
        set(value) {
            putData(Constants.PreferencesKey.SHOULD_SHOW_BATTERY_DIALOG, value)
        }
    override var isFirstOpenCreatePasscode: Boolean
        get() =  getData(Constants.PreferencesKey.IS_FIRST_OPEN_CREATE_PASSCODE, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_CREATE_PASSCODE, value)
        }
    override var languageScrollPosition: Int
        get() = getData(Constants.PreferencesKey.LANGUAGE_SCROLL_POSITION, Int::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.LANGUAGE_SCROLL_POSITION, value)
        }
    override var isFirstOpenHome: Boolean
        get() = getData(Constants.PreferencesKey.IS_FIRST_OPEN_HOME, Boolean::class) ?: true
        set(value) {
            putData(Constants.PreferencesKey.IS_FIRST_OPEN_HOME, value)
        }
    override var startTimer: Long
        get() = getData(Constants.PreferencesKey.START_TIMER, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.START_TIMER, value)
        }
    override var finishTimer: Long
        get() = getData(Constants.PreferencesKey.FINISH_TIMER, Long::class) ?: 0
        set(value) {
            putData(Constants.PreferencesKey.FINISH_TIMER, value)
        }
    override var voiceRealPasscode: String
        get() = getData(Constants.PreferencesKey.VOICE_REAL_PASSCODE, String::class) ?: ""
        set(value) {
            putData(Constants.PreferencesKey.VOICE_REAL_PASSCODE, value)
        }
}
