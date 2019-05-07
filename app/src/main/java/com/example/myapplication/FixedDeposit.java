package com.example.myapplication;
import java.io.Serializable;

public class FixedDeposit extends Investment implements Serializable
{
    int Amount;

    public FixedDeposit(String name, int date, int amt, int gain)
    {
        this.name = name;
        this.date.date = date;
        this.Amount = amt;
        this.gainPercent = gain;
        this.currentMarketValue = Amount;
    }
}
