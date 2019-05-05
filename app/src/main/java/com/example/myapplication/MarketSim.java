package com.example.myapplication;

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
public class MarketSim extends AppCompatActivity {

    Market m;
    Player player;

    public void update()
    {
        m.DailyUpdate();
        TextView textView = (TextView) this.findViewById(R.id.day);
        textView.setText(String.valueOf(m.day));
        TextView textView2 = (TextView) this.findViewById(R.id.current_cash);
        textView2.setText(String.valueOf(m.stocks.get(2).currentMarketValue));

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



        Thread thread = new Thread() {

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



}
