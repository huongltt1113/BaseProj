package com.dev.baseproject.ui.component.sound

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.widget.ScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.baseproject.R
import com.dev.baseproject.customviews.CircularSeekBar.OnProgressChangedListener
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.FragmentSoundDetailBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.ui.component.bottomsheet.ConfirmBottomSheet
import com.dev.baseproject.ui.component.bottomsheet.DurationBottomSheet
import com.dev.baseproject.ui.component.bottomsheet.EnableOneMethodBottomSheet
import com.dev.baseproject.ui.component.home.adapter.SoundAdapter
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_APPLY_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_APPLY_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_PLAY_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_PLAY_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_FLASH_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_FLASH_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_SOUND_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_SOUND_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_VIBRATE_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_SWITCH_VIBRATE_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_VOICE_MAX_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_VOICE_MAX_FIRST
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_VOICE_MUTE_AGAIN
import com.dev.baseproject.utils.Constants.SOUND_DETAIL_VOICE_MUTE_FIRST
import com.dev.baseproject.utils.Logger
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlin.jvm.internal.Intrinsics

@AndroidEntryPoint
class SoundDetailFragment : BaseFragmentBinding<FragmentSoundDetailBinding>() {
    private var cameraManager: CameraManager? = null
    private var hasFlash = false
    private var mediaPlayer: MediaPlayer? = null
    private var resourceId: Int = R.drawable.dog
    private var soundId: Pair<Int?, Int?> = Pair(null, null)
    private var isPlaying: Boolean = false

    private lateinit var soundAdapter: SoundAdapter
    private lateinit var durationAdapter: DurationAdapter
    private var durationBottomSheet: DurationBottomSheet? = null
    private val durationList: MutableList<String> = mutableListOf()
    private val itemList = mutableListOf<SoundItem>()
    private var durationAdded = ""
    private var timeDuration = Constants.VALUE_DURATION_LOOP
    private var isSoundEnabled = true
    private var isVibrationEnabled = false
    private var isFlashEnabled = false
    private var defaultSoundVolume = 0.0f
    private var confirmBottomSheet: ConfirmBottomSheet? = null
    private var enableOneMethodBottomSheet: EnableOneMethodBottomSheet? = null

    override fun getContentViewId() = R.layout.fragment_sound_detail

    override fun initializeViews() {
        resourceId = localStorage.resourceId.takeIf { it != 0 } ?: R.drawable.dog
        durationAdded = localStorage.durationAdded
        timeDuration = localStorage.timeDuration
        isSoundEnabled = localStorage.isSoundEnabled
        isVibrationEnabled = localStorage.isVibrationEnabled
        isFlashEnabled = localStorage.isFlashEnabled
        defaultSoundVolume = localStorage.defaultSoundVolume
        arguments?.let {
            resourceId = it.getInt("resource_id", resourceId)
        }
        addToRecent()
        durationList.addAll(listOf("5s", "10s", "15s"))
        if (localStorage.durationAdded.isNotEmpty() &&
            localStorage.durationAdded !in
            listOf(
                "5s",
                "10s",
                "15s",
            )
        ) {
            durationList.add(localStorage.durationAdded)
        }
        durationList.add(0, getString(R.string.loop))

        if (itemList.isEmpty()) {
            itemList.addAll(getAllSound())
        }

        setupRecyclerView()
        setUpDurationRecyclerView()

        dataBinding.ivsound.setImageResource(resourceId)
        this.cameraManager =
            requireContext().getSystemService(Context.CAMERA_SERVICE) as CameraManager
        this.hasFlash = checkFlashAvailability()
        // sound
        if (!localStorage.isSoundEnabled) {
            dataBinding.switchsound.isChecked = false
//            dataBinding.ivswitch.setImageResource(R.drawable.switchpathoff)
        } else {
            dataBinding.switchsound.isChecked = true
//            dataBinding.ivswitch.setImageResource(R.drawable.switchpathon)
        }
        // vibration
        if (!localStorage.isVibrationEnabled) {
            dataBinding.switchvibrate.isChecked = false
        } else {
            dataBinding.switchvibrate.isChecked = true
        }
        // flash
        if (!localStorage.isFlashEnabled) {
            dataBinding.switchflash.isChecked = false
        } else {
            dataBinding.switchflash.isChecked = true
        }

        soundId = getSoundFromResourceId(resourceId)
        soundId.first?.let { mediaPlayer = MediaPlayer.create(context, it) }
        soundId.second?.let { dataBinding.heading.text = getString(it) }

        if (dataBinding.circularseekbar.progress == 0f) {
            dataBinding.voicemute.setImageResource(R.drawable.ic_vol_off)
        }

        updateUI()
    }

