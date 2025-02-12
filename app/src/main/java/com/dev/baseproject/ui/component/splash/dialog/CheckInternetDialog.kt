package com.dev.baseproject.ui.component.splash.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dev.baseproject.R
import com.dev.baseproject.databinding.DialogCheckInternetBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Logger
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CheckInternetDialog: BottomSheetDialogFragment() {
    private lateinit var dataBinding: DialogCheckInternetBinding
    var clickConfirmYes: (() -> Unit)? = null
     var clickConfirmNo: (() -> Unit)? = null
    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft: FragmentTransaction = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: IllegalStateException) {
            Logger.e(TAG, "Exception : $e")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        dataBinding = DialogCheckInternetBinding.inflate(inflater, container, false)

        dataBinding.btnConfirmYes.setOnClickListener {

            if (!AppConfig.isDoubleClick()) {
                clickConfirmYes?.invoke()
                dismiss()
            }
        }
        dataBinding.btnCancel.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                clickConfirmNo?.invoke()
                dismiss()
            }
        }
        val shakeAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake)
        dataBinding.img.startAnimation(shakeAnimation)
        dataBinding.img.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                dataBinding.img.startAnimation(shakeAnimation)
            }
        }
        return dataBinding.root
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        clickConfirmNo?.invoke()
    }

    companion object {
        const val TAG = "CheckInternetDialog"
    }
}