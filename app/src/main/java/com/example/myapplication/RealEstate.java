package com.example.myapplication;
import java.io.Serializable;

public class RealEstate extends Investment implements Serializable
{
    public RealEstate(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
