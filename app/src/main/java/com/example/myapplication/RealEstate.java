package com.example.myapplication;

public class RealEstate extends Investment
{
    public RealEstate(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
