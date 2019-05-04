package com.example.myapplication;

public class Investment
{
    String name;
    int currentMarketValue;
    int currentSellingPrice;
    int date;
    int gainPercent;
    int liquidity;

    public void DailyUpdate()
    {
        currentMarketValue = ((100 + gainPercent) * currentMarketValue)/100;
    }
    public void DateUpdate()
    {
        date = date + 1;
    }

}
