package com.example.myapplication;

public class FixedDeposit extends Investment
{
    int Amount;

    public FixedDeposit(String name, int date, int amt, int gain)
    {
        this.name = name;
        this.date = date;
        this.Amount = amt;
        this.gainPercent = gain;
        this.currentMarketValue = Amount;
    }

    public void DailyUpdate()
    {
        if(date%7 == 0)
        {
            Amount = ((gainPercent + 100) * Amount)/100;
            currentMarketValue = Amount;
        }
    }
}
