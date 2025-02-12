package com.dev.baseproject.ui.component.splash.view

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.dev.baseproject.App
import com.dev.baseproject.R
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.dev.baseproject.databinding.FragmentAskLanguageBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.ui.component.splash.dialog.WarningBottomSheet
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class AskLanguageFragment : BaseFragmentBinding<FragmentAskLanguageBinding>() {

    private var langCode = App.instance.localStorage.langCode
    private var isChooseLanguage: Boolean? = false
    private var warningBottomSheet: WarningBottomSheet? = null

    override fun getContentViewId() = R.layout.fragment_ask_language

    override fun initializeViews() {
        dataBinding.txtNext.visibility = View.GONE
        if (langCode.isEmpty()) {
            val currentLocalLanguage = Locale.getDefault().language
            langCode = LangCode.ENGLISH.value
            enumValues<LangCode>().forEach {
                if (it.value.lowercase().equals(currentLocalLanguage.lowercase())) {
                    langCode = currentLocalLanguage
                }
            }
            updateLanguage()
        }
        resetViewItem()
    }

    override fun registerListeners() {
        dataBinding.radioGroup.setOnCheckedChangeListener { radioGroup: RadioGroup, checkedId: Int ->
            when(checkedId){
                R.id.rbt_english -> {
                    isChooseLanguage = true
                    langCode = LangCode.ENGLISH.value
                    goToLanguage2()
                }
                R.id.rbt_japan -> {
                    isChooseLanguage = true
                    langCode = LangCode.JAPAN.value
                    goToLanguage2()
                }
                R.id.rbt_korean -> {
                    isChooseLanguage = true
                    langCode = LangCode.KOREAN.value
                    goToLanguage2()
                }
                R.id.rbt_hindi -> {
                    isChooseLanguage = true
                    langCode = LangCode.HINDI.value
                    goToLanguage2()
                }
                R.id.rbt_china -> {
                    isChooseLanguage = true
                    langCode = LangCode.CHINA.value
                    goToLanguage2()
                }
                R.id.rbt_vietnam -> {
                    isChooseLanguage = true
                    langCode = LangCode.VIETNAM.value
                    goToLanguage2()
                }
                R.id.rbt_portuguase -> {
                    isChooseLanguage = true
                    langCode = LangCode.PORTUGUESE.value
                    goToLanguage2()
                }
                R.id.rbt_spanish -> {
                    isChooseLanguage = true
                    langCode = LangCode.SPANISH.value
                    goToLanguage2()
                }
                R.id.rbt_german -> {
                    isChooseLanguage = true
                    langCode = LangCode.GERMAN.value
                    goToLanguage2()
                }
                R.id.rbt_russian -> {
                    isChooseLanguage = true
                    langCode = LangCode.RUSSIAN.value
                    goToLanguage2()
                }
                R.id.rbt_ukraian -> {
                    isChooseLanguage = true
                    langCode = LangCode.UKRAIAN.value
                    goToLanguage2()
                }
                R.id.rbt_abric -> {
                    isChooseLanguage = true
                    langCode = LangCode.ABRIC.value
                    goToLanguage2()
                }
                R.id.rbt_turkey -> {
                    isChooseLanguage = true
                    langCode = LangCode.TURKEY.value
                    goToLanguage2()
                }
                else -> Unit
            }
        }

        dataBinding.txtNext.setOnClickListener {
            if (isChooseLanguage == true) {
                when (langCode) {
                    LangCode.ENGLISH.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_ENLISH)
                    }
                    LangCode.JAPAN.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_JAPAN)
                    }
                    LangCode.KOREAN.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_KOREA)
                    }
                    LangCode.HINDI.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_HINDI)
                    }
                    LangCode.CHINA.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_CHINA)
                    }
                    LangCode.VIETNAM.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_VIETNAM)
                    }
                    LangCode.PORTUGUESE.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_PORTUGUESE)
                    }
                    LangCode.SPANISH.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_SPANISH)
                    }
                    LangCode.GERMAN.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_GERMAN)
                    }
                    LangCode.RUSSIAN.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_RUSSIAN)
                    }
                    LangCode.UKRAIAN.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_UKRAIAN)
                    }
                    LangCode.ABRIC.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_ABRIC)
                    }
                    LangCode.TURKEY.value -> {
                        AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_LANGUAGE_TURKEY)
                    }
                }
            } else {
                initWarningBottomSheet()
            }
        }
    }
    private fun goToLanguage2(){
        val bundle = Bundle().apply {
            putString(KEY_LANGUAGE, langCode)
            putInt(SCROLL_POSITION, dataBinding.scvLanguage.scrollY)
        }
        try {
            findNavControllerSafety()?.navigate(R.id.atcAskLanguageToAskLanguage2,bundle)
        } catch (e: Throwable) {
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }


    override fun initializeData() {

    }

    override fun onResume() {
        super.onResume()
        if (localStorage.isFirstOpenLanguage) {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_LANGUAGE_FIRST)
            localStorage.isFirstOpenLanguage = false
        } else {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_LANGUAGE_AGAIN)
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
                dataBinding.itemEnglish.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.JAPAN.value -> {
                dataBinding.itemJapan.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.KOREAN.value -> {
                dataBinding.itemKorean.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.HINDI.value -> {
                dataBinding.itemHindi.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.CHINA.value -> {
                dataBinding.itemChina.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.VIETNAM.value -> {
                dataBinding.itemVietNam.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.PORTUGUESE.value -> {
                dataBinding.itemPortuguase.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.SPANISH.value -> {
                dataBinding.itemSpanish.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.GERMAN.value -> {
                dataBinding.itemGerman.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.RUSSIAN.value -> {
                dataBinding.itemRussian.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.UKRAIAN.value -> {
                dataBinding.itemUkraian.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.ABRIC.value -> {
                dataBinding.itemAbric.setBackgroundResource(R.drawable.bg_selected_request_age)
            }

            LangCode.TURKEY.value -> {
                dataBinding.itemTurkey.setBackgroundResource(R.drawable.bg_selected_request_age)
            }
        }
    }

    private fun initWarningBottomSheet() {
        warningBottomSheet = WarningBottomSheet()
        if (activity?.isFinishing == false) {
            activity?.supportFragmentManager?.let {
                warningBottomSheet?.show(it,
                    WarningBottomSheet.TAG)
            }
        }
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

    companion object {
        const val KEY_LANGUAGE = "KEY_LANGUAGE"
        const val SCROLL_POSITION = "SCROLL_POSITION"
    }

}