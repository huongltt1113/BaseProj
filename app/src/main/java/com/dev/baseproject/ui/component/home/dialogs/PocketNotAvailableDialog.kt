package com.dev.baseproject.ui.component.home.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.dev.baseproject.R

class PocketNotAvailableDialog: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.dialog_pocket_not_available, container, false)
        if(dialog != null && dialog!!.window != null){
            dialog!!.window!!.setBackgroundDrawableResource(R.drawable.bg_rectangle_16)
        }
        val btnGotIt = inflate.findViewById<TextView>(R.id.gotIt)
        btnGotIt.setOnClickListener {
            dismiss()
        }
        return inflate
    }
}