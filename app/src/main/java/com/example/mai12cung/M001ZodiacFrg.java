package com.example.mai12cung;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class M001ZodiacFrg extends Fragment {

    private final String[] names = {
            "Bạch Dương", "Kim Ngưu", "Song Tử", "Cự Giải",
            "Sư Tử", "Xử Nữ", "Thiên Bình", "Thiên Yết",
            "Nhân Mã", "Ma Kết", "Bảo Bình", "Song Ngư"
    };

    private final String[] photos = {
            "aries.jpg", "taurus.jpg", "gemini.jpg", "cancer.jpg",
            "leo.jpg", "virgo.jpg", "libra.jpg", "scorpio.jpg",
            "sagittarius.jpg", "capricorn.jpg", "aquarius.jpg", "pisces.jpg"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m001_frg_zodiac, container, false);
        RecyclerView rv = v.findViewById(R.id.rv_zodiac);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));

        ArrayList<Bitmap> listBitmap = new ArrayList<>();
        try {
            for (String photo : photos) {
                InputStream is = getActivity().getAssets().open("photo/" + photo);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                listBitmap.add(bmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        rv.setAdapter(new ZodiacAdapter(names, listBitmap));
        return v;
    }
}