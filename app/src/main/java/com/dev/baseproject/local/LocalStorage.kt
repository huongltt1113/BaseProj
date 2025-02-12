package com.dev.baseproject.local

import kotlin.reflect.KClass

interface LocalStorage {

    fun putString(key: String, value: String?)
    fun getString(key: String): String?
    fun remove(key: String)

    var authorization: String?

    fun <T : Any> putData(key: String, t: T?)

    fun <T : Any> getData(key: String): T?

    fun <T : Any> getData(key: String, clazz: KClass<T>): T?

    var isFirstOpen: Boolean

    var langCode: String

    var userBalance: Int
    var appOpen: String
    var userOneTime:Int
    var isFirstAccectPrivacyTerms: Boolean
    var goToHome: Boolean
    var goToPrivacy: Boolean
    var goToRecordPasscode: Boolean
    var goToTextToVoice: Boolean
    var isFirstShowCheckInternetDialog: Boolean
    var isFirstConfirmYesCheckInternetDialog: Boolean
    var isFirstConfirmCancelCheckInternetDialog: Boolean
    var isNotificationPermissionDeniedOnce:Boolean
    var goToCreatePasscode: Boolean
    var goToSetting: Boolean
    var goToHowtoUse: Boolean
    var goToChooseSound: Boolean
    var goToSoundDetail: Boolean
    var isSoundEnabled:Boolean
    var isVibrationEnabled:Boolean
    var isFlashEnabled:Boolean
    var timeDuration: Long
    var durationAdded: String
    var resourceId: Int
    var flashSpeed: Int
    var voiceLocal: String
    var voicePasscode: String
    var isFirstSwitchSoundClick: Boolean
    var isFirstSwitchVibrateClick: Boolean
    var isFirstSwitchFlashClick: Boolean
    var isFirstVoiceMaxClick: Boolean
    var isFirstVoiceMuteClick: Boolean
    var isFirstPlaySoundDetailClick: Boolean
    var isFirstApplySoundDetailClick: Boolean
    var isFirstRadioSettingClick: Boolean
    var isFirstFeedbackSettingClick: Boolean
    var isFirstRateUsSettingClick: Boolean
    var isFirstPrivacySettingClick: Boolean
    var isFirstLanguageSetting: Boolean
    var isFirstActiveHomeClick: Boolean
    var isFirstChangeVoicePasscodeHomeClick: Boolean
    var isFirstDontTouchClick: Boolean
    var isFirstPocketClick: Boolean
    var isFirstClapClick: Boolean
    var isFirstVoiceClick: Boolean
    var isFirstRecordVoiceClick: Boolean
    var isFirstSavePasscodeClick: Boolean
    var isFirstSelectLanguageRecordPasscodeClick: Boolean
    var isFirstSavePasscodeTexttoVoiceClick: Boolean
    var isFirstListenTexttoVoiceClick: Boolean
    var isFirstSelectLanguageTexttoVoiceClick: Boolean
    var isFirstInstall: Boolean
    var firstTimeOpenApp: Long
    var isFirstOpenIntro1: Boolean

    var isFirstOpenIntro2: Boolean

    var isFirstOpenIntro3: Boolean
    var lastTimeExitApp: Long
    var countClickNoBeforeUpdate : Int
    var isFirstOpenLanguage: Boolean
    var countTotalExitAppToShowRating : Int
    var isShowRating: Boolean
    var isStartService300s: Boolean
    var countShowRating: Int
    var timeShowRatingFirst: Long
    var countClickNoBeforeRating : Int
    var isDontShowConfirmNotificationPermission: Boolean
    var isGoToPermissionNotificaton: Boolean
    var countClickNoBeforeNotification : Int
    var isDenyNotificationPermissionFirst: Boolean
    var lastStartTimeMotion:Long
    var lastStartTimeClap:Long
    var lastStartTimeVoice:Long
    var lastStartTimePocket:Long

    var isFirstAudioPermissionRequire: Boolean
    var isFirstNotificationPermissionRequire: Boolean

    var isShowClapIntro: Boolean
    var isShowVoiceIntro: Boolean
    var isShowDontTouchIntro: Boolean
    var isShowPocketIntro: Boolean
    var lastMode: Int
    var isPhoneFoundActivityActive: Boolean
    var isClapServiceDetected: Boolean
    var isDontTouchServiceDetected: Boolean
    var isPocketServiceDetected: Boolean
    var isVoiceServiceDetected: Boolean
    var isPhoneFoundActivityActiveFromNoti: Boolean
    var recentSounds: String
    var isFirstOpenSetting: Boolean
    var isChangeSettingSoundDetail: Boolean
    var defaultSoundVolume: Float
    var sensitivityPK: Float
    var withLightPK: Boolean
    var sensitivityDT: Float
    var shouldShowBatteryDialog: Boolean
    var isFirstOpenCreatePasscode: Boolean
    var languageScrollPosition: Int
    var isFirstOpenHome: Boolean
    var startTimer: Long
    var finishTimer: Long
    var voiceRealPasscode: String
}