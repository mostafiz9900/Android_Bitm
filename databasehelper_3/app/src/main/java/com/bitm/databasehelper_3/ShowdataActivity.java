package com.bitm.databasehelper_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowdataActivity extends AppCompatActivity {
    private DatabaseHelper helper;

    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        init();
        getRecyclerView();
        Cursor cursor=helper.viewdataList();
        while (cursor.moveToNext()){

            int id=cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name=cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age=cursor.getString(cursor.getColumnIndex(helper.COL_AGE));

            studentList.add(new Student(id,name,age));
            studentAdapter.notifyDataSetChanged();
        }
    }

    private void init() {
        recyclerView=findViewById(R.id.studentRV);
        studentList=new ArrayList<>();
        helper=new DatabaseHelper(this);
        studentAdapter=new StudentAdapter(this,studentList,helper);
    }

    private void getRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);
    }

}
