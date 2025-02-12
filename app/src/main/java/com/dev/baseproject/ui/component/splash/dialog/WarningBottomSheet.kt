package com.dev.baseproject.ui.component.splash.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.dev.baseproject.databinding.BottomSheetWarningBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Logger

class WarningBottomSheet : BottomSheetDialogFragment() {
    private lateinit var dataBinding: BottomSheetWarningBinding

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft: FragmentTransaction = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: IllegalStateException) {
            Logger.e(TAG, "Exception : $e")
            Firebase.crashlytics.recordException(e)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.btnConfirmYes.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                dismiss()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        dataBinding = BottomSheetWarningBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    companion object {
        const val TAG = "WarningBottomSheet"
    }
}
