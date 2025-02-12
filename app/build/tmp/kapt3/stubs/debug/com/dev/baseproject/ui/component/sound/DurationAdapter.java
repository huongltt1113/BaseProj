package com.dev.baseproject.ui.component.sound;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J*\u0010\u001f\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00050\u00050\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/dev/baseproject/ui/component/sound/DurationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/dev/baseproject/ui/component/sound/DurationAdapter$DurationViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "diffCallBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "lastPosition", "", "selectedPosition", "getData", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "setSelectedItem", "time", "setSelectedPosition", "updateData", "item", "onSelectDone", "Lkotlin/Function0;", "DurationViewHolder", "app_debug"})
public final class DurationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.dev.baseproject.ui.component.sound.DurationAdapter.DurationViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onItemClick = null;
    private int selectedPosition = -1;
    private int lastPosition = -1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> diffCallBack = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.AsyncListDiffer<java.lang.String> differ = null;
    
    public DurationAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onItemClick) {
        super();
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
    java.lang.String item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSelectDone) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getData() {
        return null;
    }
    
    public final void setSelectedItem(@org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    private final void setSelectedPosition(int position) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.dev.baseproject.ui.component.sound.DurationAdapter.DurationViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.ui.component.sound.DurationAdapter.DurationViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/dev/baseproject/ui/component/sound/DurationAdapter$DurationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/dev/baseproject/databinding/ItemDurationBinding;", "(Lcom/dev/baseproject/ui/component/sound/DurationAdapter;Lcom/dev/baseproject/databinding/ItemDurationBinding;)V", "getBinding", "()Lcom/dev/baseproject/databinding/ItemDurationBinding;", "bindItem", "", "item", "", "app_debug"})
    public final class DurationViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.dev.baseproject.databinding.ItemDurationBinding binding = null;
        
        public DurationViewHolder(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.databinding.ItemDurationBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dev.baseproject.databinding.ItemDurationBinding getBinding() {
            return null;
        }
        
        public final void bindItem(@org.jetbrains.annotations.NotNull()
        java.lang.String item) {
        }
    }
}