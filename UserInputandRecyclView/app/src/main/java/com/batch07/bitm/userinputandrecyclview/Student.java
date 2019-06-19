package com.batch07.bitm.userinputandrecyclview;

public class Student {
    private String name;
    private String id;
    private String depat;
    private String bach;
    private int profileImage;
    private String phoneNo;

    public Student() {
    }

    public Student(String name, String id, String depat, String bach, int profileImage, String phoneNo) {
        this.name = name;
        this.id = id;
        this.depat = depat;
        this.bach = bach;
        this.profileImage = profileImage;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepat() {
        return depat;
    }

    public String getBach() {
        return bach;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
