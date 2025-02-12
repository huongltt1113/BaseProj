package com.dev.baseproject;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.dev.baseproject.ads.GoogleMobileAdsConsentManager;
import com.dev.baseproject.data.AppDatabase;
import com.dev.baseproject.data.dao.ClickerDao;
import com.dev.baseproject.di.AppModule;
import com.dev.baseproject.di.AppModule_DatabaseNameFactory;
import com.dev.baseproject.di.AppModule_PreferencesNameFactory;
import com.dev.baseproject.di.AppModule_ProviderCMPFactory;
import com.dev.baseproject.di.AppModule_ProviderMobileIdFactory;
import com.dev.baseproject.di.NetworkModule_ListenerResponseFactory;
import com.dev.baseproject.di.NetworkModule_ProvideLoggingInterceptorFactory;
import com.dev.baseproject.di.NetworkModule_ProvideOkHttpClientFactory;
import com.dev.baseproject.di.NetworkModule_ProvidePostApiFactory;
import com.dev.baseproject.di.NetworkModule_ProvideRetrofitInterfaceFactory;
import com.dev.baseproject.di.StorageModule;
import com.dev.baseproject.di.StorageModule_AppDatabaseFactory;
import com.dev.baseproject.di.StorageModule_FileHelperFactory;
import com.dev.baseproject.di.StorageModule_ProvideClickDaoFactory;
import com.dev.baseproject.di.StorageModule_ProvideLocalRepositoryFactory;
import com.dev.baseproject.local.LocalData;
import com.dev.baseproject.local.LocalStorage;
import com.dev.baseproject.repository.FileHelper;
import com.dev.baseproject.repository.FileHelperImpl;
import com.dev.baseproject.repository.ScriptRepository;
import com.dev.baseproject.server.ApiClient;
import com.dev.baseproject.server.Network;
import com.dev.baseproject.services.ClapDetectionService;
import com.dev.baseproject.services.ClapDetectionService_MembersInjector;
import com.dev.baseproject.services.MotionDetectionService;
import com.dev.baseproject.services.MotionDetectionService_MembersInjector;
import com.dev.baseproject.services.PocketDetectionService;
import com.dev.baseproject.services.PocketDetectionService_MembersInjector;
import com.dev.baseproject.services.VoiceDetectionService;
import com.dev.baseproject.services.VoiceDetectionService_MembersInjector;
import com.dev.baseproject.ui.MainActivity;
import com.dev.baseproject.ui.MainViewModel;
import com.dev.baseproject.ui.MainViewModel_Factory;
import com.dev.baseproject.ui.MainViewModel_HiltModules;
import com.dev.baseproject.ui.base.BaseActivityBinding_MembersInjector;
import com.dev.baseproject.ui.base.BaseActivity_MembersInjector;
import com.dev.baseproject.ui.base.BaseFragment_MembersInjector;
import com.dev.baseproject.ui.base.BaseViewModel_MembersInjector;
import com.dev.baseproject.ui.component.findphone.PhoneFoundActivity;
import com.dev.baseproject.ui.component.home.fragment.CountDownFragment;
import com.dev.baseproject.ui.component.home.fragment.CreatePasscodeFragment;
import com.dev.baseproject.ui.component.home.fragment.HomeFragment;
import com.dev.baseproject.ui.component.home.fragment.HowToUseFragment;
import com.dev.baseproject.ui.component.home.fragment.RecordPassCodeFragment;
import com.dev.baseproject.ui.component.home.fragment.TextToVoiceFragment;
import com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel;
import com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel_Factory;
import com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel_HiltModules;
import com.dev.baseproject.ui.component.permission.GrantPermissionFragment;
import com.dev.baseproject.ui.component.setting.SettingFragment;
import com.dev.baseproject.ui.component.setting.SettingLanguageFragment;
import com.dev.baseproject.ui.component.sound.ChooseFunnyFragment;
import com.dev.baseproject.ui.component.sound.ChooseMelodyFragment;
import com.dev.baseproject.ui.component.sound.ChooseSoundEffectFragment;
import com.dev.baseproject.ui.component.sound.ChooseSoundFragment;
import com.dev.baseproject.ui.component.sound.SoundDetailFragment;
import com.dev.baseproject.ui.component.splash.view.AskLanguageFragment;
import com.dev.baseproject.ui.component.splash.view.AskLanguageFragment2;
import com.dev.baseproject.ui.component.splash.view.IntroFragment;
import com.dev.baseproject.ui.component.splash.view.SplashFragment;
import com.dev.baseproject.ui.component.splash.view.SplashFragment_MembersInjector;
import com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel;
import com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel_Factory;
import com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel_HiltModules;
import com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel;
import com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel_Factory;
import com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel_HiltModules;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DaggerApp_HiltComponents_SingletonC {
  private DaggerApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private AppModule appModule;

    private ApplicationContextModule applicationContextModule;

    private StorageModule storageModule;

    private Builder() {
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder storageModule(StorageModule storageModule) {
      this.storageModule = Preconditions.checkNotNull(storageModule);
      return this;
    }

    public App_HiltComponents.SingletonC build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (storageModule == null) {
        this.storageModule = new StorageModule();
      }
      return new SingletonCImpl(appModule, applicationContextModule, storageModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public App_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements App_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public App_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends App_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectCountDownFragment(CountDownFragment countDownFragment) {
      injectCountDownFragment2(countDownFragment);
    }

    @Override
    public void injectCreatePasscodeFragment(CreatePasscodeFragment createPasscodeFragment) {
      injectCreatePasscodeFragment2(createPasscodeFragment);
    }

    @Override
    public void injectHomeFragment(HomeFragment homeFragment) {
      injectHomeFragment2(homeFragment);
    }

    @Override
    public void injectHowToUseFragment(HowToUseFragment howToUseFragment) {
      injectHowToUseFragment2(howToUseFragment);
    }

    @Override
    public void injectRecordPassCodeFragment(RecordPassCodeFragment recordPassCodeFragment) {
      injectRecordPassCodeFragment2(recordPassCodeFragment);
    }

    @Override
    public void injectTextToVoiceFragment(TextToVoiceFragment textToVoiceFragment) {
      injectTextToVoiceFragment2(textToVoiceFragment);
    }

    @Override
    public void injectGrantPermissionFragment(GrantPermissionFragment grantPermissionFragment) {
      injectGrantPermissionFragment2(grantPermissionFragment);
    }

    @Override
    public void injectSettingFragment(SettingFragment settingFragment) {
      injectSettingFragment2(settingFragment);
    }

    @Override
    public void injectSettingLanguageFragment(SettingLanguageFragment settingLanguageFragment) {
      injectSettingLanguageFragment2(settingLanguageFragment);
    }

    @Override
    public void injectChooseFunnyFragment(ChooseFunnyFragment chooseFunnyFragment) {
      injectChooseFunnyFragment2(chooseFunnyFragment);
    }

    @Override
    public void injectChooseMelodyFragment(ChooseMelodyFragment chooseMelodyFragment) {
      injectChooseMelodyFragment2(chooseMelodyFragment);
    }

    @Override
    public void injectChooseSoundEffectFragment(
        ChooseSoundEffectFragment chooseSoundEffectFragment) {
      injectChooseSoundEffectFragment2(chooseSoundEffectFragment);
    }

    @Override
    public void injectChooseSoundFragment(ChooseSoundFragment chooseSoundFragment) {
      injectChooseSoundFragment2(chooseSoundFragment);
    }

    @Override
    public void injectSoundDetailFragment(SoundDetailFragment soundDetailFragment) {
      injectSoundDetailFragment2(soundDetailFragment);
    }

    @Override
    public void injectAskLanguageFragment2(AskLanguageFragment2 askLanguageFragment2) {
      injectAskLanguageFragment22(askLanguageFragment2);
    }

    @Override
    public void injectAskLanguageFragment(AskLanguageFragment askLanguageFragment) {
      injectAskLanguageFragment3(askLanguageFragment);
    }

    @Override
    public void injectIntroFragment(IntroFragment introFragment) {
      injectIntroFragment2(introFragment);
    }

    @Override
    public void injectSplashFragment(SplashFragment splashFragment) {
      injectSplashFragment2(splashFragment);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @CanIgnoreReturnValue
    private CountDownFragment injectCountDownFragment2(CountDownFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private CreatePasscodeFragment injectCreatePasscodeFragment2(CreatePasscodeFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private HomeFragment injectHomeFragment2(HomeFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private HowToUseFragment injectHowToUseFragment2(HowToUseFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private RecordPassCodeFragment injectRecordPassCodeFragment2(RecordPassCodeFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private TextToVoiceFragment injectTextToVoiceFragment2(TextToVoiceFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private GrantPermissionFragment injectGrantPermissionFragment2(
        GrantPermissionFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SettingFragment injectSettingFragment2(SettingFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SettingLanguageFragment injectSettingLanguageFragment2(
        SettingLanguageFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private ChooseFunnyFragment injectChooseFunnyFragment2(ChooseFunnyFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private ChooseMelodyFragment injectChooseMelodyFragment2(ChooseMelodyFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private ChooseSoundEffectFragment injectChooseSoundEffectFragment2(
        ChooseSoundEffectFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private ChooseSoundFragment injectChooseSoundFragment2(ChooseSoundFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SoundDetailFragment injectSoundDetailFragment2(SoundDetailFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private AskLanguageFragment2 injectAskLanguageFragment22(AskLanguageFragment2 instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private AskLanguageFragment injectAskLanguageFragment3(AskLanguageFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private IntroFragment injectIntroFragment2(IntroFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SplashFragment injectSplashFragment2(SplashFragment instance) {
      BaseFragment_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseFragment_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseFragment_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      SplashFragment_MembersInjector.injectGoogleMobileAdsConsentManager(instance, singletonCImpl.providerCMPProvider.get());
      return instance;
    }
  }

  private static final class ViewCImpl extends App_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends App_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
      injectMainActivity2(mainActivity);
    }

    @Override
    public void injectPhoneFoundActivity(PhoneFoundActivity phoneFoundActivity) {
      injectPhoneFoundActivity2(phoneFoundActivity);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>of(LazyClassKeyProvider.com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_dev_baseproject_ui_MainViewModel, MainViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel, SettingViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel, TopicViewModel_HiltModules.KeyModule.provide()));
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      BaseActivity_MembersInjector.injectDatabase(instance, singletonCImpl.appDatabaseProvider.get());
      BaseActivityBinding_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private PhoneFoundActivity injectPhoneFoundActivity2(PhoneFoundActivity instance) {
      BaseActivity_MembersInjector.injectDatabase(instance, singletonCImpl.appDatabaseProvider.get());
      BaseActivityBinding_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_dev_baseproject_ui_MainViewModel = "com.dev.baseproject.ui.MainViewModel";

      static String com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel = "com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel";

      static String com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel = "com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel";

      static String com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel = "com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel";

      @KeepFieldType
      MainViewModel com_dev_baseproject_ui_MainViewModel2;

      @KeepFieldType
      HomeViewModel com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel2;

      @KeepFieldType
      TopicViewModel com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel2;

      @KeepFieldType
      SettingViewModel com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel2;
    }
  }

  private static final class ViewModelCImpl extends App_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<SettingViewModel> settingViewModelProvider;

    private Provider<TopicViewModel> topicViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.settingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.topicViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>of(LazyClassKeyProvider.com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel, ((Provider) homeViewModelProvider), LazyClassKeyProvider.com_dev_baseproject_ui_MainViewModel, ((Provider) mainViewModelProvider), LazyClassKeyProvider.com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel, ((Provider) settingViewModelProvider), LazyClassKeyProvider.com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel, ((Provider) topicViewModelProvider)));
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @CanIgnoreReturnValue
    private HomeViewModel injectHomeViewModel(HomeViewModel instance) {
      BaseViewModel_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseViewModel_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseViewModel_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private MainViewModel injectMainViewModel(MainViewModel instance) {
      BaseViewModel_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseViewModel_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseViewModel_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SettingViewModel injectSettingViewModel(SettingViewModel instance) {
      BaseViewModel_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseViewModel_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseViewModel_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private TopicViewModel injectTopicViewModel(TopicViewModel instance) {
      BaseViewModel_MembersInjector.injectApiClient(instance, singletonCImpl.providePostApiProvider.get());
      BaseViewModel_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      BaseViewModel_MembersInjector.injectFileHelper(instance, singletonCImpl.fileHelperProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel = "com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel";

      static String com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel = "com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel";

      static String com_dev_baseproject_ui_MainViewModel = "com.dev.baseproject.ui.MainViewModel";

      static String com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel = "com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel";

      @KeepFieldType
      HomeViewModel com_dev_baseproject_ui_component_home_viewmodel_HomeViewModel2;

      @KeepFieldType
      SettingViewModel com_dev_baseproject_ui_component_splash_viewmodel_SettingViewModel2;

      @KeepFieldType
      MainViewModel com_dev_baseproject_ui_MainViewModel2;

      @KeepFieldType
      TopicViewModel com_dev_baseproject_ui_component_splash_viewmodel_TopicViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel 
          return (T) viewModelCImpl.injectHomeViewModel(HomeViewModel_Factory.newInstance(singletonCImpl.scriptRepositoryProvider.get()));

          case 1: // com.dev.baseproject.ui.MainViewModel 
          return (T) viewModelCImpl.injectMainViewModel(MainViewModel_Factory.newInstance());

          case 2: // com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel 
          return (T) viewModelCImpl.injectSettingViewModel(SettingViewModel_Factory.newInstance());

          case 3: // com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel 
          return (T) viewModelCImpl.injectTopicViewModel(TopicViewModel_Factory.newInstance());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectClapDetectionService(ClapDetectionService clapDetectionService) {
      injectClapDetectionService2(clapDetectionService);
    }

    @Override
    public void injectMotionDetectionService(MotionDetectionService motionDetectionService) {
      injectMotionDetectionService2(motionDetectionService);
    }

    @Override
    public void injectPocketDetectionService(PocketDetectionService pocketDetectionService) {
      injectPocketDetectionService2(pocketDetectionService);
    }

    @Override
    public void injectVoiceDetectionService(VoiceDetectionService voiceDetectionService) {
      injectVoiceDetectionService2(voiceDetectionService);
    }

    @CanIgnoreReturnValue
    private ClapDetectionService injectClapDetectionService2(ClapDetectionService instance) {
      ClapDetectionService_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private MotionDetectionService injectMotionDetectionService2(MotionDetectionService instance) {
      MotionDetectionService_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private PocketDetectionService injectPocketDetectionService2(PocketDetectionService instance) {
      PocketDetectionService_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private VoiceDetectionService injectVoiceDetectionService2(VoiceDetectionService instance) {
      VoiceDetectionService_MembersInjector.injectLocalStorage(instance, singletonCImpl.provideLocalRepositoryProvider.get());
      return instance;
    }
  }

  private static final class SingletonCImpl extends App_HiltComponents.SingletonC {
    private final AppModule appModule;

    private final ApplicationContextModule applicationContextModule;

    private final StorageModule storageModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<GoogleMobileAdsConsentManager> providerCMPProvider;

    private Provider<String> preferencesNameProvider;

    private Provider<LocalStorage> provideLocalRepositoryProvider;

    private Provider<String> providerMobileIdProvider;

    private Provider<String> databaseNameProvider;

    private Provider<AppDatabase> appDatabaseProvider;

    private Provider<Retrofit> provideRetrofitInterfaceProvider;

    private Provider<ApiClient> providePostApiProvider;

    private Provider<FileHelper> fileHelperProvider;

    private Provider<ClickerDao> provideClickDaoProvider;

    private Provider<ScriptRepository> scriptRepositoryProvider;

    private SingletonCImpl(AppModule appModuleParam,
        ApplicationContextModule applicationContextModuleParam, StorageModule storageModuleParam) {
      this.appModule = appModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      this.storageModule = storageModuleParam;
      initialize(appModuleParam, applicationContextModuleParam, storageModuleParam);

    }

    private LocalData localData() {
      return new LocalData(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule), preferencesNameProvider.get());
    }

    private Network network() {
      return new Network(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    private Interceptor interceptor() {
      return NetworkModule_ListenerResponseFactory.listenerResponse(provideLocalRepositoryProvider.get());
    }

    private OkHttpClient okHttpClient() {
      return NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(NetworkModule_ProvideLoggingInterceptorFactory.provideLoggingInterceptor(), interceptor());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final AppModule appModuleParam,
        final ApplicationContextModule applicationContextModuleParam,
        final StorageModule storageModuleParam) {
      this.providerCMPProvider = DoubleCheck.provider(new SwitchingProvider<GoogleMobileAdsConsentManager>(singletonCImpl, 0));
      this.preferencesNameProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 2));
      this.provideLocalRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<LocalStorage>(singletonCImpl, 1));
      this.providerMobileIdProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 3));
      this.databaseNameProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 5));
      this.appDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 4));
      this.provideRetrofitInterfaceProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 7));
      this.providePostApiProvider = DoubleCheck.provider(new SwitchingProvider<ApiClient>(singletonCImpl, 6));
      this.fileHelperProvider = DoubleCheck.provider(new SwitchingProvider<FileHelper>(singletonCImpl, 8));
      this.provideClickDaoProvider = DoubleCheck.provider(new SwitchingProvider<ClickerDao>(singletonCImpl, 10));
      this.scriptRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ScriptRepository>(singletonCImpl, 9));
    }

    @Override
    public void injectApp(App app) {
      injectApp2(app);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private App injectApp2(App instance) {
      App_MembersInjector.injectGoogleMobileAdsConsentManager(instance, providerCMPProvider.get());
      App_MembersInjector.injectLocalStorage(instance, provideLocalRepositoryProvider.get());
      App_MembersInjector.injectNetwork(instance, network());
      App_MembersInjector.injectAndroidId(instance, providerMobileIdProvider.get());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.dev.baseproject.ads.GoogleMobileAdsConsentManager 
          return (T) AppModule_ProviderCMPFactory.providerCMP(singletonCImpl.appModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.dev.baseproject.local.LocalStorage 
          return (T) StorageModule_ProvideLocalRepositoryFactory.provideLocalRepository(singletonCImpl.storageModule, singletonCImpl.localData());

          case 2: // @com.dev.baseproject.local.PreferenceInfo java.lang.String 
          return (T) AppModule_PreferencesNameFactory.preferencesName(singletonCImpl.appModule);

          case 3: // @com.dev.baseproject.local.MobileIdInfo java.lang.String 
          return (T) AppModule_ProviderMobileIdFactory.providerMobileId(singletonCImpl.appModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.dev.baseproject.data.AppDatabase 
          return (T) StorageModule_AppDatabaseFactory.appDatabase(singletonCImpl.storageModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.databaseNameProvider.get());

          case 5: // @com.dev.baseproject.data.DatabaseInfo java.lang.String 
          return (T) AppModule_DatabaseNameFactory.databaseName(singletonCImpl.appModule);

          case 6: // com.dev.baseproject.server.ApiClient 
          return (T) NetworkModule_ProvidePostApiFactory.providePostApi(singletonCImpl.provideRetrofitInterfaceProvider.get());

          case 7: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitInterfaceFactory.provideRetrofitInterface(singletonCImpl.okHttpClient());

          case 8: // com.dev.baseproject.repository.FileHelper 
          return (T) StorageModule_FileHelperFactory.fileHelper(singletonCImpl.storageModule, new FileHelperImpl());

          case 9: // com.dev.baseproject.repository.ScriptRepository 
          return (T) new ScriptRepository(singletonCImpl.provideClickDaoProvider.get());

          case 10: // com.dev.baseproject.data.dao.ClickerDao 
          return (T) StorageModule_ProvideClickDaoFactory.provideClickDao(singletonCImpl.storageModule, singletonCImpl.appDatabaseProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
