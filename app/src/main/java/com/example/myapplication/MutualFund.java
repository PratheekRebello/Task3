package com.example.myapplication;

public class MutualFund extends Investment
{
    public MutualFund(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
