package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.io.Serializable;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class Buy extends AppCompatActivity implements Serializable{

    Player player;
    Market m;
    EditText text;
    Investment temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        text =  (EditText) this.findViewById(R.id.number);
        String s = (String)intent.getSerializableExtra("name");
        m = ((MyApplication) this.getApplication()).m;
        player = ((MyApplication) this.getApplication()).player;

        TextView textView = (TextView) this.findViewById(R.id.buy_name);
        textView.setText(String.valueOf(s));

        temp = null;
        for(int i = 0; i < m.stocks.size();i++)
        {
            if(m.stocks.get(i).name.equals(s)) {
                temp = m.stocks.get(i);
                break;
            }
        }
        if(temp==null)
        {
            for(int i = 0; i < m.real_estate.size();i++)
            {
                if(m.real_estate.get(i).name.equals(s)) {
                    temp = m.real_estate.get(i);
                    break;
                }
            }
        }
        if(temp==null)
        {
            for(int i = 0; i < m.gold.size();i++)
            {
                if(m.gold.get(i).name.equals(s)) {
                    temp = m.gold.get(i);
                    break;
                }
            }
        }
        if(temp==null)
        {
            for(int i = 0; i < m.fixed_deposits.size();i++)
            {
                if(m.fixed_deposits.get(i).name.equals(s)) {
                    temp = m.fixed_deposits.get(i);
                    break;
                }
            }
        }

        if(temp!=null)
        {
            TextView textView1 = (TextView) this.findViewById(R.id.buy_current);
            textView1.setText(String.valueOf(temp.currentMarketValue));
            TextView textView2 = (TextView) this.findViewById(R.id.buy_gain);
            textView2.setText(String.valueOf(temp.gainPercent));
            TextView textView3 = (TextView) this.findViewById(R.id.buy_holding);
            textView3.setText(String.valueOf(player.myPortfolio.getCurrentHolding(s)));
        }

        /*m.day.setListener(new Date.ChangeListener() {
            @Override
            public void onChange() {
                Toast.makeText(getApplicationContext(),"blah", Toast.LENGTH_LONG).show();
            }
        });*/

        Button button = (Button) findViewById(R.id.buy);

        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                String content = text.getText().toString();
                try {
                    int buy = Integer.parseInt(content);
                    try{
                        player.buy(temp, buy);
                        finish();
                    }
                    catch(Exception e){
                        return;
                    }
                } catch(NumberFormatException e) {
                    return;
                } catch(NullPointerException e) {
                    return;
                }

            }   });

        Button button1 = (Button) findViewById(R.id.sell);

        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                String content = text.getText().toString();
                try {
                    int buy = Integer.parseInt(content);
                    try{
                        player.sell(temp, buy);
                        finish();
                    }
                    catch(Exception e){
                        return;
                    }
                } catch(NumberFormatException e) {
                    return;
                } catch(NullPointerException e) {
                    return;
                }

            }   });
        Button button2 = (Button) findViewById(R.id.exit);
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                finish();

            }   });
    }

}
