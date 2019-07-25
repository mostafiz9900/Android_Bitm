package com.beskilled.profileupdatefirebase;

public class User {
   private String image;
    private String name;
    private  String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String image, String name, String email) {
        this.image = image;
        this.name = name;
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
