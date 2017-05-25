package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    int answers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

/*
* create method for all the 5 question
*/
    private void checkAllQuestions(){
        question1answer();
        question2answer();
        question3answer();
        question4answer();
        question5answer();

    }

 /*
 * check each question answer and if answer is true,increment answer by 1
 * */
    private void question1answer(){
        RadioButton question1 = (RadioButton) findViewById(R.id.true1);
        boolean question1answer = question1.isChecked();
        if(question1answer){
            answers++;
        }
    }

    private void question2answer(){
        RadioButton question2 = (RadioButton) findViewById(R.id.true2);
        boolean question2answer = question2.isChecked();
        if(question2answer){
            answers++;
        }
    }
    private void question3answer(){
        RadioButton question3 = (RadioButton) findViewById(R.id.false3);
        boolean question3answer = question3.isChecked();
        if(question3answer){
            answers++;
        }
    }
    private void question4answer(){
        CheckBox answer41 = (CheckBox) findViewById(R.id.CheckBox4_1);
        CheckBox answer42 = (CheckBox) findViewById(R.id.CheckBox4_2);
        CheckBox answer43 = (CheckBox) findViewById(R.id.CheckBox4_3);
        CheckBox answer44 = (CheckBox) findViewById(R.id.CheckBox4_4);
        boolean isanswer41 = answer41.isChecked();
        boolean isanswer42 = answer42.isChecked();
        boolean isanswer43 = answer43.isChecked();
        boolean isanswer44 = answer44.isChecked();

        if(!isanswer41 && isanswer42 && isanswer43 && !isanswer44){
            answers++;

        }
/*
* check the edit text answer
* */
    }
    private String getQuestion5Input() {
        EditText userInputLastName = (EditText) findViewById(R.id.EditText);
        String name = userInputLastName.getText().toString();
        return name;
    }

    private void question5answer() {
        String name = getQuestion5Input();
        if (name.trim().equalsIgnoreCase("darwin")) {
            answers++;
        }
    }
/*
* check all question and display the result to user
* */
    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + answers+ "/5",
                    Toast.LENGTH_LONG).show();

        }
    };



}

