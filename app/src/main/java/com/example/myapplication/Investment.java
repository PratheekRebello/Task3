package com.example.myapplication;
import java.io.Serializable;

public class Investment implements Serializable
{
    String name;
    float currentMarketValue;
    int currentSellingPrice;
    Date date = new Date();
    float gainPercent;
    int liquidity;

    public void DailyUpdate()
    {
        currentMarketValue = ((100 + gainPercent) * (float)currentMarketValue)/100;
        date.date = date.date+1;
    }
    public void DateUpdate()
    {
        date.date = date.date + 1;
    }

}
