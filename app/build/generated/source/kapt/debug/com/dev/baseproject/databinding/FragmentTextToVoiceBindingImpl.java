package com.dev.baseproject.databinding;
import com.dev.baseproject.R;
import com.dev.baseproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTextToVoiceBindingImpl extends FragmentTextToVoiceBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(1, 
            new String[] {"ads_layout_banner"},
            new int[] {2},
            new int[] {com.dev.baseproject.R.layout.ads_layout_banner});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarLayout, 3);
        sViewsWithIds.put(R.id.btnBack, 4);
        sViewsWithIds.put(R.id.heading, 5);
        sViewsWithIds.put(R.id.selectlanguage, 6);
        sViewsWithIds.put(R.id.tvselectedlang, 7);
        sViewsWithIds.put(R.id.etpasscode, 8);
        sViewsWithIds.put(R.id.btnlistenpasscode, 9);
        sViewsWithIds.put(R.id.bottom_view, 10);
        sViewsWithIds.put(R.id.btnCancel, 11);
        sViewsWithIds.put(R.id.btnsavepasscode, 12);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTextToVoiceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentTextToVoiceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.EditText) bindings[8]
            , (android.widget.TextView) bindings[5]
            , (com.dev.baseproject.databinding.AdsLayoutBannerBinding) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            , (android.widget.TextView) bindings[7]
            );
        this.btm1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.regulerBannerAd);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        regulerBannerAd.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (regulerBannerAd.hasPendingBindings()) {
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
        regulerBannerAd.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRegulerBannerAd((com.dev.baseproject.databinding.AdsLayoutBannerBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRegulerBannerAd(com.dev.baseproject.databinding.AdsLayoutBannerBinding RegulerBannerAd, int fieldId) {
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
        executeBindingsOn(regulerBannerAd);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): regulerBannerAd
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}