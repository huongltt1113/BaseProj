package com.dev.baseproject.ui.component.splash.view

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dev.baseproject.ads.AdStatus
import com.dev.baseproject.ads.GoogleMobileAdsConsentManager
import com.dev.baseproject.ads.OpenAdsOnStartManager
import com.dev.baseproject.App
import com.dev.baseproject.R
import com.dev.baseproject.ads.AdManager
import com.dev.baseproject.ads.NativeAdsUtils
import com.dev.baseproject.databinding.FragmentSplashBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.AdapterStatus
import com.google.android.gms.ads.initialization.InitializationStatus
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragmentBinding<FragmentSplashBinding>() {
    @Inject
    lateinit var googleMobileAdsConsentManager: GoogleMobileAdsConsentManager
    private val isMobileAdsInitializeCalled = AtomicBoolean(false)
    private var isLoadOpenAds = false
    override fun getContentViewId() = R.layout.fragment_splash
    override fun initializeViews() {
        dataBinding.imageViewmain.setAnimation(R.raw.splash_clap)
        println("SplashFragment initializeViews")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("SplashFragment onViewCreated")
        OpenAdsOnStartManager.isSplashScreen = true
        val timer = object : CountDownTimer(Constants.TIME_DELAY_SPLASH_MAX, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                if (!isLoadOpenAds) {
                    handleWhenLoadInterDone()
                }
            }
        }
        timer.start()
        // Init Vungle without CMP
        activity?.let {
            googleMobileAdsConsentManager.gatherConsent(it) { error ->
                if (error != null) {
                    Logger.d("Consent error $error!")
                }

                if (googleMobileAdsConsentManager.canRequestAds) {
                    initializeMobileAdsSdk()
                } else {
                    handleWhenLoadInterDone()
                }
            }
        }

        if (googleMobileAdsConsentManager.canRequestAds) {
            initializeMobileAdsSdk()
        } else {
            if (!localStorage.isFirstInstall) {
                handleWhenLoadInterDone()
            }
        }

        if (localStorage.isFirstInstall) {
            localStorage.isFirstInstall = false
            localStorage.firstTimeOpenApp = System.currentTimeMillis()
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_SPLASH_FIRST)
        } else {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_SPLASH)
        }

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                OpenAdsOnStartManager.adFLowStart.collectLatest {
                    Logger.d("${SplashFragment.TAG} OpenAdManager adFlow: $it")
                    if (it.status == AdStatus.SHOW_FAILED || it.status == AdStatus.CLOSED) {
                        handleWhenLoadInterDone()
                    } else if (it.status == AdStatus.OPENED) {
                        isLoadOpenAds = true
                    }
                }
            }
        }
    }

    override fun registerListeners() {
    }

    override fun initializeData() {
    }

    private fun goToAskLanguageFragment() {
        try {
            findNavControllerSafety()?.navigate(R.id.actionSplashtoAskLanguageFragment)
        } catch (e: Throwable) {
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }

    private fun handleWhenLoadInterDone() {
        OpenAdsOnStartManager.isSplashScreen = false
        if (!localStorage.isFirstOpen) {
            goToHomeFragment()
        } else {
            goToAskLanguageFragment()
        }
    }

    private fun initializeMobileAdsSdk() {
        if (isMobileAdsInitializeCalled.getAndSet(true)) {
            Logger.d("MobileAdsSdk ready for using, return!")
            return
        }

        activity?.let {
            MobileAds.initialize(it) { initializationStatus: InitializationStatus ->
                Logger.d("Finish initialize()")
                val statusMap = initializationStatus.adapterStatusMap
                // Check if the SDK is successfully initialized
                if (statusMap.values.all { it.initializationState == AdapterStatus.State.READY }) {
                    // Proceed with loading ads
                    App.instance.isInitMobileAdsComplete = true
                    activity?.let { it1 ->
                        OpenAdsOnStartManager.loadAppOpenAd(it1)
                    }
                    AdManager.initAds(googleMobileAdsConsentManager)
                    try {
                        if (googleMobileAdsConsentManager.canRequestAds) {
                            if (localStorage.isFirstOpen && NativeAdsUtils.nativeIntro == null) {
                                NativeAdsUtils.nativeIntro =
                                    NativeAdsUtils.addSmallNativeAd(true, activity, null, false)
                            }
                            if (NativeAdsUtils.nativeAskLanguage == null) {
                                NativeAdsUtils.nativeAskLanguage =
                                    NativeAdsUtils.addLargeNativeAd(false, activity, null, false)
                            }
                        }
                    } catch (ex: Exception) {
                    }
                    AdManager.initVungleSdk()
                } else {
                    // Handle the failure case
                    App.instance.isInitMobileAdsComplete = false
                    handleWhenLoadInterDone()
                }
            }
        }
    }

    private fun goToHomeFragment() {
        try {
            if(findNavControllerSafety()?.currentDestination?.id == R.id.splashFragment) {
                findNavControllerSafety()?.navigate(R.id.actionSplashtoHomeFragment)
            }
        } catch (e: Throwable) {
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }

    companion object {
        const val TAG = "SplashFragment"
    }
}
