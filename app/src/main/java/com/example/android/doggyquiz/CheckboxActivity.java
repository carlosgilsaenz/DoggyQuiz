package com.example.android.doggyquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckboxActivity extends AppCompatActivity {

    @BindView(R.id.checkbox_question_textView)
    TextView mQuestionTextView;

    @BindView(R.id.checkboxButtonOne)
    CheckBox mButtonOne;

    @BindView(R.id.checkboxButtonTwo)
    CheckBox mButtonTwo;

    @BindView(R.id.checkboxButtonThree)
    CheckBox mButtonThree;

    @BindView(R.id.checkboxButtonFour)
    CheckBox mButtonFour;

    @BindView(R.id.checkboxImage)
    ImageView mImage;

    private boolean isThreeQuestion;

    private int pointCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        ButterKnife.bind(this);

        isThreeQuestion = true;
        Intent mIntent = getIntent();
        pointCounter = mIntent.getIntExtra("pointCounter", 0);
    }

    @OnClick(R.id.nextButtonCheckbox)
    public void buttonClicked() {

        if(isThreeQuestion){

            // checks answer question 1
            if(mButtonOne.isChecked() || mButtonTwo.isChecked()){
                Toast.makeText(this,R.string.answerCorrectTwoPoints,Toast.LENGTH_SHORT).show();
                pointCounter += 2;
            } else if (mButtonTwo.isChecked() || mButtonFour.isChecked()){
                Toast.makeText(this,R.string.answerIncorrect,Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,R.string.answerBlank,Toast.LENGTH_SHORT).show();
            }

            questionFour();
        } else{

            // checks answer for question 2
            if(mButtonOne.isChecked() || mButtonTwo.isChecked()
                    || mButtonThree.isChecked() || mButtonFour.isChecked()){
                Toast.makeText(this,R.string.answerCorrectTwoPoints,Toast.LENGTH_SHORT).show();
                pointCounter += 2;
            } else{
                Toast.makeText(this,R.string.answerBlank,Toast.LENGTH_SHORT).show();
            }

            // Initiate next editText questions
            Intent intent = new Intent(this,TextboxActivity.class);
            intent.putExtra("pointCounter", pointCounter);
            startActivity(intent);
        }
    }

    private void questionFour(){
        isThreeQuestion = false;
        mQuestionTextView.setText(R.string.questionFour);
        mButtonOne.setText(R.string.questionFourAnswerOne);
        mButtonTwo.setText(R.string.questionFourAnswerTwo);
        mButtonThree.setText(R.string.questionFourAnswerThree);
        mButtonFour.setText(R.string.questionFourAnswerFour);
        mImage.setImageResource(R.drawable.question_four);
    }
}
