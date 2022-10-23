package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foul_b = 0;
    int foul_a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayFiveForTeamA(View v) {
        scoreTeamA = scoreTeamA + 5;
        displayForTeamA(scoreTeamA);
    }

    public void displayThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void displayFoulForTeamA(View v) {
        foul_a = foul_a + 1;
        String sA = "Total Foul : " + foul_a;
        scoreTeamA = scoreTeamA - 1;
        displayForTeamA(scoreTeamA);
        foulA(sA);
    }

    public void foulA(String f) {
        TextView scoreView = (TextView) findViewById(R.id.foul_a);
        scoreView.setText(String.valueOf(f));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayFiveForTeamB(View v) {
        scoreTeamB = scoreTeamB + 5;
        displayForTeamB(scoreTeamB);
    }

    public void displayThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void displayFoulForTeamB(View v) {
        foul_b = foul_b + 1;
        String sB = "Total Foul : " + foul_b;
        scoreTeamB = scoreTeamB - 1;
        displayForTeamB(scoreTeamB);
        foulB(sB);
    }

    public void foulB(String foul) {
        TextView scoreView = (TextView) findViewById(R.id.foul_b);
        scoreView.setText(String.valueOf(foul));
    }

    public void resetScore(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        foul_b = 0;
        foul_a = 0;
        String s = "Total Foul : " + 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        foulA(s);
        foulB(s);
    }
}
