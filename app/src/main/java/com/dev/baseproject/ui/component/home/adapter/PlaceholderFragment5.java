package com.dev.baseproject.ui.component.home.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dev.baseproject.R;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class PlaceholderFragment5 extends Fragment {
    public static final PlaceholderFragment5.Companion Companion = new PlaceholderFragment5.Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static PlaceholderFragment5 newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_placeholder5, viewGroup, false);
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {

        }

        @JvmStatic
        public final PlaceholderFragment5 newInstance() {
            return new PlaceholderFragment5();
        }
    }
}
