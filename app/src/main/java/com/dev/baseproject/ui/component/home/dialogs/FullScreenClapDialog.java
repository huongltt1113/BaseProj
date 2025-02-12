package com.dev.baseproject.ui.component.home.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.dev.baseproject.R;

public final class FullScreenClapDialog extends DialogFragment {
    private FullScreenClapDialogListener listener;

   public void setListener( FullScreenClapDialogListener listener) {
        this.listener = listener;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        View inflate = layoutInflater.inflate(R.layout.dialog_fullscreen_clap, viewGroup, false);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(requireContext().getDrawable(R.drawable.bg_rectangle_16));
        }
        View findViewById = inflate.findViewById(R.id.gotIt);
        findViewById.setOnClickListener(new FullScreenClapDialogCall(this));
        TextView navigateButton = inflate.findViewById(R.id.viewDetail);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNavigateViewClicked();
                assert dialog != null;
                dialog.dismiss();
            }
        });
        return inflate;
    }

    
    public static void FullScreenClapDialogCall1(FullScreenClapDialog fullScreenClapDialog, View view) {
        FullScreenClapDialogListener fullScreenClapDialogListener = fullScreenClapDialog.listener;
        if (fullScreenClapDialogListener != null) {
            fullScreenClapDialogListener.onImageViewClicked();
        }
        Dialog dialog = fullScreenClapDialog.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
