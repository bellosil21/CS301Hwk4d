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

        /* now calling every action method with firstInstance as instructed in the hw*/
        firstInstance.placeBets(playerID[1], STARTING_SMALL);
        gameState.append("Player 2 is the small blind and has placed a minimum bet of "+ STARTING_SMALL);
        firstInstance.placeBets((playerID[2]), STARTING_BIG);
        gameState.append("Player 3 is the small blind and has put in the next higher bet.\n");
        firstInstance.fold(playerID[2]);
        gameState.append("\nPlayer 3 has folded for this turn.\n");

        /** assuming a player can show cards whenever and its a legal move.*/
        firstInstance.showCards(playerID[0], true, true);
        gameState.append("Player 1 has shown there cards to the table.\n");
        firstInstance.hideCards(playerID[0], true, true);
        gameState.append("Player 1 is hiding their cards.\n");
        /** not a legal move but just putting it here. */
        firstInstance.check(playerID[3]);
        gameState.append("Player 4 has checked for this round.\n");
        firstInstance.call(playerID[3]);
        gameState.append("Player 4 has called.\n");
        firstInstance.allIn(playerID[0]);
        gameState.append("Player 1 has bet all his chips in.\n");

        /*"create a new instance of the gamestate classs...*/
        PokerGameState thirdInstance = new PokerGameState(STARTING_CHIPS, STARTING_SMALL, STARTING_BIG, NUM_PLAYERS);
        PokerGameState fourthInstance = new PokerGameState(thirdInstance, playerID[0]);

        /* call the toString method on the fourth and second instance *?*/
        String second = secondInstance.toString();
        String fourth = fourthInstance.toString();

        gameState.append("\n" + second);
        gameState.append("\n"+ fourth);

        /** checking if second and fourth string variables are identical*/
        if(second.equals(fourth)){
            gameState.append("\nTrue");
        }
        // random playerIDs from 0 to 3 (4 players)
    }
}
