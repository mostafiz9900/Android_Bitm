package com.example.recyclerview_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Student> students;
private RecyclerView recyclerLayout;
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
        recyclerLayout.setLayoutManager(new LinearLayoutManager(this));
        recyclerLayout.setAdapter(studentAdapter);
    }

    private void getStudentList() {
        Student student=new Student("Mostafizur ","Java","2nd", R.drawable.mostafiz,27);
        Student student2=new Student("Sofiqul ","Androdi","6 Batch", R.drawable.mahabub,29);

        students.add(student);
        students.add(student2);

        students.add(student);
        students.add(student2);

        students.add(student);
        students.add(student2);

        students.add(student);
        students.add(student2);

        students.add(student);
        students.add(student2);
        studentAdapter.notifyDataSetChanged();

    }

    private void init() {
        students=new ArrayList<>();
        recyclerLayout=findViewById(R.id.recyclerLayout);
        studentAdapter=new StudentAdapter(students);
    }
}
