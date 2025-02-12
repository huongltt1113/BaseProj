package com.dev.baseproject.ui.component.home.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dev.baseproject.ui.MainActivity;
import com.dev.baseproject.ui.component.findphone.PhoneFoundActivity;

public final class MainActivityBroadcastReceiver extends BroadcastReceiver {
    final MainActivity act1;

    MainActivityBroadcastReceiver(MainActivity mainActivity) {
        this.act1 = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        if (act1 != null && !act1.isFinishing()) {
//            act1.onServiceEventTriggered(context);
//        } else {
//            // Dùng context để khởi chạy Intent nếu act1 bị null
//            Intent phoneFoundIntent = new Intent(context, PhoneFoundActivity.class);
//            phoneFoundIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            context.startActivity(phoneFoundIntent);
//        }
        Intent phoneFoundIntent = new Intent(context, PhoneFoundActivity.class);
            phoneFoundIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(phoneFoundIntent);
    }
}
