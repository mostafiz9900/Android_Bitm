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
                String img = "Batting Career Summary\n" +
                        "\tM \tInn \tNO \tRuns \tHS \tAvg \tBF \tSR \t100 \t200 \t50 \t4s \t6s\n" +
                        "Test \t55 \t103 \t7 \t3807 \t217 \t39.66 \t6150 \t61.9 \t5 \t1 \t24 \t470 \t19\n" +
                        "ODI \t201 \t189 \t25 \t5977 \t134 \t36.45 \t7281 \t82.09 \t8 \t0 \t44 \t541 \t42\n" +
                        "T20I \t72 \t71 \t8 \t1471 \t84 \t23.35 \t1195 \t123.1 \t0 \t0 \t8 \t152 \t32\n" +
                        "IPL \t63 \t46 \t11 \t746 \t66 \t21.31 \t589 \t126.66 \t0 \t0 \t2 \t70 \t20";
                String sakibName = "Name : Shakib Al Hasan ";
                String sakibBorn = "Born : Mar 24, 1987 (32 years) \n" + "Birth Place : Magura, Jessore \n" +
                        "Batting Style : Left Handed Bat \n" + "Bowling Style : Left-arm orthodox ";

                String sakibBatting = "Batting Career Summary\n" +
                        "      \tM \tInn \tNO \tRuns \tHS \tAvg     \tBF   \tSR \t100  \t200  \t50 \t4s \t6s\n" +
                        "Test \t55 \t103 \t7  \t3807 \t217 \t39.66  \t6150  \t61.9 \t5   \t1 \t24 \t470 \t19\n" +
                        "ODI \t201 \t189 \t25  \t5977 \t134 \t36.45 \t7281 \t82.09 \t8   \t0 \t44 \t541 \t42\n" +
                        "T20I \t72 \t71  \t8  \t1471  \t84 \t23.35 \t1195   \t123.1 \t0  \t0 \t8 \t152  \t32\n" +
                        "IPL \t63 \t46   \t11  \t746  \t66 \t21.31 \t589   \t126.66 \t0  \t0 \t2 \t70  \t20";


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("name", sakibName);
                intent.putExtra("born", sakibBorn);
                intent.putExtra("batting", sakibBatting);


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
