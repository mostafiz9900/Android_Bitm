package com.example.recyclerviewex;

public class Movie {
    private String Name;
    private String directorName;
    private int image;

    public Movie() {
    }

    public Movie(String name, String directorName, int image) {
        Name = name;
        this.directorName = directorName;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public int getImage() {
        return image;
    }
}
