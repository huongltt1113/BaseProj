package com.dev.baseproject.ui.component.home.fragment

import android.Manifest
import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.baseproject.R
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.FragmentHomeBinding
import com.dev.baseproject.services.ClapDetectionService
import com.dev.baseproject.services.MotionDetectionService
import com.dev.baseproject.services.MotionDetectionService.isServiceRunning
import com.dev.baseproject.services.PocketDetectionService
import com.dev.baseproject.services.VoiceDetectionService
import com.dev.baseproject.ui.base.BaseViewModelFragmentBinding
import com.dev.baseproject.ui.component.battery.BatteryRationaleDialog
import com.dev.baseproject.ui.component.bottomsheet.ConfirmBottomSheet
import com.dev.baseproject.ui.component.bottomsheet.RatingAppBottomSheet
import com.dev.baseproject.ui.component.findphone.PhoneFoundActivity
import com.dev.baseproject.ui.component.home.adapter.SoundAdapter
import com.dev.baseproject.ui.component.home.dialogs.FullPocketDialog
import com.dev.baseproject.ui.component.home.dialogs.FullScreenClapDialog
import com.dev.baseproject.ui.component.home.dialogs.FullScreenClapDialogListener
import com.dev.baseproject.ui.component.home.dialogs.FullScreenDontTouchDialog
import com.dev.baseproject.ui.component.home.dialogs.FullScreenVoiceDialog
import com.dev.baseproject.ui.component.home.dialogs.PocketNotAvailableDialog
import com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Constants.GO_TO_CHOOSE_SOUND_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_CHOOSE_SOUND_FIRST
import com.dev.baseproject.utils.Constants.GO_TO_CREATE_PASSCODE_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_CREATE_PASSCODE_FIRST
import com.dev.baseproject.utils.Constants.GO_TO_HOW_TO_USE_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_HOW_TO_USE_FIRST
import com.dev.baseproject.utils.Constants.GO_TO_SETTING_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_SETTING_FIRST
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_FIRST
import com.dev.baseproject.utils.Constants.HOME_ACTIVE_AGAIN
import com.dev.baseproject.utils.Constants.HOME_ACTIVE_FIRST
import com.dev.baseproject.utils.Constants.HOME_CHANGE_VOICE_PASSCODE_AGAIN
import com.dev.baseproject.utils.Constants.HOME_CHANGE_VOICE_PASSCODE_FIRST
import com.dev.baseproject.utils.Constants.HOME_CLAP_AGAIN
import com.dev.baseproject.utils.Constants.HOME_CLAP_FIRST
import com.dev.baseproject.utils.Constants.HOME_DONT_TOUCH_AGAIN
import com.dev.baseproject.utils.Constants.HOME_DONT_TOUCH_FIRST
import com.dev.baseproject.utils.Constants.HOME_POCKET_AGAIN
import com.dev.baseproject.utils.Constants.HOME_POCKET_FIRST
import com.dev.baseproject.utils.Constants.HOME_VOICE_AGAIN
import com.dev.baseproject.utils.Constants.HOME_VOICE_FIRST
import com.dev.baseproject.utils.Constants.MIN_DISTANCE_TIME_SHOW_RATING
import com.dev.baseproject.utils.DialogTracker
import com.dev.baseproject.utils.Logger
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseViewModelFragmentBinding<FragmentHomeBinding, HomeViewModel>(), FullScreenClapDialogListener {
    private var justChooseVoice: Boolean = false
    private var justChoosePocket: Boolean = false
    private var justChooseClap: Boolean = true
    private var justChooseDontTouch: Boolean = false
    private var fromPermissionScreen: Boolean = false
    private var fromPasscodeScreen: Boolean = false
    private var selectedSound: Int = R.drawable.dog
    private var animation : AlphaAnimation ?= null
    private var animation2 : AlphaAnimation ?= null
    private var typeServiceRunning: Int = 1
    private var dialogTracker: DialogTracker? = null
    private val itemList = mutableListOf<SoundItem>()
    private val allSoundListSound = mutableListOf<SoundItem>()
    private lateinit var soundAdapter: SoundAdapter
    private lateinit var ratingAppBottomSheet: RatingAppBottomSheet
    private var confirmBottomSheet: ConfirmBottomSheet? = null
    private val PERMISSIONS_ANDROID13 = arrayOf(
        Manifest.permission.POST_NOTIFICATIONS
    )
    private var lastStartServiceTime: Long = 0L
    private val eventReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (!localStorage.isPhoneFoundActivityActive) { // Chỉ mở nếu chưa có PhoneFoundActivity đang chạy
                localStorage.isPhoneFoundActivityActive = true
                Log.d("LCD","Mo phone found")
                val phoneFoundIntent = Intent(context, PhoneFoundActivity::class.java)
                phoneFoundIntent.putExtra("SOURCE","HOME");
                phoneFoundIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                context.startActivity(phoneFoundIntent)

            }
        }
    }

    private val batteryEventReceiver: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            localStorage.shouldShowBatteryDialog = true
        }
    }
    override fun getContentViewId() = R.layout.fragment_home

    override fun initializeViews() {
        if(localStorage.isFirstOpenHome){
            localStorage.isFirstOpenHome = false
            AppConfig.logEventTracking(Constants.GO_TO_HOME_FIRST)
            localStorage.languageScrollPosition = 0
        } else {
            AppConfig.logEventTracking(Constants.GO_TO_HOME_AGAIN)
        }
        animation = AlphaAnimation(0.2f, 1.0f)
        animation?.duration = 600
        animation?.startOffset = 80
        animation?.repeatMode = Animation.REVERSE
        animation?.repeatCount = Animation.INFINITE

        animation2 = AlphaAnimation(0.2f, 1.0f)
        animation2?.duration = 1000
        animation2?.startOffset = 40
        animation2?.repeatMode = Animation.REVERSE
        animation2?.repeatCount = Animation.INFINITE

        this.dialogTracker = DialogTracker(context)
        initAllSound()
        if (itemList.isEmpty()) {
            setItemList()
        }

        if(localStorage.sensitivityPK == Constants.SENSITIVITY_PK_FAST){
            dataBinding.swSensitivityPocket.isChecked = true
            dataBinding.tvSensitivityPocket.text = getString(R.string.fast)
        } else {
            dataBinding.swSensitivityPocket.isChecked = false
            dataBinding.tvSensitivityPocket.text = getString(R.string.slow)
        }

        if(localStorage.withLightPK){
            dataBinding.tvWithLight.text = getString(R.string.with_light)
        } else {
            dataBinding.tvWithLight.text = getString(R.string.without_light)
        }
        dataBinding.swLightPocket.isChecked = localStorage.withLightPK

        if(localStorage.sensitivityDT == Constants.SENSITIVITY_DT_FAST){
            dataBinding.swSensitivityDontTouch.isChecked = true
            dataBinding.tvSensitivityDontTouch.text = getString(R.string.fast)
        } else {
            dataBinding.swSensitivityDontTouch.isChecked = false
            dataBinding.tvSensitivityDontTouch.text = getString(R.string.slow)
        }

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            this.eventReceiver,
            IntentFilter(Constants.INTENT_SERVICE_EVENT)
        )
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            batteryEventReceiver,
            IntentFilter(Constants.INTENT_SHOW_DIALOG_BATTERY)
        )
        // Đăng ký FragmentResultListener
        parentFragmentManager.setFragmentResultListener("countdown_finished", this) { requestKey, bundle ->
            // Lấy tên dịch vụ từ bundle
            val serviceClassName = bundle.getString("service_class")
            serviceClassName?.let {
                try {
                    val serviceClass = Class.forName(it)
//                    startService(serviceClass)
                    dataBinding.rlActive.visibility = View.VISIBLE
                    dataBinding.rlDeactive.visibility = View.INVISIBLE
                    dataBinding.tvActive.text = context?.resources?.getString(R.string.deactive)
                    dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
                    dataBinding.ivShadowBottom.startAnimation(animation2)
                    dataBinding.ivShadowTop.startAnimation(animation)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun registerListeners() {
        dataBinding.sensitivityDTLayout.setOnClickListener {
            showPopupWindow(dataBinding.sensitivityDTLayout,
                getString(R.string.more_info_sensitivity_DT, dataBinding.tvSensitivityDontTouch.text))
        }
        dataBinding.sensitivityPKLayout.setOnClickListener {
            showPopupWindow(dataBinding.sensitivityPKLayout,
                getString(R.string.more_info_sensitivity_pocket, dataBinding.tvSensitivityPocket.text))
        }
        dataBinding.lightLayout.setOnClickListener {
            showPopupWindow(dataBinding.lightLayout,
                getString(R.string.more_info_light_pocket, dataBinding.tvWithLight.text))
        }
        dataBinding.swSensitivityPocket.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                localStorage.sensitivityPK = Constants.SENSITIVITY_PK_FAST
                dataBinding.tvSensitivityPocket.text = getString(R.string.fast)
            } else {
                localStorage.sensitivityPK = Constants.SENSITIVITY_PK_SLOW
                dataBinding.tvSensitivityPocket.text = getString(R.string.slow)
            }
        }

        dataBinding.swLightPocket.setOnCheckedChangeListener { _, isChecked ->
            localStorage.withLightPK = isChecked
            dataBinding.tvWithLight.text = if(isChecked) getString(R.string.with_light) else getString(R.string.without_light)
        }

        dataBinding.swSensitivityDontTouch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                localStorage.sensitivityDT = Constants.SENSITIVITY_DT_FAST
                dataBinding.tvSensitivityDontTouch.text = getString(R.string.fast)
            } else {
                localStorage.sensitivityDT = Constants.SENSITIVITY_DT_SLOW
                dataBinding.tvSensitivityDontTouch.text = getString(R.string.slow)
            }
        }
        dataBinding.btnPermission.setOnClickListener {
            findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_grantPermissionFragment)
        }

        dataBinding.layoutActive.setOnClickListener {
            if (localStorage.isFirstActiveHomeClick) {
                AppConfig.logEventTracking(HOME_ACTIVE_FIRST)
                localStorage.isFirstActiveHomeClick = false
            } else {
                AppConfig.logEventTracking(HOME_ACTIVE_AGAIN)
            }
            if (!checkPermissions()) {
                fromPermissionScreen = true
                findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_grantPermissionFragment)
            } else {
                if(justChooseVoice){
                    if(localStorage.voicePasscode.isEmpty()){
                        Toast.makeText(requireContext(), getString(R.string.create_passcode_first), Toast.LENGTH_SHORT).show()
                    } else {
                        checkServices()
                    }
                } else {
                    checkServices()
                }
            }
        }

        dataBinding.changevoicepasscode.setOnClickListener {
            if (VoiceDetectionService.isservicerunning) {
                Toast.makeText(
                    context,
                    getString(R.string.disable_voice_detection_service_first),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if(localStorage.isFirstChangeVoicePasscodeHomeClick){
                AppConfig.logEventTracking(HOME_CHANGE_VOICE_PASSCODE_FIRST)
                localStorage.isFirstChangeVoicePasscodeHomeClick = false
            }else{
                AppConfig.logEventTracking(HOME_CHANGE_VOICE_PASSCODE_AGAIN)
            }

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    "android.permission.RECORD_AUDIO"
                ) != 0
            ) {
                fromPermissionScreen = true
                findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_grantPermissionFragment)
            } else if (!SpeechRecognizer.isRecognitionAvailable(requireContext())) {
                Toast.makeText(
                    context,
                    getString(R.string.this_feature_is_not_supported_by_your_device),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (VoiceDetectionService.isservicerunning) {
                    Toast.makeText(
                        context,
                        getString(R.string.disable_voice_detection_service_first),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (localStorage.goToCreatePasscode) {
                        AppConfig.logEventTracking(GO_TO_CREATE_PASSCODE_FIRST)
                        localStorage.goToCreatePasscode = false
                    } else {
                        AppConfig.logEventTracking(GO_TO_CREATE_PASSCODE_AGAIN)
                    }
                    if (localStorage.voicePasscode.isEmpty()){
                        fromPasscodeScreen = true
                        findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_createPasscodeFragment)
                    } else {
                        //TODO Go to change passcode
                        findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_createPasscodeFragment)
                    }
                }
            }
        }

        dataBinding.btnDontTouch.setOnClickListener {
            if(VoiceDetectionService.isservicerunning || PocketDetectionService.isServiceRunning || ClapDetectionService.isservicerunning) {
                Toast.makeText(
                    context,
                    getString(R.string.disable_voice_detection_service_first),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            localStorage.lastMode = Constants.MODE_DONT_TOUCH
            if (localStorage.isFirstDontTouchClick) {
                AppConfig.logEventTracking(HOME_DONT_TOUCH_FIRST)
                localStorage.isFirstDontTouchClick = false
            } else {
                AppConfig.logEventTracking(HOME_DONT_TOUCH_AGAIN)
            }
            justChooseVoice = false
            justChooseClap = false
            justChoosePocket = false
            justChooseDontTouch = true

            typeServiceRunning = Constants.MODE_DONT_TOUCH
            if(!localStorage.isShowDontTouchIntro) {
                val dialog = FullScreenDontTouchDialog()
                dialog.setListener(this)
                AppConfig.updateResources(context, localStorage.langCode)
                dialog.show(parentFragmentManager, "FullScreenDontTouchDialog")
                localStorage.isShowDontTouchIntro = true
            }
            dataBinding.changevoicepasscode.visibility = View.GONE
            unSelectMenu()
            dataBinding.bgSelectedDontTouch.visibility = View.VISIBLE
            dataBinding.layoutSensitivityDT.visibility = View.VISIBLE
        }

        dataBinding.btnPocket.setOnClickListener {
            val sensorManager2 = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
            val proximitySensor = sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            if(proximitySensor == null){
                showPocketNotAvailableDialog()
                return@setOnClickListener
            }
            if(VoiceDetectionService.isservicerunning || MotionDetectionService.isServiceRunning || ClapDetectionService.isservicerunning) {
                Toast.makeText(
                    context,
                    getString(R.string.disable_voice_detection_service_first),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            localStorage.lastMode = Constants.MODE_POCKET
            if (localStorage.isFirstPocketClick) {
                AppConfig.logEventTracking(HOME_POCKET_FIRST)
                localStorage.isFirstPocketClick = false
            } else {
                AppConfig.logEventTracking(HOME_POCKET_AGAIN)
            }
            justChooseVoice = false
            justChooseClap = false
            justChooseDontTouch = false
            justChoosePocket = true

            typeServiceRunning = Constants.MODE_POCKET
            if(!localStorage.isShowPocketIntro) {
                // Change to FullScreenDontTouchDialog
                val dialog = FullPocketDialog()
                dialog.setListener(this)
                AppConfig.updateResources(context, localStorage.langCode)
                dialog.show(parentFragmentManager, "FullPocketDialog")
                localStorage.isShowPocketIntro = true
            }
            dataBinding.changevoicepasscode.visibility = View.GONE
            unSelectMenu()
            dataBinding.bgSelectedPocket.visibility = View.VISIBLE
            dataBinding.layoutOptionPocket.visibility = View.VISIBLE
        }

        dataBinding.btnclap.setOnClickListener {
            if(VoiceDetectionService.isservicerunning || MotionDetectionService.isServiceRunning || PocketDetectionService.isServiceRunning) {
                Toast.makeText(
                    context,
                    getString(R.string.disable_voice_detection_service_first),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            localStorage.lastMode = Constants.MODE_CLAP
            if (localStorage.isFirstClapClick) {
                AppConfig.logEventTracking(HOME_CLAP_FIRST)
                localStorage.isFirstClapClick = false
            } else {
                AppConfig.logEventTracking(HOME_CLAP_AGAIN)
            }
            justChooseVoice = false
            justChooseClap = true
            justChoosePocket = false
            justChooseDontTouch = false

            typeServiceRunning = Constants.MODE_CLAP
            dataBinding.changevoicepasscode.visibility = View.GONE
            unSelectMenu()
            dataBinding.bgSelectedClap.visibility = View.VISIBLE
        }

        dataBinding.btnvoice.setOnClickListener {
            if(ClapDetectionService.isservicerunning || MotionDetectionService.isServiceRunning || PocketDetectionService.isServiceRunning) {
                Toast.makeText(
                    context,
                    getString(R.string.disable_voice_detection_service_first),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            localStorage.lastMode = Constants.MODE_VOICE
            if (localStorage.isFirstVoiceClick) {
                AppConfig.logEventTracking(HOME_VOICE_FIRST)
                localStorage.isFirstVoiceClick = false
            } else {
                AppConfig.logEventTracking(HOME_VOICE_AGAIN)
            }
            typeServiceRunning = Constants.MODE_VOICE
            if(!localStorage.isShowVoiceIntro) {
                val dialog = FullScreenVoiceDialog()
                dialog.setListener(this)
                AppConfig.updateResources(context, localStorage.langCode)
                dialog.show(parentFragmentManager, "FullScreenVoiceDialog")
                localStorage.isShowVoiceIntro = true
            }
            unSelectMenu()
            dataBinding.bgSelectedVoice.visibility = View.VISIBLE
            dataBinding.changevoicepasscode.visibility = View.VISIBLE
            if (!justChooseVoice) {
                if(localStorage.voicePasscode.isEmpty()){
                    justChooseVoice = true
                    justChooseClap = false
                    justChoosePocket = false
                    justChooseDontTouch = false
                    dataBinding.tvChangePass.text = context?.resources?.getString(R.string.create_passcode)
                    if (!SpeechRecognizer.isRecognitionAvailable(requireContext())) {
                        Toast.makeText(
                            context,
                            getString(R.string.this_feature_is_not_supported_by_your_device),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    justChooseVoice = true
                    justChooseClap = false
                    justChoosePocket = false
                    justChooseDontTouch = false

                    dataBinding.tvChangePass.text = context?.resources?.getString(R.string.change_passcode)
                }
            }
        }

        setupRecyclerView()

        dataBinding.settings.setOnClickListener {
            if (localStorage.goToSetting) {
                AppConfig.logEventTracking(GO_TO_SETTING_FIRST)
                localStorage.goToSetting = false
            } else {
                AppConfig.logEventTracking(GO_TO_SETTING_AGAIN)
            }
            findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_settingFragment)
        }

        dataBinding.help.setOnClickListener {
            if (localStorage.goToHowtoUse) {
                AppConfig.logEventTracking(GO_TO_HOW_TO_USE_FIRST)
                localStorage.goToHowtoUse = false
            } else {
                AppConfig.logEventTracking(GO_TO_HOW_TO_USE_AGAIN)
            }
            val action =
                HomeFragmentDirections.actionHomeFragmentToHowToUseFragment(
                    typeServiceRunning
                )
            findNavController().navigate(action)
        }

        dataBinding.ivAdd.setOnClickListener {
            if(localStorage.goToChooseSound){
                AppConfig.logEventTracking(GO_TO_CHOOSE_SOUND_FIRST)
                localStorage.goToChooseSound = false
            } else {
                AppConfig.logEventTracking(GO_TO_CHOOSE_SOUND_AGAIN)
            }
            findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_chooseSoundFragment)
        }

        dataBinding.btnSeeMore.apply {
            text = getString(R.string.see_more, (allSoundListSound.size - 9).toString())
            setOnClickListener {
                if(localStorage.goToChooseSound){
                    AppConfig.logEventTracking(GO_TO_CHOOSE_SOUND_FIRST)
                    localStorage.goToChooseSound = false
                } else {
                    AppConfig.logEventTracking(GO_TO_CHOOSE_SOUND_AGAIN)
                }
                findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_chooseSoundFragment)
            }
        }
    }

    private fun setupRecyclerView() {
        dataBinding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        soundAdapter = SoundAdapter(itemList, localStorage.resourceId, onClick =  { soundItem ->
            if (localStorage.goToSoundDetail) {
                AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_FIRST)
                localStorage.goToSoundDetail = false
            } else {
                AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_AGAIN)
            }
            val action =
                HomeFragmentDirections.actionHomeFragmentToSoundDetailFragment(soundItem.iconResId)
            findNavController().navigate(action)
        })
        dataBinding.recyclerView.adapter = soundAdapter
        soundAdapter.notifyDataSetChanged()
    }

    private fun unSelectMenu() {
        dataBinding.bgSelectedClap.visibility = View.GONE
        dataBinding.bgSelectedVoice.visibility = View.GONE
        dataBinding.bgSelectedPocket.visibility = View.GONE
        dataBinding.bgSelectedDontTouch.visibility = View.GONE
        dataBinding.layoutSensitivityDT.visibility = View.GONE
        dataBinding.layoutOptionPocket.visibility = View.GONE
    }

    private fun checkServices() {
        val context: Context = requireContext()
        if (typeServiceRunning == Constants.MODE_DONT_TOUCH) {
            if (MotionDetectionService.isServiceRunning) {
                stopServiceRunning(MotionDetectionService::class.java)
                dataBinding.rlActive.visibility = View.INVISIBLE
                dataBinding.rlDeactive.visibility = View.VISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.active)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_play)
                dataBinding.ivShadowBottom.clearAnimation()
                dataBinding.ivShadowTop.clearAnimation()
            } else {
                if (ClapDetectionService.isservicerunning) {
                    stopServiceRunning(ClapDetectionService::class.java)
                }
                if (VoiceDetectionService.isservicerunning) {
                    stopServiceRunning(VoiceDetectionService::class.java)
                }
                if(PocketDetectionService.isServiceRunning){
                    stopServiceRunning(PocketDetectionService::class.java)
                }
//                startService(MotionDetectionService::class.java)
                dataBinding.rlActive.visibility = View.VISIBLE
                dataBinding.rlDeactive.visibility = View.INVISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.deactive)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
                dataBinding.ivShadowBottom.startAnimation(animation2)
                dataBinding.ivShadowTop.startAnimation(animation)
                // Điều hướng đến CountDownFragment với chế độ truyền qua Bundle
                val bundle = Bundle().apply {
                    putInt("mode_key", typeServiceRunning)
                    putString("service_class", MotionDetectionService::class.java.name)
                }
                findNavController().navigate(R.id.action_homeFragment_to_countDownFragment, bundle)
            }

        } else if (typeServiceRunning == Constants.MODE_POCKET) {
            if(PocketDetectionService.isServiceRunning){
                stopServiceRunning(PocketDetectionService::class.java)
                dataBinding.rlActive.visibility = View.INVISIBLE
                dataBinding.rlDeactive.visibility = View.VISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.active)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_play)
                dataBinding.ivShadowBottom.clearAnimation()
                dataBinding.ivShadowTop.clearAnimation()
            } else {
                if (ClapDetectionService.isservicerunning) {
                    stopServiceRunning(ClapDetectionService::class.java)
                }
                if (VoiceDetectionService.isservicerunning) {
                    stopServiceRunning(VoiceDetectionService::class.java)
                }
                if(MotionDetectionService.isServiceRunning){
                    stopServiceRunning(MotionDetectionService::class.java)
                }
//                startService(PocketDetectionService::class.java)
                dataBinding.rlActive.visibility = View.VISIBLE
                dataBinding.rlDeactive.visibility = View.INVISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.deactive)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
                dataBinding.ivShadowBottom.startAnimation(animation2)
                dataBinding.ivShadowTop.startAnimation(animation)
                // Điều hướng đến CountDownFragment với chế độ truyền qua Bundle
                val bundle = Bundle().apply {
                    putInt("mode_key", typeServiceRunning)
                    putString("service_class", PocketDetectionService::class.java.name)
                }
                findNavController().navigate(R.id.action_homeFragment_to_countDownFragment, bundle)
            }
        } else if (typeServiceRunning == Constants.MODE_CLAP) {
            if(ClapDetectionService.isservicerunning){
                stopServiceRunning(ClapDetectionService::class.java)
                dataBinding.rlActive.visibility = View.INVISIBLE
                dataBinding.rlDeactive.visibility = View.VISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.active)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_play)
                dataBinding.ivShadowBottom.clearAnimation()
                dataBinding.ivShadowTop.clearAnimation()
            } else {
                if (PocketDetectionService.isServiceRunning) {
                    stopServiceRunning(ClapDetectionService::class.java)
                }
                if (VoiceDetectionService.isservicerunning) {
                    stopServiceRunning(VoiceDetectionService::class.java)
                }
                if(MotionDetectionService.isServiceRunning){
                    stopServiceRunning(MotionDetectionService::class.java)
                }
                startService(ClapDetectionService::class.java)
                dataBinding.rlActive.visibility = View.VISIBLE
                dataBinding.rlDeactive.visibility = View.INVISIBLE
                dataBinding.tvActive.text = context.resources.getString(R.string.deactive)
                dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
                dataBinding.ivShadowBottom.startAnimation(animation2)
                dataBinding.ivShadowTop.startAnimation(animation)
            }
        } else {
            if (ContextCompat.checkSelfPermission(
                    context,
                    "android.permission.RECORD_AUDIO") == 0) {
                if (!SpeechRecognizer.isRecognitionAvailable(context)) {
                    Toast.makeText(
                        context,
                        getString(R.string.this_feature_is_not_supported_by_your_device),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (VoiceDetectionService.isservicerunning) {
                        dataBinding.rlActive.visibility = View.INVISIBLE
                        dataBinding.rlDeactive.visibility = View.VISIBLE
                        dataBinding.tvActive.text = context.resources.getString(R.string.active)
                        dataBinding.btnActivate.setImageResource(R.drawable.ic_play)
                        dataBinding.ivShadowBottom.clearAnimation()
                        dataBinding.ivShadowTop.clearAnimation()
                        stopServiceRunning(VoiceDetectionService::class.java)
                    } else {
                        dataBinding.rlActive.visibility = View.VISIBLE
                        dataBinding.rlDeactive.visibility = View.INVISIBLE
                        dataBinding.tvActive.text = context?.resources?.getString(R.string.deactive)
                        dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
                        dataBinding.ivShadowBottom.startAnimation(animation2)
                        dataBinding.ivShadowTop.startAnimation(animation)
                        if (MotionDetectionService.isServiceRunning) {
                            stopServiceRunning(MotionDetectionService::class.java)
                        }
                        if (ClapDetectionService.isservicerunning) {
                            stopServiceRunning(ClapDetectionService::class.java)
                        }
                        if(PocketDetectionService.isServiceRunning){
                            stopServiceRunning(PocketDetectionService::class.java)
                        }
                        startService(VoiceDetectionService::class.java)
                    }
                }
            } else {
                fromPermissionScreen = true
                findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_grantPermissionFragment)
            }
        }
    }

    private fun startService(serviceClass: Class<*>) {
        val context: Context = requireContext()
        requireContext().startService(Intent(context, serviceClass))
        // Cập nhật thời gian bắt đầu cho dịch vụ
        when (serviceClass) {
            MotionDetectionService::class.java -> {
                localStorage.lastStartTimeMotion = System.currentTimeMillis()
                isServiceRunning = true
            }
            PocketDetectionService::class.java -> {
                localStorage.lastStartTimePocket = System.currentTimeMillis()
                PocketDetectionService.isServiceRunning = true
            }
            ClapDetectionService::class.java -> {
                localStorage.lastStartTimeClap = System.currentTimeMillis()
                ClapDetectionService.isservicerunning = true
            }
            VoiceDetectionService::class.java -> {
                localStorage.lastStartTimeVoice = System.currentTimeMillis()
                VoiceDetectionService.isservicerunning = true
            }
        }
    }

    private fun stopServiceRunning(serviceClass: Class<*>) {

        val context: Context = requireContext()
        requireContext().stopService(Intent(context, serviceClass))

        val currentTime = System.currentTimeMillis()
        val timeRange: Long
        when (serviceClass) {
            MotionDetectionService::class.java -> {
                timeRange = currentTime - localStorage.lastStartTimeMotion
                isServiceRunning = false
            }

            PocketDetectionService::class.java -> {
                timeRange = currentTime - localStorage.lastStartTimePocket
                PocketDetectionService.isServiceRunning = false
            }

            PocketDetectionService::class.java -> {
                timeRange = currentTime - localStorage.lastStartTimePocket
                PocketDetectionService.isServiceRunning = false
            }

            ClapDetectionService::class.java -> {
                timeRange = currentTime - localStorage.lastStartTimeClap
                ClapDetectionService.isservicerunning = false
            }

            VoiceDetectionService::class.java -> {
                timeRange = currentTime - localStorage.lastStartTimeVoice
                VoiceDetectionService.isservicerunning = false
            }

            else -> return
        }
//        // Kiểm tra thời gian đã chạy của dịch vụ
//        if (timeRange >= 300000L) {
//            localStorage.isStartService300s = true
//        }
//
//        // Kiểm tra điều kiện hiển thị đánh giá
//        if (localStorage.countTotalExitAppToShowRating >= Constants.COUNT_BACK_TO_SHOW_RATING
//            && !localStorage.isShowRating
//            && localStorage.isStartService300s
//        ) {
//            if (localStorage.countShowRating == 0) {
//                localStorage.countShowRating += 1
//                localStorage.countTotalExitAppToShowRating = 0
//                localStorage.timeShowRatingFirst = System.currentTimeMillis()
////                initRatingAppBottomSheet()
//            } else if (localStorage.countShowRating < Constants.MAX_COUNT_SHOW_RATING
//                && System.currentTimeMillis() - localStorage.timeShowRatingFirst >= MIN_DISTANCE_TIME_SHOW_RATING
//            ) {
//                localStorage.countShowRating += 1
////                initRatingAppBottomSheet()
//            } else {
//                localStorage.countTotalExitAppToShowRating += 1
//                localStorage.isShowRating = true
//                activity?.finishAffinity()
//            }
//        }
    }

    private fun showPermissionSuccessDialog() {
        val layoutInflater = layoutInflater
        val inflater: View =
            layoutInflater.inflate(R.layout.dialog_permission_success, null as ViewGroup?)
        val create =
            AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog).setView(inflater)
                .setCancelable(false).create()
        if (create.getWindow() != null) {
            val window = create.window
            window?.apply {
                setLayout(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
                )
                setGravity(Gravity.CENTER)
            }
        }
        (inflater.findViewById<View>(R.id.dialog_button) as TextView).setOnClickListener {
            create.dismiss()
        }
        create.show()
    }

    private fun unselectSounds() {
        // Đặt lại màu sắc cho tất cả các items trong danh sách và cập nhật adapter
        val soundUnselectedDrawable = R.drawable.soundunselected
        val soundTextColor = ContextCompat.getColor(requireContext(), R.color.soundtextcolor)

        // Lặp qua tất cả các item và thay đổi trạng thái
        itemList.forEach { item ->
            item.isSelected = false  // Đặt lại trạng thái cho mỗi item

            // Cập nhật các thuộc tính của item
            item.iconResId = soundUnselectedDrawable
            item.label = item.label  // Nếu muốn thay đổi màu sắc label, thực hiện ở đây
        }

        // Thông báo cho adapter về sự thay đổi dữ liệu
        soundAdapter.notifyDataSetChanged()  // Đảm bảo Adapter sẽ làm mới dữ liệu

        // Nếu bạn muốn cập nhật UI ngay lập tức, bạn có thể thay đổi trực tiếp các thuộc tính trong Adapter
        soundAdapter.notifyItemRangeChanged(0, itemList.size)
    }

    override fun onBackPressed(): Boolean {
//        showExitDialog()
        if (localStorage.countTotalExitAppToShowRating >= Constants.COUNT_BACK_TO_SHOW_RATING
            && !localStorage.isShowRating
            && localStorage.isStartService300s
        ) {
            if (localStorage.countShowRating == 0) {
                localStorage.countShowRating = localStorage.countShowRating + 1
                localStorage.countTotalExitAppToShowRating = 0
                localStorage.timeShowRatingFirst = System.currentTimeMillis()
                initRatingAppBottomSheet()
                return true
            } else if (localStorage.countShowRating < Constants.MAX_COUNT_SHOW_RATING
                && System.currentTimeMillis() - localStorage.timeShowRatingFirst >= MIN_DISTANCE_TIME_SHOW_RATING
            ) {
                localStorage.countShowRating += 1
                initRatingAppBottomSheet()
                return true
            } else {
                localStorage.countTotalExitAppToShowRating += 1
                localStorage.isShowRating = true
                activity.let {
                    it?.finishAffinity()
                }
            }
        } else {
            localStorage.countTotalExitAppToShowRating += 1
            activity.let {
                it?.finishAffinity()
            }
        }
        return super.onBackPressed()
    }

    private fun isPermissionsNotification(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!hasPermissions(*PERMISSIONS_ANDROID13)) {
                return false
            }
        }
        return true
    }

    private fun hasPermissions(vararg permissions: String?): Boolean {
        for (permission in permissions) {
            if (permission?.let { activity?.checkSelfPermission(it) } != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun initRatingAppBottomSheet() {
        ratingAppBottomSheet = RatingAppBottomSheet()
        ratingAppBottomSheet.updateLanguage(context, localStorage.langCode)
        ratingAppBottomSheet.clickConfirmYes = {
            val bundel = Bundle()
            bundel.putInt(
                Constants.KEY_COUNT_CLICK_NO_BEFORE,
                localStorage.countTotalExitAppToShowRating
            )
            bundel.putString(Constants.KEY_LANGUAGE_APP, localStorage.langCode)
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_DIALOG_RATING_YES, bundel)

            if (it == 1 || it == 2 || it == 3) {
                initConfirmSendFeedbackBottomSheet()
            } else {
                activity.let {
                    it?.finishAffinity()
                }
            }
        }
        ratingAppBottomSheet.clickConfirmNo = {
            localStorage.countClickNoBeforeRating = localStorage.countClickNoBeforeRating + 1
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_DIALOG_RATING_NO)
            activity.let {
                it?.finishAffinity()
            }
        }
        ratingAppBottomSheet.clickConfirmCancel = {
            localStorage.countClickNoBeforeRating = localStorage.countClickNoBeforeRating + 1
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_DIALOG_RATING_CANCEL)
            activity.let {
                it?.finishAffinity()
            }
        }
        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_DIALOG_RATING_SHOW)
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                ratingAppBottomSheet.show(
                    it,
                    RatingAppBottomSheet.TAG
                )
            }
        }
    }

    private fun initConfirmSendFeedbackBottomSheet() {
        confirmBottomSheet = ConfirmBottomSheet.newInstance(
            resources.getString(R.string.feedback),
            resources.getString(R.string.content_feedback),
            resources.getString(R.string.allow)
        )
        confirmBottomSheet?.updateLanguage(context, localStorage.langCode)
        confirmBottomSheet?.clickConfirmYes = {
            try {
                AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_YES)
                localStorage.isShowRating = true
                activity?.let { it1 ->
                    AppConfig.sendMail(
                        it1, Constants.SUBJECT_EMAIL, context?.resources?.getString(
                            R.string.choose_email
                        )
                    )
                }
                activity.let {
                    it?.finishAffinity()
                }
            } catch (e: Exception) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
        confirmBottomSheet?.clickConfirmNo = {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_NO)
            activity.let {
                it?.finishAffinity()
            }
        }
        confirmBottomSheet?.clickConfirmCancel = {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_CANCEL)
            activity.let {
                it?.finishAffinity()
            }
        }
        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_SHOW)
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                confirmBottomSheet?.show(
                    it,
                    RatingAppBottomSheet.TAG
                )
            }
        }
    }

    private fun showPopupWindow(view: View, content: String) {
        val inflater = requireContext().getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.popup_window_text, null)

        val popupWindow = PopupWindow(
            popupView,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            true
        )

        val popupTextView = popupView.findViewById<TextView>(R.id.popup_text)
        popupTextView.text = content

        popupWindow.showAsDropDown(view)

        popupWindow.isOutsideTouchable = true
    }

    private fun showExitDialog() {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Exit App?")
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false) // Không cho phép đóng ngoài dialog

        dialog.setPositiveButton("Yes") { _, _ ->
            requireActivity().finish()  // Đóng Activity
        }

        dialog.setNegativeButton("No") { _, _ ->
            // Do nothing, dialog sẽ tự động đóng
        }

        dialog.setNeutralButton("Rate") { _, _ ->
            val packageName = requireContext().packageName
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
            startActivity(intent)
        }

        dialog.show()
    }

    override fun initializeData() {
        localStorage.isFirstOpen = false
    }

    override fun onResume() {
        super.onResume()
        initAllSound()
        setItemList()
        setupRecyclerView()
        unSelectMenu()
        if(localStorage.isChangeSettingSoundDetail) {
            localStorage.isChangeSettingSoundDetail = false
            if (ClapDetectionService.isservicerunning) {
                stopServiceRunning(ClapDetectionService::class.java)
                startService(ClapDetectionService::class.java)
            } else if (VoiceDetectionService.isservicerunning) {
                stopServiceRunning(VoiceDetectionService::class.java)
                startService(VoiceDetectionService::class.java)
            } else if (MotionDetectionService.isServiceRunning) {
                stopServiceRunning(MotionDetectionService::class.java)
                startService(MotionDetectionService::class.java)
            } else if (PocketDetectionService.isServiceRunning) {
                stopServiceRunning(PocketDetectionService::class.java)
                startService(PocketDetectionService::class.java)
            }
        }
        if (ClapDetectionService.isservicerunning || VoiceDetectionService.isservicerunning || PocketDetectionService.isServiceRunning || isServiceRunning) {
            dataBinding.rlActive.visibility = View.VISIBLE
            dataBinding.rlDeactive.visibility = View.INVISIBLE
            dataBinding.tvActive.text = context?.resources?.getString(R.string.deactive)
            dataBinding.btnActivate.setImageResource(R.drawable.ic_pause)
            dataBinding.ivShadowBottom.startAnimation(animation2)
            dataBinding.ivShadowTop.startAnimation(animation)
            unSelectMenu()
            if(ClapDetectionService.isservicerunning) {
                dataBinding.bgSelectedClap.visibility = View.VISIBLE
            } else if (VoiceDetectionService.isservicerunning) {
                dataBinding.bgSelectedVoice.visibility = View.VISIBLE
            } else if(PocketDetectionService.isServiceRunning){
                dataBinding.bgSelectedPocket.visibility = View.VISIBLE
                dataBinding.layoutOptionPocket.visibility = View.VISIBLE
            } else {
                dataBinding.bgSelectedDontTouch.visibility = View.VISIBLE
                dataBinding.layoutSensitivityDT.visibility = View.VISIBLE
            }
        } else {
            dataBinding.rlActive.visibility = View.INVISIBLE
            dataBinding.rlDeactive.visibility = View.VISIBLE
            dataBinding.tvActive.text = context?.resources?.getString(R.string.active)
            dataBinding.btnActivate.setImageResource(R.drawable.ic_play)
            dataBinding.ivShadowBottom.clearAnimation()
            dataBinding.ivShadowTop.clearAnimation()
            unSelectMenu()
            dataBinding.bgSelectedClap.visibility = View.VISIBLE
            if(!localStorage.isShowClapIntro) {
                val dialog = FullScreenClapDialog()
                dialog.setListener(this)
                AppConfig.updateResources(context, localStorage.langCode)
                dialog.show(parentFragmentManager, "SimpleDialogFragment")
                localStorage.isShowClapIntro = true
            }
        }
        var lastModeValue = localStorage.lastMode
        if (lastModeValue == Constants.MODE_CLAP){
            dataBinding.bgSelectedClap.visibility = View.VISIBLE
            dataBinding.changevoicepasscode.visibility = View.GONE
            dataBinding.btnclap.performClick()
        } else if(lastModeValue == Constants.MODE_VOICE){
            dataBinding.bgSelectedVoice.visibility = View.VISIBLE
            dataBinding.changevoicepasscode.visibility = View.VISIBLE
            if (localStorage.voicePasscode.isEmpty()) {
                dataBinding.tvChangePass.text = context?.resources?.getString(R.string.create_passcode)
            } else {
                dataBinding.tvChangePass.text = context?.resources?.getString(R.string.change_passcode)
            }
            dataBinding.btnvoice.performClick()
        } else if(lastModeValue == Constants.MODE_POCKET){
            dataBinding.bgSelectedPocket.visibility = View.VISIBLE
            dataBinding.changevoicepasscode.visibility = View.GONE
            dataBinding.layoutSensitivityDT.visibility = View.VISIBLE
            dataBinding.btnPocket.performClick()
        } else if(lastModeValue == Constants.MODE_DONT_TOUCH){
            dataBinding.bgSelectedDontTouch.visibility = View.VISIBLE
            dataBinding.changevoicepasscode.visibility = View.GONE
            dataBinding.layoutOptionPocket.visibility = View.VISIBLE
            dataBinding.btnDontTouch.performClick()
        }

        if(localStorage.shouldShowBatteryDialog){
            localStorage.shouldShowBatteryDialog = false
            showBatteryDialog()
        }
    }

    private fun showBatteryDialog(){
        val dialog = BatteryRationaleDialog()
        dialog.onNavigateClick = {
            if(findNavControllerSafety()?.currentDestination?.id == R.id.homeFragment){
                findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_grantPermissionFragment)
            }
            dialog.dismiss()
        }
        dialog.show(parentFragmentManager, "BatteryRationaleDialog")
    }

    private fun showPocketNotAvailableDialog(){
        val dialog = PocketNotAvailableDialog()
        dialog.show(parentFragmentManager, "PocketNotAvailableDialog")
    }

    private fun checkPermissions(): Boolean {
        val hasNotificationPermission =
            ContextCompat.checkSelfPermission(
                requireContext(),
                "android.permission.POST_NOTIFICATIONS"
            ) == PackageManager.PERMISSION_GRANTED
                    || Build.VERSION.SDK_INT < 33
        val hasRecordPermission = ContextCompat.checkSelfPermission(
            requireContext(),
            "android.permission.RECORD_AUDIO"
        ) == PackageManager.PERMISSION_GRANTED
        return hasNotificationPermission && hasRecordPermission
    }

    private fun initAllSound(){
        allSoundListSound.clear()
        allSoundListSound.addAll(getAllSound())
    }

    private fun getAllSound(): List<SoundItem>{
        val soundList = mutableListOf<SoundItem>()
        soundList.apply {
            add(SoundItem(R.drawable.policewhistle, getString(R.string.police_whistle)))
            add(SoundItem(R.drawable.cat, getString(R.string.cat_meowing)))
            add(SoundItem(R.drawable.dog, getString(R.string.dog_barking)))
            add(SoundItem(R.drawable.rifle, getString(R.string.rifle)))
            add(SoundItem(R.drawable.calvelry, getString(R.string.cavelry)))
            add(SoundItem(R.drawable.trumpet, getString(R.string.army_trumpet)))
            add(SoundItem(R.drawable.whistle, getString(R.string.whistle)))
            add(SoundItem(R.drawable.thunder, getString(R.string.thunder)))
            add(SoundItem(R.drawable.car, getString(R.string.car_honk)))
            add(SoundItem(R.drawable.doorbell, getString(R.string.door_bell)))
            add(SoundItem(R.drawable.birds, getString(R.string.birds_chirping)))
            add(SoundItem(R.drawable.partyhorn, getString(R.string.party_horn)))
            add(SoundItem(R.drawable.beast_roar, getString(R.string.beast_roar)))
            add(SoundItem(R.drawable.greeting, getString(R.string.greeting)))
            add(SoundItem(R.drawable.christmas_themed, getString(R.string.christmas_themed)))
            add(SoundItem(R.drawable.halloween_doorbell, getString(R.string.halloween_doorbell)))
            add(SoundItem(R.drawable.police_siren_loop, getString(R.string.police_siren_loop)))
            add(SoundItem(R.drawable.oh_my_god, getString(R.string.oh_my_god)))
            add(SoundItem(R.drawable.happy_birthday_doorbell, getString(R.string.happy_birthday_doorbell)))
            add(SoundItem(R.drawable.single_cat_meow, getString(R.string.single_cat_meow)))
            add(SoundItem(R.drawable.toy_dog_barking, getString(R.string.toy_dog_barking)))
            add(SoundItem(R.drawable.intercom_doorbell, getString(R.string.intercom_doorbell)))
            add(SoundItem(R.drawable.sad_trumpet, getString(R.string.sad_trumpet)))
            // Melody
            add(SoundItem(R.drawable.solitude_ringtone, getString(R.string.solitude_ringtone_label)))
            add(SoundItem(R.drawable.ballerina_music, getString(R.string.ballerina_music_label)))
            add(SoundItem(R.drawable.ding_dong_merrily, getString(R.string.ding_dong_merrily_label)))
            add(SoundItem(R.drawable.peaceful_piano_melody, getString(R.string.peaceful_piano_melody_label)))
            // Funny
            add(SoundItem(R.drawable.ic_winning_horn, getString(R.string.winning_horn_sound)))
            add(SoundItem(R.drawable.ic_loading_sound, getString(R.string.loading_sound)))
            add(SoundItem(R.drawable.ic_oh_no, getString(R.string.whispered_oh_no)))
            add(SoundItem(R.drawable.ic_80s_alarm_clock, getString(R.string.alarm_clock_80s)))
            add(SoundItem(R.drawable.ic_clock_ticking_fast, getString(R.string.clock_ticking_fast)))
            add(SoundItem(R.drawable.ic_aggressive_male_laugh, getString(R.string.aggressive_male_laugh)))
            add(SoundItem(R.drawable.ic_applause, getString(R.string.applause_and_standing_ovation)))
            add(SoundItem(R.drawable.ic_cartoon_steps, getString(R.string.cartoon_steps)))
            add(SoundItem(R.drawable.ic_cartoon_run, getString(R.string.cartoon_run)))
            add(SoundItem(R.drawable.ic_funny_footsteps, getString(R.string.funny_footstep)))
            add(SoundItem(R.drawable.ic_funny_laugh, getString(R.string.funny_laugh)))
            add(SoundItem(R.drawable.ic_glitch_button, getString(R.string.glitch_button)))
            add(SoundItem(R.drawable.ic_glitching, getString(R.string.glitching)))
            add(SoundItem(R.drawable.ic_glitchy, getString(R.string.glitchy)))
            add(SoundItem(R.drawable.hurry_up_game_movement, getString(R.string.hurry_up_game_movement)))
            add(SoundItem(R.drawable.ic_hand_bell, getString(R.string.hand_bell_chiming)))
            add(SoundItem(R.drawable.mallet_notification, getString(R.string.mallet_notification)))
            add(SoundItem(R.drawable.ic_whistle_noise, getString(R.string.whistle_noise)))
            add(SoundItem(R.drawable.ghost_of_christmas_past, getString(R.string.ghost_of_christmas_past)))
            add(SoundItem(R.drawable.ic_festival_cheers, getString(R.string.festival_cheers)))
        }
        return soundList
    }

    private fun setItemList(){
        itemList.clear()
        val recentSounds = localStorage.recentSounds.split(",").toMutableList()
        allSoundListSound.find { it.iconResId == localStorage.resourceId }?.let {
            itemList.add(it)
        }
        recentSounds.forEach { iconResId ->
            allSoundListSound.find { it.iconResId.toString() == iconResId && it.iconResId != localStorage.resourceId }?.let {
                itemList.add(it)
            }
        }
        while(itemList.size < 9){
            val randomSound = allSoundListSound.filter { it.iconResId.toString() !in recentSounds }.random()
            recentSounds.add(randomSound.iconResId.toString())
            if(!randomSound.iconResId.equals(localStorage.resourceId)) {
                itemList.add(randomSound)
            }
            itemList.distinctBy { it.iconResId }
        }
    }

    companion object {
        const val TAG = "HomeFragment"
        const val TAG1 = "ConfirmDeleteScriptBottomSheet"
    }

    override fun onPause() {
        super.onPause()
        if (::ratingAppBottomSheet.isInitialized && ratingAppBottomSheet.isVisible) {
            ratingAppBottomSheet.dismiss()
        }
    }

    override fun onImageViewClicked() {}

    override fun onNavigateViewClicked() {
        val action = HomeFragmentDirections.actionHomeFragmentToHowToUseFragment(
            typeServiceRunning
        )
        findNavControllerSafety()?.navigate(action)
    }
}
