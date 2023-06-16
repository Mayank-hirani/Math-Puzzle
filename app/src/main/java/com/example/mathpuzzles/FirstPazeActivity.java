package com.example.mathpuzzles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class FirstPazeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1,textView2;
    private int cnt=1;
    public static int levelNo=0,lastLevel;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpaze);

        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor= preferences.edit();

        lastLevel= preferences.getInt("lastLevel",-1);//0

        Log.d("RRR", "onCreate: LastLevel="+lastLevel);

        textView1 = findViewById(R.id.continew);
        textView2 = findViewById(R.id.puzzles);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== textView1.getId()){
            Intent intent = new Intent(FirstPazeActivity.this, Continue_SecondPage_Activity.class);
            lastLevel++;
            intent.putExtra("level",lastLevel);//0
            startActivity(intent);
        }
        if (view.getId()== textView2.getId()){
            Intent intent = new Intent(FirstPazeActivity.this,Puzzles_Secondpage_Activity.class);
            startActivity(intent);
        }
    }

}