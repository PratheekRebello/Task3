package com.example.myapplication;
import java.util.*;
import android.content.Context;
import java.io.Serializable;
public class Market implements Serializable
{
    Date day;
    DataExtractor data;
    LinkedList<Stock> stocks = new LinkedList<>();
    LinkedList<Bond> bonds = new LinkedList<>();
    LinkedList<Gold> gold = new LinkedList<>();
    LinkedList<RealEstate> real_estate = new LinkedList<>();
    LinkedList<MutualFund> mutual_funds = new LinkedList<>();
    LinkedList<FixedDeposit> fixed_deposits = new LinkedList<>();

    public Market(Context con)
    {
        day = new Date();
        Stock a = new Stock("Reliance", 1, 0,0);
        Stock b = new Stock("Tata Steel", 1, 0,0);
        Stock c = new Stock("HDFC", 1, 0,0);
        Stock d = new Stock("Infosys", 1, 0,0);
        Stock e = new Stock("Cipla", 1, 0,0);
        Stock f = new Stock("ONGC", 1, 0,0);
        Stock g = new Stock("Maruti Suzuki", 1, 0,0);
        Stock h = new Stock("Unilever", 1, 0,0);
        Stock i = new Stock("Britannia", 1, 0,0);
        Stock j = new Stock("Bajaj Finance", 1, 0,0);

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
        FixedDeposit bbb = new FixedDeposit("BoI",1,0,0);
        FixedDeposit ccc = new FixedDeposit("ICICI",1,0,0);

        fixed_deposits.add(aaa);
        fixed_deposits.add(bbb);
        fixed_deposits.add(ccc);

        Gold go = new Gold("Gold",1,0,0);
        gold.add(go);

        RealEstate x;
        RealEstate dddd = new RealEstate("Delhi",1,0,0);
        RealEstate mmmm = new RealEstate("Mumbai",1,0,0);
        RealEstate kkkk = new RealEstate("Kolkata",1,0,0);
        RealEstate bbbb = new RealEstate("Bangalore",1,0,0);
        RealEstate cccc = new RealEstate("Chennai",1,0,0);
        real_estate.add(dddd);
        real_estate.add(mmmm);
        real_estate.add(kkkk);
        real_estate.add(bbbb);
        real_estate.add(cccc);

        data = new DataExtractor(this, con);

        Initialise();
    }

    public void Initialise()
    {
        for(int i = 0; i<stocks.size(); i++)
        {
            data.Initialise(i,stocks.get(i));
        }
        for(int i = 0; i<gold.size(); i++)
        {
            data.Initialise(i,gold.get(i));
        }
    }
    public void DailyUpdate()
    {
        this.day.date = this.day.date +1;
        for(int i = 0; i<stocks.size(); i++)
        {
            data.updateGain(i,stocks.get(i));
            stocks.get(i).DailyUpdate();
        }
        for(int i = 0; i<gold.size(); i++)
        {
            data.updateGainGold(i,gold.get(i));
            gold.get(i).DailyUpdate();
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

