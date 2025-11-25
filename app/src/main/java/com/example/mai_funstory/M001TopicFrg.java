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

        loadTopics();

        return v;
    }

    private void loadTopics() {
        try {
            // Lấy danh sách icon chủ đề
            String[] list = getActivity().getAssets().list("photo");

            for (String fileName : list) {

                // 1) Inflate item_topic.xml
                View item = getLayoutInflater().inflate(R.layout.item_topic, lnTopic, false);

                // 2) Ánh xạ
                ImageView imv = item.findViewById(R.id.imvTopic);
                TextView tv = item.findViewById(R.id.tvTopic);

                // 3) Load icon
                InputStream is = getActivity().getAssets().open("photo/" + fileName);
                imv.setImageBitmap(BitmapFactory.decodeStream(is));

                // 4) Set tên topic
                String topicName = fileName.replace(".png", "");
                tv.setText(topicName);

                // 5) Set sự kiện click
                item.setOnClickListener(v -> {
                    ((MainActivity) getActivity()).gotoM002Screen(topicName);
                });

                // 6) Add vào layout
                lnTopic.addView(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
