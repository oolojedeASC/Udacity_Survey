package com.example.olaoluwa.udacitysurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int getFirst_Quest_score = 0;
    int getSecond_Quest_score = 0;
    int getThirdQuest_score = 0;
    int getFourthQuest_score = 0;
    int getFifth_Quest_score = 0;

    // When the First Question Answers are Clicked
    public void RadioButtonQ1(View view) {
        // Is the button now checked?
        boolean checkQ1 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1_answer_1:
                if (checkQ1)
                    getFirst_Quest_score = 1;
                break;
            case R.id.q1_answer_2:
                if (checkQ1)
                    getFirst_Quest_score = 0;
                break;
        }
    }

    // When the Second Question Answers are Clicked
    public void RadioButtonQ2(View view) {
        // Is the button now checked?
        boolean checkQ2 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2_answer_1:
                if (checkQ2)
                    getSecond_Quest_score = 1;
                break;
            case R.id.q2_answer_2:
                if (checkQ2)
                    getSecond_Quest_score = 0;
                break;
        }
    }

    // When the Fifth Question Answers are Clicked
    public void RadioButtonQ5(View view) {
        // Is the button now checked?
        boolean checkQ5 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q5_answer_1:
                if (checkQ5)
                    getFifth_Quest_score = 1;
                break;
            case R.id.q5_answer_2:
                if (checkQ5)
                    getFifth_Quest_score = 0;
                break;
        }
    }

    private void surveyCalculation(){

        // Converts the EditTest for question 3 to an integer
        EditText q3Answer   = (EditText)findViewById(R.id.q3_answer);
        String value3= q3Answer.getText().toString();
        int finalValue1 =Integer.parseInt(value3);

        // 24 hour clock (12AM - 5AM)
        if ((24 <= finalValue1) && (finalValue1 >= 5) ){
            getThirdQuest_score = 0;
        } else{
            getThirdQuest_score = 1;
        }

        // Converts the EditTest for question 4 to an integer
        EditText q4Answer   = (EditText)findViewById(R.id.q4_answer);
        String value4= q4Answer.getText().toString();
        int finalValue2 =Integer.parseInt(value4);

        // 24 hour clock (12AM-12PM)
        if ((10 <= finalValue2) && (finalValue2 >= 24) ){
            getFourthQuest_score = 1;
        } else{
            getFourthQuest_score = 0;
        }

    }

    public void submitResponse(View view) {
        //surveyCalculation();
        EditText userName = (EditText)findViewById(R.id.User_Name);
        String userValue = userName.getText().toString();

        if (getFirst_Quest_score + getSecond_Quest_score + getThirdQuest_score + getFourthQuest_score + getFifth_Quest_score >= 3) {
            Toast.makeText(this, userValue + " You are a Lark!", Toast.LENGTH_LONG).show();
        } if(getFirst_Quest_score + getSecond_Quest_score + getThirdQuest_score + getFourthQuest_score + getFifth_Quest_score < 3){
            Toast.makeText(this, userValue + " You are an Owl", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, userValue + " Please Answer All of the Questions", Toast.LENGTH_LONG).show();
        }


    }


    }









