package com.example.mai12cung;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacAdapter.VH> {

    private final String[] names;
    private final Bitmap[] photos;

    public ZodiacAdapter(String[] names, java.util.List<Bitmap> photoList) {
        this.names = names;
        this.photos = photoList.toArray(new Bitmap[0]);
    }

    public static class VH extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName;

        public VH(View v) {
            super(v);
            ivPhoto = v.findViewById(R.id.iv_photo);
            tvName = v.findViewById(R.id.tv_name);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zodiac, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.ivPhoto.setImageBitmap(photos[position]);
        holder.tvName.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}