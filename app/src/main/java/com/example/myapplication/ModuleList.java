package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class ModuleList extends AppCompatActivity {

    Player p;
    Button button1, button2, button3, button4, button5, button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        p = ((MyApplication) this.getApplication()).player;

        //Buttons for different modules
        button1 = (Button) findViewById(R.id.shares_and_equity);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),SharesAndEquity.class);
                startActivityForResult(i, 1);

            }   });

        button2 = (Button) findViewById(R.id.IPO);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),IPO.class);
                startActivityForResult(i, 1);
            }   });

        button3 = (Button) findViewById(R.id.types_of_shares);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),TypesOfShares.class);
                startActivityForResult(i, 1);

            }   });

        button4 = (Button) findViewById(R.id.stock_indices);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),StockIndices.class);
                startActivityForResult(i, 1);
            }   });

        button5 = (Button) findViewById(R.id.market_jargon);
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   Intent i = new Intent(getApplicationContext(),MarketJargon.class);
                startActivityForResult(i, 1);
            }   });
        this.setColor(button1,0);
        this.setColor(button2,1);
        this.setColor(button3,2);
        this.setColor(button4,3);
        this.setColor(button5,4);
        button6 = (Button) findViewById(R.id.back);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {   finish();

            }   });


    }

    //Change colour based on right and wrong
    public void setColor(Button b, int i)
    {
        if(p.solved[i] == 1)
            b.setBackgroundColor(Color.parseColor("#00ff00"));
        else if(p.solved[i] == 2)
            b.setBackgroundColor(Color.parseColor("#ff0000"));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        this.setColor(button1,0);
        this.setColor(button2,1);
        this.setColor(button3,2);
        this.setColor(button4,3);
        this.setColor(button5,4);
    }


}
