package com.dev.baseproject.ui.component.home.fragment

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentRecordPassCodeBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_RECORD_VOICE_AGAIN
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_RECORD_VOICE_FIRST
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_SAVE_PASSCODE_AGAIN
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_SAVE_PASSCODE_FIRST
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_SELECT_LANGUAGE_AGAIN
import com.dev.baseproject.utils.Constants.RECORDPASSCODE_SELECT_LANGUAGE_FIRST
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordPassCodeFragment : BaseFragmentBinding<FragmentRecordPassCodeBinding>(), RecognitionListener {
    private var isListening = false
    private var recognizerIntent: Intent? = null
    private var speechRecognizer: SpeechRecognizer? = null
    private var currentLocale: String = "en"
    override fun getContentViewId() = R.layout.fragment_record_pass_code

    override fun initializeViews() {
        resetSpeechRecognizer()
        setRecognizerIntent(localStorage.voiceLocal)
        val selectedLangResId = when (localStorage.voiceLocal) {
            "en" -> R.string.text_lang_en
            "es" -> R.string.text_lang_es
            "hi" -> R.string.text_lang_hi
            "ja" -> R.string.text_lang_ja
            "ko" -> R.string.text_lang_ko
            "vi" -> R.string.text_lang_vi
            "ar" -> R.string.text_lang_ar
            "tr" -> R.string.text_lang_tr
            "zh" -> R.string.text_lang_zh
            "de" -> R.string.text_lang_de
            "ru" -> R.string.text_lang_ru
            "uk" -> R.string.text_lang_uk
            "pt" -> R.string.text_lang_pt
            else -> R.string.text_lang_en
        }
        dataBinding.soundanimationview.visibility  = View.INVISIBLE
        dataBinding.tvselectedlang.text = getString(selectedLangResId)
        currentLocale = localStorage.voiceLocal
        dataBinding.tvpasscode.text = Editable.Factory.getInstance().newEditable(localStorage.voicePasscode)
        dataBinding.recordvoiceicon.setOnClickListener {
            if(!AppConfig.isDoubleClick()){

                Log.d("LCD", "Record icon clicked. isListening = $isListening")
                if(localStorage.isFirstRecordVoiceClick){
                    AppConfig.logEventTracking(RECORDPASSCODE_RECORD_VOICE_FIRST)
                    localStorage.isFirstRecordVoiceClick = false
                }else{
                    AppConfig.logEventTracking(RECORDPASSCODE_RECORD_VOICE_AGAIN)
                }
                if (!isListening) {
                    dataBinding.soundanimationview.visibility  = View.VISIBLE
                    dataBinding.soundanimationview.repeatCount = 10
                    startListening()
                    dataBinding.tvrecordingstatus.text = getString(R.string.tap_to_complete)
                    Log.d("LCD", "Started listening.")
                    dataBinding.soundanimationview.playAnimation()
                } else {
                    stopListening()
                    dataBinding.tvrecordingstatus.text = getString(R.string.tap_to_record)
                    Log.d("LCD", "Stopped listening.")
                    dataBinding.soundanimationview.pauseAnimation()
                    dataBinding.soundanimationview.visibility  = View.INVISIBLE
                }
            }
        }
        dataBinding.btnSavePasscode.setOnClickListener {
            if(!AppConfig.isDoubleClick()){
                if(localStorage.isFirstSavePasscodeClick){
                    AppConfig.logEventTracking(RECORDPASSCODE_SAVE_PASSCODE_FIRST)
                    localStorage.isFirstSavePasscodeClick = false
                }else{
                    AppConfig.logEventTracking(RECORDPASSCODE_SAVE_PASSCODE_AGAIN)
                }
                if (dataBinding.tvpasscode.text.equals("")) {
                    localStorage.voiceLocal = currentLocale
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.please_record_something),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    localStorage.voicePasscode = dataBinding.tvpasscode.text.toString()
                    localStorage.voiceRealPasscode = dataBinding.tvpasscode.text.toString()
                    localStorage.voiceLocal = currentLocale
                }
                findNavControllerSafety()?.popBackStack()
            }
        }
        dataBinding.selectlanguage.setOnClickListener {
            if(!AppConfig.isDoubleClick()){
                if(localStorage.isFirstSelectLanguageRecordPasscodeClick){
                    AppConfig.logEventTracking(RECORDPASSCODE_SELECT_LANGUAGE_FIRST)
                    localStorage.isFirstSelectLanguageRecordPasscodeClick = false
                }else{
                    AppConfig.logEventTracking(RECORDPASSCODE_SELECT_LANGUAGE_AGAIN)
                }
                showLanguageSelectionDialog()
            }
        }

        dataBinding.btnBack.setOnClickListener {
            findNavControllerSafety()?.navigateUp()
        }

        dataBinding.btnCancel.setOnClickListener {
            if(!AppConfig.isDoubleClick()){
                findNavControllerSafety()?.popBackStack()
            }
        }
    }
    private fun showLanguageSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext(), R.style.CustomDialogTheme)
        val dialogView = layoutInflater.inflate(R.layout.dialog_language_selection, null)
        builder.setView(dialogView)
        val radioButtonEnglish = dialogView.findViewById<RadioButton>(R.id.radioButtonEnglishv)
        val radioButtonSpanish = dialogView.findViewById<RadioButton>(R.id.radioButtonSpanishv)
        val radioButtonHindi = dialogView.findViewById<RadioButton>(R.id.radioButtonHindiv)
        val radioButtonJapanese = dialogView.findViewById<RadioButton>(R.id.radioButtonJapanesev)
        val radioButtonKorean = dialogView.findViewById<RadioButton>(R.id.radioButtonKoreanv)
        val radioButtonVietnamese = dialogView.findViewById<RadioButton>(R.id.radioButtonVietnamesev)
        val radioButtonChinese = dialogView.findViewById<RadioButton>(R.id.radioButtonChinesev)
        val radioButtonArabic = dialogView.findViewById<RadioButton>(R.id.radioButtonArabicv)
        val radioButtonTurkish = dialogView.findViewById<RadioButton>(R.id.radioButtonTurkishv)
        val radioButtonGerman = dialogView.findViewById<RadioButton>(R.id.radioButtonGermanv)
        val radioButtonRussian = dialogView.findViewById<RadioButton>(R.id.radioButtonRussianv)
        val radioButtonUkrainian = dialogView.findViewById<RadioButton>(R.id.radioButtonUkrainianv)
        val radioButtonPortuguese = dialogView.findViewById<RadioButton>(R.id.radioButtonPortuguesev)

        when (currentLocale) {
            "en" -> radioButtonEnglish.isChecked = true
            "es" -> radioButtonSpanish.isChecked = true
            "hi" -> radioButtonHindi.isChecked = true
            "ja" -> radioButtonJapanese.isChecked = true
            "ko" -> radioButtonKorean.isChecked = true
            "vi" -> radioButtonVietnamese.isChecked = true
            "zh" -> radioButtonChinese.isChecked = true
            "ar" -> radioButtonArabic.isChecked = true
            "tr" -> radioButtonTurkish.isChecked = true
            "de" -> radioButtonGerman.isChecked = true
            "ru" -> radioButtonRussian.isChecked = true
            "uk" -> radioButtonUkrainian.isChecked = true
            "pt" -> radioButtonPortuguese.isChecked = true
        }

        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.bg_rectangle_16))
        alertDialog.setCanceledOnTouchOutside(false)
        dialogView.findViewById<TextView>(R.id.buttonOk).setOnClickListener {
            when {
                radioButtonEnglish.isChecked -> updateLanguage("en", R.string.text_lang_en)
                radioButtonSpanish.isChecked -> updateLanguage("es", R.string.text_lang_es)
                radioButtonHindi.isChecked -> updateLanguage("hi", R.string.text_lang_hi)
                radioButtonJapanese.isChecked -> updateLanguage("ja", R.string.text_lang_ja)
                radioButtonKorean.isChecked -> updateLanguage("ko", R.string.text_lang_ko)
                radioButtonVietnamese.isChecked -> updateLanguage("vi", R.string.text_lang_vi)
                radioButtonChinese.isChecked -> updateLanguage("zh", R.string.text_lang_zh)
                radioButtonArabic.isChecked -> updateLanguage("ar", R.string.text_lang_ar)
                radioButtonTurkish.isChecked -> updateLanguage("tr", R.string.text_lang_tr)
                radioButtonPortuguese.isChecked -> updateLanguage("pt", R.string.text_lang_pt)
                radioButtonUkrainian.isChecked -> updateLanguage("uk", R.string.text_lang_uk)
                radioButtonGerman.isChecked -> updateLanguage("de", R.string.text_lang_de)
                radioButtonRussian.isChecked -> updateLanguage("ru", R.string.text_lang_ru)
            }
            alertDialog.dismiss()
        }

        dialogView.findViewById<TextView>(R.id.buttonCancel).setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun updateLanguage(locale: String, languageResId: Int) {
        currentLocale = locale
        dataBinding.tvselectedlang.text = getString(languageResId)
        setRecognizerIntent(locale)
    }


    override fun registerListeners() {

    }

    override fun initializeData() {

    }

    override fun onReadyForSpeech(p0: Bundle?) {
        Log.d("LCD", "Speech recognizer is ready for speech.")
    }

    override fun onBeginningOfSpeech() {
        Log.d("LCD", "Speech recognizer detected the beginning of speech.")
    }

    override fun onRmsChanged(p0: Float) {
        Log.d("LCD", "RMS changed: $p0")
//        if(speechRecognizer != null){
//            if(p0 < RMS_THRESHOLD){
//                silenceCount += 1
//                if(silenceCount >= SILENCE_COUNT_THRESHOLD){
//                    stopListening()
//                    silenceCount = 0
//                }
//            }
//        }
    }

    override fun onBufferReceived(p0: ByteArray?) {

    }

    override fun onEndOfSpeech() {
        Log.d("LCD", "Speech recognizer detected the end of speech.")
        if(isListening){
            isListening = false
            dataBinding.tvrecordingstatus.text = getString(R.string.tap_to_record)
            dataBinding.soundanimationview.pauseAnimation()
            dataBinding.soundanimationview.visibility  = View.INVISIBLE
        }
    }

    override fun onError(p0: Int) {
        val errorMessage = when (p0) {
            SpeechRecognizer.ERROR_AUDIO -> "Audio recording error."
            SpeechRecognizer.ERROR_CLIENT -> "Client-side error."
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions."
            SpeechRecognizer.ERROR_NETWORK -> "Network error."
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout."
            SpeechRecognizer.ERROR_NO_MATCH -> "No match found."
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Recognizer is busy."
            SpeechRecognizer.ERROR_SERVER -> "Server error."
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input."
            else -> "Unknown error."
        }
        Log.e("LCD", "Speech recognition error: $errorMessage")
//        if(isListening){
//            isListening = false
//            dataBinding.tvrecordingstatus.text = getString(R.string.tap_to_record)
//            dataBinding.soundanimationview.pauseAnimation()
//            dataBinding.soundanimationview.visibility  = View.INVISIBLE
//        }
    }

    override fun onResults(p0: Bundle?) {
        val results = p0?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        Log.e("Results", results.toString())
        if (!results.isNullOrEmpty()) {
            val recognizedText = results[0]
            Log.e("res","Recognized text: $recognizedText")
            val processedText = processRecognitionResult(recognizedText)
            val limitedText = if (processedText.length > 30) {
                processedText.take(30)
            } else {
                processedText
            }
            dataBinding.tvpasscode.text = Editable.Factory.getInstance().newEditable(limitedText)
            dataBinding.soundanimationview.pauseAnimation()
            dataBinding.soundanimationview.visibility = View.INVISIBLE
            dataBinding.tvrecordingstatus.text = getString(R.string.tap_to_record)
            stopListening()
        } else {
            Log.e("LCD", "No recognition results.")
        }
    }

    private fun processRecognitionResult(text: String): String {
        val cleanedText = text.trim().replace(Regex("[^\\p{L}\\p{N} ]"), "")
        return cleanedText
    }

    override fun onPartialResults(p0: Bundle?) {
        val partialResults = p0?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)

        val recognizedText = partialResults?.get(0) ?: ""

        if (recognizedText.length > 30) {
            stopListening()
            Toast.makeText(requireContext(), R.string.max_length_exceeded, Toast.LENGTH_SHORT).show()
            return
        }

        if(currentLocale != "en"){
            dataBinding.tvpasscode.text = Editable.Factory.getInstance().newEditable(processRecognitionResult(recognizedText))
        }
        Log.e("LCD", "onPartialResults called. Partial results: ${partialResults?.get(0)}")
    }

    override fun onEvent(p0: Int, p1: Bundle?) {

    }

    private fun resetSpeechRecognizer() {
        try {
            if (!SpeechRecognizer.isRecognitionAvailable(requireContext())) {
                Toast.makeText(requireContext(), "Speech recognition is not available on this device.", Toast.LENGTH_SHORT).show()
                return
            }
            if (speechRecognizer != null) {
                speechRecognizer?.setRecognitionListener(null as RecognitionListener?)
                speechRecognizer?.destroy()
                speechRecognizer = null
            }
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())

            if (SpeechRecognizer.isRecognitionAvailable(requireContext())) {
                speechRecognizer?.setRecognitionListener(this)
            }
        } catch (e: java.lang.IllegalArgumentException) {

        }
    }


    private fun setRecognizerIntent(language: String) {
        val languageTag = when (language) {
            "en" -> "en-US"
            "es" -> "es-ES"
            "hi" -> "hi-IN"
            "ja" -> "ja-JP"
            "ko" -> "ko-KR"
            "vi" -> "vi-VN"
            "zh" -> "zh-CN"
            "pt" -> "pt-PT"
            "de" -> "de-DE"
            "ru" -> "ru-RU"
            "uk" -> "uk-UA"
            "ar" -> "ar-SA"
            "tr" -> "tr-TR"
            else -> "en-US"
        }
        Log.e("Lang", "Recognizer language set to: $languageTag")
        recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageTag)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5)
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
        }
    }

    private fun startListening() {
        if (!isListening && speechRecognizer != null) {
            try {
                speechRecognizer?.startListening(recognizerIntent)
                isListening = true
            } catch (e: Exception) {

            }
        }
    }

    private fun stopListening() {
        if (isListening && speechRecognizer != null) {
            try {
                speechRecognizer?.stopListening()
                isListening = false
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Failed to stop listening: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        try {

        } catch (e: IllegalArgumentException) {
            Log.e("LCD", "Error destroying SpeechRecognizer: ${e.message}")
        }
    }
    companion object{
        const val RMS_THRESHOLD: Float = 1.0f // RMS threshold to detect speech
        const val SILENCE_COUNT_THRESHOLD: Int = 2
    }

}
