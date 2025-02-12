package com.dev.baseproject.ui.component.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.baseproject.R
import com.dev.baseproject.data.entity.SoundItem
import com.dev.baseproject.databinding.ItemSoundBinding

class SoundAdapter(
    private var itemList: MutableList<SoundItem>,
    private var selectedResourceId: Int,
    private val onClick: (SoundItem) -> Unit,
    private val isShowLabel: Boolean? = true,
    private val itemWidth: Int? = null,
    private val spacing: Int? = null
) : RecyclerView.Adapter<SoundAdapter.SoundViewHolder>() {

    private var previousSelectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val binding = ItemSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val item = itemList[position]
        holder.onBind(item)
        // Xử lý sự kiện click nếu cần
        holder.itemView.setOnClickListener {
            onClick(item)
            selectedResourceId = item.iconResId
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class SoundViewHolder(private val viewBinding: ItemSoundBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(item: SoundItem) {
            viewBinding.imageIcon.setImageResource(item.iconResId)
            if (isShowLabel == true) {
                viewBinding.textLabel.visibility = android.view.View.VISIBLE
                viewBinding.textLabel.text = item.label
            } else {
                viewBinding.itemLayout.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                spacing?.let {
                    viewBinding.itemLayout.setPadding(0, 0, spacing, 0, )
                }
                itemWidth?.let {
                    viewBinding.imageIcon.layoutParams = ViewGroup.LayoutParams(
                        itemWidth, itemWidth
                    )
                }
                viewBinding.textLabel.visibility = android.view.View.GONE
            }
            // Kiểm tra nếu `resourceId` khớp với item hiện tại
            if (item.iconResId == selectedResourceId) {
                // Thay đổi background cho item đã chọn
                previousSelectedPosition = this.adapterPosition
                viewBinding.imageIcon.setBackgroundResource(R.drawable.soundselected)
            } else {
                // Khôi phục background mặc định
                viewBinding.imageIcon.setBackgroundResource(R.drawable.soundunselected)
            }
        }
    }
}
