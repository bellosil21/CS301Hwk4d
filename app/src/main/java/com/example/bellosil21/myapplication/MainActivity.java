package com.example.bellosil21.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText gameState;

    // amount of money each player starts with
    public static final int STARTING_CHIPS = 2000;
    // small blind entry fee
    public static final int STARTING_SMALL = 25;
    // big blind entry fee
    public static final int STARTING_BIG = 50;
    // number of players
    public static final int NUM_PLAYERS = 4;

    //max number of players is 4
    public int[] playerID = new int[4];

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
        /* player[0] is the perspective of player 1*/
        PokerGameState secondInstance = new PokerGameState(firstInstance, playerID[0]);


        //TODO: finish the onClick() implmentation as noted on the assignment documentation using
        // random playerIDs from 0 to 3 (4 players)
    }
}
