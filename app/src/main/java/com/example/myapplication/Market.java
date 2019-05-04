package com.example.myapplication;
import java.util.*;

public class Market
{
    LinkedList<Stock> stocks = new LinkedList<Stock>();
    LinkedList<Bond> bonds = new LinkedList<Bond>();
    LinkedList<Gold> gold = new LinkedList<Gold>();
    LinkedList<RealEstate> real_estate = new LinkedList<RealEstate>();
    LinkedList<MutualFund> mutual_funds = new LinkedList<MutualFund>();
    LinkedList<FixedDeposit> fixed_deposits = new LinkedList<FixedDeposit>();

    DataExtractor data = new DataExtractor();
    public Market()
    {
        Stock a = new Stock("Reliance", 1, data.get("Reliance"), data.getG("Reliance"));
        Stock b = new Stock("TataSteel", 1, data.get("TataSteel"), data.getG("TataSteel"));
        Stock c = new Stock("HDFC", 1, data.get("HDFC"), data.getG("HDFC"));
        Stock d = new Stock("Infosys", 1, data.get("Infosys"), data.getG("Infosys"));
        Stock e = new Stock("SunPharma", 1, data.get("SunPharma"), data.getG("SunPharma"));
        Stock f = new Stock("ONGC", 1, data.get("ONGC"), data.getG("ONGC"));
        Stock g = new Stock("MarutiSuzuki", 1, data.get("MarutiSuzuki"), data.getG("MarutiSuzuki"));
        Stock h = new Stock("Unilever", 1, data.get("Unilever"), data.getG("Unilever"));
        Stock i = new Stock("Nestle", 1, data.get("Nestle"), data.getG("Nestle"));
        Stock j = new Stock("BajajFinance", 1, data.get("BajajFinance"), data.getG("BajajFinance"));

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

        Bond aa = new Bond("LIC",1,data.get("LIC"),data.getG("LIC"));
        Bond bb = new Bond("NBARD - National Bank for Agricultural and Rural Development",1,data.get("NBARD - National Bank for Agricultural and Rural Development"),data.getG("NBARD - National Bank for Agricultural and Rural Development"));
        Bond cc = new Bond("IndianRailways",1,data.get("IndianRailways"),data.getG("IndianRailways"));

        bonds.add(aa);
        bonds.add(bb);
        bonds.add(cc);

        FixedDeposit aaa = new FixedDeposit("SBI",1,0,data.getG("SBI"));
        FixedDeposit bbb = new FixedDeposit("HDFC",1,0,data.getG("HDFC"));
        FixedDeposit ccc = new FixedDeposit("ICICI",1,0,data.getG("ICICI"));
        FixedDeposit ddd = new FixedDeposit("Canara",1,0,data.getG("Canara"));

        fixed_deposits.add(aaa);
        fixed_deposits.add(bbb);
        fixed_deposits.add(ccc);

        Gold go = new Gold("Gold",1,data.get("Gold"),data.getG("Gold"));
        gold.add(go);

        RealEstate x;
        for(int in = 0; in<20; in++)
        {
            x = new RealEstate("RealEstate",1,data.get("RealEstate"),data.getG("RealEstate"));
            real_estate.add(x);
        }
    }

    public static void main()
    {
        Market m = new Market();
        for(int i = 0; i<m.stocks.size();i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).currentMarketValue);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).gainPercent);
            System.out.print("\n");
        }
        System.out.print("\n");
        for(int i = 0; i<m.stocks.size();i++)
        {
            m.stocks.get(i).DailyUpdate();
        }
        for(int i = 0; i<m.stocks.size();i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).currentMarketValue);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).gainPercent);
            System.out.print("\n");
        }
        System.out.print("\n");
        for(int i = 0; i<m.stocks.size();i++)
        {
            m.stocks.get(i).DailyUpdate();
        }
        for(int i = 0; i<m.stocks.size();i++)
        {
            System.out.print(m.stocks.get(i).name);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).currentMarketValue);
            System.out.print(" ");
            System.out.print(m.stocks.get(i).gainPercent);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}

