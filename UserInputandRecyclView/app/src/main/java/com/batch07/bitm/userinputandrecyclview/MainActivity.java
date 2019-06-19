package com.batch07.bitm.userinputandrecyclview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getStudetList();
    }

    private void init() {
        studentList = new ArrayList<>();
    }

    public void getStudetList() {
        Student student_1 = new Student("Mostafiz", "246642", "Java", "R-37", R.drawable.mostafiz, "01633321732");
        Student student_2 = new Student("Sofiqul", "246688", "Java", "R-37", R.drawable.sofiqul, "016333000000");
        studentList.add(student_1);
        studentList.add(student_2);
    }
}
