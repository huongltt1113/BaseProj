package com.dev.baseproject.ui.component.sound;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/dev/baseproject/ui/component/sound/ChooseSoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/dev/baseproject/ui/component/sound/ChooseSoundAdapter$SoundViewHolder;", "soundList", "", "Lcom/dev/baseproject/data/entity/SoundItem;", "onClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SoundViewHolder", "app_debug"})
public final class ChooseSoundAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.dev.baseproject.ui.component.sound.ChooseSoundAdapter.SoundViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.dev.baseproject.data.entity.SoundItem> soundList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onClick = null;
    
    public ChooseSoundAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dev.baseproject.data.entity.SoundItem> soundList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.dev.baseproject.ui.component.sound.ChooseSoundAdapter.SoundViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.ui.component.sound.ChooseSoundAdapter.SoundViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/dev/baseproject/ui/component/sound/ChooseSoundAdapter$SoundViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/dev/baseproject/databinding/ItemChooseSoundBinding;", "(Lcom/dev/baseproject/ui/component/sound/ChooseSoundAdapter;Lcom/dev/baseproject/databinding/ItemChooseSoundBinding;)V", "onBind", "", "item", "Lcom/dev/baseproject/data/entity/SoundItem;", "app_debug"})
    public final class SoundViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.dev.baseproject.databinding.ItemChooseSoundBinding binding = null;
        
        public SoundViewHolder(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.databinding.ItemChooseSoundBinding binding) {
            super(null);
        }
        
        public final void onBind(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.data.entity.SoundItem item) {
        }
    }
}