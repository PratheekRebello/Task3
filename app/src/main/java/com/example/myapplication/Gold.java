package com.example.myapplication;
import java.io.Serializable;


public class Gold extends Investment implements Serializable
{
    public Gold(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
