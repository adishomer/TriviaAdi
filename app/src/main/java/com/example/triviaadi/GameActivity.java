package com.example.triviaadi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btna1,btna2,btna3,btna4;
    private TextView tvQueation;
    private TextView tvQueationNumber, tvPoints, tvGameOver;
    private Collection2 collection;
    private Question q;
    private LinearLayout llg;
    private int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String str = intent.getStringExtra("bgColor");
        llg = findViewById(R.id.activity_game);
        setBackgroundColorGame(str);

        tvQueation= findViewById(R.id.tvQuestion);

        btna1=findViewById(R.id.btna1);
        btna2=findViewById(R.id.btna2);
        btna3=findViewById(R.id.btna3);
        btna4=findViewById(R.id.btna4);


        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvPoints=findViewById(R.id.tvPoints);
        tvQueationNumber=findViewById(R.id.tvQuestionNumber);
        tvGameOver=findViewById(R.id.tvGameOver);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection= new Collection2();
        collection.initQuestions();

        nextOuestion();

    }

    private void nextOuestion() {
        if (collection.isNotLastOuestion())
        {
            q = collection.getNextQuestion();

            tvQueation.setText(q.getQuestion());
            btna1.setText(q.getA1());
            btna2.setText(q.getA2());
            btna3.setText(q.getA3());
            btna4.setText(q.getA4());
        }
        else
        {
            tvGameOver.setVisibility(View.VISIBLE);
            createDialog();
        }
    }

    private void createDialog() {
        CustomDialog customDialog=new CustomDialog(this);
        customDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v==btna1)
        {
            if (q.getCorrect()==1)
                points++;
        }
        if (v==btna2)
        {
            if (q.getCorrect()==2)
                points++;
        }
        if (v==btna3)
        {
            if (q.getCorrect()==3)
                points++;
        }
        if (v==btna4)
        {
            if (q.getCorrect()==4)
                points++;
        }
        tvPoints.setText("point: "+points);
        if (collection.isNotLastOuestion()){
            tvQueationNumber.setText("Question number: "+(collection.getIndex()+1));
        }
        nextOuestion();
    }

    public void reset() {
        this.points=0;
        collection.initQuestions();
        tvPoints.setText("point: "+0);
        tvQueationNumber.setText("Queation number: "+1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextOuestion();
    }
    public void setBackgroundColorGame(String color)
    {
        switch (color)
        {
            case "Red":
            {

                llg.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue":
            {

                llg.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Pink":
            {

                llg.setBackgroundColor(Color.argb(255,255,192,203));
                break;
            }
            case "Yellow":
            {

                llg.setBackgroundColor(Color.YELLOW);
                break;
            }

            default:

                llg.setBackgroundColor(Color.WHITE);
        }
    }
}