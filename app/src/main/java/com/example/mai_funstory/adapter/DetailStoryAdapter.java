package com.example.mai_funstory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.mai_funstory.R;
import com.example.mai_funstory.model.StoryEntity;

import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {

    List<StoryEntity> list;

    public DetailStoryAdapter(List<StoryEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View v, Object o) {
        return v == o;
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int pos) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail_story, parent, false);

        TextView tv = v.findViewById(R.id.tvContent);
        tv.setText(list.get(pos).getContent());

        parent.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup parent, int pos, Object object) {
        parent.removeView((View) object);
    }
}
