package com.dev.baseproject.ui.component.home.dialogs;

import android.view.View;

public class FullPocketDialogCall implements View.OnClickListener {
    public final FullPocketDialog fullscreen1;

    public FullPocketDialogCall(FullPocketDialog fullScreenDontTouchDialog) {
        this.fullscreen1 = fullScreenDontTouchDialog;
    }

    @Override
    public void onClick(View view) {
        FullPocketDialog.FullPocketDialog1(this.fullscreen1, view);
    }
}