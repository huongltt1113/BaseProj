package com.dev.baseproject.ui.component.home.fragment;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/dev/baseproject/ui/component/home/fragment/RecordPassCodeFragment;", "Lcom/dev/baseproject/ui/base/BaseFragmentBinding;", "Lcom/dev/baseproject/databinding/FragmentRecordPassCodeBinding;", "Landroid/speech/RecognitionListener;", "()V", "currentLocale", "", "isListening", "", "recognizerIntent", "Landroid/content/Intent;", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "getContentViewId", "", "initializeData", "", "initializeViews", "onBeginningOfSpeech", "onBufferReceived", "p0", "", "onDestroy", "onEndOfSpeech", "onError", "onEvent", "p1", "Landroid/os/Bundle;", "onPartialResults", "onReadyForSpeech", "onResults", "onRmsChanged", "", "processRecognitionResult", "text", "registerListeners", "resetSpeechRecognizer", "setRecognizerIntent", "language", "showLanguageSelectionDialog", "startListening", "stopListening", "updateLanguage", "locale", "languageResId", "Companion", "app_debug"})
public final class RecordPassCodeFragment extends com.dev.baseproject.ui.base.BaseFragmentBinding<com.dev.baseproject.databinding.FragmentRecordPassCodeBinding> implements android.speech.RecognitionListener {
    private boolean isListening = false;
    @org.jetbrains.annotations.Nullable()
    private android.content.Intent recognizerIntent;
    @org.jetbrains.annotations.Nullable()
    private android.speech.SpeechRecognizer speechRecognizer;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentLocale = "en";
    public static final float RMS_THRESHOLD = 1.0F;
    public static final int SILENCE_COUNT_THRESHOLD = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ui.component.home.fragment.RecordPassCodeFragment.Companion Companion = null;
    
    public RecordPassCodeFragment() {
        super();
    }
    
    @java.lang.Override()
    public int getContentViewId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    private final void showLanguageSelectionDialog() {
    }
    
    private final void updateLanguage(java.lang.String locale, int languageResId) {
    }
    
    @java.lang.Override()
    public void registerListeners() {
    }
    
    @java.lang.Override()
    public void initializeData() {
    }
    
    @java.lang.Override()
    public void onReadyForSpeech(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onBeginningOfSpeech() {
    }
    
    @java.lang.Override()
    public void onRmsChanged(float p0) {
    }
    
    @java.lang.Override()
    public void onBufferReceived(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    @java.lang.Override()
    public void onEndOfSpeech() {
    }
    
    @java.lang.Override()
    public void onError(int p0) {
    }
    
    @java.lang.Override()
    public void onResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    private final java.lang.String processRecognitionResult(java.lang.String text) {
        return null;
    }
    
    @java.lang.Override()
    public void onPartialResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onEvent(int p0, @org.jetbrains.annotations.Nullable()
    android.os.Bundle p1) {
    }
    
    private final void resetSpeechRecognizer() {
    }
    
    private final void setRecognizerIntent(java.lang.String language) {
    }
    
    private final void startListening() {
    }
    
    private final void stopListening() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/dev/baseproject/ui/component/home/fragment/RecordPassCodeFragment$Companion;", "", "()V", "RMS_THRESHOLD", "", "SILENCE_COUNT_THRESHOLD", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}