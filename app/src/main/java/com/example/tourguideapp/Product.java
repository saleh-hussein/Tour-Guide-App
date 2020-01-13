package com.example.tourguideapp;

import java.io.Serializable;

public class Product implements Serializable {
    //declare variables for restaurant information
    private String mProductName;
    private int mProductImage;
    private String mProductPhone;
    private String mProductWebsite;
    private String mProductLocation;
    private String mProductDetails;

    //constructor
    public Product(String mProductName, int mProductImage, String mProductPhone, String mProductWebsite, String mProductLocation, String mProductDetails) {
        this.mProductName = mProductName;
        this.mProductImage = mProductImage;
        this.mProductPhone = mProductPhone;
        this.mProductWebsite = mProductWebsite;
        this.mProductLocation = mProductLocation;
        this.mProductDetails = mProductDetails;
    }

    //getter and setter
    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public int getmProductImage() {
        return mProductImage;
    }

    public void setmProductImage(int mProductImage) {
        this.mProductImage = mProductImage;
    }

    public String getmProductPhone() {
        return mProductPhone;
    }

    public void setmProductPhone(String mProductPhone) {
        this.mProductPhone = mProductPhone;
    }

    public String getmProductWebsite() {
        return mProductWebsite;
    }

    public void setmProductWebsite(String mProductWebsite) {
        this.mProductWebsite = mProductWebsite;
    }

    public String getmProductLocation() {
        return mProductLocation;
    }

    public void setmProductLocation(String mProductLocation) {
        this.mProductLocation = mProductLocation;
    }

    public String getmProductDetails() {
        return mProductDetails;
    }

    public void setmProductDetails(String mProductDetails) {
        this.mProductDetails = mProductDetails;
    }
}
