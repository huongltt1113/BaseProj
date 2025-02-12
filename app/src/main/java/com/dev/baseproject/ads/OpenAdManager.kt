package com.dev.baseproject.ads

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.dev.baseproject.App
import com.google.android.gms.ads.appopen.AppOpenAd
import com.dev.baseproject.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import java.util.Date

object OpenAdManager: LifecycleObserver {
    private var appOpenAd: AppOpenAd? = null
    var isShowingAd = false
    private var currentActivity: WeakReference<Activity>? = null
    private var loadTime = 0L
    private var isTurnOn = true
    private var canShowAd = false
    private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    var isDestroyWhenChangeScreen = false

    private val _adFLow = MutableSharedFlow<AdModel>()
    val adFLow get() = _adFLow.asSharedFlow()
    private var currentAdMobTag = ""

    fun start() {
        App.instance.unregisterActivityLifecycleCallbacks(lifecycleCallbacks)
        App.instance.registerActivityLifecycleCallbacks(lifecycleCallbacks)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onStart() {
        if (isTurnOn) {
            showAdIfAvailable()
        }
    }

    fun switchOnOff(turnOn: Boolean) {
        isTurnOn = turnOn
    }

    private fun postData(model: AdModel, delay: Long = 0) {
        mainScope.launch {
            delay(delay)
            _adFLow.emit(model)
        }
    }

    private fun showAdIfAvailable() {
    }

    private fun fetchAd() {
    }

    private fun isAdAvailable(): Boolean {
        return appOpenAd != null
                && wasLoadTimeLessThanNHoursAgo(4)
                && App.instance.googleMobileAdsConsentManager.canRequestAds
                && !OpenAdsOnStartManager.isAdShowing
    }

    /** Utility method to check if ad was loaded more than n hours ago.  */
    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
        val dateDifference = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }

    private fun removeLifecycleCallbacks() {
        App.instance.unregisterActivityLifecycleCallbacks(lifecycleCallbacks)
    }

    private val lifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
            currentActivity = WeakReference(activity)
//        if (activity is MainActivity) {
//            // do sth
//        }
        }

        override fun onActivityDestroyed(activity: Activity) {
            currentActivity = null
//            if (activity is MainActivity)
//                || activity is MyHomeActivity
//                || activity is SavedScriptsActivity
//                || activity is SettingActivity) {
//                removeLifecycleCallbacks()
//                canShowAd = false
//            }

            if(activity is MainActivity){
                removeLifecycleCallbacks()
                canShowAd = false
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityStopped(activity: Activity) {
            if (activity is MainActivity ) canShowAd = true
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }

        override fun onActivityResumed(activity: Activity) {
            currentActivity = WeakReference(activity)
        }
    }
}