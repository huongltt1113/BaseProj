package com.dev.baseproject.databinding;
import com.dev.baseproject.R;
import com.dev.baseproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(57);
        sIncludes.setIncludes(1, 
            new String[] {"ads_layout_banner"},
            new int[] {2},
            new int[] {com.dev.baseproject.R.layout.ads_layout_banner});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarLayout, 3);
        sViewsWithIds.put(R.id.btnPermission, 4);
        sViewsWithIds.put(R.id.tvmode, 5);
        sViewsWithIds.put(R.id.settings, 6);
        sViewsWithIds.put(R.id.layoutClap, 7);
        sViewsWithIds.put(R.id.bgSelectedClap, 8);
        sViewsWithIds.put(R.id.btnclap, 9);
        sViewsWithIds.put(R.id.layoutDontTouch, 10);
        sViewsWithIds.put(R.id.bgSelectedDontTouch, 11);
        sViewsWithIds.put(R.id.btnDontTouch, 12);
        sViewsWithIds.put(R.id.layoutPocket, 13);
        sViewsWithIds.put(R.id.bgSelectedPocket, 14);
        sViewsWithIds.put(R.id.btnPocket, 15);
        sViewsWithIds.put(R.id.layoutVoice, 16);
        sViewsWithIds.put(R.id.bgSelectedVoice, 17);
        sViewsWithIds.put(R.id.btnvoice, 18);
        sViewsWithIds.put(R.id.textclap, 19);
        sViewsWithIds.put(R.id.linedonttouch, 20);
        sViewsWithIds.put(R.id.linePocket, 21);
        sViewsWithIds.put(R.id.linevoice, 22);
        sViewsWithIds.put(R.id.layoutActive, 23);
        sViewsWithIds.put(R.id.rlActive, 24);
        sViewsWithIds.put(R.id.ivShadowBottom, 25);
        sViewsWithIds.put(R.id.ivShadowTop, 26);
        sViewsWithIds.put(R.id.ivStroke, 27);
        sViewsWithIds.put(R.id.ivWhite, 28);
        sViewsWithIds.put(R.id.rlDeactive, 29);
        sViewsWithIds.put(R.id.outerDeactiveLayout, 30);
        sViewsWithIds.put(R.id.help, 31);
        sViewsWithIds.put(R.id.btnActivate, 32);
        sViewsWithIds.put(R.id.tvActive, 33);
        sViewsWithIds.put(R.id.changevoicepasscode, 34);
        sViewsWithIds.put(R.id.tvChangePass, 35);
        sViewsWithIds.put(R.id.layoutTheme, 36);
        sViewsWithIds.put(R.id.layoutSensitivityDT, 37);
        sViewsWithIds.put(R.id.sensitivityDTLayout, 38);
        sViewsWithIds.put(R.id.ivMoreInfoSensitivityDT, 39);
        sViewsWithIds.put(R.id.tvSensitivityDontTouch, 40);
        sViewsWithIds.put(R.id.swSensitivityDontTouch, 41);
        sViewsWithIds.put(R.id.layoutOptionPocket, 42);
        sViewsWithIds.put(R.id.sensitivityPKLayout, 43);
        sViewsWithIds.put(R.id.ivMoreInfoSensitivityPK, 44);
        sViewsWithIds.put(R.id.tvSensitivityPocket, 45);
        sViewsWithIds.put(R.id.swSensitivityPocket, 46);
        sViewsWithIds.put(R.id.lightLayout, 47);
        sViewsWithIds.put(R.id.ivMoreInfoLightPK, 48);
        sViewsWithIds.put(R.id.tvWithLight, 49);
        sViewsWithIds.put(R.id.swLightPocket, 50);
        sViewsWithIds.put(R.id.llLabelChooseSound, 51);
        sViewsWithIds.put(R.id.tvChooseSound, 52);
        sViewsWithIds.put(R.id.ivAdd, 53);
        sViewsWithIds.put(R.id.recyclerView, 54);
        sViewsWithIds.put(R.id.btnSeeMore, 55);
        sViewsWithIds.put(R.id.rlad, 56);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 57, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.TextView) bindings[55]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.ImageView) bindings[31]
            , (android.widget.ImageView) bindings[53]
            , (android.widget.ImageView) bindings[48]
            , (android.widget.ImageView) bindings[39]
            , (android.widget.ImageView) bindings[44]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[28]
            , (android.widget.RelativeLayout) bindings[23]
            , (android.widget.FrameLayout) bindings[7]
            , (android.widget.FrameLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[42]
            , (android.widget.FrameLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[37]
            , (android.widget.FrameLayout) bindings[36]
            , (android.widget.FrameLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[47]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[22]
            , (android.widget.LinearLayout) bindings[51]
            , (android.widget.ImageView) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[54]
            , (com.dev.baseproject.databinding.AdsLayoutBannerBinding) bindings[2]
            , (android.widget.RelativeLayout) bindings[24]
            , (android.widget.RelativeLayout) bindings[29]
            , (android.widget.RelativeLayout) bindings[56]
            , (android.widget.LinearLayout) bindings[38]
            , (android.widget.LinearLayout) bindings[43]
            , (android.widget.ImageView) bindings[6]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[50]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[41]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[46]
            , (android.widget.TextView) bindings[19]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            , (com.dev.baseproject.customviews.autofit.AutoResizeTextView) bindings[33]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[52]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[49]
            , (com.dev.baseproject.customviews.autofit.AutoResizeTextView) bindings[5]
            );
        this.btm1.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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