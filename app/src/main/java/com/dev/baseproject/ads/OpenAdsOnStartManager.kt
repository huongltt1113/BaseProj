package com.dev.baseproject.ads

import android.app.Activity
import com.dev.baseproject.App
import com.google.android.gms.ads.appopen.AppOpenAd
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.Date

object OpenAdsOnStartManager {
    var appOpenAd: AppOpenAd? = null
    var isAdShowing = false
    var isSplashScreen = true
    private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private var loadTime = 0L

    val _adFLowStart = MutableSharedFlow<AdModel>()
    val adFLowStart get() = _adFLowStart.asSharedFlow()
    private var currentAdMobTag = ""

    private fun postData(model: AdModel, delay: Long = 0) {
        mainScope.launch {
            delay(delay)
            _adFLowStart.emit(model)
        }
    }

    fun loadAppOpenAd(activity: Activity) {
        postData(
            AdModel(
                type = AdType.OPEN,
                status = AdStatus.SHOW_FAILED,
                tag = currentAdMobTag
            )
        )
    }

    fun showAdIfAvailable(ativity: Activity) {
    }

    private fun isAdAvailable(): Boolean {
        return true
    }

    private fun isCanLoadAd(): Boolean {
        return App.instance.googleMobileAdsConsentManager.canRequestAds
    }

    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
        val dateDifference = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }
}