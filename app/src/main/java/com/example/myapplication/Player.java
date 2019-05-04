package com.example.myapplication;

public class Player
{
    int date;
    Portfolio myPortfolio;
    int currentCash;



    public Player()
    {
        date = 1;
        myPortfolio = new Portfolio();
    }

    public void Invest(Investment inv) throws NotEnoughMoney
    {
        if(currentCash < inv.currentSellingPrice) {
            throw new NotEnoughMoney();
        }
        inv.date = date;
        myPortfolio.addInvestment(inv);
        currentCash = currentCash - inv.currentSellingPrice;
    }
}
