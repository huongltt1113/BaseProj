package com.dev.baseproject.ui.component.home.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dev.baseproject.databinding.FragmentHowToUseBinding;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;


public final class PlaceholderFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentHowToUseBinding _binding;

    private FragmentHowToUseBinding getBinding() {
        FragmentHowToUseBinding fragmentHowToUseBinding = this._binding;
        return fragmentHowToUseBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this._binding = FragmentHowToUseBinding.inflate(layoutInflater, viewGroup, false);
        return  _binding.getRoot();
    }

    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public PlaceholderFragment newInstance() {
            return new PlaceholderFragment();
        }
    }
    public static PlaceholderFragment newInstance() {
        return Companion.newInstance();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
