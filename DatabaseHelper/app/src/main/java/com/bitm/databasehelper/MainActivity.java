package com.bitm.databasehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText name, age;
private Button insert;

private String aName, aAge;
private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aName=name.getText().toString();
                aAge=age.getText().toString();
                long id=databaseHelper.insertData(aName,aAge);
                Toast.makeText(MainActivity.this,""+id,Toast.LENGTH_LONG).show();


            }
        });
    }

    private void init() {
        name=findViewById(R.id.nameEt);
        age=findViewById(R.id.ageEt);
        insert=findViewById(R.id.insertBtn);
        databaseHelper=new DatabaseHelper(this);

    }
}
