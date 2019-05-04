package com.example.myapplication;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataExtractor
{
    public int get(String s)
    {
        return 1;
    }
    public int getG(String s)
    {
        return 1;
    }
    Market m;
    List<List<List<String>>> stocks = new ArrayList<>();
    List<List<List<String>>> bonds = new ArrayList<>();
    List<List<List<String>>> real_estate = new ArrayList<>();
    List<List<List<String>>> gold = new ArrayList<>();
    List<List<List<String>>> fixed_deposits = new ArrayList<>();

    public DataExtractor(Market m)
    {
        this.m = m;
        for(int i = 0; i<m.stocks.size(); i++)
        {
            Stock temp = m.stocks.get(i);
            List<List<String>> l = read("app/src/main/java/com/example/myapplication/sampledata/".concat(temp.name.concat(".csv")));
            stocks.add(l);
        }
        for(int i = 0; i<m.bonds.size(); i++)
        {
            Bond temp = m.bonds.get(i);
            List<List<String>> l = read("app/src/main/java/com/example/myapplication/sampledata/".concat(temp.name.concat(".csv")));
            bonds.add(l);
        }
        for(int i = 0; i<m.gold.size(); i++)
        {
            Gold temp = m.gold.get(i);
            List<List<String>> l = read("app/src/main/java/com/example/myapplication/sampledata/".concat(temp.name.concat(".csv")));
            gold.add(l);
        }
        for(int i = 0; i<m.real_estate.size(); i++)
        {
            RealEstate temp = m.real_estate.get(i);
            List<List<String>> l = read("app/src/main/java/com/example/myapplication/sampledata/".concat(temp.name.concat(".csv")));
            real_estate.add(l);
        }
    }



    private static List<List<String>> read(String s)
    {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(s))) {
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

    /*public static void main(String args[])
    {
        Market m = new Market();
        String currentDirectory = System.getProperty("user.dir");
        List<List<String>> test = read("app/src/main/java/com/example/myapplication/sampledata/".concat(s));
        System.out.println(test.get(3).get(3));
    }*/
}
