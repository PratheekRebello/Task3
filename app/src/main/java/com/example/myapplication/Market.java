package com.example.myapplication;
import java.util.*;
import android.content.Context;

public class Market
{
    int day;
    DataExtractor data;
    LinkedList<Stock> stocks = new LinkedList<>();
    LinkedList<Bond> bonds = new LinkedList<>();
    LinkedList<Gold> gold = new LinkedList<>();
    LinkedList<RealEstate> real_estate = new LinkedList<>();
    LinkedList<MutualFund> mutual_funds = new LinkedList<>();
    LinkedList<FixedDeposit> fixed_deposits = new LinkedList<>();

    public Market(Context con)
    {
        day = 1;
        Stock a = new Stock("Reliance", 1, 0,0);
        Stock b = new Stock("TataSteel", 1, 0,0);
        Stock c = new Stock("HDFC", 1, 0,0);
        Stock d = new Stock("Infosys", 1, 0,0);
        Stock e = new Stock("Cipla", 1, 0,0);
        Stock f = new Stock("ONGC", 1, 0,0);
        Stock g = new Stock("MarutiSuzuki", 1, 0,0);
        Stock h = new Stock("Unilever", 1, 0,0);
        Stock i = new Stock("Britannia", 1, 0,0);
        Stock j = new Stock("BajajFinance", 1, 0,0);

        stocks.add(a);
        stocks.add(b);
        stocks.add(c);
        stocks.add(d);
        stocks.add(e);
        stocks.add(f);
        stocks.add(g);
        stocks.add(h);
        stocks.add(i);
        stocks.add(j);

        Bond aa = new Bond("NHAI",1,0,0);
        Bond bb = new Bond("NABARD - National Bank for Agricultural and Rural Development",1,0,0);
        Bond cc = new Bond("IndianRailways",1,0,0);

        bonds.add(aa);
        bonds.add(bb);
        bonds.add(cc);

        FixedDeposit aaa = new FixedDeposit("SBI",1,0,0);
        FixedDeposit bbb = new FixedDeposit("HDFC",1,0,0);
        FixedDeposit ccc = new FixedDeposit("ICICI",1,0,0);
        FixedDeposit ddd = new FixedDeposit("Canara",1,0,0);

        fixed_deposits.add(aaa);
        fixed_deposits.add(bbb);
        fixed_deposits.add(ccc);

        Gold go = new Gold("Gold",1,0,0);
        gold.add(go);

        RealEstate x;
        for(int in = 0; in<20; in++)
        {
            x = new RealEstate("RealEstate",1,0,0);
            real_estate.add(x);
        }
        data = new DataExtractor(this, con);

        Initialise();
    }

    public void Initialise()
    {
        for(int i = 0; i<stocks.size(); i++)
        {
            data.Initialise(i,stocks.get(i));
        }
    }
    public void DailyUpdate()
    {
        this.day = this.day +1;
        for(int i = 0; i<stocks.size(); i++)
        {
            data.updateGain(i,stocks.get(i));
            stocks.get(i).DailyUpdate();
        }
    }

   /* public static void main(String args[])
    {
        Market m = new Market();
        m.Initialise();
        for(int i = 0; i<m.stocks.size(); i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).date);
            System.out.print(" ");
            System.out.println(m.stocks.get(i).currentMarketValue);
        }
        System.out.print("\n");
        m.day = m.day +1;
        m.DailyUpdate();
        for(int i = 0; i<m.stocks.size(); i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).date);
            System.out.print(" ");
            System.out.println(m.stocks.get(i).currentMarketValue);
        }
        System.out.print("\n");
        m.day = m.day +1;
        m.DailyUpdate();
        for(int i = 0; i<m.stocks.size(); i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).date);
            System.out.print(" ");
            System.out.println(m.stocks.get(i).currentMarketValue);
        }
        System.out.print("\n");
        m.day = m.day +1;
        m.DailyUpdate();
        for(int i = 0; i<m.stocks.size(); i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).date);
            System.out.print(" ");
            System.out.println(m.stocks.get(i).currentMarketValue);
        }
    }*/

}

