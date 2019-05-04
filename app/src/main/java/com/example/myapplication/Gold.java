package com.example.myapplication;


public class Gold extends Investment
{
    public Gold(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
