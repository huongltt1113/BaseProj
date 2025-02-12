package com.dev.baseproject.ui.component.home.dialogs;

import android.view.View;


public final class FullScreenDontTouchDialogCall implements View.OnClickListener {
    public final FullScreenDontTouchDialog fullscreen1;

    public FullScreenDontTouchDialogCall(FullScreenDontTouchDialog fullScreenDontTouchDialog) {
        this.fullscreen1 = fullScreenDontTouchDialog;
    }

    @Override
    public void onClick(View view) {
        FullScreenDontTouchDialog.FullScreenDontTouchDialogCall1(this.fullscreen1, view);
    }
}
