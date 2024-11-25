package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class HotelService {
    private String name;

    public HotelService() {
    }

    public HotelService(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
