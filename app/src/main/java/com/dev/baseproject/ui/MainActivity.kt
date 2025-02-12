package com.dev.baseproject.ui

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.navigation.findNavController
import com.dev.baseproject.R
import com.dev.baseproject.databinding.ActivityMainBinding
import com.dev.baseproject.services.MotionDetectionService
import com.dev.baseproject.services.PocketDetectionService
import com.dev.baseproject.ui.base.BaseActivityBinding
import com.dev.baseproject.ui.component.bottomsheet.RequestInternetBottomSheet
import com.dev.baseproject.ui.component.home.fragment.CountDownFragment
import com.dev.baseproject.ui.component.splash.view.AskLanguageFragment
import com.dev.baseproject.ui.component.splash.view.IntroFragment
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import com.dev.baseproject.utils.NetworkUtils
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : BaseActivityBinding<ActivityMainBinding, MainViewModel>()  {

    private var requestInternetBottomSheet : RequestInternetBottomSheet = RequestInternetBottomSheet()
    override fun getContentViewId() = R.layout.activity_main

    override fun initializeViews() {
        Logger.d("initialize MainActivity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppConfig.updateResources(this, localStorage.langCode)
        if(localStorage.isPhoneFoundActivityActive){
            localStorage.isPhoneFoundActivityActive = false
        }
        val navController = findNavController(R.id.mainNavHostFragment)
        val intentFragment = intent.getStringExtra("fragment_to_load")
        val typeServiceRunning = intent.getIntExtra("type_service_running", Constants.MODE_DONT_TOUCH)
        intent.putExtra("fragment_to_load", "")
        intent.putExtra("type_service_running", Constants.MODE_DONT_TOUCH)
        if(intentFragment == CountDownFragment::class.java.name){
            val bundle = Bundle().apply {
                putInt("mode_key", typeServiceRunning)
                if(typeServiceRunning == Constants.MODE_DONT_TOUCH){
                    putString("service_class", MotionDetectionService::class.java.name)
                } else if(typeServiceRunning == Constants.MODE_POCKET) {
                    putString("service_class", PocketDetectionService::class.java.name)
                }
            }
            navController.navigate(R.id.countDownFragment, bundle)
        }
    }

    override fun registerListeners() {

    }

    override fun initializeData() {

    }

    fun checkShowRequestInternet() {
        try {
            val fragment = this.supportFragmentManager.findFragmentById(R.id.mainNavHostFragment)?.childFragmentManager?.fragments?.get(0)
            if (!NetworkUtils.isNetworkConnected()) {
                dataBinding.llInternetConnect.visibility = View.GONE
                dataBinding.llInternetDisconnect.visibility = View.VISIBLE
                if (!requestInternetBottomSheet.isVisible && (fragment is IntroFragment || fragment is AskLanguageFragment)) {
                    initRequestInternetBottomSheet()
                }
            } else {
                dataBinding.llInternetConnect.visibility = View.GONE
                dataBinding.llInternetDisconnect.visibility = View.GONE
            }
        } catch (ex: Exception) {
            Logger.e(ex.message)
            Firebase.crashlytics.recordException(ex)
        }
    }
    private fun initRequestInternetBottomSheet() {
        requestInternetBottomSheet = RequestInternetBottomSheet()
        requestInternetBottomSheet.updateLanguage(this, localStorage.langCode)
        requestInternetBottomSheet.clickConfirmYes = {
            try {
                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                AppConfig.logEventTracking(Constants.MAIN_REQUEST_INTERNET_YES)
            } catch (e: Exception) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
        requestInternetBottomSheet.clickConfirmNo = {
            try {
                AppConfig.logEventTracking(Constants.MAIN_REQUEST_INTERNET_NO)
            } catch (e: Exception) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
        requestInternetBottomSheet.clickConfirmCancel = {
            try {
                AppConfig.logEventTracking(Constants.MAIN_REQUEST_INTERNET_CANCEL)
            } catch (e: Exception) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
        if (this.isFinishing == false) {
            if (requestInternetBottomSheet.isVisible) {
                requestInternetBottomSheet.dismiss()
            }
            this.supportFragmentManager.let {
                requestInternetBottomSheet.show(
                    it,
                    RequestInternetBottomSheet.TAG
                )
            }
        }
    }

    override fun onResume() {
        if (localStorage.langCode.isNotBlank()) {
            val resources: Resources = resources
            val locale = Locale(localStorage.langCode)
            Locale.setDefault(locale)
            val config = Configuration()
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        localStorage.lastTimeExitApp = System.currentTimeMillis()
    }

}
