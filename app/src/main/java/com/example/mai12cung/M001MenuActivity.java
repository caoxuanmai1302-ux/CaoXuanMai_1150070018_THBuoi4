package com.example.mai12cung;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class M001MenuActivity extends AppCompatActivity {
    TextView tvName, tvContent;
    ImageView currentImg;
    int imgId;
    String zodiacName, zodiacContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_menu);
    }
}