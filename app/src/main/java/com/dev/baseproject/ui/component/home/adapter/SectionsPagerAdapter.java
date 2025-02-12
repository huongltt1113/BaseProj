package com.dev.baseproject.ui.component.home.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.dev.baseproject.utils.Constants;

public final class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private final Context context;

    @Override
    public int getCount() {
        return Constants.HTS_TAB_COUNT;
    }

    public SectionsPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return PlaceHolderFragment3.newInstance();
        } else if (i == 1) {
            return PlaceholderFragment2.Companion.newInstance();
        } else if (i == 2) {
            return PlaceHolderFragment4.Companion.newInstance();
        } else if (i == 3) {
            return PlaceholderFragment5.Companion.newInstance();
        } else {
            throw new IllegalArgumentException("Invalid position: " + i);
        }
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return this.context.getResources().getString(SectionsPagerAdapterKt.TAB_TITLES[i].intValue());
    }
}

//public final class SectionsPagerAdapter extends FragmentPagerAdapter {
//    private final Context context;
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    public SectionsPagerAdapter(Context context2, FragmentManager fragmentManager) {
//        super(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        this.context = context2;
//    }
//
//    @Override
//    public Fragment getItem(int i) {
//        if (i == 0) {
//            return PlaceHolderFragment3.newInstance();
//        }
//        if (i == 1) {
//            return PlaceholderFragment2.Companion.newInstance();
//        }
//        if (i == 2) {
//            return PlaceHolderFragment4.Companion.newInstance();
//        }
//        throw new IllegalArgumentException("Invalid position: " + i);
//    }
//
//    @Override
//    public CharSequence getPageTitle(int i) {
//        return this.context.getResources().getString(SectionsPagerAdapterKt.TAB_TITLES[i].intValue());
//    }
//}
