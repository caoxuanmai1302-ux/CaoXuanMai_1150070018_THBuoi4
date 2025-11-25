package com.example.mai_funstory;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class M000SplashFrg extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m000_frg_splash, container, false);

        new Handler().postDelayed(() -> {
            ((MainActivity) getActivity()).gotoM001Screen();
        }, 1500);

        return v;
    }
}
