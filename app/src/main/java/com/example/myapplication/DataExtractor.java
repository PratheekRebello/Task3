package com.example.myapplication;
import java.io.Serializable;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.*;
import android.content.Context;
import android.content.res.AssetManager;

public class DataExtractor implements Serializable
{
    int ind = 10;
    Market m;
    Context c;
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
        news = read("news".concat(".csv"));
    }



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

    public void Initialise(int index, Gold gld)
    {
        String s = gold.get(index).get(ind+m.day.date).get(1);
        s = s.substring(1,s.length()-1);
        float f = Float.parseFloat(s);
        gld.currentMarketValue = f/100;
    }

    public void Initialise(int index, Stock stk)
    {
        String s = stocks.get(index).get(ind+(m.day.date % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f = Float.parseFloat(s);
        stk.currentMarketValue = f;
    }
    public void FDInitialise(int index, FixedDeposit fd)
    {
        fd.gainPercent = Float.parseFloat(fixed_deposits.get(index).get(1));
        fd.currentMarketValue = 0;
    }

    public void updateGain(int index, Stock stk)
    {
        String s = stocks.get(index).get(ind+(m.day.date % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f1 = Float.parseFloat(s);

        s = stocks.get(index).get(ind+((m.day.date +1) % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f2 = Float.parseFloat(s);
        stk.gainPercent = 100 * (f2 - f1)/f2;

        if(m.day.date % 50 == 0)
        {
            stk.currentMarketValue = f1;
        }
    }

    public void updateGainGold(int index, Gold stk)
    {
        String s = gold.get(index).get(ind+(m.day.date % 400)).get(1);
        s = s.substring(1,s.length()-1);
        float f1 = Float.parseFloat(s);

        s = gold.get(index).get(ind+((m.day.date +1) % 400)).get(1);
        s = s.substring(1,s.length()-1);
        float f2 = Float.parseFloat(s);
        stk.gainPercent = 100 * (f2 - f1)/f2;

        if(m.day.date % 50 == 0)
        {
            stk.currentMarketValue = f1/100;
        }
    }
    public void newsUpdate()
    {
        List<String> l = news.get((m.day.date - 1) %6);
        if(l==null) return;
        else
            for(int i = 0; i<l.size()-1;i++)
            {
                m.stocks.get(i).gainPercent = m.stocks.get(i).gainPercent + Float.parseFloat(l.get(i+1));
            }
    }

    public String provideNews()
    {
        return news.get(m.day.date % 6).get(0);
    }
}
