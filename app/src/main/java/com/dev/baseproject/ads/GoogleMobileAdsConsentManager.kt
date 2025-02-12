package com.dev.baseproject.ads

import android.app.Activity
import android.content.Context
import com.dev.baseproject.utils.Logger
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.FormError
import com.google.android.ump.UserMessagingPlatform
import java.util.concurrent.atomic.AtomicBoolean

/**
 * The Google Mobile Ads SDK provides the User Messaging Platform (Google's IAB Certified consent
 * management platform) as one solution to capture consent for users in GDPR impacted countries.
 * This is an example and you can choose another consent management platform to capture consent.
 */
class GoogleMobileAdsConsentManager constructor(context: Context) {
	private val consentInformation: ConsentInformation =
		UserMessagingPlatform.getConsentInformation(context)

	/** Interface definition for a callback to be invoked when consent gathering is complete. */
	fun interface OnConsentGatheringCompleteListener {
		fun consentGatheringComplete(error: FormError?)
	}

	/** Helper variable to determine if the app can request ads. */
	val canRequestAds: Boolean
		get() = consentInformation.canRequestAds()

	private val isShownConsentForm= AtomicBoolean(false)

	/** Helper variable to determine if the privacy options form is required. */
	val isPrivacyOptionsRequired: Boolean
		get() =
			consentInformation.privacyOptionsRequirementStatus ==
					ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED

	/**
	 * Helper method to call the UMP SDK methods to request consent information and load/show a
	 * consent form if necessary.
	 */
	fun gatherConsent(
		activity: Activity,
		onConsentGatheringCompleteListener: OnConsentGatheringCompleteListener,
    ) {
		if (isShownConsentForm.get()) {
			Logger.d("$TAG ##### BAILS shown one time")
			onConsentGatheringCompleteListener.consentGatheringComplete(null)
			return
		}
		// For testing purposes, you can force a DebugGeography of EEA or NOT_EEA.
		val debugSettings =
			ConsentDebugSettings.Builder(activity)
				.setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
				// Check your logcat output for the hashed device ID e.g.
				// "Use new ConsentDebugSettings.Builder().addTestDeviceHashedId("ABCDEF012345")" to use
				// the debug functionality.
				.addTestDeviceHashedId("839EF50B3B30E21DD187979579A0312C")
				.build()

/*		val params =
			ConsentRequestParameters.Builder().setConsentDebugSettings(debugSettings).build()*/

		val params = ConsentRequestParameters.Builder()
			.setTagForUnderAgeOfConsent(false)
			.build()
		// Requesting an update to consent information should be called on every app launch.
		Logger.d("$TAG ##### START requestConsentInfoUpdate")
		consentInformation.requestConsentInfoUpdate(
			activity,
			params,
			{
				Logger.d("$TAG ##### FINISH requestConsentInfoUpdate")
				UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) { formError ->
					Logger.d("$TAG ##### FINISH show Consent Form")
					isShownConsentForm.set(true)
					// Consent has been gathered.
					onConsentGatheringCompleteListener.consentGatheringComplete(formError)
				}
			},
			{ requestConsentError ->
				Logger.d("$TAG ##### ERROR RequestConsentInfo")
				onConsentGatheringCompleteListener.consentGatheringComplete(requestConsentError)
			}
		)
	}

	/** Helper method to call the UMP SDK method to show the privacy options form. */
	fun showPrivacyOptionsForm(
      activity: Activity,
      onConsentFormDismissedListener: OnConsentFormDismissedListener,
    ) {
		UserMessagingPlatform.showPrivacyOptionsForm(activity, onConsentFormDismissedListener)
	}

	companion object {
		private const val TAG = "ConsentManager"
	}
}
