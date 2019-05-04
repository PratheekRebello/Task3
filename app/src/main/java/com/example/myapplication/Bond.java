package com.example.myapplication;

public class Bond extends Investment
{
    public Bond(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
