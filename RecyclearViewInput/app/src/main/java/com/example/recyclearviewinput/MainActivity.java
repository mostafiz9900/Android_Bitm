package com.example.recyclearviewinput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Student> studentList;
private RecyclerView recyclearLayout;
private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecyclerView();
        getStudentList();
    }

    private void initRecyclerView() {
        recyclearLayout.setLayoutManager(new LinearLayoutManager(this));
        recyclearLayout.setAdapter(studentAdapter);
    }

    private void getStudentList() {
        Student student=new Student("ST001","Mostafiz",R.drawable.mostafiz,26,"mostafiz9900@gmail.com");

        Student student2=new Student("ST002","Mohabub Rahaman",R.drawable.mahabub,26,"mahabur@gmail.com");
        studentList.add(student);
        studentList.add(student2);

        studentList.add(student);
        studentList.add(student2);

        studentList.add(student);
        studentList.add(student2);

        studentList.add(student);
        studentList.add(student2);

        studentList.add(student);
        studentList.add(student2);

        studentAdapter.notifyDataSetChanged();
    }

    private void init() {
        studentList=new ArrayList<>();
        recyclearLayout=findViewById(R.id.recyclearLayout);
        studentAdapter=new StudentAdapter(studentList);

    }
}
