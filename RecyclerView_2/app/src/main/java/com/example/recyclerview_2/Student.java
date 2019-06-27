package com.example.recyclerview_2;

public class Student {
    private String sName;
    private String sDept;
    private String sBach;
    private int sImage;
    private int sAge;

    public Student() {
    }

    public Student(String sName, String sDept, String sBach, int sImage, int sAge) {
        this.sName = sName;
        this.sDept = sDept;
        this.sBach = sBach;
        this.sImage = sImage;
        this.sAge = sAge;
    }

    public String getsName() {
        return sName;
    }

    public String getsDept() {
        return sDept;
    }

    public String getsBach() {
        return sBach;
    }

    public int getsImage() {
        return sImage;
    }

    public int getsAge() {
        return sAge;
    }
}
