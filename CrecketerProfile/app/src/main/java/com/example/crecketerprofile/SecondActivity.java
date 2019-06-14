package com.example.crecketerprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
private TextView nameTV;
private TextView bornTV;

private String name;
private String born;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTV=findViewById(R.id.nameTV);
        bornTV=findViewById(R.id.bornTV);


        name=getIntent().getStringExtra("name");
        nameTV.setText(name);

        born=getIntent().getStringExtra("born");
        bornTV.setText(born);




    }
}
