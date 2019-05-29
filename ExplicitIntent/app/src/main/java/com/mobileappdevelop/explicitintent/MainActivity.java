package com.mobileappdevelop.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText textET;
private Button saBtn;
private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textET=findViewById(R.id.textET);
        saBtn=findViewById(R.id.saBtn);
        saBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=textET.getText().toString().trim();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",data);
                startActivity(intent);
            }
        });


    }
}
