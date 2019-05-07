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
import android.widget.Toast;


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
        //Set all objects
        p = ((MyApplication) this.getApplication()).player;
        //Get name of module from previous activity
        String s = (String)intent.getSerializableExtra("name");;
        rgroup = (RadioGroup) this.findViewById(R.id.options);
        question = (TextView) this.findViewById(R.id.question);
        option1 = (RadioButton) this.findViewById(R.id.option1);
        option2 = (RadioButton) this.findViewById(R.id.option2);
        option3 = (RadioButton) this.findViewById(R.id.option3);
        option4 = (RadioButton) this.findViewById(R.id.option4);
        this.setUp(s);

        //Verifiy if the answer is right
        Button b = (Button)this.findViewById(R.id.verify);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0)
            {
                verify();

            }   });

    }

    public void verify()
    {
        //Selected button
        RadioButton checkedRadioButton = (RadioButton) findViewById(rgroup.getCheckedRadioButtonId());
        if (rgroup.getCheckedRadioButtonId() == -1)
        {
            //None selected
            Toast.makeText(getBaseContext(), "Pick an Answer" , Toast.LENGTH_SHORT ).show();
            return;
        }
        else if(checkedRadioButton.equals(correct))
        {
            //Correct Selected, and unattempted
            if(p.solved[index] == 0) {
                p.currentCash = p.currentCash + 10000;
                p.solved[index] = 1;
            }
            Toast.makeText(getBaseContext(), "Right Answer! \n +10000 Cash" , Toast.LENGTH_SHORT ).show();

            //If attempted already, skip
            finish();
        }
        else
        {
            //Wrong Selected
            p.solved[index] = 2;
            Toast.makeText(getBaseContext(), "Wrong Answer!" , Toast.LENGTH_SHORT ).show();
            finish();
        }
    }

    public void setUp(String s)
    {
        //Set up the quiz page - question, options, and correct answer
        if(s.equals("shares_and_equity"))
        {
            index = 0;
            question.setText(String.valueOf("Why do businesses sell shares?"));
            option1.setText(String.valueOf("Because they like to"));
            option2.setText(String.valueOf("To expand the business"));
            option3.setText(String.valueOf("Can't get a loan"));
            option4 .setText(String.valueOf("Pressure from employees"));
            correct = option2;
        }
        else if(s.equals("ipo"))
        {
            index = 1;
            question.setText(String.valueOf("What is the difference between a public and a private company?"));
            option1.setText(String.valueOf("Public companies have sold a part of their shares to the public"));
            option2.setText(String.valueOf("Private companies are held by a private pool of investors"));
            option3.setText(String.valueOf("Both"));
            option4 .setText(String.valueOf("None"));
            correct = option3;
        }
        else if(s.equals("stock_indices"))
        {
            index = 2;
            question.setText(String.valueOf("Who should consider investing in an index?"));
            option1.setText(String.valueOf("Person betting on economy"));
            option2.setText(String.valueOf("Person who likes a specific company"));
            option3.setText(String.valueOf("Investor with high risk appetite"));
            option4 .setText(String.valueOf("Senior citizens"));
            correct = option1;
        }
        else if(s.equals("types_of_shares"))
        {
            index = 3;
            question.setText(String.valueOf("What is a preference share"));
            option1.setText(String.valueOf("A non voting share where the holder is entitled to dividend before the regular equity shareholder"));
            option2.setText(String.valueOf("A preferred share to get a vote in management of company"));
            option3.setText(String.valueOf("Preference to be repaid during liquidation of company"));
            option4 .setText(String.valueOf("A debt note"));
            correct = option1;
        }
        else if(s.equals("market_jargon"))
        {
            index = 4;
            question.setText(String.valueOf("What is face value of a stock?"));
            option1.setText(String.valueOf("The current market price of a share"));
            option2.setText(String.valueOf("The dividend per year on a share"));
            option3.setText(String.valueOf("Fixed denomination of a share of a company"));
            option4 .setText(String.valueOf("The discounted cash flow value of a share"));
            correct = option3;
        }
    }

}
