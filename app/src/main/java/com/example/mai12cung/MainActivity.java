package com.example.mai12cung;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.ln_main, new M000SplashFrg())
                    .commit();
        }
    }

    public void showZodiacScreen() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, new M001ZodiacFrg())
                .commit();
    }
}