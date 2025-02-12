package com.dev.baseproject.ads

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.FrameLayout
import com.dev.baseproject.BuildConfig
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.dev.baseproject.remote.RemoteConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Decrypt
import com.dev.baseproject.utils.Logger
import com.vungle.ads.BaseAd
import com.vungle.ads.BaseAdListener
import com.vungle.ads.VungleError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference


object AdManager {
    private var adsConsentManager: GoogleMobileAdsConsentManager? = null
    private var loadedInterstitialLastTime = 0L
//    private var loadedRewardLastTime = 0L

    var mInterstitialAd: InterstitialAd? = null
//    private var mRewardedAd: RewardedAd? = null
    private var isLoadingInterstitialAd = false
//    private var isLoadingRewardAd = false
    private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private var retryCountInterstitialAd = 0
    private var retryCountRewardedAd = 0
    private const val MAX_RETRY_COUNT = 5
    private var showedInterstitialLastTime = 0L
    private var mActivity: WeakReference<Activity>? = null
    private var configs = AdsConfig()
    private val _adFLow = MutableSharedFlow<AdModel>()
    val adFLow get() = _adFLow.asSharedFlow()
    private var currentAdMobTag = ""
    private var loadAdJob: Job? = null
    private var adCloseListener : AdCloseListener? = null

    var rewardedInterstitialAd: RewardedInterstitialAd? = null
    private var isLoadingRewardInterAd = false
    private var loadedRewardInterLastTime = 0L
    private var retryCountRewardedIntersAd = 0
    fun initAds(googleMobileAdsConsentManager: GoogleMobileAdsConsentManager) {
        adsConsentManager = googleMobileAdsConsentManager
        loadInterstitialAd(null, true)
        OpenAdManager.start()
    }

    fun attachActivity(activity: Activity) {
        mActivity = WeakReference(activity)
    }

    fun release() {
        mInterstitialAd = null
        rewardedInterstitialAd = null
        vungleInterstitialAd = null
    }

    fun resetShowInterstitialLastTime() {

    }

    fun updateConfig() {

    }

    fun buildAdRequest(isShowCollapsible : Boolean = false): AdRequest {
        val extras = Bundle()
        if (isShowCollapsible) {
            extras.putString("collapsible", "bottom")
            // extras.putString("collapsible_request_id", UUID.randomUUID().toString())
        }
        return AdRequest.Builder()
            .addNetworkExtrasBundle(
                AdMobAdapter::class.java,
                extras
            )
            //.addTestDevice("2A3CD06E42E19CD8E68FE4C38E08302E")
            //.addTestDevice("F9B599244354AF6F1E0269B3332C8A07")
            .build()
    }

    fun loadBanner(view: FrameLayout
                   , isShowCollapsible: Boolean = false
                   , key: String = if (BuildConfig.DEBUG) Constants.BANNER_AD_KEY else Decrypt.decodeBase64String(Constants.BANNER_AD_KEY_REAL), ): AdView {

        val adView = AdView(view.context)
        return adView
    }

    @Synchronized
    fun loadInterstitialAd(inter : AdIntertitialListener? = null, isInterSplash: Boolean? = false) {
        inter?.onAdComplete()
    }

    private fun retryLoadInterstitialAd(millis: Long) {
        loadInterstitialAd()
    }

    @Synchronized
    fun showInterstitialAd(adCloseListener: AdCloseListener? = null, isForced: Boolean = false, tag: String? = null, screenTag: String? = null): Boolean {
        return true
    }

    @Synchronized
    fun reloadAd(delay: Long = 2_000) {
    }

    private val canShowInter: Boolean
        get() {
            return true
        }

    private fun postData(model: AdModel, delay: Long = 0) {
        mainScope.launch {
            delay(delay)
            _adFLow.emit(model)
        }
    }

    @Synchronized
    fun loadRewardedIntersAd() {
    }

    private fun retryLoadRewardedIntersAd(millis: Long) {
    }

    @Synchronized
    fun showRewardedIntersAd(tag: String? = null): Boolean {
        postData(
            AdModel(
                type = AdType.REWARD,
                status = AdStatus.EARNED_REWARD,
                tag = currentAdMobTag
            )
        )
        return true
    }

    private var vungleInterstitialAd: com.vungle.ads.InterstitialAd? = null
    private var retryAttemptInterstitialAd = 0

    private const val APP_ID = "65d1e3c925daba"
    private const val VUNGLE_INTER_ID = "INTER_VUNGLE_SDK-2107471"

    private fun loadInterstitialVungleAds(context: Context) {
    }

    fun initVungleSdk() {
    }

    private fun retryLoadInterstitialVungle() {
    }

    private val vungleInterstitialAdListener = object : BaseAdListener {
        override fun onAdClicked(baseAd: BaseAd) {}

        override fun onAdEnd(baseAd: BaseAd) {
            Logger.d("Vungle Inter onAdEnd")
        }

        override fun onAdFailedToLoad(baseAd: BaseAd, adError: VungleError) {
            retryLoadInterstitialVungle()
            Logger.d("Vungle Inter onAdFailedToLoad")
        }

        override fun onAdFailedToPlay(baseAd: BaseAd, adError: VungleError) {
            postData(
                AdModel(
                    type = AdType.INTERSTITIAL,
                    status = AdStatus.SHOW_FAILED,
                    tag = currentAdMobTag
                )
            )
            showedInterstitialLastTime = System.currentTimeMillis()
            OpenAdManager.switchOnOff(true)
            retryLoadInterstitialVungle()
        }

        override fun onAdImpression(baseAd: BaseAd) {
            OpenAdManager.switchOnOff(false)
        }

        override fun onAdLeftApplication(baseAd: BaseAd) {
            postData(
                AdModel(
                    type = AdType.INTERSTITIAL,
                    status = AdStatus.CLOSED,
                    tag = currentAdMobTag
                )
            )
            showedInterstitialLastTime = System.currentTimeMillis()
            OpenAdManager.switchOnOff(true)
            retryLoadInterstitialVungle()
        }

        override fun onAdLoaded(baseAd: BaseAd) {
            retryAttemptInterstitialAd = 0
            Logger.d("Vungle Inter onAdLoaded")
        }

        override fun onAdStart(baseAd: BaseAd) {}
    }
}

data class AdsConfig(
    var waitingShowInter: Long = RemoteConfig.commonInfo.waitingShowInter, //seconds
    var loadAdDistance: Long = RemoteConfig.commonInfo.loadAdDistance //second
)

interface AdCloseListener {
    fun onAdClosed()
    fun onAdDismiss()
}

interface AdIntertitialListener {
    fun onAdComplete()
    fun onAdError()
}

