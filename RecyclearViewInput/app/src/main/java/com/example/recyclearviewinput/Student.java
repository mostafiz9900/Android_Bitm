package com.example.recyclearviewinput;

public class Student {
    private String studentId;
    private String studentName;
    private int studentImage;
    private int studentAge;
    private String studentEmail;

    public Student() {
    }

    public Student(String studentId, String studentName, int studentImage, int studentAge, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentImage = studentImage;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentImage() {
        return studentImage;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }
}
