package com.example.mai_funstory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mai_funstory.R;
import com.example.mai_funstory.model.StoryEntity;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryVH> {

    List<StoryEntity> list;
    IClick listener;

    public interface IClick {
        void onClick(int pos);
    }

    public StoryAdapter(List<StoryEntity> list, IClick listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public StoryVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);
        return new StoryVH(v);
    }

    @Override
    public void onBindViewHolder(StoryVH h, int pos) {
        h.tvStory.setText(list.get(pos).getTitle());
        h.itemView.setOnClickListener(v -> listener.onClick(pos));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StoryVH extends RecyclerView.ViewHolder {
        TextView tvStory;

        public StoryVH(View v) {
            super(v);
            tvStory = v.findViewById(R.id.tvStory);
        }
    }
}
