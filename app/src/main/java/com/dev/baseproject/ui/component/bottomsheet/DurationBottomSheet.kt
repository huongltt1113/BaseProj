package com.dev.baseproject.ui.component.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dev.baseproject.R
import com.dev.baseproject.databinding.BottomSheetDurationBinding
import com.dev.baseproject.extension.disable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Locale

class DurationBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetDurationBinding
    var onSaveButtonClick: ((String) -> Unit)? = null

    override fun show(
        manager: FragmentManager,
        tag: String?,
    ) {
        try {
            val ft: FragmentTransaction = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: IllegalStateException) {
            Log.e(TAG, "Exception : $e")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = BottomSheetDurationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.minutePicker.value = 0
        binding.secondPicker.value = 1

        val hourList = mutableListOf<String>()
        for (i in 0..99) {
            hourList.add(String.format(Locale.getDefault(), "%02d  ", i))
        }

        val minutesList = mutableListOf<String>()
        for (i in 0..59) {
            minutesList.add(String.format(Locale.getDefault(), "%02d  ", i))
        }
        val secondsList = mutableListOf<String>()
        for (i in 0..59) {
            secondsList.add(String.format(Locale.getDefault(), "%02d  ", i))
        }

        binding.hourPicker.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.poppinsmedium)
        binding.minutePicker.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.poppinsmedium)
        binding.secondPicker.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.poppinsmedium)

        binding.hourPicker.displayedValues = hourList.toTypedArray()
        binding.minutePicker.displayedValues = minutesList.toTypedArray()
        binding.secondPicker.displayedValues = secondsList.toTypedArray()

        binding.hourPicker.disable()
        binding.minutePicker.apply {
            maxValue = 59
            minValue = 0
        }

        binding.secondPicker.apply {
            maxValue = 59
            minValue = 0
        }
        binding.hourPicker.apply {
            maxValue = 99
            minValue = 0
        }

        binding.btnClose.setOnClickListener {
            this.dismiss()
        }

        binding.btnNo.setOnClickListener {
            this.dismiss()
        }

        binding.btnConfirm.setOnClickListener {
            val minutes = binding.minutePicker.value
            val seconds = binding.secondPicker.value

            val timeString = "${minutes}m${seconds}s"

            if (minutes == 0 && seconds == 0) {
                binding.btnConfirm.isEnabled = false
            } else {
                binding.btnConfirm.isEnabled = true
                val timeString = "${minutes}m${seconds}s"
                onSaveButtonClick?.invoke(timeString)
                dismiss()
            }
        }

        binding.minutePicker.setOnValueChangedListener { _, _, _ ->
            enableConfirmButtonIfValid()
        }

        binding.secondPicker.setOnValueChangedListener { _, _, _ ->
            enableConfirmButtonIfValid()
        }
    }

    private fun enableConfirmButtonIfValid() {
        val minutes = binding.minutePicker.value
        val seconds = binding.secondPicker.value

        if (minutes == 0 && seconds == 0) {
            binding.btnConfirm.isEnabled = false
            Toast.makeText(context, "Minimum time is 1s", Toast.LENGTH_SHORT).show()
        } else {
            binding.btnConfirm.isEnabled = true
        }
    }

    companion object {
        const val TAG = "DurationBottomSheet"
    }
}
