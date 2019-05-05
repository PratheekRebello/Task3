package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Period;
import android.content.Context;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.MenuInflater;


public class MarketSim extends AppCompatActivity {

    Market m;
    Player player;
    Thread thread;

    public void update()
    {
        m.DailyUpdate();
        TextView textView = (TextView) this.findViewById(R.id.day);
        textView.setText(String.valueOf(m.day));
        TextView textView2 = (TextView) this.findViewById(R.id.current_cash);
        textView2.setText(String.valueOf(player.currentCash));
        TextView textView3 = (TextView) this.findViewById(R.id.assets);
        textView3.setText(String.valueOf(player.assets));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_sim);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m = new Market(getApplicationContext());
        player = new Player(m);
        TextView textView = (TextView) this.findViewById(R.id.day);
        textView.setText(String.valueOf(m.day));
        TextView textView2 = (TextView) this.findViewById(R.id.current_cash);
        textView2.setText(String.valueOf(player.currentCash));
        TextView textView3 = (TextView) this.findViewById(R.id.assets);
        textView3.setText(String.valueOf(player.assets));
        //textView3.setText(String.valueOf(m.data.gold.get(0)));



        thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                update();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();
    }


    public void onClick(View anchor) {
        // TODO Auto-generated method stub
        PopupMenu popupMenu = new PopupMenu(MarketSim.this, anchor);
        //popupMenu.setOnDismissListener(new OnDismissListener());
        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener());
        if(anchor.equals(findViewById(R.id.stocks)))
            popupMenu.inflate(R.menu.stock_list);
        else
            popupMenu.inflate(R.menu.real_estate_list);
        popupMenu.show();
    }

    /*private class OnDismissListener implements PopupMenu.OnDismissListener {

        @Override
        public void onDismiss(PopupMenu menu) {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), "Popup Menu is dismissed",
                    Toast.LENGTH_SHORT).show();
        }

    }*/
    public void openBuyWindow(String s)
    {
        /*try{thread.sleep(10000);}
        catch(Exception e)
        {
        }*/
        Intent i = new Intent(getApplicationContext(),Buy.class);
        startActivity(i);
        //TextView textView = (TextView) this.findViewById(R.id.buy_name);
        //textView.setText(String.valueOf(s));
        Toast.makeText(getApplicationContext(), s,
                Toast.LENGTH_SHORT).show();
    }
    private class OnMenuItemClickListener implements
            PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // TODO Auto-generated method stub
            switch (item.getItemId()) {
                case R.id.Reliance:
                    openBuyWindow("Reliance");
                    return true;
                case R.id.Tata_Steel:
                    openBuyWindow("Tata Steel");
                    return true;
                case R.id.HDFC:
                    openBuyWindow("HDFC");
                    return true;
                case R.id.Cipla:
                    openBuyWindow("Cipla");
                    return true;
                case R.id.Infosys:
                    openBuyWindow("Infosys");
                    return true;
                case R.id.Maruti_Suzuki:
                    openBuyWindow("Maruti Suzuki");
                    return true;
                case R.id.Unilever:
                    openBuyWindow("Unilever");
                    return true;
                case R.id.Britannia:
                    openBuyWindow("Britannia");
                    return true;
                case R.id.ONGC:
                    openBuyWindow("ONGC");
                    return true;
                case R.id.Bajaj_Finance:
                    openBuyWindow("Bajaj Finance");
                    return true;

                case R.id.Delhi:
                    openBuyWindow("Delhi");
                    return true;
                case R.id.Mumbai:
                    openBuyWindow("Mumbai");
                    return true;
                case R.id.Kolkata:
                    openBuyWindow("Kolkata");
                    return true;
                case R.id.Bangalore:
                    openBuyWindow("Bangalore");
                    return true;
                case R.id.Chennai:
                    openBuyWindow("Chennai");
                    return true;


            }
            return false;
        }
    }
}



