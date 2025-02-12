package com.dev.baseproject.ui.component.sound

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.baseproject.R
import com.dev.baseproject.databinding.ItemDurationBinding

class DurationAdapter(
    private val onItemClick: (String) -> Unit
): RecyclerView.Adapter<DurationAdapter.DurationViewHolder>() {

    private var selectedPosition: Int = -1
    private var lastPosition: Int = -1

    inner class DurationViewHolder(val binding: ItemDurationBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: String){
            binding.tvDuration.text = item
            if(this.adapterPosition == selectedPosition){
                binding.tvDuration.background = ContextCompat.getDrawable(binding.root.context, R.drawable.bg_selected_duration)
                binding.tvDuration.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            } else {
                binding.tvDuration.background = ContextCompat.getDrawable(binding.root.context, R.drawable.bg_unselected_duration)
                binding.tvDuration.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
            }

            binding.root.setOnClickListener {
                lastPosition = selectedPosition
                selectedPosition = this.adapterPosition
                notifyItemChanged(lastPosition)
                notifyItemChanged(selectedPosition)
                onItemClick(item)
            }
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallBack)

    fun setData(list: List<String>) {
        differ.submitList(list)
    }

    fun updateData(list: List<String>, item: String, onSelectDone: () -> Unit){
        lastPosition = selectedPosition
        selectedPosition = -1
        notifyItemChanged(lastPosition)

        differ.submitList(list){
            setSelectedItem(item)
            onSelectDone()
        }
    }

    fun getData(): List<String>{
        return differ.currentList
    }

    fun setSelectedItem(time: String){
        if(time.isEmpty()) {
            setSelectedPosition(0)
        } else {
            setSelectedPosition(differ.currentList.indexOf(time))
        }
    }

    private fun setSelectedPosition(position: Int) {
        lastPosition = selectedPosition
        selectedPosition = position
        notifyItemChanged(lastPosition)
        notifyItemChanged(selectedPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DurationViewHolder {
        val binding = ItemDurationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DurationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DurationViewHolder, position: Int) {
        holder.bindItem(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}