package com.dev.baseproject.databinding;
import com.dev.baseproject.R;
import com.dev.baseproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPlaceholder5BindingImpl extends FragmentPlaceholder5Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv1, 1);
        sViewsWithIds.put(R.id.divider1, 2);
        sViewsWithIds.put(R.id.tv2, 3);
        sViewsWithIds.put(R.id.divider2, 4);
        sViewsWithIds.put(R.id.tv4, 5);
        sViewsWithIds.put(R.id.divider4, 6);
        sViewsWithIds.put(R.id.tv5, 7);
        sViewsWithIds.put(R.id.divider5, 8);
        sViewsWithIds.put(R.id.layoutGuide1, 9);
        sViewsWithIds.put(R.id.iv1, 10);
        sViewsWithIds.put(R.id.label1, 11);
        sViewsWithIds.put(R.id.layoutActive, 12);
        sViewsWithIds.put(R.id.rlActive, 13);
        sViewsWithIds.put(R.id.ivShadowBottom, 14);
        sViewsWithIds.put(R.id.ivShadowTop, 15);
        sViewsWithIds.put(R.id.ivStroke, 16);
        sViewsWithIds.put(R.id.ivWhite, 17);
        sViewsWithIds.put(R.id.btnActivate, 18);
        sViewsWithIds.put(R.id.tvActive, 19);
        sViewsWithIds.put(R.id.layoutGuide2, 20);
        sViewsWithIds.put(R.id.iv2, 21);
        sViewsWithIds.put(R.id.label2, 22);
        sViewsWithIds.put(R.id.ivContent2, 23);
        sViewsWithIds.put(R.id.layoutGuide4, 24);
        sViewsWithIds.put(R.id.iv4, 25);
        sViewsWithIds.put(R.id.label4, 26);
        sViewsWithIds.put(R.id.ivContent4, 27);
        sViewsWithIds.put(R.id.layoutGuide5, 28);
        sViewsWithIds.put(R.id.iv5, 29);
        sViewsWithIds.put(R.id.tvGuide5, 30);
        sViewsWithIds.put(R.id.ivBackground, 31);
        sViewsWithIds.put(R.id.circularseekbar, 32);
        sViewsWithIds.put(R.id.voicemute, 33);
        sViewsWithIds.put(R.id.voicemax, 34);
        sViewsWithIds.put(R.id.ivsound, 35);
        sViewsWithIds.put(R.id.play, 36);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPlaceholder5BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }
    private FragmentPlaceholder5BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[18]
            , (com.dev.baseproject.customviews.CircularSeekBar) bindings[32]
            , (com.google.android.material.divider.MaterialDivider) bindings[2]
            , (com.google.android.material.divider.MaterialDivider) bindings[4]
            , (com.google.android.material.divider.MaterialDivider) bindings[6]
            , (com.google.android.material.divider.MaterialDivider) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[29]
            , (android.widget.ImageView) bindings[31]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[35]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[26]
            , (android.widget.RelativeLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[28]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.RelativeLayout) bindings[13]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[30]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.ImageView) bindings[33]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
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