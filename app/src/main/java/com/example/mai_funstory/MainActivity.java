package com.example.mai_funstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mai_funstory.model.StoryEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoM000Screen();
    }

    private void load(Fragment frg) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, frg)
                .addToBackStack(null)
                .commit();
    }

    public void gotoM000Screen() {
        load(new M000SplashFrg());
    }

    public void gotoM001Screen() {
        load(new M001TopicFrg());
    }

    public void gotoM002Screen(String topicName) {
        load(new M002StoryFrg(topicName));
    }

    public void gotoM003Screen(List<StoryEntity> list, int pos) {
        load(new M003DetailStoryFrg(list, pos));
    }
}
