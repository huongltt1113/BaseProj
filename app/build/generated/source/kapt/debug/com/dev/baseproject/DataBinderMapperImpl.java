package com.dev.baseproject;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dev.baseproject.databinding.ActivityMainBindingImpl;
import com.dev.baseproject.databinding.ActivityPhoneFoundBindingImpl;
import com.dev.baseproject.databinding.AdsLayoutBannerBindingImpl;
import com.dev.baseproject.databinding.BottomSheetAlertSoundDetailBindingImpl;
import com.dev.baseproject.databinding.BottomSheetConfirmApplyLanguageBindingImpl;
import com.dev.baseproject.databinding.BottomSheetConfirmToShowAdsBindingImpl;
import com.dev.baseproject.databinding.BottomSheetDurationBindingImpl;
import com.dev.baseproject.databinding.BottomSheetRatingAppBindingImpl;
import com.dev.baseproject.databinding.BottomSheetRequestInternetBindingImpl;
import com.dev.baseproject.databinding.BottomSheetUpdateNewVersionBindingImpl;
import com.dev.baseproject.databinding.BottomSheetWarningBindingImpl;
import com.dev.baseproject.databinding.DialogCheckInternetBindingImpl;
import com.dev.baseproject.databinding.FragmentAskLanguageBindingImpl;
import com.dev.baseproject.databinding.FragmentChooseFunnyBindingImpl;
import com.dev.baseproject.databinding.FragmentChooseMelodyBindingImpl;
import com.dev.baseproject.databinding.FragmentChooseSoundBindingImpl;
import com.dev.baseproject.databinding.FragmentChooseSoundEffectBindingImpl;
import com.dev.baseproject.databinding.FragmentCountDownBindingImpl;
import com.dev.baseproject.databinding.FragmentCreatePasscodeBindingImpl;
import com.dev.baseproject.databinding.FragmentGrantPermissionBindingImpl;
import com.dev.baseproject.databinding.FragmentHomeBindingImpl;
import com.dev.baseproject.databinding.FragmentHowToUseBindingImpl;
import com.dev.baseproject.databinding.FragmentIntroBindingImpl;
import com.dev.baseproject.databinding.FragmentPasscordBindingImpl;
import com.dev.baseproject.databinding.FragmentPermissionBindingImpl;
import com.dev.baseproject.databinding.FragmentPlaceHolder3BindingImpl;
import com.dev.baseproject.databinding.FragmentPlaceHolder4BindingImpl;
import com.dev.baseproject.databinding.FragmentPlaceholder2BindingImpl;
import com.dev.baseproject.databinding.FragmentPlaceholder5BindingImpl;
import com.dev.baseproject.databinding.FragmentRecordPassCodeBindingImpl;
import com.dev.baseproject.databinding.FragmentSettingBindingImpl;
import com.dev.baseproject.databinding.FragmentSettingLanguageBindingImpl;
import com.dev.baseproject.databinding.FragmentSoundDetailBindingImpl;
import com.dev.baseproject.databinding.FragmentSplashBindingImpl;
import com.dev.baseproject.databinding.FragmentTextToVoiceBindingImpl;
import com.dev.baseproject.databinding.ItemChooseSoundBindingImpl;
import com.dev.baseproject.databinding.ItemDurationBindingImpl;
import com.dev.baseproject.databinding.ItemSoundBindingImpl;
import com.dev.baseproject.databinding.NativeAdUnifiedBindingImpl;
import com.dev.baseproject.databinding.NativeAdUnifiedSmallBindingImpl;
import com.dev.baseproject.databinding.NativeAdUnifiedTypeClickBindingImpl;
import com.dev.baseproject.databinding.NativeFaqBindingImpl;
import com.dev.baseproject.databinding.PopupWindowTextBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYPHONEFOUND = 2;

  private static final int LAYOUT_ADSLAYOUTBANNER = 3;

  private static final int LAYOUT_BOTTOMSHEETALERTSOUNDDETAIL = 4;

  private static final int LAYOUT_BOTTOMSHEETCONFIRMAPPLYLANGUAGE = 5;

  private static final int LAYOUT_BOTTOMSHEETCONFIRMTOSHOWADS = 6;

  private static final int LAYOUT_BOTTOMSHEETDURATION = 7;

  private static final int LAYOUT_BOTTOMSHEETRATINGAPP = 8;

  private static final int LAYOUT_BOTTOMSHEETREQUESTINTERNET = 9;

  private static final int LAYOUT_BOTTOMSHEETUPDATENEWVERSION = 10;

  private static final int LAYOUT_BOTTOMSHEETWARNING = 11;

  private static final int LAYOUT_DIALOGCHECKINTERNET = 12;

  private static final int LAYOUT_FRAGMENTASKLANGUAGE = 13;

  private static final int LAYOUT_FRAGMENTCHOOSEFUNNY = 14;

  private static final int LAYOUT_FRAGMENTCHOOSEMELODY = 15;

  private static final int LAYOUT_FRAGMENTCHOOSESOUND = 16;

  private static final int LAYOUT_FRAGMENTCHOOSESOUNDEFFECT = 17;

  private static final int LAYOUT_FRAGMENTCOUNTDOWN = 18;

  private static final int LAYOUT_FRAGMENTCREATEPASSCODE = 19;

  private static final int LAYOUT_FRAGMENTGRANTPERMISSION = 20;

  private static final int LAYOUT_FRAGMENTHOME = 21;

  private static final int LAYOUT_FRAGMENTHOWTOUSE = 22;

  private static final int LAYOUT_FRAGMENTINTRO = 23;

  private static final int LAYOUT_FRAGMENTPASSCORD = 24;

  private static final int LAYOUT_FRAGMENTPERMISSION = 25;

  private static final int LAYOUT_FRAGMENTPLACEHOLDER3 = 26;

  private static final int LAYOUT_FRAGMENTPLACEHOLDER4 = 27;

  private static final int LAYOUT_FRAGMENTPLACEHOLDER2 = 28;

  private static final int LAYOUT_FRAGMENTPLACEHOLDER5 = 29;

  private static final int LAYOUT_FRAGMENTRECORDPASSCODE = 30;

  private static final int LAYOUT_FRAGMENTSETTING = 31;

  private static final int LAYOUT_FRAGMENTSETTINGLANGUAGE = 32;

  private static final int LAYOUT_FRAGMENTSOUNDDETAIL = 33;

  private static final int LAYOUT_FRAGMENTSPLASH = 34;

  private static final int LAYOUT_FRAGMENTTEXTTOVOICE = 35;

  private static final int LAYOUT_ITEMCHOOSESOUND = 36;

  private static final int LAYOUT_ITEMDURATION = 37;

  private static final int LAYOUT_ITEMSOUND = 38;

  private static final int LAYOUT_NATIVEADUNIFIED = 39;

  private static final int LAYOUT_NATIVEADUNIFIEDSMALL = 40;

  private static final int LAYOUT_NATIVEADUNIFIEDTYPECLICK = 41;

  private static final int LAYOUT_NATIVEFAQ = 42;

  private static final int LAYOUT_POPUPWINDOWTEXT = 43;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(43);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.activity_phone_found, LAYOUT_ACTIVITYPHONEFOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.ads_layout_banner, LAYOUT_ADSLAYOUTBANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_alert_sound_detail, LAYOUT_BOTTOMSHEETALERTSOUNDDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_confirm_apply_language, LAYOUT_BOTTOMSHEETCONFIRMAPPLYLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_confirm_to_show_ads, LAYOUT_BOTTOMSHEETCONFIRMTOSHOWADS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_duration, LAYOUT_BOTTOMSHEETDURATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_rating_app, LAYOUT_BOTTOMSHEETRATINGAPP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_request_internet, LAYOUT_BOTTOMSHEETREQUESTINTERNET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_update_new_version, LAYOUT_BOTTOMSHEETUPDATENEWVERSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.bottom_sheet_warning, LAYOUT_BOTTOMSHEETWARNING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.dialog_check_internet, LAYOUT_DIALOGCHECKINTERNET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_ask_language, LAYOUT_FRAGMENTASKLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_choose_funny, LAYOUT_FRAGMENTCHOOSEFUNNY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_choose_melody, LAYOUT_FRAGMENTCHOOSEMELODY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_choose_sound, LAYOUT_FRAGMENTCHOOSESOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_choose_sound_effect, LAYOUT_FRAGMENTCHOOSESOUNDEFFECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_count_down, LAYOUT_FRAGMENTCOUNTDOWN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_create_passcode, LAYOUT_FRAGMENTCREATEPASSCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_grant_permission, LAYOUT_FRAGMENTGRANTPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_how_to_use, LAYOUT_FRAGMENTHOWTOUSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_intro, LAYOUT_FRAGMENTINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_passcord, LAYOUT_FRAGMENTPASSCORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_permission, LAYOUT_FRAGMENTPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_place_holder3, LAYOUT_FRAGMENTPLACEHOLDER3);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_place_holder4, LAYOUT_FRAGMENTPLACEHOLDER4);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_placeholder2, LAYOUT_FRAGMENTPLACEHOLDER2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_placeholder5, LAYOUT_FRAGMENTPLACEHOLDER5);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_record_pass_code, LAYOUT_FRAGMENTRECORDPASSCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_setting, LAYOUT_FRAGMENTSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_setting_language, LAYOUT_FRAGMENTSETTINGLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_sound_detail, LAYOUT_FRAGMENTSOUNDDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_splash, LAYOUT_FRAGMENTSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.fragment_text_to_voice, LAYOUT_FRAGMENTTEXTTOVOICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.item_choose_sound, LAYOUT_ITEMCHOOSESOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.item_duration, LAYOUT_ITEMDURATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.item_sound, LAYOUT_ITEMSOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.native_ad_unified, LAYOUT_NATIVEADUNIFIED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.native_ad_unified_small, LAYOUT_NATIVEADUNIFIEDSMALL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.native_ad_unified_type_click, LAYOUT_NATIVEADUNIFIEDTYPECLICK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.native_faq, LAYOUT_NATIVEFAQ);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.dev.baseproject.R.layout.popup_window_text, LAYOUT_POPUPWINDOWTEXT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPHONEFOUND: {
          if ("layout/activity_phone_found_0".equals(tag)) {
            return new ActivityPhoneFoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_phone_found is invalid. Received: " + tag);
        }
        case  LAYOUT_ADSLAYOUTBANNER: {
          if ("layout/ads_layout_banner_0".equals(tag)) {
            return new AdsLayoutBannerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for ads_layout_banner is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETALERTSOUNDDETAIL: {
          if ("layout/bottom_sheet_alert_sound_detail_0".equals(tag)) {
            return new BottomSheetAlertSoundDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_alert_sound_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETCONFIRMAPPLYLANGUAGE: {
          if ("layout/bottom_sheet_confirm_apply_language_0".equals(tag)) {
            return new BottomSheetConfirmApplyLanguageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_confirm_apply_language is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETCONFIRMTOSHOWADS: {
          if ("layout/bottom_sheet_confirm_to_show_ads_0".equals(tag)) {
            return new BottomSheetConfirmToShowAdsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_confirm_to_show_ads is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETDURATION: {
          if ("layout/bottom_sheet_duration_0".equals(tag)) {
            return new BottomSheetDurationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_duration is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETRATINGAPP: {
          if ("layout/bottom_sheet_rating_app_0".equals(tag)) {
            return new BottomSheetRatingAppBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_rating_app is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETREQUESTINTERNET: {
          if ("layout/bottom_sheet_request_internet_0".equals(tag)) {
            return new BottomSheetRequestInternetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_request_internet is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETUPDATENEWVERSION: {
          if ("layout/bottom_sheet_update_new_version_0".equals(tag)) {
            return new BottomSheetUpdateNewVersionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_update_new_version is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETWARNING: {
          if ("layout/bottom_sheet_warning_0".equals(tag)) {
            return new BottomSheetWarningBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_warning is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCHECKINTERNET: {
          if ("layout/dialog_check_internet_0".equals(tag)) {
            return new DialogCheckInternetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_check_internet is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTASKLANGUAGE: {
          if ("layout/fragment_ask_language_0".equals(tag)) {
            return new FragmentAskLanguageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ask_language is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHOOSEFUNNY: {
          if ("layout/fragment_choose_funny_0".equals(tag)) {
            return new FragmentChooseFunnyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_choose_funny is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHOOSEMELODY: {
          if ("layout/fragment_choose_melody_0".equals(tag)) {
            return new FragmentChooseMelodyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_choose_melody is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHOOSESOUND: {
          if ("layout/fragment_choose_sound_0".equals(tag)) {
            return new FragmentChooseSoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_choose_sound is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHOOSESOUNDEFFECT: {
          if ("layout/fragment_choose_sound_effect_0".equals(tag)) {
            return new FragmentChooseSoundEffectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_choose_sound_effect is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCOUNTDOWN: {
          if ("layout/fragment_count_down_0".equals(tag)) {
            return new FragmentCountDownBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_count_down is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEPASSCODE: {
          if ("layout/fragment_create_passcode_0".equals(tag)) {
            return new FragmentCreatePasscodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_create_passcode is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGRANTPERMISSION: {
          if ("layout/fragment_grant_permission_0".equals(tag)) {
            return new FragmentGrantPermissionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_grant_permission is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOWTOUSE: {
          if ("layout/fragment_how_to_use_0".equals(tag)) {
            return new FragmentHowToUseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_how_to_use is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINTRO: {
          if ("layout/fragment_intro_0".equals(tag)) {
            return new FragmentIntroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_intro is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPASSCORD: {
          if ("layout/fragment_passcord_0".equals(tag)) {
            return new FragmentPasscordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_passcord is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPERMISSION: {
          if ("layout/fragment_permission_0".equals(tag)) {
            return new FragmentPermissionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_permission is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLACEHOLDER3: {
          if ("layout/fragment_place_holder3_0".equals(tag)) {
            return new FragmentPlaceHolder3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_place_holder3 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLACEHOLDER4: {
          if ("layout/fragment_place_holder4_0".equals(tag)) {
            return new FragmentPlaceHolder4BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_place_holder4 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLACEHOLDER2: {
          if ("layout/fragment_placeholder2_0".equals(tag)) {
            return new FragmentPlaceholder2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_placeholder2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLACEHOLDER5: {
          if ("layout/fragment_placeholder5_0".equals(tag)) {
            return new FragmentPlaceholder5BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_placeholder5 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRECORDPASSCODE: {
          if ("layout/fragment_record_pass_code_0".equals(tag)) {
            return new FragmentRecordPassCodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_record_pass_code is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETTING: {
          if ("layout/fragment_setting_0".equals(tag)) {
            return new FragmentSettingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_setting is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETTINGLANGUAGE: {
          if ("layout/fragment_setting_language_0".equals(tag)) {
            return new FragmentSettingLanguageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_setting_language is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSOUNDDETAIL: {
          if ("layout/fragment_sound_detail_0".equals(tag)) {
            return new FragmentSoundDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sound_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPLASH: {
          if ("layout/fragment_splash_0".equals(tag)) {
            return new FragmentSplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTEXTTOVOICE: {
          if ("layout/fragment_text_to_voice_0".equals(tag)) {
            return new FragmentTextToVoiceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_text_to_voice is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCHOOSESOUND: {
          if ("layout/item_choose_sound_0".equals(tag)) {
            return new ItemChooseSoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_choose_sound is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMDURATION: {
          if ("layout/item_duration_0".equals(tag)) {
            return new ItemDurationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_duration is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSOUND: {
          if ("layout/item_sound_0".equals(tag)) {
            return new ItemSoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_sound is invalid. Received: " + tag);
        }
        case  LAYOUT_NATIVEADUNIFIED: {
          if ("layout/native_ad_unified_0".equals(tag)) {
            return new NativeAdUnifiedBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for native_ad_unified is invalid. Received: " + tag);
        }
        case  LAYOUT_NATIVEADUNIFIEDSMALL: {
          if ("layout/native_ad_unified_small_0".equals(tag)) {
            return new NativeAdUnifiedSmallBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for native_ad_unified_small is invalid. Received: " + tag);
        }
        case  LAYOUT_NATIVEADUNIFIEDTYPECLICK: {
          if ("layout/native_ad_unified_type_click_0".equals(tag)) {
            return new NativeAdUnifiedTypeClickBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for native_ad_unified_type_click is invalid. Received: " + tag);
        }
        case  LAYOUT_NATIVEFAQ: {
          if ("layout/native_faq_0".equals(tag)) {
            return new NativeFaqBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for native_faq is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPWINDOWTEXT: {
          if ("layout/popup_window_text_0".equals(tag)) {
            return new PopupWindowTextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_window_text is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(43);

    static {
      sKeys.put("layout/activity_main_0", com.dev.baseproject.R.layout.activity_main);
      sKeys.put("layout/activity_phone_found_0", com.dev.baseproject.R.layout.activity_phone_found);
      sKeys.put("layout/ads_layout_banner_0", com.dev.baseproject.R.layout.ads_layout_banner);
      sKeys.put("layout/bottom_sheet_alert_sound_detail_0", com.dev.baseproject.R.layout.bottom_sheet_alert_sound_detail);
      sKeys.put("layout/bottom_sheet_confirm_apply_language_0", com.dev.baseproject.R.layout.bottom_sheet_confirm_apply_language);
      sKeys.put("layout/bottom_sheet_confirm_to_show_ads_0", com.dev.baseproject.R.layout.bottom_sheet_confirm_to_show_ads);
      sKeys.put("layout/bottom_sheet_duration_0", com.dev.baseproject.R.layout.bottom_sheet_duration);
      sKeys.put("layout/bottom_sheet_rating_app_0", com.dev.baseproject.R.layout.bottom_sheet_rating_app);
      sKeys.put("layout/bottom_sheet_request_internet_0", com.dev.baseproject.R.layout.bottom_sheet_request_internet);
      sKeys.put("layout/bottom_sheet_update_new_version_0", com.dev.baseproject.R.layout.bottom_sheet_update_new_version);
      sKeys.put("layout/bottom_sheet_warning_0", com.dev.baseproject.R.layout.bottom_sheet_warning);
      sKeys.put("layout/dialog_check_internet_0", com.dev.baseproject.R.layout.dialog_check_internet);
      sKeys.put("layout/fragment_ask_language_0", com.dev.baseproject.R.layout.fragment_ask_language);
      sKeys.put("layout/fragment_choose_funny_0", com.dev.baseproject.R.layout.fragment_choose_funny);
      sKeys.put("layout/fragment_choose_melody_0", com.dev.baseproject.R.layout.fragment_choose_melody);
      sKeys.put("layout/fragment_choose_sound_0", com.dev.baseproject.R.layout.fragment_choose_sound);
      sKeys.put("layout/fragment_choose_sound_effect_0", com.dev.baseproject.R.layout.fragment_choose_sound_effect);
      sKeys.put("layout/fragment_count_down_0", com.dev.baseproject.R.layout.fragment_count_down);
      sKeys.put("layout/fragment_create_passcode_0", com.dev.baseproject.R.layout.fragment_create_passcode);
      sKeys.put("layout/fragment_grant_permission_0", com.dev.baseproject.R.layout.fragment_grant_permission);
      sKeys.put("layout/fragment_home_0", com.dev.baseproject.R.layout.fragment_home);
      sKeys.put("layout/fragment_how_to_use_0", com.dev.baseproject.R.layout.fragment_how_to_use);
      sKeys.put("layout/fragment_intro_0", com.dev.baseproject.R.layout.fragment_intro);
      sKeys.put("layout/fragment_passcord_0", com.dev.baseproject.R.layout.fragment_passcord);
      sKeys.put("layout/fragment_permission_0", com.dev.baseproject.R.layout.fragment_permission);
      sKeys.put("layout/fragment_place_holder3_0", com.dev.baseproject.R.layout.fragment_place_holder3);
      sKeys.put("layout/fragment_place_holder4_0", com.dev.baseproject.R.layout.fragment_place_holder4);
      sKeys.put("layout/fragment_placeholder2_0", com.dev.baseproject.R.layout.fragment_placeholder2);
      sKeys.put("layout/fragment_placeholder5_0", com.dev.baseproject.R.layout.fragment_placeholder5);
      sKeys.put("layout/fragment_record_pass_code_0", com.dev.baseproject.R.layout.fragment_record_pass_code);
      sKeys.put("layout/fragment_setting_0", com.dev.baseproject.R.layout.fragment_setting);
      sKeys.put("layout/fragment_setting_language_0", com.dev.baseproject.R.layout.fragment_setting_language);
      sKeys.put("layout/fragment_sound_detail_0", com.dev.baseproject.R.layout.fragment_sound_detail);
      sKeys.put("layout/fragment_splash_0", com.dev.baseproject.R.layout.fragment_splash);
      sKeys.put("layout/fragment_text_to_voice_0", com.dev.baseproject.R.layout.fragment_text_to_voice);
      sKeys.put("layout/item_choose_sound_0", com.dev.baseproject.R.layout.item_choose_sound);
      sKeys.put("layout/item_duration_0", com.dev.baseproject.R.layout.item_duration);
      sKeys.put("layout/item_sound_0", com.dev.baseproject.R.layout.item_sound);
      sKeys.put("layout/native_ad_unified_0", com.dev.baseproject.R.layout.native_ad_unified);
      sKeys.put("layout/native_ad_unified_small_0", com.dev.baseproject.R.layout.native_ad_unified_small);
      sKeys.put("layout/native_ad_unified_type_click_0", com.dev.baseproject.R.layout.native_ad_unified_type_click);
      sKeys.put("layout/native_faq_0", com.dev.baseproject.R.layout.native_faq);
      sKeys.put("layout/popup_window_text_0", com.dev.baseproject.R.layout.popup_window_text);
    }
  }
}
