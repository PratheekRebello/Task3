package com.example.myapplication;
import java.io.Serializable;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.*;
import android.content.Context;
import android.content.res.AssetManager;
import java.util.Random;

public class DataExtractor implements Serializable
{
    int ind = 10;
    Market m;
    Context c;
    String currentNews;
    Random rand = new Random();

    //Lists to hold real market data values
    List<List<List<String>>> stocks = new ArrayList<>();
    List<List<List<String>>> bonds = new ArrayList<>();
    List<List<List<String>>> real_estate = new ArrayList<>();
    List<List<List<String>>> gold = new ArrayList<>();
    List<List<String>> fixed_deposits = new ArrayList<>();
    List<List<String>> news = new ArrayList<>();

    public DataExtractor(Market m, Context c)
    {
        this.m = m;
        this.c = c;
        this.currentNews = "No news today!!";

        //Read data from .csv files
        for(int i = 0; i<m.stocks.size(); i++) {
            Stock temp = m.stocks.get(i);
            List<List<String>> l = read(temp.name.concat(".csv"));
            stocks.add(l);
        }
        for(int i = 0; i<m.gold.size(); i++)
        {
            Gold temp = m.gold.get(i);
            List<List<String>> l = read(temp.name.concat(".csv"));
            gold.add(l);
        }
        for(int i = 0; i<m.real_estate.size(); i++)
        {
            RealEstate temp = m.real_estate.get(i);
            List<List<String>> l = read(temp.name.concat(".csv"));
            real_estate.add(l);
        }
        fixed_deposits = read("fixed_deposits".concat(".csv"));
        news = read("stocks".concat(".csv"));
        Collections.shuffle(news);
    }


    //Function to read a list of list of strings i.e a csv file
    private List<List<String>> read(String s)
    {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.c.getAssets().open(s)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return records;
    }

    //Initialise Gold prices
    public void Initialise(int index, Gold gld)
    {
        String s = gold.get(index).get(ind+m.day.date).get(1);
        s = s.substring(1,s.length()-1);
        float f = Float.parseFloat(s);
        gld.currentMarketValue = f/100;
    }
    //Initialise Stock prices
    public void Initialise(int index, Stock stk)
    {
        String s = stocks.get(index).get(ind+(m.day.date % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f = Float.parseFloat(s);
        stk.currentMarketValue = f;
    }
    //Initialise Fixed Deposit rates
    public void FDInitialise(int index, FixedDeposit fd)
    {
        fd.gainPercent = Float.parseFloat(fixed_deposits.get(index).get(1));
        fd.maturity = Integer.parseInt(fixed_deposits.get(index).get(2));
        fd.currentMarketValue = 1;
    }
    public void RealEstateInitialise(int index, RealEstate fd)
    {
        fd.currentMarketValue = (float)(1000 + rand.nextInt(100) );
    }
    //Updating gain percent using real data
    public void updateGain(int index, Stock stk)
    {
        //Get value of this day
        String s = stocks.get(index).get(ind+(m.day.date % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f1 = Float.parseFloat(s);

        //Get value of next day
        s = stocks.get(index).get(ind+((m.day.date +1) % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f2 = Float.parseFloat(s);
        //Update Gain Percent
        stk.gainPercent = 100 * (f2 - f1)/f2;

        if(m.day.date % 50 == 0)
        {
            stk.currentMarketValue = f1;
        }
    }
    //Updating gain percent using real data for gold
    public void updateGainGold(int index, Gold stk)
    {
        //Get value of this day
        String s = gold.get(index).get(ind+(m.day.date % 400)).get(1);
        s = s.substring(1,s.length()-1);
        float f1 = Float.parseFloat(s);

        //Get value of next day
        s = gold.get(index).get(ind+((m.day.date +1) % 400)).get(1);
        s = s.substring(1,s.length()-1);
        float f2 = Float.parseFloat(s);
        //Update Gain percent
        stk.gainPercent = 100 * (f2 - f1)/f2;

        if(m.day.date % 50 == 0)
        {
            stk.currentMarketValue = f1/100;
        }
    }
    public void updateGainRealEstate(int index, RealEstate stk)
    {
        stk.gainPercent = rand.nextInt(5);
    }
    //Further updating gain percent using news data
    public void newsUpdate()
    {
        if(currentNews.equals("No news today!!"))
            return;
        else
        {
            List<String> l = news.get((m.day.date - 1) % 20);
            if (l == null)
                return;
            else {
                for (int i = 0; i < l.size() - 2; i++) {
                    m.stocks.get(i).gainPercent = m.stocks.get(i).gainPercent + Float.parseFloat(l.get(i + 1));
                }
                m.gold.get(0).gainPercent = m.gold.get(0).gainPercent + Float.parseFloat(l.get(11));
            }
        }
    }
    //Give string news data
    public String provideNews()
    {
        if(rand.nextInt() % 2 == 0)
            currentNews = news.get(m.day.date % 20).get(0);
        else currentNews = "No news today!!";
        return currentNews;
    }
}
