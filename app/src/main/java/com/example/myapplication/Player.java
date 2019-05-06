package com.example.myapplication;
import java.io.Serializable;

public class Player implements Serializable
{
    Portfolio myPortfolio;
    int currentCash;
    int assets;
    Market m;


    public Player(Market m)
    {
        myPortfolio = new Portfolio();
        this.m = m;
        //assets = myPortfolio.value();
        currentCash = 10000;
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
