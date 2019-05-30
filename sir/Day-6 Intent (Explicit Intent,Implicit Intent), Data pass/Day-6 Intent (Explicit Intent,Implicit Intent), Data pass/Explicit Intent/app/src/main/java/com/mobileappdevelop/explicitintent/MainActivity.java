package com.mobileappdevelop.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button secondActivityB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondActivityB =findViewById(R.id.secondActivityBtn);

        secondActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data ="hello everyone!!";

                Intent  intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",data);
                startActivity(intent);
            }
        });
    }
}
