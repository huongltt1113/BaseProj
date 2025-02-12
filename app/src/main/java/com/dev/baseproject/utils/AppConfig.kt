package com.dev.baseproject.utils

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import androidx.core.text.TextUtilsCompat
import com.dev.baseproject.App
import com.dev.baseproject.BuildConfig
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Calendar
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

    val widthScreen: Int
        get() = displayMetrics.widthPixels

    val heightScreen: Int
        get() = displayMetrics.heightPixels

    fun getFirebaseRemoteKey(): String {
        return "configs_" + App.instance.packageName.replace(".", "_")
    }

    private fun getScreen(context: Context): DisplayMetrics {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(dm)
        return dm
    }

    fun dpToPx(dp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics).toInt()

    fun dp2Px(dp: Float): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)

    fun pxToDp(px: Int): Float =
        px / displayMetrics.density

    fun spToPx(sp: Float): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, displayMetrics)

    fun Context.dp2px(dpValue: Float): Int {
        val scale = resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun formatDate(milliSeconds: Long): String? {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    var vibrator: Vibrator? = null
    fun vibrate(context: Context) {
        if (vibrator == null) {
            vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
        if (vibrator == null) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            //deprecated in API 26
            vibrator?.vibrate(50)
        }
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

    fun logEventTracking(nameEvent : String, bundle: Bundle? = Bundle()) {
        try {
            bundle?.putString(Constants.KEY_ANALYTICS_TRACKING, Constants.VALUE_ANALYTICS_TRACKING)
            firebaseAnalytics.logEvent(nameEvent, bundle)
            bundle?.clear()
        } catch (e : Exception) {
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }

    fun openApp(context : Context) {
        try {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(Constants.GOOGLE_PLAY_URL_APP + BuildConfig.APPLICATION_ID)
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
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

typealias Action = () -> Unit