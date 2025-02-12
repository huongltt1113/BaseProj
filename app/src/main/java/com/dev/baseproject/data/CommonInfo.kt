package com.dev.baseproject.data

import com.dev.baseproject.utils.Constants


class CommonInfo {
    var isMinData: Boolean = true
    var server: String = ""
    var urlStorage: String = ""
    var storageRegion: String = ""
    var endpointMnt: String = ""
    var isShowAds: Boolean = true
    val typeAds = "only_admob"
    val rewardCount = 0
    val supportAppOpenAds = true
    val supportAdaptiveBanner = true
    val supportNative = false
    val supportInter = true
    val countryContentRating = ""
    val runContentRatingT = false
    val onNativeAge = false

    val nativeAdCount = Constants.DEFAULT_NATIVE_AD_COUNT
    val waitingShowInter = Constants.DEFAULT_WAITING_SHOW_INTER
    val loadAdDistance = Constants.DEFAULT_LOAD_ADS_DISTANCE

    val versionAppReview = 0
    val currentVersionApp = 0
    //0: True, 1: False
    val isForceUpdate = 1
    //0: True, 1: False
    val isShowCollapsibleHome = 0
    //0: True, 1: False
    val isShowCollapsibleOther = 1

    companion object {
        const val DEFAULT_NATIVE_AD_COUNT = 10
        const val DEFAULT_MILLISECOND_INTERVAL = 1000L
        const val DEFAULT_HOUR_INTERVAL = 3600L
        const val DEFAULT_MINUTE_INTERVAL = 60L
        const val FORMAT_TIME = "yyyy-MM-dd HH:mm:ss"
        const val KEY_COUNT = "key_count"
        const val KEY_VIP_TIME = "key_vip_time"
        const val KEY_DISCOUNT_TIME = "key_discount_time"
        const val KEY_TURN = "key_turn"
    }
}