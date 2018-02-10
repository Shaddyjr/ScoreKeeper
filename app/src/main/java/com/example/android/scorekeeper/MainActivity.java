package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[] topScores = {0,0,0};
    int[] botScores = {0,0,0};
    public void change_score(View v) {
        String tag = v.getTag().toString();
        String[] data = tag.split(",");
        this.show_change(data);
    }

    public void show_change(String[] args){
        String score = args[0];
        String team = args[1];
        String direction = args[2];

        int[] focusArray;
        int index;
        int multiplier = 1;

//        establishing team array
        if(team.equals("top")) focusArray = topScores;
        else focusArray = botScores;

//        establishing score index
        if(score.equals("kill")) index = 0;
        else if(score.equals("death")) index = 1;
        else index = 2;

//        establishing multiplier direction
        if(direction.equals("-")) multiplier = -1;

        focusArray[index] += multiplier;
        if(focusArray[index]<0) focusArray[index] = 0;
        show_scores();
    }

//    shows scores using data arrays
    public void show_scores(){
        TextView top_kill = findViewById(R.id.top_kill);
        top_kill.setText(String.valueOf(topScores[0]));

        TextView top_death = findViewById(R.id.top_death);
        top_death.setText(String.valueOf(topScores[1]));

        TextView top_assist = findViewById(R.id.top_assist);
        top_assist.setText(String.valueOf(topScores[2]));

        TextView bot_kill = findViewById(R.id.bot_kill);
        bot_kill.setText(String.valueOf(botScores[0]));

        TextView bot_death = findViewById(R.id.bot_death);
        bot_death.setText(String.valueOf(botScores[1]));

        TextView bot_assist = findViewById(R.id.bot_assist);
        bot_assist.setText(String.valueOf(botScores[2]));
    }

    public void reset(View v){
        topScores = new int[]{0,0,0};
        botScores = new int[]{0,0,0};
        show_scores();
    }
}
