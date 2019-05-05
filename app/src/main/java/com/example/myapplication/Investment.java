package com.example.myapplication;

public class Investment
{
    String name;
    int currentMarketValue;
    int currentSellingPrice;
    int date;
    float gainPercent;
    int liquidity;

    public void DailyUpdate()
    {
        currentMarketValue = (int)((100 + gainPercent) * (float)currentMarketValue)/100;
        date = date+1;
    }
    public void DateUpdate()
    {
        date = date + 1;
    }

}