    private fun updateUI() {
        dataBinding.switchsound.isChecked = isSoundEnabled
        dataBinding.switchvibrate.isChecked = isVibrationEnabled
        dataBinding.switchflash.isChecked = isFlashEnabled

        soundId = getSoundFromResourceId(resourceId)
        soundId.first?.let { mediaPlayer = MediaPlayer.create(context, it) }
        soundId.second?.let { dataBinding.heading.text = getString(it) }

        dataBinding.circularseekbar.setProgress(defaultSoundVolume)
        dataBinding.circularseekbar.updateVolume(defaultSoundVolume)

        if (dataBinding.circularseekbar.progress == 0f) {
            dataBinding.voicemute.setImageResource(R.drawable.ic_vol_off)
        } else {
            dataBinding.voicemute.setImageResource(R.drawable.vollow)
        }
    }

    override fun registerListeners() {
        dataBinding.ivSettingDuration.setOnClickListener {
            if(!AppConfig.isDoubleClick()) {
                durationBottomSheet = DurationBottomSheet()
                durationBottomSheet?.onSaveButtonClick = { time ->
                    var timeDuration = convertToSeconds(time) * 1000

                    val timeInMillis = millisToTimeString(timeDuration.toLong())
                    val listItem = durationAdapter.getData().toMutableList()
                    val fixedDurations = listOf("5s", "10s", "15s", getString(R.string.loop))

                    if (listItem.count() >= 5) {
                        listItem.clear()
                        for (fixedDuration in fixedDurations) {
                            listItem.add(fixedDuration)
                        }
                    }
                    if (!fixedDurations.contains(timeInMillis) && !listItem.contains(timeInMillis)) {
                        if (timeInMillis == getString(R.string.loop)) {
                            listItem.add(getString(R.string.loop))
                        } else {
                            if (!fixedDurations.contains(timeInMillis) && !listItem.contains(
                                    timeInMillis
                                )
                            ) {
                                listItem.add(timeInMillis)
                            }
                        }
                    }
                    val sortedList =
                        listItem.sortedWith(
                            compareBy {
                                if (it.equals(getString(R.string.loop))) {
                                    Constants.VALUE_DURATION_LOOP
                                } else {
                                    convertToSeconds(
                                        it,
                                    )
                                }
                            },
                        )
                    durationAdapter.updateData(sortedList, timeInMillis, onSelectDone = {
                        dataBinding.rvDuration.scrollToPosition(sortedList.indexOf(timeInMillis))
                    })
                    durationAdded = timeInMillis
                    this.timeDuration = timeDuration
                }
                if (activity?.isFinishing == false) {
                    activity?.supportFragmentManager?.let {
                        durationBottomSheet?.show(it, DurationBottomSheet.TAG)
                    }
                }
            }
        }

        dataBinding.switchsound.setOnCheckedChangeListener { _, isChecked ->
            if (localStorage.isFirstSwitchSoundClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_SOUND_FIRST)
                localStorage.isFirstSwitchSoundClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_SOUND_AGAIN)
            }
            if (isChecked) {
                isSoundEnabled = true
//                dataBinding.ivswitch.setImageResource(R.drawable.switchpathon)
            } else {
                isSoundEnabled = false
//                dataBinding.ivswitch.setImageResource(R.drawable.switchpathoff)
            }
        }

        dataBinding.switchvibrate.setOnCheckedChangeListener { _, isChecked ->
            if (localStorage.isFirstSwitchVibrateClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_VIBRATE_FIRST)
                localStorage.isFirstSwitchVibrateClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_VIBRATE_AGAIN)
            }
            if (isChecked) {
                isVibrationEnabled = true
            } else {
                isVibrationEnabled = false
            }
        }

        dataBinding.switchflash.setOnCheckedChangeListener { _, isChecked ->
            if (localStorage.isFirstSwitchFlashClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_FLASH_FIRST)
                localStorage.isFirstSwitchFlashClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_SWITCH_FLASH_AGAIN)
            }
            if (!isChecked) {
                isFlashEnabled = false
            } else if (hasFlash) {
                isFlashEnabled = true
            } else {
                isFlashEnabled = false
                Toast
                    .makeText(
                        requireContext(),
                        getString(R.string.your_device_doesn_t_support_flash),
                        Toast.LENGTH_SHORT,
                    ).show()
            }
        }
        dataBinding.circularseekbar.setOnProgressChangedListener(
            object :
                OnProgressChangedListener {
                override fun onProgressChanged(progress: Float) {
                    if(dataBinding.scrViewSetting.y != 0f){
                        dataBinding.scrViewSetting.fullScroll(ScrollView.FOCUS_UP);
                    }
                    if (progress == 0f) {
                        dataBinding.voicemute.setImageResource(R.drawable.ic_vol_off)
                    } else {
                        dataBinding.voicemute.setImageResource(R.drawable.vollow)
                    }
                    defaultSoundVolume = progress
                }
            },
        )

        dataBinding.voicemax.setOnClickListener {
            if (localStorage.isFirstVoiceMaxClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_VOICE_MAX_FIRST)
                localStorage.isFirstVoiceMaxClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_VOICE_MAX_AGAIN)
            }
            dataBinding.circularseekbar.setProgress(1.0f)
            dataBinding.circularseekbar.updateVolume(1.0f)
            dataBinding.voicemute.setImageResource(R.drawable.vollow)
            defaultSoundVolume = 1.0f
        }

        dataBinding.voicemute.setOnClickListener {
            if (localStorage.isFirstVoiceMuteClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_VOICE_MUTE_FIRST)
                localStorage.isFirstVoiceMuteClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_VOICE_MUTE_AGAIN)
            }
            dataBinding.circularseekbar.setProgress(0.0f)
            dataBinding.circularseekbar.updateVolume(0.0f)
            dataBinding.voicemute.setImageResource(R.drawable.ic_vol_off)
            defaultSoundVolume = 0.0f
        }

        this.mediaPlayer?.setOnCompletionListener {
            dataBinding.play.setImageResource(R.drawable.play)
            dataBinding.ivsound.setBackgroundResource(R.drawable.sounddetailbg)
        }

        dataBinding.play.setOnClickListener {
            if (localStorage.isFirstPlaySoundDetailClick) {
                AppConfig.logEventTracking(SOUND_DETAIL_PLAY_FIRST)
                localStorage.isFirstPlaySoundDetailClick = false
            } else {
                AppConfig.logEventTracking(SOUND_DETAIL_PLAY_AGAIN)
            }
            isPlaying = true
            if (!mediaPlayer?.isPlaying!!) {
                mediaPlayer?.start()
                mediaPlayer?.isLooping = true
                dataBinding.play.setImageResource(R.drawable.pause)
                dataBinding.ivsound.setBackgroundResource(R.drawable.sounddetailselectedbg)
            } else {
                isPlaying = false
                val mediaPlayer4 = mediaPlayer
                mediaPlayer4?.pause()
                dataBinding.play.setImageResource(R.drawable.play)
                dataBinding.ivsound.setBackgroundResource(R.drawable.sounddetailbg)
            }
        }

        dataBinding.applybutton.setOnClickListener {
            if((defaultSoundVolume == 0f || !isSoundEnabled) && !isFlashEnabled && !isVibrationEnabled){
                initEnableOneMethodBottomSheet()
            } else {
                initConfirmSaveBottomSheet()
            }
        }

        dataBinding.cancelbutton.setOnClickListener {
            findNavControllerSafety()?.popBackStack()
        }

        dataBinding.btnBack.setOnClickListener {
            findNavControllerSafety()?.popBackStack()
        }
    }

    override fun initializeData() {
    }

    private fun setupRecyclerView() {
        dataBinding.rvSound.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val fullWidth = resources.displayMetrics.widthPixels
        val spacingInPixels = (8 * resources.displayMetrics.density).toInt()
        val itemWidth = (fullWidth - 5 * spacingInPixels) / 4
        soundAdapter =
            SoundAdapter(itemList, resourceId, onClick = { soundItem ->
                if (localStorage.goToSoundDetail) {
                    AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_FIRST)
                    localStorage.goToSoundDetail = false
                } else {
                    AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_AGAIN)
                }
                resourceId = soundItem.iconResId

                dataBinding.heading.text = soundItem.label
                dataBinding.ivsound.setImageResource(soundItem.iconResId)

                setSound()
            }, isShowLabel = false, itemWidth = itemWidth, spacing = spacingInPixels)
        dataBinding.rvSound.adapter = soundAdapter
        soundAdapter.notifyDataSetChanged()
        dataBinding.rvSound.scrollToPosition(itemList.indexOfFirst { it.iconResId == resourceId })
    }

    private fun setUpDurationRecyclerView() {
        val initDuration = localStorage.timeDuration.toLong()
        val durationInMillis = millisToTimeString(initDuration)
        val sortedList =
            durationList.sortedWith(
                compareBy {
                    if (it.equals(getString(R.string.loop))) {
                        Constants.VALUE_DURATION_LOOP
                    } else {
                        convertToSeconds(
                            it,
                        )
                    }
                },
            )
        durationAdapter =
            DurationAdapter(onItemClick = { duration ->
                val time = convertToSeconds(duration) * 1000
                if (time < 0) {
                    timeDuration = Constants.VALUE_DURATION_LOOP
                } else {
                    timeDuration = time
                }
            })
        durationAdapter.setData(sortedList)
        if (durationInMillis.equals(getString(R.string.loop))) {
            durationAdapter.setSelectedItem("")
        } else {
            durationAdapter.setSelectedItem(durationInMillis)
        }
        dataBinding.rvDuration.adapter = durationAdapter
    }

    private fun checkFlashAvailability(): Boolean {
        try {
            val cameraManager2 = this.cameraManager
            val cameraIdList = cameraManager2?.cameraIdList
            for (str in cameraIdList!!) {
                val cameraManager3 = this.cameraManager
                val cameraCharacteristics = cameraManager3?.getCameraCharacteristics(str)
                if (Intrinsics.areEqual(
                        if (cameraCharacteristics as Any? != null) {
                            cameraCharacteristics!!.get(
                                CameraCharacteristics.FLASH_INFO_AVAILABLE,
                            )
                        } else {
                            null
                        },
                        true as Any,
                    )
                ) {
                    return true
                }
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        } catch (e2: IllegalArgumentException) {
            e2.printStackTrace()
        }
        return false
    }

    private fun setSound() {
        addToRecent()
        soundId = getSoundFromResourceId(resourceId)
        soundId.first?.let {
            if(mediaPlayer?.isPlaying == true){
                mediaPlayer?.stop()
                mediaPlayer?.release()
            }
            mediaPlayer = MediaPlayer.create(context, it)
            mediaPlayer?.setOnPreparedListener(object : MediaPlayer.OnPreparedListener{
                override fun onPrepared(mp: MediaPlayer?) {
                    if(isPlaying){
                        if(mp?.isPlaying == true){
                            mp.stop()
                            mediaPlayer?.release()
                        }
                        mp?.start()
                        mp?.isLooping = true
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            val mediaPlayer2 = this.mediaPlayer
            mediaPlayer2?.pause()
            val mediaPlayer3 = this.mediaPlayer
            mediaPlayer3?.stop()
            this.mediaPlayer?.release()
            if (confirmBottomSheet != null) {
                confirmBottomSheet?.dismiss()
            }
        } catch (ex: Exception) {
            Firebase.crashlytics.recordException(ex)
        }
    }

    private fun convertToSeconds(time: String): Long {
        if (time.equals(getString(R.string.loop))) {
            return Constants.VALUE_DURATION_LOOP
        }
        val minutesRegex = "(\\d+)m".toRegex()
        val secondsRegex = "(\\d+)s".toRegex()

        val minutes =
            minutesRegex
                .find(time)
                ?.groups
                ?.get(1)
                ?.value
                ?.toInt() ?: 0
        val seconds =
            secondsRegex
                .find(time)
                ?.groups
                ?.get(1)
                ?.value
                ?.toInt() ?: 0

        return minutes * 60L + seconds
    }

    private fun millisToTimeString(milliseconds: Long): String {
        if (milliseconds == Constants.VALUE_DURATION_LOOP) return getString(R.string.loop)
        val totalSeconds = (milliseconds / 1000)
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60

        return if (minutes < 1 && seconds > 0) {
            "${seconds}s"
        } else if (minutes > 0 && seconds < 1) {
            "${minutes}m"
        } else {
            "${minutes}m${seconds}s"
        }

//        return if (minutes > 0 && seconds > 0) {
//            "${minutes}m${seconds}s"
//        } else if(minutes > 0 && seconds.toInt() == 0){
//            "${minutes}m"
//        } else {
//            "${seconds}s"
//        }
    }

    private fun getSoundFromResourceId(resourceId: Int): Pair<Int?, Int?> =
        when (resourceId) {
            R.drawable.dog -> R.raw.dogbarking to R.string.dog_barking
            R.drawable.cat -> R.raw.catmeow to R.string.cat_meowing
            R.drawable.rifle -> R.raw.rifle to R.string.rifle
            R.drawable.calvelry -> R.raw.calvery to R.string.cavelry
            R.drawable.trumpet -> R.raw.trumpet to R.string.army_trumpet
            R.drawable.whistle -> R.raw.whistle to R.string.whistle
            R.drawable.thunder -> R.raw.thunder to R.string.thunder
            R.drawable.policewhistle -> R.raw.policewhistle to R.string.police_whistle
            R.drawable.car -> R.raw.carhonk to R.string.car_honk
            R.drawable.doorbell -> R.raw.doorbell to R.string.door_bell
            R.drawable.birds -> R.raw.birdssound to R.string.birds_chirping
            R.drawable.partyhorn -> R.raw.partyhorn to R.string.party_horn
            R.drawable.beast_roar -> R.raw.beast_roar to R.string.beast_roar
            R.drawable.greeting -> R.raw.greeting to R.string.greeting
            R.drawable.christmas_themed -> R.raw.christmas_themed to R.string.christmas_themed
            R.drawable.halloween_doorbell -> R.raw.halloween_doorbell to R.string.halloween_doorbell
            R.drawable.police_siren_loop -> R.raw.police_siren_loop to R.string.police_siren_loop
            R.drawable.oh_my_god -> R.raw.oh_my_god to R.string.oh_my_god
            R.drawable.happy_birthday_doorbell -> R.raw.happy_birthday_doorbell to R.string.happy_birthday_doorbell
            R.drawable.single_cat_meow -> R.raw.single_cat_meow to R.string.single_cat_meow
            R.drawable.toy_dog_barking -> R.raw.toy_dog_barking to R.string.toy_dog_barking
            R.drawable.intercom_doorbell -> R.raw.intercom_doorbell to R.string.intercom_doorbell
            R.drawable.sad_trumpet -> R.raw.sad_trumpet to R.string.sad_trumpet // Melody
            R.drawable.solitude_ringtone -> R.raw.perfect_solitude_music_ringtone to R.string.solitude_ringtone_label
            R.drawable.ballerina_music -> R.raw.ballerina_music_box_song to R.string.ballerina_music_label
            R.drawable.ding_dong_merrily -> R.raw.ding_dong_merrily_on_high_doorbell_sound to R.string.ding_dong_merrily_label
            R.drawable.peaceful_piano_melody -> R.raw.peaceful_piano_melody_ident to R.string.peaceful_piano_melody_label // Funny
            R.drawable.ic_winning_horn -> R.raw.winning_horn_sound to R.string.winning_horn_sound
            R.drawable.ic_loading_sound -> R.raw.loading_sound_effect to R.string.loading_sound
            R.drawable.ic_oh_no -> R.raw.whispered_oh_no_sound_effect to R.string.whispered_oh_no
            R.drawable.ic_80s_alarm_clock -> R.raw.alarm_clock_80s_sound to R.string.alarm_clock_80s
            R.drawable.ic_clock_ticking_fast -> R.raw.clock_ticking_fast_sound_effect to R.string.clock_ticking_fast
            R.drawable.ic_aggressive_male_laugh -> R.raw.aggressive_male_laugh_sound_effect to R.string.aggressive_male_laugh
            R.drawable.ic_applause -> R.raw.applause_and_standing_ovation_sound_effect to R.string.applause_and_standing_ovation
            R.drawable.ic_cartoon_steps -> R.raw.cartoon_steps_sound_effect to R.string.cartoon_steps
            R.drawable.ic_cartoon_run -> R.raw.cartoon_run_sound_effect to R.string.cartoon_run
            R.drawable.ic_funny_footsteps -> R.raw.funny_footsteps_sound_effect to R.string.funny_footstep
            R.drawable.ic_funny_laugh -> R.raw.funny_laugh_sound_effect to R.string.funny_laugh
            R.drawable.ic_glitch_button -> R.raw.glitch_button_click_sound_effect to R.string.glitch_button
            R.drawable.ic_glitching -> R.raw.glitching_sound_effect to R.string.glitching
            R.drawable.ic_glitchy -> R.raw.glitchy_sound_effect to R.string.glitchy
            R.drawable.hurry_up_game_movement -> R.raw.hurry_up_game_movement_sound_effect to R.string.hurry_up_game_movement
            R.drawable.ic_hand_bell -> R.raw.hand_bell_chiming_sound_effect to R.string.hand_bell_chiming
            R.drawable.mallet_notification -> R.raw.mallet_notification_sound_effect to R.string.mallet_notification
            R.drawable.ic_whistle_noise -> R.raw.whistle_noise to R.string.whistle_noise
            R.drawable.ghost_of_christmas_past -> R.raw.ghost_of_the_christmas_past_sound_effect to R.string.ghost_of_christmas_past
            R.drawable.ic_festival_cheers -> R.raw.festival_cheers_and_applause_sound_effect to R.string.festival_cheers

            else -> null to null
        }

    private fun getAllSound(): List<SoundItem> {
        val soundList = mutableListOf<SoundItem>()
        soundList.apply {
            add(SoundItem(R.drawable.cat, getString(R.string.cat_meowing)))
            add(SoundItem(R.drawable.dog, getString(R.string.dog_barking)))
            add(SoundItem(R.drawable.rifle, getString(R.string.rifle)))
            add(SoundItem(R.drawable.calvelry, getString(R.string.cavelry)))
            add(SoundItem(R.drawable.trumpet, getString(R.string.army_trumpet)))
            add(SoundItem(R.drawable.whistle, getString(R.string.whistle)))
            add(SoundItem(R.drawable.thunder, getString(R.string.thunder)))
            add(SoundItem(R.drawable.policewhistle, getString(R.string.police_whistle)))
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
            add(
                SoundItem(
                    R.drawable.happy_birthday_doorbell,
                    getString(R.string.happy_birthday_doorbell),
                ),
            )
            add(SoundItem(R.drawable.single_cat_meow, getString(R.string.single_cat_meow)))
            add(SoundItem(R.drawable.toy_dog_barking, getString(R.string.toy_dog_barking)))
            add(SoundItem(R.drawable.intercom_doorbell, getString(R.string.intercom_doorbell)))
            add(SoundItem(R.drawable.sad_trumpet, getString(R.string.sad_trumpet)))
            // Melody
            add(
                SoundItem(
                    R.drawable.solitude_ringtone,
                    getString(R.string.solitude_ringtone_label),
                ),
            )
            add(SoundItem(R.drawable.ballerina_music, getString(R.string.ballerina_music_label)))
            add(
                SoundItem(
                    R.drawable.ding_dong_merrily,
                    getString(R.string.ding_dong_merrily_label),
                ),
            )
            add(
                SoundItem(
                    R.drawable.peaceful_piano_melody,
                    getString(R.string.peaceful_piano_melody_label),
                ),
            )
            // Funny
            add(SoundItem(R.drawable.ic_winning_horn, getString(R.string.winning_horn_sound)))
            add(SoundItem(R.drawable.ic_loading_sound, getString(R.string.loading_sound)))
            add(SoundItem(R.drawable.ic_oh_no, getString(R.string.whispered_oh_no)))
            add(SoundItem(R.drawable.ic_80s_alarm_clock, getString(R.string.alarm_clock_80s)))
            add(SoundItem(R.drawable.ic_clock_ticking_fast, getString(R.string.clock_ticking_fast)))
            add(
                SoundItem(
                    R.drawable.ic_aggressive_male_laugh,
                    getString(R.string.aggressive_male_laugh),
                ),
            )
            add(
                SoundItem(
                    R.drawable.ic_applause,
                    getString(R.string.applause_and_standing_ovation),
                ),
            )
            add(SoundItem(R.drawable.ic_cartoon_steps, getString(R.string.cartoon_steps)))
            add(SoundItem(R.drawable.ic_cartoon_run, getString(R.string.cartoon_run)))
            add(SoundItem(R.drawable.ic_funny_footsteps, getString(R.string.funny_footstep)))
            add(SoundItem(R.drawable.ic_funny_laugh, getString(R.string.funny_laugh)))
            add(SoundItem(R.drawable.ic_glitch_button, getString(R.string.glitch_button)))
            add(SoundItem(R.drawable.ic_glitching, getString(R.string.glitching)))
            add(SoundItem(R.drawable.ic_glitchy, getString(R.string.glitchy)))
            add(
                SoundItem(
                    R.drawable.hurry_up_game_movement,
                    getString(R.string.hurry_up_game_movement),
                ),
            )
            add(SoundItem(R.drawable.ic_hand_bell, getString(R.string.hand_bell_chiming)))
            add(SoundItem(R.drawable.mallet_notification, getString(R.string.mallet_notification)))
            add(SoundItem(R.drawable.ic_whistle_noise, getString(R.string.whistle_noise)))
            add(
                SoundItem(
                    R.drawable.ghost_of_christmas_past,
                    getString(R.string.ghost_of_christmas_past),
                ),
            )
            add(SoundItem(R.drawable.ic_festival_cheers, getString(R.string.festival_cheers)))
        }
        return soundList
    }

    private fun addToRecent() {
        val recentSounds = localStorage.recentSounds.split(",").toMutableList()
        if (recentSounds.contains(resourceId.toString())) {
            recentSounds.remove(resourceId.toString())
            recentSounds.add(0, resourceId.toString())
        } else if (recentSounds.size >= 9) {
            recentSounds.removeAt(8)
            recentSounds.add(0, resourceId.toString())
        } else {
            recentSounds.add(0, resourceId.toString().trim())
        }
        localStorage.recentSounds = recentSounds.joinToString(",")
    }

    private fun initConfirmSaveBottomSheet() {
        confirmBottomSheet =
            ConfirmBottomSheet.newInstance(
                resources.getString(R.string.title_save_sound_setting),
                resources.getString(R.string.content_save_sound_setting),
                resources.getString(R.string.allow),
            )
        confirmBottomSheet?.updateLanguage(context, localStorage.langCode)
        confirmBottomSheet?.clickConfirmYes = {
            try {
                if (localStorage.isFirstApplySoundDetailClick) {
                    AppConfig.logEventTracking(SOUND_DETAIL_APPLY_FIRST)
                    localStorage.isFirstApplySoundDetailClick = false
                } else {
                    AppConfig.logEventTracking(SOUND_DETAIL_APPLY_AGAIN)
                }
                if(localStorage.defaultSoundVolume != defaultSoundVolume) localStorage.defaultSoundVolume = defaultSoundVolume
                if (localStorage.resourceId != resourceId) localStorage.resourceId = resourceId
                if (localStorage.durationAdded != durationAdded) localStorage.durationAdded = durationAdded
                if (localStorage.timeDuration != timeDuration) localStorage.timeDuration = timeDuration
                if (localStorage.isSoundEnabled != isSoundEnabled) localStorage.isSoundEnabled = isSoundEnabled
                if (localStorage.isVibrationEnabled != isVibrationEnabled) localStorage.isVibrationEnabled = isVibrationEnabled
                if (localStorage.isFlashEnabled != isFlashEnabled) localStorage.isFlashEnabled = isFlashEnabled
                localStorage.isChangeSettingSoundDetail = true
                findNavControllerSafety()?.popBackStack()
            } catch (e: Exception) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
        AppConfig.logEventTracking(Constants.SETTING_CONFIRM_SAVE_SHOW)
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                confirmBottomSheet?.show(
                    it,
                    ConfirmBottomSheet.TAG,
                )
            }
        }
    }

    private fun initEnableOneMethodBottomSheet(){
        enableOneMethodBottomSheet = EnableOneMethodBottomSheet.newInstance(
            title = resources.getString(R.string.enable_at_least_one_method_title),
            content = resources.getString(R.string.enable_at_least_one_method),
            txtOk = resources.getString(R.string.mgs_ok)
        )
        enableOneMethodBottomSheet?.updateLanguage(context, localStorage.langCode)
        AppConfig.logEventTracking(Constants.SETTING_ALERT_SOUND_DETAIL_SHOW)
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                enableOneMethodBottomSheet?.show(
                    it,
                    EnableOneMethodBottomSheet.TAG,
                )
            }
        }
    }
}
