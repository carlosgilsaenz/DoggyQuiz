package com.example.android.doggyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextboxActivity extends AppCompatActivity {

    @BindView(R.id.textbox_question_textView)
    TextView mQuestionTextView;

    @BindView(R.id.editText)
    EditText mEditText;

    @BindView(R.id.textboxImage)
    ImageView mImage;

    private int pointCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbox);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        pointCounter = mIntent.getIntExtra("pointCounter", 0);
    }

    @OnClick(R.id.nextButtonText)

    public void buttonClicked() {
        //Get String from edit text box
        String answer = mEditText.getText().toString().trim();
        Log.i("TEXTBOX ACT", "STRING ANSWER = " + answer);

        if (answer.toLowerCase().contains(getString(R.string.questionFiveAnswerOne))) {
            Toast.makeText(this, R.string.answerCorrectThreePoints, Toast.LENGTH_SHORT).show();
            pointCounter += 3;
        } else {
            Toast.makeText(this, R.string.answerIncorrect, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("pointCounter", pointCounter);
        startActivity(intent);
    }

    private void questionFive() {
        mQuestionTextView.setText(R.string.questionFive);
        mImage.setImageResource(R.drawable.question_five);
    }
}
