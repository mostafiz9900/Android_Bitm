package com.example.databasehelper_2;

public class Student {
    private int id;
    private String name;
    private String age;

    public Student() {

    }

    public Student(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
