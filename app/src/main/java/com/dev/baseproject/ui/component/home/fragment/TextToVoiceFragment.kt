package com.dev.baseproject.ui.component.home.fragment

import android.content.Context
import android.content.Intent
import android.media.AudioFormat
import android.media.AudioManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentTextToVoiceBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_LISTEN_AGAIN
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_LISTEN_FIRST
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_SAVE_PASSCODE_AGAIN
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_SAVE_PASSCODE_FIRST
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_SELECT_LANGUAGE_AGAIN
import com.dev.baseproject.utils.Constants.TEXT_TO_VOICE_SELECT_LANGUAGE_FIRST
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileInputStream
import java.util.Locale
import java.util.UUID


@AndroidEntryPoint
class TextToVoiceFragment : BaseFragmentBinding<FragmentTextToVoiceBinding>() {
    private var myLocale: Locale? = null
    private var textToSpeech: TextToSpeech? = null
    private var currentLocale: String = "en"
    private var speechRecognizer: SpeechRecognizer? = null
    private var recognitionListener: RecognitionListener? = null
    private var outputFile: File? = null
    private var previousText: String = ""

    private var audioManager: AudioManager? = null
    private val volume = 0.8f
    private var volumeLevel: Int = 0

    override fun getContentViewId() = R.layout.fragment_text_to_voice

    override fun initializeViews() {
        when (localStorage.voiceLocal) {
            "en" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_en)
                myLocale = Locale.US
            }
            "es" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_es)
                myLocale = Locale("es", "ES")
            }
            "hi" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_hi)
                myLocale = Locale("hi", "IN")
            }
            "ja" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_ja)
                myLocale = Locale.JAPANESE
            }
            "ko" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_ko)
                myLocale = Locale.KOREAN
            }
            "vi" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_vi)
                myLocale = Locale("vi", "VN")
            }
            "zh" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_zh)
                myLocale = Locale.CHINESE
            }
            "ar" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_ar)
                myLocale = Locale("ar", "SA")
            }
            "tr" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_tr)
                myLocale = Locale("tr", "TR")
            }
            "pt" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_pt)
                myLocale = Locale("pt", "PT")
            }
            "uk" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_uk)
                myLocale = Locale("uk", "UA")
            }
            "de" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_de)
                myLocale = Locale.GERMAN
            }
            "ru" -> {
                dataBinding.tvselectedlang.text = getString(R.string.text_lang_ru)
                myLocale = Locale("ru", "RU")
            }
            else -> {

            }
        }
        currentLocale = localStorage.voiceLocal
        audioManager?.let {
            volumeLevel = (volume * it.getStreamMaxVolume(AudioManager.STREAM_MUSIC)).toInt()
            it.setStreamVolume(AudioManager.STREAM_MUSIC, volumeLevel, 0)
        }
        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.language = myLocale
            }
        }
        if (SpeechRecognizer.isRecognitionAvailable(requireContext())) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
            setupRecognitionListener()
        }
        dataBinding.etpasscode.setText(localStorage.voicePasscode)
        previousText = localStorage.voicePasscode

        dataBinding.etpasscode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let { string ->
                    if (getLengthWithoutPunctuation(string) == 30) {
                        if(!(getLengthWithoutPunctuation(previousText) == 30 && getLengthWithoutPunctuation(string) == 30)){
                            Toast.makeText(requireContext(), R.string.max_length_exceeded, Toast.LENGTH_SHORT).show()
                        }
                    }
                    previousText = string
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        dataBinding.btnsavepasscode.setOnClickListener {
            if(localStorage.isFirstSavePasscodeTexttoVoiceClick){
                AppConfig.logEventTracking(TEXT_TO_VOICE_SAVE_PASSCODE_FIRST)
                localStorage.isFirstSavePasscodeTexttoVoiceClick = false
            }else{
                AppConfig.logEventTracking(TEXT_TO_VOICE_SAVE_PASSCODE_AGAIN)
            }
            if (dataBinding.etpasscode.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.please_record_something), Toast.LENGTH_SHORT).show()
                localStorage.voiceLocal = currentLocale
            }else{
                val text = dataBinding.etpasscode.text.toString()
                localStorage.voicePasscode =  dataBinding.etpasscode.text.toString()
                localStorage.voiceRealPasscode =  dataBinding.etpasscode.text.toString()
                localStorage.voiceLocal = currentLocale

                textToSpeech?.setOnUtteranceProgressListener(object: UtteranceProgressListener(){
                    override fun onStart(utteranceId: String?) {
                        println("onStart")
                    }

                    override fun onDone(utteranceId: String?) {
                        println("onDone")
                        // call back when TTS is done
                        activity?.runOnUiThread  {
                            outputFile?.let {
                                println("File saved on ${outputFile!!.absolutePath} wit size: ${outputFile!!.length()/1024}")
                            }
                            try{

                                val languageTag = when (currentLocale) {
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

                                val recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageTag)
                                    putExtra("android.speech.extra.DICTATION_MODE", true)
                                    putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                                    putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
                                    putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, false)

                                    // Pass the audio file URI
                                    outputFile?.let {
                                        val recordingParcel = ParcelFileDescriptor.open(outputFile!!, ParcelFileDescriptor.MODE_READ_ONLY)
                                        val input = ParcelFileDescriptor.AutoCloseInputStream(recordingParcel)

                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                                            putExtra(RecognizerIntent.EXTRA_AUDIO_SOURCE, recordingParcel)
                                            putExtra(RecognizerIntent.EXTRA_AUDIO_SOURCE_ENCODING, AudioFormat.ENCODING_PCM_16BIT)
                                            putExtra(RecognizerIntent.EXTRA_AUDIO_SOURCE_CHANNEL_COUNT, 1)
                                            putExtra(RecognizerIntent.EXTRA_AUDIO_SOURCE_SAMPLING_RATE, 16000)
                                        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                                            val uri = Uri.parse("file:///android_asset/raw/greeting.mp3")
                                            FileInputStream(outputFile!!).use { inputStream ->
                                                val audioUri = FileProvider.getUriForFile(
                                                    requireContext(),
                                                    "${requireContext().packageName}.fileprovider",
                                                    outputFile!!
                                                )
                                                println("outputFile: ${audioUri}")
                                                putExtra(
                                                    RecognizerIntent.EXTRA_AUDIO_INJECT_SOURCE,
                                                    uri
                                                )
                                            }
                                        }
                                    }
                                }
                                speechRecognizer?.startListening(recognizerIntent)

                            } catch (e: Exception) {
                                println("Error: ${e.message}")
                            }
//                            speechRecognizer?.startListening(RecognizerIntent.getVoiceDetailsIntent(requireContext()))
                        }
                    }

                    override fun onError(utteranceId: String?) {}
                })
                val utteranceId = UUID.randomUUID().toString()
                val params = Bundle()
                params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId)
                val myDir = File(requireContext().filesDir, "audio")
                if(!myDir.exists()){
                    myDir.mkdirs()
                }
                outputFile = File(myDir, "record_passcode.wav")

                textToSpeech?.synthesizeToFile("123  " + text, params, outputFile, utteranceId)
            }
