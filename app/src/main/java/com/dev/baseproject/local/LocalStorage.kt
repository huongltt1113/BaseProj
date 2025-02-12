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
    var flashSpeed: Int
    var voiceLocal: String
    var isFirstRadioSettingClick: Boolean
    var isFirstFeedbackSettingClick: Boolean
    var isFirstRateUsSettingClick: Boolean
    var isFirstPrivacySettingClick: Boolean
    var isFirstLanguageSetting: Boolean
    var isFirstInstall: Boolean
    var firstTimeOpenApp: Long
    var isFirstOpenIntro1: Boolean

    var isFirstOpenIntro2: Boolean

    var isFirstOpenIntro3: Boolean
    var isFirstOpenLanguage: Boolean

    var isFirstOpenSetting: Boolean
    var languageScrollPosition: Int
}