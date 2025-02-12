package com.dev.baseproject.ui.component.sound;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/dev/baseproject/ui/component/sound/ChooseSoundEffectFragment;", "Lcom/dev/baseproject/ui/base/BaseFragmentBinding;", "Lcom/dev/baseproject/databinding/FragmentChooseSoundEffectBinding;", "onSoundClick", "Lkotlin/Function1;", "Lcom/dev/baseproject/data/entity/SoundItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "allSoundListSound", "", "getOnSoundClick", "()Lkotlin/jvm/functions/Function1;", "soundAdapter", "Lcom/dev/baseproject/ui/component/home/adapter/SoundAdapter;", "getContentViewId", "", "initializeData", "initializeViews", "registerListeners", "setupRecyclerView", "app_debug"})
public final class ChooseSoundEffectFragment extends com.dev.baseproject.ui.base.BaseFragmentBinding<com.dev.baseproject.databinding.FragmentChooseSoundEffectBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onSoundClick = null;
    private com.dev.baseproject.ui.component.home.adapter.SoundAdapter soundAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.dev.baseproject.data.entity.SoundItem> allSoundListSound = null;
    
    public ChooseSoundEffectFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onSoundClick) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> getOnSoundClick() {
        return null;
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
    
    @java.lang.Override()
    public void initializeData() {
    }
    
    private final void setupRecyclerView() {
    }
    
    public ChooseSoundEffectFragment() {
        super();
    }
}