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
}
