package com.example.android.doggyquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainScore)
    TextView mScore;

    private int pointCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        pointCounter = mIntent.getIntExtra("pointCounter", 0);
        mScore.setText(Integer.toString(pointCounter));
    }

    @OnClick(R.id.nextButtonMain)
    public void ButtonClick(){
        Intent intent = new Intent(this,RadioButtonActivity.class);
        startActivity(intent);
    }
}
