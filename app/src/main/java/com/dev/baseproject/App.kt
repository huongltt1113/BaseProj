package com.dev.baseproject

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.dev.baseproject.local.LocalStorage
import com.dev.baseproject.local.MobileIdInfo
import com.dev.baseproject.remote.RemoteConfig
import com.dev.baseproject.server.Network
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.LocaleHelper
import com.google.firebase.remoteconfig.BuildConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var localStorage: LocalStorage

    @Inject
    lateinit var network: Network

    @Inject
    @MobileIdInfo
    lateinit var androidId: String

    @SuppressLint("HardwareIds")
    override fun onCreate() {
        super.onCreate()
        instance = this

        CoroutineScope(Dispatchers.IO).launch {
            AppConfig.setup(applicationContext)
            RemoteConfig.ANDROID_ID = androidId

            FirebaseRemoteConfig.getInstance().setConfigSettingsAsync(
                FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(if (BuildConfig.DEBUG) 60L else 3600L).build()
            )
        }
    }

    companion object {
        lateinit var instance: App
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleHelper().updateResources(base!!))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleHelper().updateResources(this)
    }
}