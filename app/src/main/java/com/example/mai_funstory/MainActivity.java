package com.example.mai_funstory;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mai_funstory.adapter.StoryAdapter;
import com.example.mai_funstory.model.StoryEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M002StoryFrg extends Fragment {

    private Context mContext;
    private String topicName;  // <-- QUAN TRỌNG: phải có biến này

    public M002StoryFrg() {
        // Required empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_frg_story, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View v) {

        // Gán tên chủ đề
        TextView tvName = v.findViewById(R.id.tv_name);
        tvName.setText(topicName);

        // Back
        v.findViewById(R.id.iv_back).setOnClickListener(view -> {
            ((MainActivity) mContext).gotoM001Screen();
        });

        // Recycler
        RecyclerView rv = v.findViewById(R.id.rv_story);
        rv.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<StoryEntity> list = readStories();
        rv.setAdapter(new StoryAdapter(list, mContext));
    }

    private ArrayList<StoryEntity> readStories() {
        ArrayList<StoryEntity> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/" + topicName + ".txt"))
            );

            String title;
            while ((title = br.readLine()) != null) {

                StringBuilder content = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null && !line.contains("','0');")) {
                    content.append(line).append("\n");
                }

                list.add(new StoryEntity(title, content.toString()));
            }

        } catch (Exception ignored) {}
        return list;
    }

    // ====== HÀM NÀY QUAN TRỌNG NHẤT ======
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
