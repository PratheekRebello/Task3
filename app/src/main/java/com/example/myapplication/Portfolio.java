package com.example.myapplication;
import android.widget.Toast;

import java.util.*;
import java.io.Serializable;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Portfolio implements Serializable
{
    //Array of Qauntities of Each investment
    int[] Quantity = new int[19];
    //Array of Maturities of Each investment - if -1, it is liquid
    int [] Maturity = new int[19];
    Market m;

    public Portfolio(Market m)
    {
        this.m = m;
        for(int i = 0; i< Maturity.length;i++)
            Maturity[i] = -1;
    }
    //Add amt units of an investment
    public void addInvestment(String s, int amt, boolean up)
    {
        if(!up)
            amt = -amt;

        if(s.equals("Reliance"))
            Quantity[0] = Quantity[0] +amt;
        else if(s.equals("Tata Steel"))
            Quantity[1] = Quantity[1] +amt;
        else if(s.equals("HDFC"))
            Quantity[2] = Quantity[2] +amt;
        else if(s.equals("Infosys"))
            Quantity[3] = Quantity[3] +amt;
        else if(s.equals("Cipla"))
            Quantity[4] = Quantity[4] +amt;
        else if(s.equals("ONGC"))
            Quantity[5] = Quantity[5] +amt;
        else if(s.equals("Maruti Suzuki"))
            Quantity[6] = Quantity[6] +amt;
        else if(s.equals("Unilever"))
            Quantity[7] = Quantity[7] +amt;
        else if(s.equals("Britannia"))
            Quantity[8] = Quantity[8] +amt;
        else if(s.equals("Bajaj Finance"))
            Quantity[9] = Quantity[9] +amt;
        else if(s.equals("Delhi"))
            Quantity[10] = Quantity[10] +amt;
        else if(s.equals("Mumbai"))
            Quantity[11] = Quantity[11] +amt;
        else if(s.equals("Kolkata"))
            Quantity[12] = Quantity[12] +amt;
        else if(s.equals("Bangalore"))
            Quantity[13] = Quantity[13] +amt;
        else if(s.equals("Chennai"))
            Quantity[14] = Quantity[14] +amt;
        else if(s.equals("Gold"))
            Quantity[15] = Quantity[15] +amt;
        else if(s.equals("SBI")) {
            if (Maturity[16] == -1) {
                Quantity[16] = Quantity[16] + amt;
                Maturity[16] = m.fixed_deposits.get(0).maturity;
            }
        }
        else if(s.equals("BoI"))
        {
            if (Maturity[17] == -1) {
                Quantity[17] = Quantity[17] + amt;
                Maturity[17] = m.fixed_deposits.get(0).maturity;
            }
        }
        else if(s.equals("ICICI"))
        {
            if (Maturity[18] == -1) {
                Quantity[18] = Quantity[18] + amt;
                Maturity[18] = m.fixed_deposits.get(0).maturity;
            }
        }
    }
    //Get Maturity date
    public int getMaturity(String s)
    {
        if(s.equals("Reliance"))
            return Maturity[0];
        else if(s.equals("Tata Steel"))
            return Maturity[1];
        else if(s.equals("HDFC"))
            return Maturity[2];
        else if(s.equals("Infosys"))
            return Maturity[3];
        else if(s.equals("Cipla"))
            return Maturity[4];
        else if(s.equals("ONGC"))
            return Maturity[5];
        else if(s.equals("Maruti Suzuki"))
            return Maturity[6];
        else if(s.equals("Unilever"))
            return Maturity[7];
        else if(s.equals("Britannia"))
            return Maturity[8];
        else if(s.equals("Bajaj Finance"))
            return Maturity[9];
        else if(s.equals("Delhi"))
            return Maturity[10];
        else if(s.equals("Mumbai"))
            return Maturity[11];
        else if(s.equals("Kolkata"))
            return Maturity[12];
        else if(s.equals("Bangalore"))
            return Maturity[13];
        else if(s.equals("Chennai"))
            return Maturity[14];
        else if(s.equals("Gold"))
            return Maturity[15];
        else if(s.equals("SBI"))
            return Maturity[16];
        else if(s.equals("BoI"))
            return Maturity[17];
        else if(s.equals("ICICI"))
            return Maturity[18];
        else
            return 0;
    }
    //Get current Quantity held
    public int getCurrentHolding(String s)
    {
        if(s.equals("Reliance"))
            return Quantity[0];
        else if(s.equals("Tata Steel"))
            return Quantity[1];
        else if(s.equals("HDFC"))
            return Quantity[2];
        else if(s.equals("Infosys"))
            return Quantity[3];
        else if(s.equals("Cipla"))
            return Quantity[4];
        else if(s.equals("ONGC"))
            return Quantity[5];
        else if(s.equals("Maruti Suzuki"))
            return Quantity[6];
        else if(s.equals("Unilever"))
            return Quantity[7];
        else if(s.equals("Britannia"))
            return Quantity[8];
        else if(s.equals("Bajaj Finance"))
            return Quantity[9];
        else if(s.equals("Delhi"))
            return Quantity[10];
        else if(s.equals("Mumbai"))
            return Quantity[11];
        else if(s.equals("Kolkata"))
            return Quantity[12];
        else if(s.equals("Bangalore"))
            return Quantity[13];
        else if(s.equals("Chennai"))
            return Quantity[14];
        else if(s.equals("Gold"))
            return Quantity[15];
        else if(s.equals("SBI"))
            return Quantity[16];
        else if(s.equals("BoI"))
            return Quantity[17];
        else if(s.equals("ICICI"))
            return Quantity[18];
        else
            return 0;
    }
}
