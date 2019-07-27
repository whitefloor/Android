package com.ehappy.game_2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtScore,txtShowScore;
    private static MainActivity mainActivity=null;
    private int score = 0;

    public MainActivity(){
        mainActivity = this;
    }

    public void clearScore(){
        score = 0;
        showScore();
    }
    public void addScore(int s){
        score += s;
        showScore();
    }
    public void showScore(){
        txtShowScore.setText(score+"");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShowScore = (TextView)findViewById(R.id.txtShowScore);

    }

    public static MainActivity getMainActivity(){
        return mainActivity;
    }


}
