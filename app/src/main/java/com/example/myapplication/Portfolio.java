package com.example.myapplication;
import java.util.*;

public class Portfolio
{
    LinkedList<Investment> listOfInvestments;

    public Portfolio()
    {
        listOfInvestments = new LinkedList<Investment>();
    }

    public void addInvestment(Investment inv)
    {
        this.listOfInvestments.add(inv);
    }
    public Investment getInvestment(String name)
    {
        Investment temp;
        for(int i = 0; i<this.listOfInvestments.size();i++)
        {
            temp = this.listOfInvestments.get(i);
            if(name.equals(temp.name))
            {
                return temp;
            }
        }
        return null;
    }

    public void removeInvestment(String name)
    {
        Investment temp = this.getInvestment(name);
        if(temp == null)
            return;
        else
            this.listOfInvestments.remove(temp);
    }

    public int value()
    {
        int v = 0;
        for(int i = 0; i<this.listOfInvestments.size();i++)
        {
            v = v+this.listOfInvestments.get(i).currentMarketValue;
        }
        return v;
    }
}
