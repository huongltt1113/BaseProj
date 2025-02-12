package com.dev.baseproject.ui.component.home.dialogs;

import android.view.View;


public final class FullScreenVoiceDialogCall implements View.OnClickListener {
    public final FullScreenVoiceDialog fullscreen1;

    public FullScreenVoiceDialogCall(FullScreenVoiceDialog fullScreenVoiceDialog) {
        this.fullscreen1 = fullScreenVoiceDialog;
    }

    @Override
    public void onClick(View view) {
        FullScreenVoiceDialog.FullScreenVoiceDialogCall1(this.fullscreen1, view);
    }
}
