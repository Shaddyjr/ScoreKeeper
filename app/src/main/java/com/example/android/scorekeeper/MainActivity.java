package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView top_kill,top_death,top_assist,bot_kill,bot_death,bot_assist;
    int[] topScores;
    int[] botScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_kill = findViewById(R.id.top_kill);
        top_death = findViewById(R.id.top_death);
        top_assist = findViewById(R.id.top_assist);
        bot_kill = findViewById(R.id.bottom_kill);
        bot_death = findViewById(R.id.bottom_death);
        bot_assist = findViewById(R.id.bottom_assist);

        resetScores();
    }

    public void change_score(View v) {
        String tag = v.getTag().toString();
        String[] data = tag.split(",");
        show_change(data);
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
        top_kill.setText(String.valueOf(topScores[0]));
        top_death.setText(String.valueOf(topScores[1]));
        top_assist.setText(String.valueOf(topScores[2]));
        bot_kill.setText(String.valueOf(botScores[0]));
        bot_death.setText(String.valueOf(botScores[1]));
        bot_assist.setText(String.valueOf(botScores[2]));
    }

    public void resetScores(){
        topScores = new int[]{0,0,0};
        botScores = new int[]{0,0,0};
    }

    public void reset(View v){
        resetScores();
        show_scores();
    }
}
