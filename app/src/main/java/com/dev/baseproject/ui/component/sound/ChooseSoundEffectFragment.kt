package com.dev.baseproject.ui.component.sound

import androidx.recyclerview.widget.GridLayoutManager
import com.dev.baseproject.R
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.FragmentChooseSoundEffectBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.ui.component.home.adapter.SoundAdapter
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_SOUND_DETAIL_FIRST
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseSoundEffectFragment(
    val onSoundClick: (SoundItem) -> Unit = {}
) : BaseFragmentBinding<FragmentChooseSoundEffectBinding>() {
    private lateinit var soundAdapter: SoundAdapter
    private val allSoundListSound = mutableListOf<SoundItem>()

    override fun getContentViewId() = R.layout.fragment_choose_sound_effect

    override fun initializeViews() {
        if(allSoundListSound.isEmpty()){
            allSoundListSound.apply {
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
                add(SoundItem(R.drawable.happy_birthday_doorbell, getString(R.string.happy_birthday_doorbell)))
                add(SoundItem(R.drawable.single_cat_meow, getString(R.string.single_cat_meow)))
                add(SoundItem(R.drawable.toy_dog_barking, getString(R.string.toy_dog_barking)))
                add(SoundItem(R.drawable.intercom_doorbell, getString(R.string.intercom_doorbell)))
                add(SoundItem(R.drawable.sad_trumpet, getString(R.string.sad_trumpet)))
            }
        }
    }

    override fun registerListeners() {
        setupRecyclerView()
    }

    override fun initializeData() {

    }

    private fun setupRecyclerView() {
        dataBinding.rvSoundEffect.layoutManager = GridLayoutManager(requireContext(), 3)
        soundAdapter = SoundAdapter(allSoundListSound, localStorage.resourceId, onClick =  { soundItem ->
            if (localStorage.goToSoundDetail) {
                AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_FIRST)
                localStorage.goToSoundDetail = false
            } else {
                AppConfig.logEventTracking(GO_TO_SOUND_DETAIL_AGAIN)
            }
            onSoundClick(soundItem)
        })
        dataBinding.rvSoundEffect.adapter = soundAdapter
        soundAdapter.notifyDataSetChanged()
    }
}