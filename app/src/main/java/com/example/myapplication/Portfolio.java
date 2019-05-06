package com.example.myapplication;
import java.util.*;
import java.io.Serializable;

public class Portfolio implements Serializable
{
    int[] Quantity = new int[19];

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
        else if(s.equals("SBI"))
            Quantity[16] = Quantity[16] +amt;
        else if(s.equals("BoI"))
            Quantity[17] = Quantity[17] +amt;
        else if(s.equals("ICICI"))
            Quantity[18] = Quantity[18] +amt;
    }
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
