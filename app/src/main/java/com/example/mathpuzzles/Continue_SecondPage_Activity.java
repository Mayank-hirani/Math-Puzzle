package com.example.mathpuzzles;

import static com.example.mathpuzzles.FirstPazeActivity.editor;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Continue_SecondPage_Activity extends AppCompatActivity implements View.OnClickListener {

    List<String> imgArr=new ArrayList<String>();

    Button[] b = new Button[10];
    Button submitbutton;
    TextView textans,levelbord;
    ImageView img,truebutton,skipbutton, backspacebutton;

    String temp,data;
    static int i, levelNo;
    private int cnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countinue_secondpage);



        skipbutton = findViewById(R.id.skipbutton);
        skipbutton.setOnClickListener(this);
        levelbord = findViewById(R.id.levelbord);
        levelbord.setOnClickListener(this);
        truebutton = findViewById(R.id.truebutton);
        truebutton.setOnClickListener(this);

        img = findViewById(R.id.img);
        img.setOnClickListener(this);
        textans = findViewById(R.id.textans);
        textans.setOnClickListener(this);
        backspacebutton = findViewById(R.id.backspacebutton);
        backspacebutton.setOnClickListener(this);
        submitbutton = findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(this);


        levelNo = getIntent().getIntExtra("level", 0);//0
        levelbord.setText("Level " + (levelNo+1));//1

        //buttonArr
        for (int i = 0; i < b.length; i++) {
            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            b[i] = findViewById(id);
            b[i].setOnClickListener(this);
        }


        //assets img in put
        String[] images = new String[0];
        try {
            images = getAssets().list("LevelImages");
            imgArr = new ArrayList<String>(Arrays.asList(images));
            Log.d("YYY", "onCreate: Images=" + imgArr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream stream = null;
        try {
            stream = getAssets().open("LevelImages/" + imgArr.get(levelNo));//0
            Drawable drawable = Drawable.createFromStream(stream, null);
            img.setImageDrawable(drawable);
        } catch (Exception ignored) {
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void onClick(View view) {
        try {

            if (view.getId()==b[1].getId()){
                data=textans.getText().toString();
                temp=data+"1";
                textans.setText(""+temp);}
            if (view.getId()==b[2].getId()){
                data=textans.getText().toString();
                temp=data+"2";
                textans.setText(""+temp);}
            if (view.getId()==b[3].getId()){
                data=textans.getText().toString();
                temp=data+"3";
                textans.setText(""+temp);}
            if (view.getId()==b[4].getId()){
                data=textans.getText().toString();
                temp=data+"4";
                textans.setText(""+temp);}
            if (view.getId()==b[5].getId()){
                data=textans.getText().toString();
                temp=data+"5";
                textans.setText(""+temp);}
            if (view.getId()==b[6].getId()){
                data=textans.getText().toString();
                temp=data+"6";
                textans.setText(""+temp);}
            if (view.getId()==b[7].getId()){
                data=textans.getText().toString();
                temp=data+"7";
                textans.setText(""+temp);}
            if (view.getId()==b[8].getId()){
                data=textans.getText().toString();
                temp=data+"8";
                textans.setText(""+temp);}
            if (view.getId()==b[9].getId()){
                data=textans.getText().toString();
                temp=data+"9";
                textans.setText(""+temp);}
            if (view.getId()==b[0].getId()){
                data=textans.getText().toString();
                temp=data+"0";
                textans.setText(""+temp);}
            if (view.getId()==backspacebutton.getId()) {
                temp=textans.getText().toString().substring(0,temp.length()-1);
                textans.setText(""+temp);
            }
            if (view.getId()==submitbutton.getId())
            {
                if(textans.getText().toString().equals(config.ansArr[levelNo]))
                {
                    editor.putInt("lastLevel", (levelNo));//0,1
                    editor.putString("levelStatus"+levelNo,"win");//levelStatus0=win
                    editor.commit();

                    levelNo++;//1
                    Intent intent=new Intent(Continue_SecondPage_Activity.this,Winpage_Activity.class);
                    intent.putExtra("level", levelNo);//1
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(this,"something went worng...",Toast.LENGTH_SHORT).show();
                    textans.setText("");
                }
            }
            if(view.getId()==skipbutton.getId())
            {
                MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(Continue_SecondPage_Activity.this);
                builder.setTitle("Alert..!");
                builder.setMessage("Are you sure, you want to skip a level???");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        builder.show();
                        editor.putInt("lastLevel", (levelNo));//2,3
                        editor.putString("levelStatus"+levelNo,"skip");
                        editor.commit();

                        levelNo++;
                        Intent intent=new Intent(Continue_SecondPage_Activity.this,Continue_SecondPage_Activity.class);
                        intent.putExtra("level", levelNo);//3

                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }

        }catch (Exception ex){
            Toast.makeText(this, "something went wrong...", Toast.LENGTH_SHORT).show();
        }

    }
}