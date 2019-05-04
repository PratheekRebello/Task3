package com.example.myapplication;


public class Stock extends Investment
{
    public Stock(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
