package com.dev.baseproject.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dev.baseproject.R;
import com.dev.baseproject.utils.Constants;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;


public class NativeAdsUtils {
    public static NativeAd nativeIntro = null;
    public static NativeAd nativeAskLanguage = null;
    public static NativeAd nativeFAQ = null;
    public static ViewGroup viewGroupIntro = null;
    public static ViewGroup viewGroupAskLanguage = null;
    public static ViewGroup viewFAQ = null;

    public static void destroy(NativeAd nativeAd) {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    public static NativeAd addLargeNativeAd(final boolean isLoadIntro, Activity activity, AdsListener listener, boolean isTypeClick) {
        return addNativeAd(isLoadIntro, activity, listener, isTypeClick);
    }

    public static NativeAd addSmallNativeAd(final boolean isLoadIntro, Activity activity, AdsListener listener, boolean isTypeClick) {
        return addNativeAd(isLoadIntro, activity, listener, isTypeClick);
    }

    public static NativeAd addSmallNativeFAQAd(Activity activity, AdsListener listener) {
        return addNativeFAQAd(activity, listener);
    }

    private static NativeAd addNativeFAQAd(final Activity activity, final AdsListener listener) {
        String nativeId = Constants.NATIVE_AD_KEY;
        AdLoader.Builder builder = new AdLoader.Builder(activity, nativeId);
        // OnUnifiedNativeAdLoadedListener implementation.
        final NativeAd[] nativeAds = new NativeAd[1];
        builder.forNativeAd(nativeAd -> {
            nativeFAQ = nativeAd;
            if (viewFAQ != null) {
                showNativeFAQ(activity, viewFAQ, R.layout.native_faq, nativeFAQ, listener);
            }
            nativeAds[0] = nativeAd;
        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(true)
                .build();

        com.google.android.gms.ads.nativead.NativeAdOptions adOptions = new  com.google.android.gms.ads.nativead.NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);
        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                if (listener != null) {
                    listener.onAdClicked();
                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

        return nativeAds[0];
    }

    private static NativeAd addNativeAd(final boolean isLoadIntro, final Activity activity, final AdsListener listener, boolean isTypeClick) {
        String nativeId;
        nativeId = Constants.NATIVE_AD_KEY;
        AdLoader.Builder builder = new AdLoader.Builder(activity, nativeId);
        // OnUnifiedNativeAdLoadedListener implementation.
        final NativeAd[] nativeAds = new NativeAd[1];
        builder.forNativeAd(nativeAd -> {
            if (isLoadIntro) {
                nativeIntro = nativeAd;
                if (viewGroupIntro != null) {
                    if (isTypeClick) {
                        showNative(isLoadIntro, activity, viewGroupIntro, R.layout.native_ad_unified_type_click, nativeIntro, listener);
                    } else {
                        showNative(isLoadIntro, activity, viewGroupIntro, R.layout.native_ad_unified_small, nativeIntro, listener);
                    }
                }
            } else {
                nativeAskLanguage = nativeAd;
                if (viewGroupAskLanguage != null) {
                    showNative(isLoadIntro, activity, viewGroupAskLanguage, R.layout.native_ad_unified, nativeAskLanguage, listener);
                }
            }
            nativeAds[0] = nativeAd;
        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(true)
                .build();

        com.google.android.gms.ads.nativead.NativeAdOptions adOptions = new  com.google.android.gms.ads.nativead.NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);
        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                if (listener != null) {
                    listener.onAdClicked();
                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

        return nativeAds[0];
    }

    public static void populateUnifiedNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        // Set the media view. Media content will be automatically populated in the media view once
        // adView.setNativeAd() is called.
        MediaView mediaView = adView.findViewById(R.id.ad_media);
        adView.setMediaView(mediaView);

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline is guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            adView.getIconView().setBackground(
                    nativeAd.getIcon().getDrawable());
            ((MediaView) adView.getIconView()).setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);

        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        VideoController vc = nativeAd.getMediaContent().getVideoController();

        // Updates the UI to say whether or not this ad has a video asset.
        if (vc.hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        } else {

        }
    }

    public static void populateUnifiedNativeIntroAdView(NativeAd nativeAd, NativeAdView adView) {
        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline is guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            adView.getIconView().setBackground(
                    nativeAd.getIcon().getDrawable());
            ((MediaView) adView.getIconView()).setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);

        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        VideoController vc = nativeAd.getMediaContent().getVideoController();

        // Updates the UI to say whether or not this ad has a video asset.
        if (vc.hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        } else {

        }
    }

    public static void  showNative(boolean isLoadIntro, Activity activity, ViewGroup viewGroup, final int layoutId, NativeAd nativeAd, final AdsListener listener) {
        if (viewGroup != null) {
            NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(layoutId, null);
            if (isLoadIntro) {
                populateUnifiedNativeIntroAdView(nativeAd, adView);
            } else {
                populateUnifiedNativeAdView(nativeAd, adView);
            }
            viewGroup.setVisibility(View.VISIBLE);
            viewGroup.removeAllViews();
            viewGroup.addView(adView);
            if (listener != null) {
                listener.onAdLoaded(nativeAd);
            }
        }
    }

    public static void  showNativeFAQ( Activity activity, ViewGroup viewGroup, final int layoutId, NativeAd nativeAd, final AdsListener listener) {
        if (viewGroup != null) {
            NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(layoutId, null);
            populateUnifiedNativeIntroAdView(nativeAd, adView);
            viewGroup.setVisibility(View.VISIBLE);
            viewGroup.removeAllViews();
            viewGroup.addView(adView);
            if (listener != null) {
                listener.onAdLoaded(nativeAd);
            }
        }
    }
}
