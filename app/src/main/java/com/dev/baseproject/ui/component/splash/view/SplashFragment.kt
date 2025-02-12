package com.dev.baseproject.ui.component.splash.view

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentSplashBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragmentBinding<FragmentSplashBinding>() {
    private var isLoadOpenAds = false
    override fun getContentViewId() = R.layout.fragment_splash
    override fun initializeViews() {
        dataBinding.imageViewmain.setAnimation(R.raw.splash_clap)
        println("SplashFragment initializeViews")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("SplashFragment onViewCreated")
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

        if (localStorage.isFirstInstall) {
            localStorage.isFirstInstall = false
            localStorage.firstTimeOpenApp = System.currentTimeMillis()
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_SPLASH_FIRST)
        } else {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_SPLASH)
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
        if (!localStorage.isFirstOpen) {
            goToHomeFragment()
        } else {
            goToAskLanguageFragment()
        }
    }

    private fun goToHomeFragment() {
        try {
            if (findNavControllerSafety()?.currentDestination?.id == R.id.splashFragment) {
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
