package com.mobileappdevelop.converttk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText amount = findViewById(R.id.amountTE);
        RadioButton dollToTaka = findViewById(R.id.dollToTaka);
        RadioButton takatoDoll = findViewById(R.id.TakaToDoll);
        TextView result = findViewById(R.id.resultTV);


        Button convert = findViewById(R.id.convertBtn);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Currenc converter", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
