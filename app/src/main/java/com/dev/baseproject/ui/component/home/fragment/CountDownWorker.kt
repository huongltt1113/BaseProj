package com.dev.baseproject.ui.component.home.fragment

import android.app.ForegroundServiceStartNotAllowedException
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.dev.baseproject.R
import com.dev.baseproject.local.LocalData
import com.dev.baseproject.services.MotionDetectionService
import com.dev.baseproject.services.PocketDetectionService
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Constants.COUNT_DOWN_TIME
import java.util.concurrent.TimeUnit

class CountDownWorker(
    val context: Context,
     workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val serviceClassName = inputData.getString(KEY_INPUT_STRING) ?: return Result.failure()

        try{
            serviceClassName?.let {
                startService(Class.forName(it), context)
            }
        } catch (e: Exception){
            println(e.message)
            return Result.failure()
        }
        return Result.success()
    }

    private fun startService(
        serviceClass: Class<*>,
        context: Context
    ) {
        val localStorage = LocalData(applicationContext, "sharedPreferences")
        println("Starting service: ${serviceClass.simpleName}")
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
                LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(Constants.INTENT_SHOW_DIALOG_BATTERY))
                Toast.makeText(context, R.string.battery_permission_exception, Toast.LENGTH_SHORT).show()
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
                context.startService(Intent(context, serviceClass))
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

    companion object {
        // Key for passing input data
        private const val KEY_INPUT_STRING = "input_string"

        fun scheduleDelayedTask(context: Context, inputString: String) {
            // Create input data
            val inputData = Data.Builder()
                .putString(KEY_INPUT_STRING, inputString)
                .build()

            val delayedWorkRequest = OneTimeWorkRequestBuilder<CountDownWorker>()
                .setInputData(inputData)
                .setInitialDelay(COUNT_DOWN_TIME - 500L, TimeUnit.MILLISECONDS)
                .addTag("CountDownWorker")
                .build()

            WorkManager.getInstance(context).enqueue(delayedWorkRequest)
            println("Scheduled delayed task")
        }

        fun cancelDelayedTask(context: Context) {
            WorkManager.getInstance(context).cancelAllWorkByTag("CountDownWorker")
            println("Cancelled delayed task")
        }
    }
}