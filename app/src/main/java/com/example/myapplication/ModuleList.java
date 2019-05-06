package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ModuleList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button) findViewById(R.id.shares_and_equity);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),SharesAndEquity.class);
                startActivity(i);

            }   });
        Button button2 = (Button) findViewById(R.id.IPO);

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),IPO.class);
                startActivity(i);

            }   });
        Button button3 = (Button) findViewById(R.id.types_of_shares);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),TypesOfShares.class);
                startActivity(i);

            }   });
        Button button4 = (Button) findViewById(R.id.stock_indices);

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),StockIndices.class);
                startActivity(i);

            }   });
        Button button5 = (Button) findViewById(R.id.market_jargon);

        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),MarketJargon.class);
                startActivity(i);

            }   });
        Button button6 = (Button) findViewById(R.id.back);

        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   finish();

            }   });
    }
}
