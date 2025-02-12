package com.dev.baseproject.ads;

import com.google.android.gms.ads.nativead.NativeAd;

public interface AdsListener {
    public void onAdClosed();

    public void onAdClicked();

    public void onAdLoaded(NativeAd nativeAd);

    public void onAdFailed();
}

