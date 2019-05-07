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

public class TypesOfShares extends AppCompatActivity {

    //Module activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_shares);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Take Quiz
        Button b = (Button) this.findViewById(R.id.take4);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                Intent i = new Intent(getApplicationContext(),Quiz.class);
                i.putExtra("name", "types_of_shares");
                startActivity(i);
                finish();
            }   });
    }

}
