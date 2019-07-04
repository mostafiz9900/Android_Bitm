package com.bitm.databasehelper_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, ageEt;
    private Button insertBtn, viewBtn;

    private String aName, aAge;
    private DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowdataActivity.class));
            }
        });

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aName = nameEt.getText().toString();
                aAge = ageEt.getText().toString();
                long id = helper.insertData(aName, aAge);
                Toast.makeText(MainActivity.this,""+id,Toast.LENGTH_LONG).show();

            }
        });
    }



    private void init() {
        nameEt = findViewById(R.id.nameEt);
        ageEt = findViewById(R.id.ageEt);
        insertBtn = findViewById(R.id.insertBtn);
        viewBtn = findViewById(R.id.viewBtn);

        helper = new DatabaseHelper(this);

    }
}
