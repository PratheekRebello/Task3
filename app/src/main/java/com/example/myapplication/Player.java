package com.example.myapplication;

public class Player
{
    Portfolio myPortfolio;
    int currentCash;
    int assets;
    Market m;


    public Player(Market m)
    {
        myPortfolio = new Portfolio();
        this.m = m;
        assets = myPortfolio.value();
    }

    public void Invest(Investment inv) throws NotEnoughMoney
    {
        if(currentCash < inv.currentSellingPrice) {
            throw new NotEnoughMoney();
        }
        inv.date = m.day;
        myPortfolio.addInvestment(inv);
        currentCash = currentCash - inv.currentSellingPrice;
    }
}
