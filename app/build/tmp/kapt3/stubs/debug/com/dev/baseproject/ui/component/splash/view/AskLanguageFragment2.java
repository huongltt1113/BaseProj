package com.dev.baseproject.ui.component.splash.view;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\nH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/dev/baseproject/ui/component/splash/view/AskLanguageFragment2;", "Lcom/dev/baseproject/ui/base/BaseFragmentBinding;", "Lcom/dev/baseproject/databinding/FragmentAskLanguageBinding;", "()V", "isChooseLanguage", "", "Ljava/lang/Boolean;", "langCode", "", "lastCheckedId", "", "Ljava/lang/Integer;", "scrollPosition", "warningBottomSheet", "Lcom/dev/baseproject/ui/component/splash/dialog/WarningBottomSheet;", "bindViewItemSelected", "", "getContentViewId", "getItemFromId", "Landroid/view/View;", "id", "getLangCodeFromId", "initWarningBottomSheet", "initializeData", "initializeViews", "onBackPressed", "registerListeners", "resetViewItem", "trackLanguageSelection", "updateLanguageLocale", "needRecreate", "updateRadioButtonUI", "checkedId", "LangCode", "app_debug"})
public final class AskLanguageFragment2 extends com.dev.baseproject.ui.base.BaseFragmentBinding<com.dev.baseproject.databinding.FragmentAskLanguageBinding> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String langCode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isChooseLanguage = false;
    @org.jetbrains.annotations.Nullable()
    private com.dev.baseproject.ui.component.splash.dialog.WarningBottomSheet warningBottomSheet;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer lastCheckedId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer scrollPosition = 0;
    
    public AskLanguageFragment2() {
        super();
    }
    
    @java.lang.Override()
    public int getContentViewId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    @java.lang.Override()
    public void registerListeners() {
    }
    
    private final void updateLanguageLocale(boolean needRecreate) {
    }
    
    private final java.lang.String getLangCodeFromId(int id) {
        return null;
    }
    
    private final void updateRadioButtonUI(int checkedId) {
    }
    
    private final android.view.View getItemFromId(int id) {
        return null;
    }
    
    private final void trackLanguageSelection() {
    }
    
    @java.lang.Override()
    public void initializeData() {
    }
    
    private final void initWarningBottomSheet() {
    }
    
    private final void resetViewItem() {
    }
    
    private final void bindViewItemSelected() {
    }
    
    @java.lang.Override()
    public boolean onBackPressed() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/dev/baseproject/ui/component/splash/view/AskLanguageFragment2$LangCode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "ENGLISH", "JAPAN", "KOREAN", "HINDI", "CHINA", "VIETNAM", "SPANISH", "PORTUGUESE", "GERMAN", "RUSSIAN", "UKRAIAN", "ABRIC", "TURKEY", "app_debug"})
    public static enum LangCode {
        /*public static final*/ NONE /* = new NONE(null) */,
        /*public static final*/ ENGLISH /* = new ENGLISH(null) */,
        /*public static final*/ JAPAN /* = new JAPAN(null) */,
        /*public static final*/ KOREAN /* = new KOREAN(null) */,
        /*public static final*/ HINDI /* = new HINDI(null) */,
        /*public static final*/ CHINA /* = new CHINA(null) */,
        /*public static final*/ VIETNAM /* = new VIETNAM(null) */,
        /*public static final*/ SPANISH /* = new SPANISH(null) */,
        /*public static final*/ PORTUGUESE /* = new PORTUGUESE(null) */,
        /*public static final*/ GERMAN /* = new GERMAN(null) */,
        /*public static final*/ RUSSIAN /* = new RUSSIAN(null) */,
        /*public static final*/ UKRAIAN /* = new UKRAIAN(null) */,
        /*public static final*/ ABRIC /* = new ABRIC(null) */,
        /*public static final*/ TURKEY /* = new TURKEY(null) */;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String value = null;
        
        LangCode(java.lang.String value) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.dev.baseproject.ui.component.splash.view.AskLanguageFragment2.LangCode> getEntries() {
            return null;
        }
    }
}