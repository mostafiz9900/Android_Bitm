package com.example.databasehelper_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowdataActivity extends AppCompatActivity {
private DatabaseHelper helper;
private List<Student> studentList;
private StudentAdapter studentAdapter;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        init();
    }

    private void init() {
        helper=new DatabaseHelper(this);
        studentList=new ArrayList<>();
        studentAdapter=new StudentAdapter(this,studentList,helper);
        recyclerView=findViewById(R.id.studentRV);
    }
}
