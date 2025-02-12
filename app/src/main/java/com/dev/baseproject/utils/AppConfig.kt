package com.dev.baseproject.utils

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.core.text.TextUtilsCompat
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import java.util.Locale


object AppConfig {
    lateinit var connectivityManager: ConnectivityManager
    lateinit var displayMetrics: DisplayMetrics
    private var firebaseAnalytics: FirebaseAnalytics = Firebase.analytics
    fun setup(context: Context) {
        connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        displayMetrics = getScreen(context)
    }

    private fun getScreen(context: Context): DisplayMetrics {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(dm)
        return dm
    }

    var lastClickTime: Long = 0
    const val DOUBLE_CLICK_TIME_DELTA: Long = 600
    fun isDoubleClick(): Boolean {
        val clickTime = System.currentTimeMillis()
        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
            return true
        }
        lastClickTime = clickTime
        return false
    }

    fun logEventTracking(nameEvent: String, bundle: Bundle? = Bundle()) {
        try {
            bundle?.putString(Constants.KEY_ANALYTICS_TRACKING, Constants.VALUE_ANALYTICS_TRACKING)
            firebaseAnalytics.logEvent(nameEvent, bundle)
            bundle?.clear()
        } catch (e: Exception) {
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }

    fun sendMail(context: Context, subject: String?, title: String?) {
        val email = Intent(Intent.ACTION_SEND)
        email.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(Constants.EMAIL))
        email.putExtra(Intent.EXTRA_SUBJECT, subject)
        email.putExtra(Intent.EXTRA_TEXT, "")
        email.type = "message/rfc822"
        context.startActivity(Intent.createChooser(email, title))
    }

    fun updateResources(
        context: Context?, language: String,
    ): Context? {
        val contextFormatted: Context?
        val locale: Locale
        if (language.contains("-")) {
            val splitLanguage = language.split("-")
            locale = Locale(splitLanguage[0], splitLanguage[1])
        } else {
            locale = Locale(language)
        }
        Locale.setDefault(locale)
        val res = context?.resources
        val config = Configuration(res?.configuration)
        config.setLocale(locale)
        contextFormatted = context?.createConfigurationContext(config)
        return contextFormatted
    }

    fun isRTL(): Boolean {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL
    }
}

