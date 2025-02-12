package com.dev.baseproject.ui.component.home.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bBS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\n2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/dev/baseproject/ui/component/home/adapter/SoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/dev/baseproject/ui/component/home/adapter/SoundAdapter$SoundViewHolder;", "itemList", "", "Lcom/dev/baseproject/data/entity/SoundItem;", "selectedResourceId", "", "onClick", "Lkotlin/Function1;", "", "isShowLabel", "", "itemWidth", "spacing", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "previousSelectedPosition", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SoundViewHolder", "app_debug"})
public final class SoundAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.dev.baseproject.ui.component.home.adapter.SoundAdapter.SoundViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.dev.baseproject.data.entity.SoundItem> itemList;
    private int selectedResourceId;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isShowLabel = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer itemWidth = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer spacing = null;
    private int previousSelectedPosition = 0;
    
    public SoundAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dev.baseproject.data.entity.SoundItem> itemList, int selectedResourceId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.dev.baseproject.data.entity.SoundItem, kotlin.Unit> onClick, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isShowLabel, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemWidth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer spacing) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.dev.baseproject.ui.component.home.adapter.SoundAdapter.SoundViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.ui.component.home.adapter.SoundAdapter.SoundViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/dev/baseproject/ui/component/home/adapter/SoundAdapter$SoundViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/dev/baseproject/databinding/ItemSoundBinding;", "(Lcom/dev/baseproject/ui/component/home/adapter/SoundAdapter;Lcom/dev/baseproject/databinding/ItemSoundBinding;)V", "onBind", "", "item", "Lcom/dev/baseproject/data/entity/SoundItem;", "app_debug"})
    public final class SoundViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.dev.baseproject.databinding.ItemSoundBinding viewBinding = null;
        
        public SoundViewHolder(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.databinding.ItemSoundBinding viewBinding) {
            super(null);
        }
        
        public final void onBind(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.data.entity.SoundItem item) {
        }
    }
}