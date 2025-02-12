package com.dev.baseproject.di

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.dev.baseproject.ads.GoogleMobileAdsConsentManager
import com.dev.baseproject.data.DatabaseInfo
import com.dev.baseproject.local.MobileIdInfo
import com.dev.baseproject.local.PreferenceInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    @PreferenceInfo
    fun preferencesName(): String {
        return "sharedPreferences"
    }

    @Singleton
    @Provides
    @DatabaseInfo
    fun databaseName(): String {
        return "clicker"
    }

    @SuppressLint("HardwareIds")
    @Singleton
    @Provides
    @MobileIdInfo
    fun providerMobileId(@ApplicationContext context: Context) = Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.ANDROID_ID
    ) + "_sdk" + Build.VERSION.SDK_INT

    @Singleton
    @Provides
    @Named("AppId")
    fun providerAppId() = "base_project"

    @Singleton
    @Provides
    fun providerCMP(@ApplicationContext context: Context) = GoogleMobileAdsConsentManager(context)

}
