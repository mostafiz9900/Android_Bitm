package com.example.datetimetest;

import java.util.Date;

public class Expence {
    private int id;
    private String type;
    private double cost;
    private Date date;
    private String time;
    private String image;

    public Expence() {
    }

    public Expence(int id, String type, double cost, Date date, String time, String image) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getImage() {
        return image;
    }
}
