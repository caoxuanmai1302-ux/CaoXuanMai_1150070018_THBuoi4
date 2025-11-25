package com.example.mai_funstory;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.InputStream;

public class M001TopicFrg extends Fragment {

    LinearLayout lnTopic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m001_frg_topic, container, false);

        lnTopic = v.findViewById(R.id.lnTopic);

        loadTopic();

        return v;
    }

    private void loadTopic() {
        View item = getLayoutInflater().inflate(R.layout.item_topic, lnTopic, false);

        ImageView imv = item.findViewById(R.id.imvTopic);
        TextView tv = item.findViewById(R.id.tvTopic);

        tv.setText("Trạng Quỳnh");
        imv.setImageResource(R.drawable.trangquynh);

        item.setOnClickListener(v -> {
            ((MainActivity) getActivity()).gotoM002Screen("TrangQuynh");
        });

        lnTopic.addView(item);
    }
}
