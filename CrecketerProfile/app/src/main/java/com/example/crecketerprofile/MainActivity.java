package com.example.crecketerprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sakibBtn;
    private Button tamimBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sakibBtn = findViewById(R.id.sakibBtn);
        tamimBtn = findViewById(R.id.tamimBtn);

        sakibBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sakibName = "Name : Shakib Al Hasan";
                String sakibBorn = "Born : Mar 24, 1987 (32 years) \n" + "Birth Place : Magura, Jessore \n" +
                        "Batting Style : Left Handed Bat \n" + "Bowling Style : Left-arm orthodox ";


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("name", sakibName);
                intent.putExtra("born", sakibBorn);


                startActivity(intent);
            }
        });
        tamimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tamimName = "Name : Tamim Iqbal";
                String taminBorn = "Born : Mar 20, 1989 (30 years)";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", tamimName);
                intent.putExtra("born", taminBorn);
                startActivity(intent);
            }
        });
    }
}
