package com.dev.baseproject.ui.component.home.dialogs;

import android.view.View;


public final class FullScreenClapDialogCall implements View.OnClickListener {
    public final FullScreenClapDialog fullscreen1;

    public FullScreenClapDialogCall(FullScreenClapDialog fullScreenClapDialog) {
        this.fullscreen1 = fullScreenClapDialog;
    }

    @Override
    public void onClick(View view) {
        FullScreenClapDialog.FullScreenClapDialogCall1(this.fullscreen1, view);
    }
}
