package com.example.mathpuzzles;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Puzzles_Secondpage_Activity extends AppCompatActivity {

    GridView gridView;
    private int levelNo;
    private int cnt;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_secondpage);
        gridView=findViewById(R.id.level_view);

        levelNo=getIntent().getIntExtra("levelNo",levelNo);
        cnt=getIntent().getIntExtra("cnt",cnt);

        PuzzlesAdapter adapter=new PuzzlesAdapter(Puzzles_Secondpage_Activity.this,config.no);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }
}