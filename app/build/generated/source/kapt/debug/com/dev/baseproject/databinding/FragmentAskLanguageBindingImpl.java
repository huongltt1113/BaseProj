package com.dev.baseproject.databinding;
import com.dev.baseproject.R;
import com.dev.baseproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAskLanguageBindingImpl extends FragmentAskLanguageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(31);
        sIncludes.setIncludes(0, 
            new String[] {"native_ad_unified"},
            new int[] {1},
            new int[] {com.dev.baseproject.R.layout.native_ad_unified});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtNext, 2);
        sViewsWithIds.put(R.id.scvLanguage, 3);
        sViewsWithIds.put(R.id.itemHindi, 4);
        sViewsWithIds.put(R.id.itemGerman, 5);
        sViewsWithIds.put(R.id.itemSpanish, 6);
        sViewsWithIds.put(R.id.itemPortuguase, 7);
        sViewsWithIds.put(R.id.itemEnglish, 8);
        sViewsWithIds.put(R.id.itemVietNam, 9);
        sViewsWithIds.put(R.id.itemTurkey, 10);
        sViewsWithIds.put(R.id.itemRussian, 11);
        sViewsWithIds.put(R.id.itemUkraian, 12);
        sViewsWithIds.put(R.id.itemJapan, 13);
        sViewsWithIds.put(R.id.itemKorean, 14);
        sViewsWithIds.put(R.id.itemChina, 15);
        sViewsWithIds.put(R.id.itemAbric, 16);
        sViewsWithIds.put(R.id.radio_group, 17);
        sViewsWithIds.put(R.id.rbt_hindi, 18);
        sViewsWithIds.put(R.id.rbt_german, 19);
        sViewsWithIds.put(R.id.rbt_spanish, 20);
        sViewsWithIds.put(R.id.rbt_portuguase, 21);
        sViewsWithIds.put(R.id.rbt_english, 22);
        sViewsWithIds.put(R.id.rbt_vietnam, 23);
        sViewsWithIds.put(R.id.rbt_turkey, 24);
        sViewsWithIds.put(R.id.rbt_russian, 25);
        sViewsWithIds.put(R.id.rbt_ukraian, 26);
        sViewsWithIds.put(R.id.rbt_japan, 27);
        sViewsWithIds.put(R.id.rbt_korean, 28);
        sViewsWithIds.put(R.id.rbt_china, 29);
        sViewsWithIds.put(R.id.rbt_abric, 30);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentAskLanguageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private FragmentAskLanguageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[16]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[15]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[8]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[5]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[4]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[13]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[14]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[7]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[11]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[6]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[10]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[12]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[9]
            , (com.dev.baseproject.databinding.NativeAdUnifiedBinding) bindings[1]
            , (android.widget.RadioGroup) bindings[17]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.RadioButton) bindings[29]
            , (android.widget.RadioButton) bindings[22]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RadioButton) bindings[18]
            , (android.widget.RadioButton) bindings[27]
            , (android.widget.RadioButton) bindings[28]
            , (android.widget.RadioButton) bindings[21]
            , (android.widget.RadioButton) bindings[25]
            , (android.widget.RadioButton) bindings[20]
            , (android.widget.RadioButton) bindings[24]
            , (android.widget.RadioButton) bindings[26]
            , (android.widget.RadioButton) bindings[23]
            , (android.widget.ScrollView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.nativeAskLanguge);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        nativeAskLanguge.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (nativeAskLanguge.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        nativeAskLanguge.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNativeAskLanguge((com.dev.baseproject.databinding.NativeAdUnifiedBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNativeAskLanguge(com.dev.baseproject.databinding.NativeAdUnifiedBinding NativeAskLanguge, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(nativeAskLanguge);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): nativeAskLanguge
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}