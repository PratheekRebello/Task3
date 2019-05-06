package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MarketJargon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_jargon);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b = (Button) this.findViewById(R.id.take5);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                Intent i = new Intent(getApplicationContext(),Quiz.class);
                i.putExtra("name", "market_jargon");
                startActivity(i);
                finish();
            }   });
    }

}
