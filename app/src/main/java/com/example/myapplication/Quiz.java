package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;





public class Quiz extends AppCompatActivity {

    Player p;
    TextView question;
    RadioGroup rgroup;
    RadioButton option1,option2,option3,option4;
    RadioButton correct;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        p = ((MyApplication) this.getApplication()).player;
        String s = (String)intent.getSerializableExtra("name");;
        rgroup = (RadioGroup) this.findViewById(R.id.options);
        question = (TextView) this.findViewById(R.id.question);
        option1 = (RadioButton) this.findViewById(R.id.option1);
        option2 = (RadioButton) this.findViewById(R.id.option2);
        option3 = (RadioButton) this.findViewById(R.id.option3);
        option4 = (RadioButton) this.findViewById(R.id.option4);
        this.setUp(s);

        Button b = (Button)this.findViewById(R.id.verify);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                verify();

            }   });

    }

    public void verify()
    {
        System.out.println(rgroup.getCheckedRadioButtonId());
        RadioButton checkedRadioButton = (RadioButton) findViewById(rgroup.getCheckedRadioButtonId());
        if (rgroup.getCheckedRadioButtonId() == -1)
        {
            return;
        }
        else if(checkedRadioButton.equals(correct))
        {
            if(p.solved[index] == 0) {
                p.currentCash = p.currentCash + 10000;
                p.solved[index] = 1;
            }
            finish();
        }
        else
        {
            p.solved[index] = 2;
            finish();
        }
    }

    public void setUp(String s)
    {
        if(s.equals("shares_and_equity"))
        {
            index = 0;
            question.setText(String.valueOf("Question1"));
            option1.setText(String.valueOf("1"));
            option2.setText(String.valueOf("2"));
            option3.setText(String.valueOf("3"));
            option4 .setText(String.valueOf("4"));
            correct = option1;
        }
        else if(s.equals("ipo"))
        {
            index = 1;
            question.setText(String.valueOf("Question2"));
            option1.setText(String.valueOf("1"));
            option2.setText(String.valueOf("2"));
            option3.setText(String.valueOf("3"));
            option4 .setText(String.valueOf("4"));
            correct = option2;
        }
        else if(s.equals("stock_indices"))
        {
            index = 2;
            question.setText(String.valueOf("Question3"));
            option1.setText(String.valueOf("1"));
            option2.setText(String.valueOf("2"));
            option3.setText(String.valueOf("3"));
            option4 .setText(String.valueOf("4"));
            correct = option3;
        }
        else if(s.equals("types_of_shares"))
        {
            index = 3;
            question.setText(String.valueOf("Question4"));
            option1.setText(String.valueOf("1"));
            option2.setText(String.valueOf("2"));
            option3.setText(String.valueOf("3"));
            option4 .setText(String.valueOf("4"));
            correct = option4;
        }
        else if(s.equals("market_jargon"))
        {
            index = 4;
            question.setText(String.valueOf("Question5"));
            option1.setText(String.valueOf("1"));
            option2.setText(String.valueOf("2"));
            option3.setText(String.valueOf("3"));
            option4 .setText(String.valueOf("4"));
            correct = option1;
        }
    }



}
