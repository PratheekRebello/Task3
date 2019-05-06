package com.example.myapplication;
import java.io.Serializable;

public class Player implements Serializable
{
    Portfolio myPortfolio;
    int currentCash;
    int assets;
    boolean market_seen;
    Market m;
    int[] solved = new int[5];


    public Player(Market m)
    {
        myPortfolio = new Portfolio();
        this.m = m;
        market_seen = false;
        //assets = myPortfolio.value();
        currentCash = 10000;
        for(int i = 0; i<solved.length;i++)
        {
            solved[i] = 0;
        }
    }

    public void buy(Investment inv,int units) throws NotEnoughMoney
    {
        if(currentCash < units * inv.currentMarketValue)
            throw new NotEnoughMoney();
        else{
            currentCash = currentCash - (int)(units * inv.currentMarketValue);
            myPortfolio.addInvestment(inv.name, units,true);}
    }
    public void sell(Investment inv,int units) throws NotEnoughMoney
    {
        if(myPortfolio.getCurrentHolding(inv.name) < units)
            throw new NotEnoughMoney();
        else {
            currentCash = currentCash + (int)(units * inv.currentMarketValue);
            myPortfolio.addInvestment(inv.name, units, false);
        }
    }
    public float value()
    {
        float val = 0;
        for(int i = 0; i<10;i++)
        {
            val = val + m.stocks.get(i).currentMarketValue * myPortfolio.getCurrentHolding(m.stocks.get(i).name);
        }
        for(int i = 11; i<15;i++)
        {
            val = val + m.real_estate.get(i-10).currentMarketValue * myPortfolio.getCurrentHolding(m.real_estate.get(i-10).name);
        }
        for(int i = 15; i<16;i++)
        {
            val = val + m.gold.get(i-15).currentMarketValue * myPortfolio.getCurrentHolding(m.gold.get(i-15).name);
        }
        for(int i = 16; i<19;i++)
        {
            val = val + m.fixed_deposits.get(i-16).currentMarketValue * myPortfolio.getCurrentHolding(m.fixed_deposits.get(i-16).name);
        }
        return val;
    }
}
