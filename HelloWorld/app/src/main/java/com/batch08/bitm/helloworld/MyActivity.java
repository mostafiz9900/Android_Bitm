package com.batch08.bitm.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    private TextView textView;
    private EditText nameET;
    private Button submitBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textView=findViewById(R.id.myName);
        nameET=findViewById(R.id.nameInputEt);
        submitBtn=findViewById(R.id.su)


    }
}
