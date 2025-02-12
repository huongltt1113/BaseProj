package com.dev.baseproject.ui.component.setting;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\bH\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/dev/baseproject/ui/component/setting/SettingLanguageFragment;", "Lcom/dev/baseproject/ui/base/BaseViewModelFragmentBinding;", "Lcom/dev/baseproject/databinding/FragmentSettingLanguageBinding;", "Lcom/dev/baseproject/ui/component/splash/viewmodel/SettingViewModel;", "()V", "confirmApplyLanguageBottomSheet", "Lcom/dev/baseproject/ui/component/splash/dialog/ConfirmApplyLanguageBottomSheet;", "isChangeLanguage", "", "langCode", "", "scrollPosition", "", "Ljava/lang/Integer;", "bindViewItemSelected", "", "getContentViewId", "getLocalizedContext", "Landroid/content/Context;", "context", "locale", "Ljava/util/Locale;", "initializeData", "initializeViews", "onBackPressed", "onDestroy", "onPause", "onResume", "registerListeners", "resetViewItem", "updateLanguage", "languageCode", "updateLanguageLocale", "needRecreate", "Companion", "app_debug"})
public final class SettingLanguageFragment extends com.dev.baseproject.ui.base.BaseViewModelFragmentBinding<com.dev.baseproject.databinding.FragmentSettingLanguageBinding, com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel> {
    private boolean isChangeLanguage = true;
    @org.jetbrains.annotations.Nullable()
    private com.dev.baseproject.ui.component.splash.dialog.ConfirmApplyLanguageBottomSheet confirmApplyLanguageBottomSheet;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String langCode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer scrollPosition = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ui.component.setting.SettingLanguageFragment.Companion Companion = null;
    
    public SettingLanguageFragment() {
        super();
    }
    
    @java.lang.Override()
    public int getContentViewId() {
        return 0;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void initializeViews() {
    }
    
    @java.lang.Override()
    public void registerListeners() {
    }
    
    @java.lang.Override()
    public boolean onBackPressed() {
        return false;
    }
    
    @java.lang.Override()
    public void initializeData() {
    }
    
    private final void updateLanguage(java.lang.String languageCode) {
    }
    
    protected final void updateLanguageLocale(boolean needRecreate) {
    }
    
    private final void resetViewItem() {
    }
    
    private final void bindViewItemSelected() {
    }
    
    private final android.content.Context getLocalizedContext(android.content.Context context, java.util.Locale locale) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/dev/baseproject/ui/component/setting/SettingLanguageFragment$Companion;", "", "()V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}