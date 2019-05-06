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

    public void DailyUpdate()
    {
        if(date.date%7 == 0)
        {
            Amount = (int)(((gainPercent + 100) * Amount))/100;
            currentMarketValue = Amount;
        }
    }
}