//            findNavControllerSafety()?.popBackStack()
        }

        dataBinding.btnlistenpasscode.setOnClickListener {
            if(localStorage.isFirstListenTexttoVoiceClick){
                AppConfig.logEventTracking(TEXT_TO_VOICE_LISTEN_FIRST)
                localStorage.isFirstListenTexttoVoiceClick = false
            }else{
                AppConfig.logEventTracking(TEXT_TO_VOICE_LISTEN_AGAIN)
            }
            if (dataBinding.etpasscode.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.please_record_something), Toast.LENGTH_SHORT).show()
            }else{
                textToSpeech?.speak(dataBinding.etpasscode.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null)
            }

        }

        dataBinding.selectlanguage.setOnClickListener {
            if(localStorage.isFirstSelectLanguageTexttoVoiceClick){
                AppConfig.logEventTracking(TEXT_TO_VOICE_SELECT_LANGUAGE_FIRST)
                localStorage.isFirstSelectLanguageTexttoVoiceClick = false
            }else{
                AppConfig.logEventTracking(TEXT_TO_VOICE_SELECT_LANGUAGE_AGAIN)
            }
            showLanguageSelectionDialog()
        }

        dataBinding.btnBack.setOnClickListener {
            findNavControllerSafety()?.navigateUp()
        }

        dataBinding.btnCancel.setOnClickListener {
            speechRecognizer?.stopListening()
            textToSpeech?.stop()
            findNavControllerSafety()?.navigateUp()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    fun getLengthWithoutPunctuation(input: String): Int {
        // Loại bỏ các ký tự dấu câu bằng regex và chỉ giữ lại chữ và số
        val withoutPunctuation = input.replace("\\p{Punct}".toRegex(), "")
        return withoutPunctuation.length
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
        val radioButtonPortuguese = dialogView.findViewById<RadioButton>(R.id.radioButtonPortuguesev)
        val radioButtonUkrainian = dialogView.findViewById<RadioButton>(R.id.radioButtonUkrainianv)
        val radioButtonGerman = dialogView.findViewById<RadioButton>(R.id.radioButtonGermanv)
        val radioButtonRussian = dialogView.findViewById<RadioButton>(R.id.radioButtonRussianv)

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
            "pt" -> radioButtonPortuguese.isChecked = true
            "uk" -> radioButtonUkrainian.isChecked = true
            "de" -> radioButtonGerman.isChecked = true
            "ru" -> radioButtonRussian.isChecked = true
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
            myLocale = Locale(currentLocale)
            textToSpeech = TextToSpeech(requireContext()) { status ->
                if (status != TextToSpeech.ERROR) {
                    textToSpeech?.language = myLocale
                }
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
    }

    override fun onBackPressed(): Boolean {
        speechRecognizer?.stopListening()
        textToSpeech?.stop()
        return super.onBackPressed()
    }

    override fun onStop() {
        speechRecognizer?.stopListening()
        textToSpeech?.stop()
        super.onStop()
    }

    override fun onPause() {
        speechRecognizer?.stopListening()
        textToSpeech?.stop()
        super.onPause()
    }

    private fun setupRecognitionListener() {
        recognitionListener = object : RecognitionListener {
            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                matches?.let { resultList ->
                    // Process the first result to ensure numbers are in word form
                    val firstResult = resultList.firstOrNull()
                    if(!firstResult.isNullOrEmpty()){
                        val tempString = firstResult.substring(3, firstResult.length).trim()
                        if(tempString.matches(".*\\d.*".toRegex())){
                            localStorage.voiceRealPasscode = tempString.trim()
                        } else {
                            localStorage.voiceRealPasscode = dataBinding.etpasscode.text.toString().trim()
                        }
                        println("Result without 123: ${localStorage.voiceRealPasscode}")
                        speechRecognizer?.stopListening()
                        findNavControllerSafety()?.popBackStack()
                    }
//                    println("First result: $firstResult")
//                    findNavControllerSafety()?.popBackStack()
                }
            }

            // Implement other RecognitionListener methods
            override fun onReadyForSpeech(params: Bundle?) {
                println("onReadyForSpeech")
            }
            override fun onBeginningOfSpeech() {
                println("onBeginningOfSpeech")
            }
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {
                println("onEndOfSpeech")
                if(findNavControllerSafety()?.currentDestination?.id == R.id.textToVoiceFragment){
                    speechRecognizer?.stopListening()
                    findNavControllerSafety()?.popBackStack()
                }
            }
            override fun onError(error: Int) {
                val errorMessage = when (error) {
                    SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
                    SpeechRecognizer.ERROR_CLIENT -> "Client side error"
                    SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions"
                    SpeechRecognizer.ERROR_NETWORK -> "Network error"
                    SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout"
                    SpeechRecognizer.ERROR_NO_MATCH -> "No match found"
                    SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "RecognitionService busy"
                    SpeechRecognizer.ERROR_SERVER -> "Server error"
                    SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input"
                    else -> "Unknown error"
                }
                activity?.runOnUiThread {
                    println("stt error: $errorMessage")
                }
                if(findNavControllerSafety()?.currentDestination?.id == R.id.textToVoiceFragment){
                    speechRecognizer?.stopListening()
                    findNavControllerSafety()?.popBackStack()
                }
            }
            override fun onPartialResults(partialResults: Bundle?) {
                val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                matches?.let { resultList ->
                    // Process the first result to ensure numbers are in word form
                    val firstResult = resultList.firstOrNull()
                    println("Partial result: $firstResult")
                    if(!firstResult.isNullOrEmpty()){
                        val tempString =  firstResult.substring(3, firstResult.length).trim()
                        if(tempString.matches(".*\\d.*".toRegex())){
                            localStorage.voiceRealPasscode = tempString.trim()
                        } else {
                            localStorage.voiceRealPasscode = dataBinding.etpasscode.text.toString().trim()
                        }
                        println("Partial result without 123: ${localStorage.voiceRealPasscode}")
                        speechRecognizer?.stopListening()
                        findNavControllerSafety()?.popBackStack()
                    }
//                    localStorage.voiceRealPasscode = firstResult
                }
            }
            override fun onEvent(eventType: Int, params: Bundle?) {}
        }

        speechRecognizer?.setRecognitionListener(recognitionListener)
    }

    override fun registerListeners() {

    }

    override fun initializeData() {

    }

}
