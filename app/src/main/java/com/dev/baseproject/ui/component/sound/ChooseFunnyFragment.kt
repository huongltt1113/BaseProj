package com.dev.baseproject.ui.component.sound

import com.dev.baseproject.R
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.FragmentChooseFunnyBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_FIRST
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseFunnyFragment(
    val onSoundClick: (SoundItem) -> Unit = {}
) : BaseFragmentBinding<FragmentChooseFunnyBinding>() {
    private lateinit var soundAdapter: ChooseSoundAdapter
    private val listFunny = mutableListOf<SoundItem>()
    override fun getContentViewId() = R.layout.fragment_choose_funny

    override fun initializeViews() {
        if(listFunny.isEmpty()){
            listFunny.apply {
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
        }
    }

    override fun registerListeners() {
        setupRecyclerView()
    }

    override fun initializeData() {

    }

    private fun setupRecyclerView(){
        soundAdapter = ChooseSoundAdapter(
            soundList = listFunny,
            onClick = { soundItem ->
                if (localStorage.goToSoundDetail) {
                    AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_FIRST)
                    localStorage.goToSoundDetail = false
                } else {
                    AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_AGAIN)
                }
                onSoundClick(soundItem)
            }
        )

        dataBinding.rvSoundFunny.adapter = soundAdapter
        soundAdapter.notifyDataSetChanged()
    }
}