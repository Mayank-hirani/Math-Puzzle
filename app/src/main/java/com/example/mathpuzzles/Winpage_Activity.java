package com.example.mathpuzzles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Winpage_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView continew, mainmenu,textwin;
    private int levelNo;
    private int cnt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winpage);

        continew=findViewById(R.id.wincontinewbutton);
        continew.setOnClickListener(this);
        mainmenu=findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(this);
        textwin=findViewById(R.id.textwin);
        textwin.setOnClickListener(this);

        levelNo = getIntent().getIntExtra("level",levelNo);//1
        textwin.setText("Puzzle "+levelNo+" Completed");//1

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == continew.getId()) {
            Intent intent = new Intent(Winpage_Activity.this, Continue_SecondPage_Activity.class);
            intent.putExtra("level",levelNo);//
            startActivity(intent);
        }
        if (v.getId() == mainmenu.getId()) {
            Intent intent = new Intent(Winpage_Activity.this, FirstPazeActivity.class);
            intent.putExtra("level",levelNo);
            intent.putExtra("cnt",cnt);
            startActivity(intent);
        }
    }
}