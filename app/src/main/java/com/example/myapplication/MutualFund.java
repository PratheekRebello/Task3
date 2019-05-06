package com.example.myapplication;
import java.io.Serializable;

public class MutualFund extends Investment implements Serializable
{
    public MutualFund(String name, int date, int curr, int gain)
    {
        this.name = name;
        this.date.date = date;
        this.currentMarketValue = curr;
        this.gainPercent = gain;
    }
}
