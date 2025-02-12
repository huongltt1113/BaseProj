package com.dev.baseproject.ui.component.findphone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.dev.baseproject.R
import com.dev.baseproject.databinding.ActivityPhoneFoundBinding
import com.dev.baseproject.services.ClapDetectionService
import com.dev.baseproject.services.MotionDetectionService
import com.dev.baseproject.services.PocketDetectionService
import com.dev.baseproject.services.VoiceDetectionService
import com.dev.baseproject.ui.MainActivity
import com.dev.baseproject.ui.MainViewModel
import com.dev.baseproject.ui.base.BaseActivityBinding
import com.dev.baseproject.ui.component.home.fragment.CountDownFragment
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhoneFoundActivity: BaseActivityBinding<ActivityPhoneFoundBinding, MainViewModel>()  {
    private var animation: Animation? = null
    private var animation2: Animation? = null
    private var animationRotate: Animation? = null
    private var isFromHome: Boolean = true

    private val durationCompleteReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

        }
    }
    private val playbackStatusReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

        }
    }
    override fun getContentViewId(): Int {
        return R.layout.activity_phone_found
    }

    private var wakeLock: PowerManager.WakeLock? = null

    private fun acquireWakeLock() {
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(
            PowerManager.SCREEN_BRIGHT_WAKE_LOCK or
                    PowerManager.ACQUIRE_CAUSES_WAKEUP, "PhoneFound:WakeLock"
        )
        wakeLock!!.acquire(1000*60)
    }

    private fun releaseWakeLock() {
        if (wakeLock != null && wakeLock!!.isHeld) {
            wakeLock!!.release()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppConfig.updateResources(this, localStorage.langCode)
        acquireWakeLock()

        Log.w("PhoneFoundActivity", "onCreate")

        LocalBroadcastManager.getInstance(this).registerReceiver(
            this.playbackStatusReceiver,
            IntentFilter("com.dev.baseproject.services.PLAYBACK_STATUS")
        )
        if (MotionDetectionService.isServiceRunning) {
            LocalBroadcastManager.getInstance(this).registerReceiver(
                this.durationCompleteReceiver,
                IntentFilter(Constants.INTENT_DONT_TOUCH_DURATION_COMPLETE)
            )
        } else if (ClapDetectionService.isservicerunning) {
            LocalBroadcastManager.getInstance(this).registerReceiver(
                this.durationCompleteReceiver,
                IntentFilter(Constants.INTENT_CLAP_DURATION_COMPLETE)
            )
        } else if (VoiceDetectionService.isservicerunning) {
            LocalBroadcastManager.getInstance(this).registerReceiver(
                this.durationCompleteReceiver,
                IntentFilter(Constants.INTENT_VOICE_DURATION_COMPLETE)
            )
        } else if (PocketDetectionService.isServiceRunning) {
            LocalBroadcastManager.getInstance(this).registerReceiver(
                this.durationCompleteReceiver,
                IntentFilter(Constants.INTENT_POCKET_DURATION_COMPLETE)
            )
        }

        val source = intent.getStringExtra("SOURCE")
        when (source) {
            "FROM_HOME" -> {
                // Logic khi điều hướng từ HomeFragment
//                localStorage.isPhoneFoundActivityActive = false
                isFromHome = true
            }

            "FROM_NOTIFICATION" -> {
                // Logic khi điều hướng từ thông báo
                localStorage.isPhoneFoundActivityActiveFromNoti = false
                isFromHome = false
            }

            else -> {
                // Logic mặc định nếu không xác định được nguồn

            }
        }

        animation = AlphaAnimation(0.3f, 1.0f)
        animation?.duration = 800
        animation?.startOffset = 80
        animation?.repeatMode = Animation.REVERSE
        animation?.repeatCount = Animation.INFINITE

        animation2 = AlphaAnimation(0.3f, 1.0f)
        animation2?.duration = 1000
        animation2?.startOffset = 40
        animation2?.repeatMode = Animation.REVERSE
        animation2?.repeatCount = Animation.INFINITE

        animationRotate = RotateAnimation(
            0f,
            180f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animationRotate?.duration = 1000
        animationRotate?.interpolator = LinearInterpolator()

        dataBinding.apply {
            ivShadowTop.startAnimation(animation)
            ivShadowBottom.startAnimation(animation2)
            ivBell.startAnimation(animationRotate)
        }

        if (MotionDetectionService.isServiceRunning) {
            dataBinding.description.text = getString(R.string.phone_found_motion_detected)
        } else if (ClapDetectionService.isservicerunning) {
            dataBinding.description.text = getString(R.string.phone_found_clap_detected)
        } else if (VoiceDetectionService.isservicerunning) {
            dataBinding.description.text = getString(R.string.phone_found_voice_detected)
        } else if (PocketDetectionService.isServiceRunning) {
            dataBinding.description.text = getString(R.string.phone_found_pocket_detected)
        }

        dataBinding.btnCloseService.setOnClickListener {
            when {
                MotionDetectionService.isServiceRunning ->
                    stopService(Intent(this, MotionDetectionService::class.java))

                PocketDetectionService.isServiceRunning ->
                    stopService(Intent(this, PocketDetectionService::class.java))
            }
            localStorage.isPhoneFoundActivityActive = false
            localStorage.isClapServiceDetected = false
            localStorage.isDontTouchServiceDetected = false
            localStorage.isPocketServiceDetected = false
            localStorage.isVoiceServiceDetected = false
            if (MotionDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_DONT_TOUCH_STOP_MUSIC))
                navigateToCountDown()
            } else if (ClapDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_CLAP_STOP_MUSIC))
                navigateToHome()
            } else if (VoiceDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_VOICE_STOP_MUSIC))
                navigateToHome()
            } else if (PocketDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_POCKET_STOP_MUSIC))
                navigateToCountDown()
            }
        }

        dataBinding.btnCloseService2.setOnClickListener {
            when {
                MotionDetectionService.isServiceRunning ->
                    stopService(Intent(this, MotionDetectionService::class.java))

                ClapDetectionService.isservicerunning ->
                    stopService(Intent(this, ClapDetectionService::class.java))

                VoiceDetectionService.isservicerunning ->
                    stopService(Intent(this, VoiceDetectionService::class.java))

                PocketDetectionService.isServiceRunning ->
                    stopService(Intent(this, PocketDetectionService::class.java))
            }
            localStorage.isPhoneFoundActivityActive = false
            localStorage.isClapServiceDetected = false
            localStorage.isDontTouchServiceDetected = false
            localStorage.isPocketServiceDetected = false
            localStorage.isVoiceServiceDetected = false
            if (MotionDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_DONT_TOUCH_STOP_MUSIC))
            } else if (ClapDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_CLAP_STOP_MUSIC))
            } else if (VoiceDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_VOICE_STOP_MUSIC))
            } else if (PocketDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_POCKET_STOP_MUSIC))
            }
            navigateToHome()
        }
    }

    override fun initializeViews() {
        animation = AlphaAnimation(0.3f, 1.0f)
        animation?.duration = 800
        animation?.startOffset = 80
        animation?.repeatMode = Animation.REVERSE
        animation?.repeatCount = Animation.INFINITE

        animation2 = AlphaAnimation(0.3f, 1.0f)
        animation2?.duration = 1000
        animation2?.startOffset = 40
        animation2?.repeatMode = Animation.REVERSE
        animation2?.repeatCount = Animation.INFINITE

        animationRotate = RotateAnimation(
            0f,
            180f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animationRotate?.duration = 1000
        animationRotate?.interpolator = LinearInterpolator()

        dataBinding.apply {
            ivShadowTop.startAnimation(animation)
            ivShadowBottom.startAnimation(animation2)
            ivBell.startAnimation(animationRotate)
        }

    }

    override fun registerListeners() {

    }

    override fun initializeData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        localStorage.isPhoneFoundActivityActive = false
        releaseWakeLock()
        dataBinding.apply {
            ivShadowTop.clearAnimation()
            ivShadowBottom.clearAnimation()
            ivBell.clearAnimation()
        }
        try {
            LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(this.playbackStatusReceiver)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        try {
            LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(this.durationCompleteReceiver)
        } catch (e2: IllegalArgumentException) {
            e2.printStackTrace()
        }
    }

    override fun onStop() {
        super.onStop()
        localStorage.lastTimeExitApp = System.currentTimeMillis()
    }

    private fun stopService(){
        if(localStorage.isPhoneFoundActivityActive){
            localStorage.isPhoneFoundActivityActive = false
            localStorage.isClapServiceDetected = false
            localStorage.isDontTouchServiceDetected = false
            localStorage.isPocketServiceDetected = false
            localStorage.isVoiceServiceDetected = false
            if (MotionDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_DONT_TOUCH_STOP_MUSIC))
            } else if (ClapDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_CLAP_STOP_MUSIC))
            } else if (VoiceDetectionService.isservicerunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_VOICE_STOP_MUSIC))
            } else if (PocketDetectionService.isServiceRunning) {
                LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(Constants.INTENT_POCKET_STOP_MUSIC))
            }
            localStorage.lastTimeExitApp = System.currentTimeMillis()
        }
    }

    override fun onBackPressed() {
        stopService()
        if(supportFragmentManager.fragments.size > 0){
            super.onBackPressed()
        } else {
            if (MotionDetectionService.isServiceRunning || PocketDetectionService.isServiceRunning) {
                navigateToCountDown()
            } else {
                navigateToHome()
            }
//            navigateToCountDown()
        }
    }
    private fun navigateToCountDown(){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("fragment_to_load", CountDownFragment::class.java.name)
        if(MotionDetectionService.isServiceRunning){
            intent.putExtra("type_service_running", Constants.MODE_DONT_TOUCH)
        } else if(PocketDetectionService.isServiceRunning){
            intent.putExtra("type_service_running", Constants.MODE_POCKET)
        }
        startActivity(intent)
        finish()
    }

    private fun navigateToHome(){
        if(!isFromHome){
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        } else {
            finish()
        }
    }
}
