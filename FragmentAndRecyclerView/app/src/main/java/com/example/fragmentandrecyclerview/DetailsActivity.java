package com.example.fragmentandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.imageV);
        textView = findViewById(R.id.nameTV);
        String s = getIntent().getStringExtra("name");
        String img = getIntent().getStringExtra("image");

        imageView.setImageResource(R.drawable.clock);
        textView.setText(s);
    }
}
