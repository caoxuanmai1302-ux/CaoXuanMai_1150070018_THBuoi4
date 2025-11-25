package com.example.mai_funstory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mai_funstory.adapter.DetailStoryAdapter;
import com.example.mai_funstory.model.StoryEntity;

import java.util.List;

public class M003DetailStoryFrg extends Fragment {

    List<StoryEntity> list;
    int pos;
    ViewPager pager;

    public M003DetailStoryFrg(List<StoryEntity> list, int pos) {
        this.list = list;
        this.pos = pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m003_frg_detail_story, container, false);

        pager = v.findViewById(R.id.viewPager);
        pager.setAdapter(new DetailStoryAdapter(list));
        pager.setCurrentItem(pos);

        return v;
    }
}
