package com.example.databasehelper_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
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
        recyclerViewConfi();

        Cursor cursor = helper.dataList();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));
            studentList.add(new Student(id, name, age));
            studentAdapter.notifyDataSetChanged();

        }
    }

    private void recyclerViewConfi() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);
    }

    private void init() {
        helper = new DatabaseHelper(this);
        studentList = new ArrayList<>();
        studentAdapter = new StudentAdapter(this, studentList, helper);
        recyclerView = findViewById(R.id.studentRV);
    }
}
