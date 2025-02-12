package com.dev.baseproject.ui.component.splash.view

import android.content.res.Configuration
import android.content.res.Resources
import android.view.View
import android.view.ViewTreeObserver
import android.widget.RadioGroup
import com.dev.baseproject.App
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentAskLanguageBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.ui.component.splash.dialog.WarningBottomSheet
import com.dev.baseproject.ui.component.splash.view.AskLanguageFragment.Companion.KEY_LANGUAGE
import com.dev.baseproject.ui.component.splash.view.AskLanguageFragment.Companion.SCROLL_POSITION
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class AskLanguageFragment2 : BaseFragmentBinding<FragmentAskLanguageBinding>() {

    private var langCode = App.instance.localStorage.langCode
    private var isChooseLanguage: Boolean? = false
    private var warningBottomSheet: WarningBottomSheet? = null
    private var lastCheckedId: Int? = null
    private var scrollPosition: Int? = 0
    override fun getContentViewId() = R.layout.fragment_ask_language

    override fun initializeViews() {
        arguments?.let {
            langCode = it.getString(KEY_LANGUAGE,"")
            scrollPosition = it.getInt(SCROLL_POSITION,0)
            isChooseLanguage = true
        }
        if(localStorage.languageScrollPosition != 0){
            scrollPosition = localStorage.languageScrollPosition
        }
        dataBinding.scvLanguage.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Cuộn đến vị trí mong muốn
                scrollPosition?.let { dataBinding.scvLanguage.smoothScrollTo(0, it) }

                // Hoặc cuộn mượt
                // scrollView.smoothScrollTo(0, scrollPosition)

                // Xóa listener để không cuộn lại lần nữa
                dataBinding.scvLanguage.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
        resetViewItem()
        bindViewItemSelected()
    }

    override fun registerListeners() {
        dataBinding.radioGroup.setOnCheckedChangeListener { radioGroup: RadioGroup, checkedId: Int ->
            if ( lastCheckedId != checkedId) {
                isChooseLanguage = true
                langCode = getLangCodeFromId(checkedId)
                updateRadioButtonUI(checkedId)
            }
        }

        dataBinding.txtNext.setOnClickListener {
            if (isChooseLanguage == true) {
                val needRecreate = if((langCode == "ar" && localStorage.langCode != "ar") || (langCode != "ar" && localStorage.langCode == "ar")) true else false
                localStorage.langCode = langCode
                localStorage.voiceLocal = langCode
                updateLanguageLocale(needRecreate)
                trackLanguageSelection()
                localStorage.languageScrollPosition = dataBinding.scvLanguage.scrollY
                findNavControllerSafety()?.navigate(R.id.actAskLanguage2ToIntroFragment1)
            } else {
                initWarningBottomSheet()
            }
        }
    }

    private fun updateLanguageLocale(needRecreate: Boolean = false) {
        if (localStorage.langCode.isNotBlank()) {
            val resources: Resources? = context?.resources
            val locale = Locale(localStorage.langCode)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            resources?.updateConfiguration(config, resources?.displayMetrics)
            if(needRecreate){
                try {
                    requireActivity().recreate()
                } catch (e : Exception){
                    Logger.e(e.message)
                }
            }
        }
    }

    private fun getLangCodeFromId(id: Int): String {
        return when (id) {
            R.id.rbt_english -> LangCode.ENGLISH.value
            R.id.rbt_japan -> LangCode.JAPAN.value
            R.id.rbt_korean -> LangCode.KOREAN.value
            R.id.rbt_hindi -> LangCode.HINDI.value
            R.id.rbt_china -> LangCode.CHINA.value
            R.id.rbt_vietnam -> LangCode.VIETNAM.value
            R.id.rbt_portuguase -> LangCode.PORTUGUESE.value
            R.id.rbt_spanish -> LangCode.SPANISH.value
            R.id.rbt_german -> LangCode.GERMAN.value
            R.id.rbt_russian -> LangCode.RUSSIAN.value
            R.id.rbt_ukraian -> LangCode.UKRAIAN.value
            R.id.rbt_abric -> LangCode.ABRIC.value
            R.id.rbt_turkey -> LangCode.TURKEY.value
            else -> LangCode.NONE.value
        }
    }

    private fun updateRadioButtonUI(checkedId: Int) {
        // Đặt lại trạng thái của RadioButton trước đó (nếu có)
        lastCheckedId?.let {
            val lastItem = getItemFromId(it)
            lastItem?.setBackgroundResource(R.drawable.bg_item_language)
        }

        // Cập nhật trạng thái của RadioButton hiện tại
        val currentItem = getItemFromId(checkedId)
        currentItem?.setBackgroundResource(R.drawable.bg_selected_request_age)

        // Đặt trạng thái checked cho RadioButton hiện tại
        dataBinding.radioGroup.check(checkedId)

        // Lưu lại ID của RadioButton hiện tại
        lastCheckedId = checkedId
    }

    private fun getItemFromId(id: Int): View? {
        return when (id) {
            R.id.rbt_english -> dataBinding.itemEnglish
            R.id.rbt_japan -> dataBinding.itemJapan
            R.id.rbt_korean -> dataBinding.itemKorean
            R.id.rbt_hindi -> dataBinding.itemHindi
            R.id.rbt_china -> dataBinding.itemChina
            R.id.rbt_vietnam -> dataBinding.itemVietNam
            R.id.rbt_portuguase -> dataBinding.itemPortuguase
            R.id.rbt_spanish -> dataBinding.itemSpanish
            R.id.rbt_german -> dataBinding.itemGerman
            R.id.rbt_russian -> dataBinding.itemRussian
            R.id.rbt_ukraian -> dataBinding.itemUkraian
            R.id.rbt_abric -> dataBinding.itemAbric
            R.id.rbt_turkey -> dataBinding.itemTurkey
            else -> null
        }
    }

    private fun trackLanguageSelection() {
        when (langCode) {
            LangCode.ENGLISH.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_ENLISH)
            LangCode.JAPAN.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_JAPAN)
            LangCode.KOREAN.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_KOREA)
            LangCode.HINDI.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_HINDI)
            LangCode.CHINA.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_CHINA)
            LangCode.VIETNAM.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_VIETNAM)
            LangCode.PORTUGUESE.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_PORTUGUESE)
            LangCode.SPANISH.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_SPANISH)
            LangCode.GERMAN.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_GERMAN)
            LangCode.RUSSIAN.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_RUSSIAN)
            LangCode.UKRAIAN.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_UKRAIAN)
            LangCode.ABRIC.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_ABRIC)
            LangCode.TURKEY.value -> AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_TURKEY)
        }
    }

    override fun initializeData() {

    }

    private fun initWarningBottomSheet() {
        warningBottomSheet = WarningBottomSheet()
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                warningBottomSheet?.show(
                    it,
                    WarningBottomSheet.TAG
                )
            }
        }
    }


    private fun resetViewItem() {
        dataBinding.itemEnglish.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemJapan.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemKorean.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemHindi.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemChina.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemVietNam.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemPortuguase.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemSpanish.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemGerman.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemRussian.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemUkraian.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemAbric.setBackgroundResource(R.drawable.bg_item_language)
        dataBinding.itemTurkey.setBackgroundResource(R.drawable.bg_item_language)

    }

    private fun bindViewItemSelected() {
        if (langCode.isEmpty()) return
        when (langCode) {
            LangCode.NONE.value -> Unit

            LangCode.ENGLISH.value -> {
                dataBinding.radioGroup.check(R.id.rbt_english)
                dataBinding.itemEnglish.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_english
            }

            LangCode.JAPAN.value -> {
                dataBinding.radioGroup.check(R.id.rbt_japan)
                dataBinding.itemJapan.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_japan
            }

            LangCode.KOREAN.value -> {
                dataBinding.radioGroup.check(R.id.rbt_korean)
                dataBinding.itemKorean.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_korean
            }

            LangCode.HINDI.value -> {
                dataBinding.radioGroup.check(R.id.rbt_hindi)
                dataBinding.itemHindi.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_hindi
            }

            LangCode.CHINA.value -> {
                dataBinding.radioGroup.check(R.id.rbt_china)
                dataBinding.itemChina.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_china
            }

            LangCode.VIETNAM.value -> {
                dataBinding.radioGroup.check(R.id.rbt_vietnam)
                dataBinding.itemVietNam.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_vietnam
            }

            LangCode.PORTUGUESE.value -> {
                dataBinding.radioGroup.check(R.id.rbt_portuguase)
                dataBinding.itemPortuguase.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_portuguase
            }

            LangCode.SPANISH.value -> {
                dataBinding.radioGroup.check(R.id.rbt_spanish)
                dataBinding.itemSpanish.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_spanish
            }

            LangCode.GERMAN.value -> {
                dataBinding.radioGroup.check(R.id.rbt_german)
                dataBinding.itemGerman.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_german
            }

            LangCode.RUSSIAN.value -> {
                dataBinding.radioGroup.check(R.id.rbt_russian)
                dataBinding.itemRussian.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_russian
            }

            LangCode.UKRAIAN.value -> {
                dataBinding.radioGroup.check(R.id.rbt_ukraian)
                dataBinding.itemUkraian.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_ukraian
            }

            LangCode.ABRIC.value -> {
                dataBinding.radioGroup.check(R.id.rbt_abric)
                dataBinding.itemAbric.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_abric
            }

            LangCode.TURKEY.value -> {
                dataBinding.radioGroup.check(R.id.rbt_turkey)
                dataBinding.itemTurkey.setBackgroundResource(R.drawable.bg_selected_request_age)
                lastCheckedId = R.id.rbt_turkey
            }
        }
    }

    override fun onBackPressed(): Boolean {
        return super.onBackPressed()
    }

    enum class LangCode(val value: String) {
        NONE(""),
        ENGLISH("en"),
        JAPAN("ja"),
        KOREAN("ko"),
        HINDI("hi"),
        CHINA("zh"),
        VIETNAM("vi"),
        SPANISH("es"),
        PORTUGUESE("pt"),
        GERMAN("de"),
        RUSSIAN("ru"),
        UKRAIAN("uk"),
        ABRIC("ar"),
        TURKEY("tr")
    }

}