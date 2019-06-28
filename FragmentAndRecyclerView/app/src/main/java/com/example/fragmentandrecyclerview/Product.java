package com.example.fragmentandrecyclerview;

public class Product {
    private String pId;
    private String pName;
    private double pPrice;
    private int pImage;

    public Product() {
    }

    public Product(String pId, String pName, double pPrice, int pImage) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pImage = pImage;
    }

    public String getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public int getpImage() {
        return pImage;
    }
}
