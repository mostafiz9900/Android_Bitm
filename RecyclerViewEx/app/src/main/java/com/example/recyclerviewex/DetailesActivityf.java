package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailesActivityf extends AppCompatActivity {
private TextView textView , directorTV;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes_activityf);
        textView=findViewById(R.id.nameTV);
        directorTV=findViewById(R.id.derecnameTV);
        imageView=findViewById(R.id.imgeView);

        String name=getIntent().getStringExtra("name");
        String director=getIntent().getStringExtra("director");
        String image=getIntent().getStringExtra("image");

        textView.setText(name);
        directorTV.setText(director);
        imageView.setImageResource(R.drawable.clock);

    }
}
