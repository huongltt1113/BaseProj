package com.dev.baseproject.ui.component.sound

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.ItemChooseSoundBinding

class ChooseSoundAdapter(
    private val soundList: List<SoundItem>,
    private val onClick: (SoundItem) -> Unit
): RecyclerView.Adapter<ChooseSoundAdapter.SoundViewHolder>() {

    inner class SoundViewHolder(private val binding: ItemChooseSoundBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: SoundItem) {
            binding.ivSound.setImageResource(item.iconResId)
            binding.tvSound.text = item.label

            binding.root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val binding = ItemChooseSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val item = soundList[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int {
        return soundList.size
    }
}