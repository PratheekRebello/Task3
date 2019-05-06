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
    List<List<List<String>>> fixed_deposits = new ArrayList<>();

    public DataExtractor(Market m, Context c)
    {
        this.m = m;
        this.c = c;
        for(int i = 0; i<m.stocks.size(); i++)
        {
            Stock temp = m.stocks.get(i);
            List<List<String>> l = read(temp.name.concat(".csv"));
            stocks.add(l);
        }
        for(int i = 0; i<m.bonds.size(); i++)
        {
            Bond temp = m.bonds.get(i);
            List<List<String>> l = read(temp.name.concat(".csv"));
            bonds.add(l);
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
        gld.currentMarketValue = f;
    }

    public void Initialise(int index, Stock stk)
    {
        String s = stocks.get(index).get(ind+(m.day.date % 400)).get(3);
        s = s.substring(1,s.length()-1);
        float f = Float.parseFloat(s);
        stk.currentMarketValue = f;
    }

    public void updateGain(int index, Investment stk)
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
        /*Random rand = new Random();
        int gain = rand.nextInt(2000);
        gain = gain - 1000;
        float gainP = ((float)(gain))/100;
        stk.gainPercent = gainP;*/

    }
    /*public static void main(String args[]) {
        Market m = new Market();
        System.out.println(m.data.stocks.get(1));
    }*/
}
