package com.example.databasehelper_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, ageEt;
    private Button insertBtn, showDataBtn;
    private String aName, aAge;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ShowdataActivity.class);
                startActivity(intent);
            }
        });

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aName = nameEt.getText().toString();
                aAge = ageEt.getText().toString();
               long id= databaseHelper.insertData(aName, aAge);
                Toast.makeText(MainActivity.this,""+id,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init() {
        nameEt = findViewById(R.id.nameEt);
        ageEt = findViewById(R.id.ageEt);
        insertBtn = findViewById(R.id.insertBtn);
        showDataBtn=findViewById(R.id.showDataBtn);
        databaseHelper = new DatabaseHelper(this);


    }
}
