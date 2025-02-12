package com.dev.baseproject.ui.component.permission

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentPermissionBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding

class PermissionFragment : BaseFragmentBinding<FragmentPermissionBinding>() {

    private var isRecordPermission = false
    private var isBatteryPermission = false

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            //findNavControllerSafety()?.navigate()
            val bundle = Bundle()
            bundle.putBoolean(KEY_RECORD_PERMISSION, true)
            findNavControllerSafety()?.navigate(R.id.action_permissionFragment_to_recordPermissionFragment, bundle)
        }
    private val requestAudioPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if(isIgnoringBatteryOptimizations(requireContext())){
                findNavControllerSafety()?.navigate(R.id.action_recordPermissionFragment_to_homeFragment)
            } else {
                val bundle = Bundle()
                bundle.putBoolean(KEY_BATTERY_PERMISSION, true)
                findNavControllerSafety()?.navigate(R.id.action_recordPermissionFragment_to_batteryFragment, bundle)
            }
        }
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _: ActivityResult ->
        findNavControllerSafety()?.navigate(R.id.action_batteryPermissionFragment_to_homeFragment)
    }

    override fun getContentViewId() = R.layout.fragment_permission

    override fun initializeViews() {
        isRecordPermission = arguments?.containsKey(KEY_RECORD_PERMISSION) ?: false
        isBatteryPermission = arguments?.containsKey(KEY_BATTERY_PERMISSION) ?: false

        if(isRecordPermission){
            dataBinding.txtTitle.text = getString(R.string.record_permission)
            dataBinding.txtMsg.text = getString(R.string.label_record_permission)

            dataBinding.btnNext.text = getString(R.string.allow_record)
        } else if(isBatteryPermission){
            dataBinding.txtTitle.text = getString(R.string.battery_limit_free)
            dataBinding.txtMsg.text = getString(R.string.battery_optimization_label)

            dataBinding.btnNext.text = getString(R.string.allow_battery_optimization)
        }
    }

    override fun registerListeners() {
        dataBinding.btnNext.setOnClickListener {
            if(isRecordPermission){
                requestAudioPermissionLauncher.launch("android.permission.RECORD_AUDIO")
            } else if(isBatteryPermission){
                val intentSettings = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
                with(intentSettings) {
                    context?.let {
                        data = Uri.fromParts("package", it.packageName, null)
                        addCategory(Intent.CATEGORY_DEFAULT)
                    }
                }
                startForResult.launch(intentSettings)
            } else {
                requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS")
            }
        }

        dataBinding.btnNotNow.setOnClickListener {
            if(isRecordPermission){
                if(isIgnoringBatteryOptimizations(requireContext())){
                    findNavControllerSafety()?.navigate(R.id.action_recordPermissionFragment_to_homeFragment)
                } else {
                    val bundle = Bundle()
                    bundle.putBoolean(KEY_BATTERY_PERMISSION, true)
                    findNavControllerSafety()?.navigate(R.id.action_recordPermissionFragment_to_batteryFragment, bundle)
                }
            } else if(isBatteryPermission){
                findNavControllerSafety()?.navigate(R.id.action_batteryPermissionFragment_to_homeFragment)
            } else {
                val bundle = Bundle()
                bundle.putBoolean(KEY_RECORD_PERMISSION, true)
                findNavControllerSafety()?.navigate(R.id.action_permissionFragment_to_recordPermissionFragment, bundle)
            }
        }
    }

    override fun initializeData() {

    }

    private fun isIgnoringBatteryOptimizations(context: Context): Boolean {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        return powerManager.isIgnoringBatteryOptimizations(context.packageName)
    }

    companion object {
        const val KEY_BATTERY_PERMISSION = "KEY_BATTERY_PERMISSION"
        const val KEY_RECORD_PERMISSION = "KEY_RECORD_PERMISSION"
    }
}