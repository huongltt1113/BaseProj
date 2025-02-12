package com.dev.baseproject.databinding;
import com.dev.baseproject.R;
import com.dev.baseproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSoundDetailBindingImpl extends FragmentSoundDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarLayout, 1);
        sViewsWithIds.put(R.id.btnBack, 2);
        sViewsWithIds.put(R.id.heading, 3);
        sViewsWithIds.put(R.id.scrViewSetting, 4);
        sViewsWithIds.put(R.id.ivBackground, 5);
        sViewsWithIds.put(R.id.circularseekbar, 6);
        sViewsWithIds.put(R.id.voicemute, 7);
        sViewsWithIds.put(R.id.voicemax, 8);
        sViewsWithIds.put(R.id.ivsound, 9);
        sViewsWithIds.put(R.id.play, 10);
        sViewsWithIds.put(R.id.rvSound, 11);
        sViewsWithIds.put(R.id.layvib, 12);
        sViewsWithIds.put(R.id.tvVib, 13);
        sViewsWithIds.put(R.id.ivvibrateswitch, 14);
        sViewsWithIds.put(R.id.switchvibrate, 15);
        sViewsWithIds.put(R.id.layFlash, 16);
        sViewsWithIds.put(R.id.tvFlash, 17);
        sViewsWithIds.put(R.id.ivflashswitch, 18);
        sViewsWithIds.put(R.id.switchflash, 19);
        sViewsWithIds.put(R.id.soundsettings, 20);
        sViewsWithIds.put(R.id.darkversion, 21);
        sViewsWithIds.put(R.id.switchsound, 22);
        sViewsWithIds.put(R.id.ivDuration, 23);
        sViewsWithIds.put(R.id.lableduration, 24);
        sViewsWithIds.put(R.id.layoutDuration, 25);
        sViewsWithIds.put(R.id.rvDuration, 26);
        sViewsWithIds.put(R.id.ivSettingDuration, 27);
        sViewsWithIds.put(R.id.bottom_view, 28);
        sViewsWithIds.put(R.id.cancelbutton, 29);
        sViewsWithIds.put(R.id.applybutton, 30);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSoundDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private FragmentSoundDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[30]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[29]
            , (com.dev.baseproject.customviews.CircularSeekBar) bindings[6]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.TextView) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[25]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (android.widget.ImageView) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (android.widget.ScrollView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[19]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[22]
            , (com.google.android.material.materialswitch.MaterialSwitch) bindings[15]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[13]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[7]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}