package com.example.bellosil21.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // TODO: Need to Add comments
    private EditText gameState;

    public static final int STARTING_CHIPS = 2000;
    public static final int STARTING_SMALL = 25;
    public static final int STARTING_BIG = 50;
    public static final int NUM_PLAYERS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameState = findViewById(R.id.gameState);

        Button runTest = findViewById(R.id.runTest);
            runTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        gameState.setText("");

        PokerGameState firstInstance = new PokerGameState(STARTING_CHIPS, STARTING_SMALL,
                STARTING_BIG, NUM_PLAYERS);

        //TODO: finish the onClick() implmentation as noted on the assignment documentation using
        // random playerIDs from 0 to 3 (4 players)
    }
}
