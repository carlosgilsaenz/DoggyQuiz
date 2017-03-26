package com.example.android.doggyquiz;

import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mick Jagger on 3/25/2017.
 */

public class RadioButtonActivity extends AppCompatActivity {

    @BindView(R.id.radio_question_textView)
    TextView mQuestionTextView;

    @BindView(R.id.radioButtonOne)
    Button mButtonOne;

    @BindView(R.id.radioButtonTwo)
    Button mButtonTwo;

    @BindView(R.id.radioButtonThree)
    Button mButtonThree;

    @BindView(R.id.radioButtonGroup)
    RadioGroup mRadioGroup;

    @BindView(R.id.radioImage)
    ImageView mImage;

    private int pointCounter = 0;

    public boolean isFirstQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        ButterKnife.bind(this);

        isFirstQuestion = true;
    }

    @OnClick(R.id.nextButtonRadio)
    public void buttonClicked() {

        if(isFirstQuestion){
            // get selected id
            int selectedButton = mRadioGroup.getCheckedRadioButtonId();
            // checks answer question 1
            switch(selectedButton){
                case R.id.radioButtonOne:
                    Toast.makeText(this,R.string.answerIncorrect,Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButtonTwo:
                    Toast.makeText(this,R.string.answerCorrectOnePoint,Toast.LENGTH_SHORT).show();
                    pointCounter++;
                    break;
                case R.id.radioButtonThree:
                    Toast.makeText(this,R.string.answerCorrectOnePoint,Toast.LENGTH_SHORT).show();
                    pointCounter++;
                    break;
                default:
                    Toast.makeText(this,R.string.answerBlank,Toast.LENGTH_SHORT).show();
            }

            questionTwo();

        } else{
            // get selected Id
             int selectedButton = mRadioGroup.getCheckedRadioButtonId();
            // checks answer for question 2
            switch(selectedButton){
                case R.id.radioButtonOne:
                    Toast.makeText(this,R.string.answerCorrectOnePoint,Toast.LENGTH_SHORT).show();
                    pointCounter++;
                    break;
                case R.id.radioButtonTwo:
                    Toast.makeText(this,R.string.answerIncorrect,Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButtonThree:
                    Toast.makeText(this,R.string.answerIncorrect,Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this,R.string.answerBlank,Toast.LENGTH_SHORT).show();
            }
            // Initiate next checkbox questions
            Intent intent = new Intent(this,CheckboxActivity.class);
            intent.putExtra("pointCounter", pointCounter);
            startActivity(intent);
        }

    }

    // setup for question two
    private void questionTwo(){
        isFirstQuestion = false;
        mQuestionTextView.setText(R.string.questionTwo);
        mButtonOne.setText(R.string.quesitonTwoAnswerOne);
        mButtonTwo.setText(R.string.quesitonTwoAnswerTwo);
        mButtonThree.setText(R.string.quesitonTwoAnswerThree);
        mImage.setImageResource(R.drawable.question_two);
    }

}
