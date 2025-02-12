package com.dev.baseproject.ui.component.home.fragment

import android.app.ForegroundServiceStartNotAllowedException
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentCountDownBinding
import com.dev.baseproject.services.MotionDetectionService
import com.dev.baseproject.services.PocketDetectionService
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Constants.COUNT_DOWN_TIME
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CountDownFragment : BaseFragmentBinding<FragmentCountDownBinding>() {
    private var countDown: CountDownTimer? = null
    private var mode: Int? = null
    private var serviceClassName: String? = null
    private var needNavigateUp = false
    private lateinit var handlerThread: HandlerThread
    private lateinit var newHandler: Handler
    private lateinit var runnable: Runnable
    private lateinit var backgroundThread: Thread
    private var currentTimer: Int = 10
    private var hadStartedService: Boolean = false

    override fun getContentViewId() = R.layout.fragment_count_down

    override fun initializeViews() {
        // Nhận dữ liệu từ Bundle
        arguments?.let {
            mode = it.getInt("mode_key")
            serviceClassName = it.getString("service_class")
        }
        // Thiết lập text dựa trên chế độ
        dataBinding.noti.text =
            when (mode) {
                Constants.MODE_POCKET -> getString(R.string.pocket_mode_active)
                Constants.MODE_DONT_TOUCH -> getString(R.string.don_t_touch_mode_active)
                else -> getString(R.string.don_t_touch_mode_active)
            }
        dataBinding.description.text =
            when (mode) {
                Constants.MODE_POCKET -> getString(R.string.pocket_mode)
                Constants.MODE_DONT_TOUCH -> getString(R.string.don_t_touch_mode)
                else -> getString(R.string.don_t_touch_mode)
            }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    stopCountDownWithoutService()
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            },
        )
        startCountDown()
    }

    private fun stopCountDownWithoutService() {
        CountDownWorker.cancelDelayedTask(requireContext())
        countDown?.cancel()
        countDown = null
    }

    override fun registerListeners() {
        dataBinding.btnStartNow.setOnClickListener {
            stopCountDownAndStartService()
        }
    }

    private fun startCountDown() {
        localStorage.startTimer = System.currentTimeMillis()

        CountDownWorker.scheduleDelayedTask(requireContext(), serviceClassName ?: "")

        countDown =
            object : CountDownTimer(COUNT_DOWN_TIME, 1000) {
                override fun onTick(p0: Long) {
                    val secondsRemaining = p0 / 1000
                    currentTimer = secondsRemaining.toInt()
                    dataBinding.number.text = secondsRemaining.toString()
//                    val powerManager = requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
//                    val isScreenOn = powerManager.isInteractive
//                    if(!isScreenOn){
//                        newHandler.postDelayed({
//                            hadStartedService = true
//                            countDown?.cancel()
//                            countDown = null
//                            navigateBackAndStartService()
//                        }, 3000L)
//                    }
                }

                override fun onFinish() {
                    dataBinding.number.text = "0"
                    navigateBackAndStartService(false)
                }
            }.start()
    }

    private fun navigateBackAndStartService(needStartService: Boolean = true) {
        // Tạo Bundle chứa thông tin dịch vụ cần chạy
        needNavigateUp = true
        val resultBundle =
            Bundle().apply {
                putString("service_class", serviceClassName)
            }
        val handler = Handler(Looper.getMainLooper())
        handler.post{
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                // Gửi kết quả trở lại HomeFragment
                parentFragmentManager.setFragmentResult("countdown_finished", resultBundle)
                if(findNavControllerSafety()?.currentDestination?.id == R.id.countDownFragment) {
                    val action = CountDownFragmentDirections.actionCountDownFragmentToHomeFragment()
                    findNavControllerSafety()?.navigate(action)
                }
            }
        }
        if(needStartService){
            serviceClassName?.let {
                startService(Class.forName(it))
            }
        }
    }

    private fun stopCountDownAndStartService() {
        countDown?.cancel()
        countDown = null
        dataBinding.number.text = "0"
        CountDownWorker.cancelDelayedTask(requireContext())
        navigateBackAndStartService(needStartService = true)
//        serviceClassName?.let {
//            startService(Class.forName(it))
//        }
    }

    private fun startService(serviceClass: Class<*>) {
        val context: Context = requireContext()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            try{
                val intent: Intent = Intent(
                    context,
                    serviceClass
                )
                ContextCompat.startForegroundService(context, intent)
                // Cập nhật thời gian bắt đầu cho dịch vụ
                when (serviceClass) {
                    MotionDetectionService::class.java -> {
                        localStorage.lastStartTimeMotion = System.currentTimeMillis()
                        MotionDetectionService.isServiceRunning = true
                    }
                    PocketDetectionService::class.java -> {
                        localStorage.lastStartTimePocket = System.currentTimeMillis()
                        PocketDetectionService.isServiceRunning = true
                    }
                }
            } catch (e : ForegroundServiceStartNotAllowedException){
                LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(Intent(Constants.INTENT_SHOW_DIALOG_BATTERY))
                Toast.makeText(requireContext().applicationContext, R.string.battery_permission_exception, Toast.LENGTH_SHORT).show()
                return
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val intent: Intent = Intent(
                    context,
                    serviceClass
                )
                ContextCompat.startForegroundService(context, intent)
            } else {
                requireContext().startService(Intent(context, serviceClass))
            }
            // Cập nhật thời gian bắt đầu cho dịch vụ
            when (serviceClass) {
                MotionDetectionService::class.java -> {
                    localStorage.lastStartTimeMotion = System.currentTimeMillis()
                    MotionDetectionService.isServiceRunning = true
                }
                PocketDetectionService::class.java -> {
                    localStorage.lastStartTimePocket = System.currentTimeMillis()
                    PocketDetectionService.isServiceRunning = true
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCountDownWithoutService()
    }

    override fun onResume() {
        super.onResume()
        if(needNavigateUp){
            if(findNavControllerSafety()?.currentDestination?.id == R.id.countDownFragment) {
                val action = CountDownFragmentDirections.actionCountDownFragmentToHomeFragment()
                findNavControllerSafety()?.navigate(action)
            }
        }
    }

    override fun initializeData() {}
}
