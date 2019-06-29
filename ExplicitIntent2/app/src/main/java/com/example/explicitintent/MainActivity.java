package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText editText;
private Button button;
private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.nameET);
        button=findViewById(R.id.secondBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=editText.getText().toString().trim();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",data);
                startActivity(intent);
            }
        });
    }
}
