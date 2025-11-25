package com.example.mai_funstory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mai_funstory.adapter.StoryAdapter;
import com.example.mai_funstory.model.StoryEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class M002StoryFrg extends Fragment {

    RecyclerView rvStory;
    List<StoryEntity> list = new ArrayList<>();

    String topic = "TrangQuynh";

    public M002StoryFrg() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m002_frg_story, container, false);

        rvStory = v.findViewById(R.id.rv_story);

        loadStoryFile();

        rvStory.setAdapter(new StoryAdapter(list, pos -> {
            ((MainActivity) getActivity()).gotoM003Screen(list, pos);
        }));

        return v;
    }


    private void loadStoryFile() {
        try {
            InputStream is = getActivity().getAssets().open("story/TrangQuynh.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            String title = "";
            StringBuilder content = new StringBuilder();

            while ((line = br.readLine()) != null) {

                if (line.equals("','0');")) {
                    list.add(new StoryEntity(title, content.toString()));
                    title = "";
                    content = new StringBuilder();
                    continue;
                }

                if (title.isEmpty()) title = line;
                else content.append(line).append("\n");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
