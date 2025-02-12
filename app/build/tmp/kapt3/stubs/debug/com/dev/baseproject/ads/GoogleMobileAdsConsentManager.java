package com.dev.baseproject.ads;

/**
 * The Google Mobile Ads SDK provides the User Messaging Platform (Google's IAB Certified consent
 * management platform) as one solution to capture consent for users in GDPR impacted countries.
 * This is an example and you can choose another consent management platform to capture consent.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canRequestAds", "", "getCanRequestAds", "()Z", "consentInformation", "Lcom/google/android/ump/ConsentInformation;", "isPrivacyOptionsRequired", "isShownConsentForm", "Ljava/util/concurrent/atomic/AtomicBoolean;", "gatherConsent", "", "activity", "Landroid/app/Activity;", "onConsentGatheringCompleteListener", "Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager$OnConsentGatheringCompleteListener;", "showPrivacyOptionsForm", "onConsentFormDismissedListener", "Lcom/google/android/ump/ConsentForm$OnConsentFormDismissedListener;", "Companion", "OnConsentGatheringCompleteListener", "app_debug"})
public final class GoogleMobileAdsConsentManager {
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.ump.ConsentInformation consentInformation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean isShownConsentForm = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ConsentManager";
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ads.GoogleMobileAdsConsentManager.Companion Companion = null;
    
    public GoogleMobileAdsConsentManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean getCanRequestAds() {
        return false;
    }
    
    public final boolean isPrivacyOptionsRequired() {
        return false;
    }
    
    /**
     * Helper method to call the UMP SDK methods to request consent information and load/show a
     * consent form if necessary.
     */
    public final void gatherConsent(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.dev.baseproject.ads.GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener onConsentGatheringCompleteListener) {
    }
    
    /**
     * Helper method to call the UMP SDK method to show the privacy options form.
     */
    public final void showPrivacyOptionsForm(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.google.android.ump.ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * Interface definition for a callback to be invoked when consent gathering is complete.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/dev/baseproject/ads/GoogleMobileAdsConsentManager$OnConsentGatheringCompleteListener;", "", "consentGatheringComplete", "", "error", "Lcom/google/android/ump/FormError;", "app_debug"})
    public static abstract interface OnConsentGatheringCompleteListener {
        
        public abstract void consentGatheringComplete(@org.jetbrains.annotations.Nullable()
        com.google.android.ump.FormError error);
    }
}