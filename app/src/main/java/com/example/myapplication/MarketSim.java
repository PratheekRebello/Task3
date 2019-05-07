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
import java.io.Serializable;
import android.text.method.ScrollingMovementMethod
;


public class MarketSim extends AppCompatActivity  implements Serializable {

    Market m;
    Player player;
    Thread thread;

    public void update()
    {
        //Perform updation every day
        m.DailyUpdate();
        player.UpdateFixedDeposit();
        System.out.println(player.myPortfolio.Maturity[16]);
        TextView textView = (TextView) this.findViewById(R.id.day);
        textView.setText(String.valueOf(m.day.date));
        TextView textView2 = (TextView) this.findViewById(R.id.current_cash);
        textView2.setText(String.valueOf(player.currentCash));
        TextView textView3 = (TextView) this.findViewById(R.id.assets);
        textView3.setText(String.valueOf(player.value()));
        TextView textView4 = (TextView) this.findViewById(R.id.bulletin1);
        TextView textView5 = (TextView) this.findViewById(R.id.bulletin2);
        TextView textView6 = (TextView) this.findViewById(R.id.bulletin3);
        textView6.setText(String.valueOf(textView5.getText()));
        textView5.setText(String.valueOf(textView4.getText()));
        textView4.setText(String.valueOf(m.data.provideNews()));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_sim);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set day, cash and asset value
        m = ((MyApplication) this.getApplication()).m;
        player = ((MyApplication) this.getApplication()).player;
        TextView textView = (TextView) this.findViewById(R.id.day);
        textView.setText(String.valueOf(m.day.date));
        TextView textView2 = (TextView) this.findViewById(R.id.current_cash);
        textView2.setText(String.valueOf(player.currentCash));
        TextView textView3 = (TextView) this.findViewById(R.id.assets);
        textView3.setText(String.valueOf(player.assets));

        TextView textView4 = (TextView) this.findViewById(R.id.bulletin1);
        TextView textView5 = (TextView) this.findViewById(R.id.bulletin2);
        TextView textView6 = (TextView) this.findViewById(R.id.bulletin3);
        textView4.setMovementMethod(new ScrollingMovementMethod());
        textView5.setMovementMethod(new ScrollingMovementMethod());
        textView6.setMovementMethod(new ScrollingMovementMethod());
        textView4.setText("No news today!");
        textView5.setText("No news today!");
        textView6.setText("No news today!");

        //Updating dates
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



        Button button = (Button) findViewById(R.id.gold);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                openBuyWindow("Gold");
            }   });

        //Go back to modules
        Button button6 = (Button) findViewById(R.id.ret);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {
                player.market_seen = true;
                Intent i = new Intent(getApplicationContext(),ModuleList.class);
                startActivity(i);
            }   });
    }

    //Anchor popup menus to buttons
    public void onClick(View anchor) {
        // TODO Auto-generated method stub
        PopupMenu popupMenu = new PopupMenu(MarketSim.this, anchor);
        //popupMenu.setOnDismissListener(new OnDismissListener());
        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener());
        if(anchor.equals(findViewById(R.id.stocks)))
            popupMenu.inflate(R.menu.stock_list);
        else if(anchor.equals(findViewById(R.id.real_estate)))
            popupMenu.inflate(R.menu.real_estate_list);
        else if(anchor.equals(findViewById(R.id.fixed_deposit)))
            popupMenu.inflate(R.menu.fixed_deposit_list);
        popupMenu.show();
    }

    //Go to the buy window
    public void openBuyWindow(String s)
    {
        Intent i = new Intent(getApplicationContext(),Buy.class);
        //Send name of investment as parameter
        i.putExtra("name", s);
        startActivity(i);
    }

    //PopUp Menu and decodings
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
                case R.id.SBI:
                    openBuyWindow("SBI");
                    return true;
                case R.id.BoI:
                    openBuyWindow("BoI");
                    return true;
                case R.id.ICICI:
                    openBuyWindow("ICICI");
                    return true;



            }
            return false;
        }
    }
}



