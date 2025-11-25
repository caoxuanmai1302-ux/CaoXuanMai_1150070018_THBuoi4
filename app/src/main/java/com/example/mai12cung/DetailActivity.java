package com.example.mai12cung;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        val name = intent.getStringExtra("name")
        val drawableId = intent.getIntExtra("drawableId", R.drawable.aries)
        val content = intent.getStringExtra("content")

        findViewById<ImageView>(R.id.iv_detail).setImageResource(drawableId)
        findViewById<TextView>(R.id.tv_detail_name).text = name
        findViewById<TextView>(R.id.tv_detail_content).text = content

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish()
        }
    }
}