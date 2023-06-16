package com.example.mathpuzzles;

import static com.example.mathpuzzles.FirstPazeActivity.preferences;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PuzzlesAdapter extends BaseAdapter
{
    Puzzles_Secondpage_Activity puzzles_secondpage_activity;
    String no[];
    ImageView lock,tick;
    TextView textView;
    private Activity convertView;
    private int levelNo;


    public PuzzlesAdapter(Puzzles_Secondpage_Activity puzzles_secondpage_activity, String[] no) {
        this.puzzles_secondpage_activity=puzzles_secondpage_activity;
        this.no= no;

    }

    @Override
    public int getCount() {
        return no.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        convertview=LayoutInflater.from(puzzles_secondpage_activity).inflate(R.layout.activity_puzzle_secondpage_item,parent,false);
        ImageView lock=convertview.findViewById(R.id.lockno);
        lock.setImageResource(config.lock);

        String page = preferences.getString("page","p");

        if (page.equals("p")){

            tick = convertview.findViewById(R.id.tick);
            textView = convertview.findViewById(R.id.textno);
            String status = preferences.getString("lastlevel"+(position+1),"levelNo");
            levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if (status.equals("win")){
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            }
            else if (status.equals("skip") || levelNo==position){
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(puzzles_secondpage_activity, Continue_SecondPage_Activity.class);
                    intent.putExtra("levelNo",position);
                    puzzles_secondpage_activity.startActivity(intent);
                }
            });
        }
        return convertview;
    }
}