package com.example.myapplication;
import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SharesAndEquity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_and_equity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b = (Button) this.findViewById(R.id.take1);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                Intent i = new Intent(getApplicationContext(),Quiz.class);
                i.putExtra("name", "shares_and_equity");
                startActivity(i);
                finish();
            }   });
    }
}


