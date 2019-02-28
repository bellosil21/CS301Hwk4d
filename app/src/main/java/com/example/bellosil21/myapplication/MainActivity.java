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
    public int[] playerID = {0,1,2,3};

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
        firstInstance.deal();
        /* player[0] is the perspective of player 1*/
        PokerGameState secondInstance = new PokerGameState(firstInstance, playerID[0]);

        /* now calling every action method with firstInstance as instructed in the hw*/
        boolean action0 = firstInstance.check(playerID[0]);
        gameState.append("Player 1 has checked. - " + action0);
        boolean action1 = firstInstance.placeBets(playerID[1], STARTING_SMALL);
        gameState.append("\nPlayer 2 is the small blind and has placed a minimum bet of "+ STARTING_SMALL + " - " + action1);
        boolean action2 = firstInstance.placeBets((playerID[2]), STARTING_BIG);
        gameState.append("\nPlayer 3 is the small blind and has put in the next higher bet. - " + action2);
        boolean action3 = firstInstance.fold(playerID[2]);
        gameState.append("\nPlayer 3 has folded for this turn. - " + action3 + " Because its not Player 3's turn.");

        /* assuming a player can show cards whenever and its a legal move.*/
        boolean action4 = firstInstance.showHideCards(playerID[0], true);
        gameState.append("\nPlayer 1 has shown there cards to the table. - " + action4);
        boolean action5 =firstInstance.showHideCards(playerID[0], false);
        gameState.append("\nPlayer 1 is hiding their cards. - " + action5);

        /* not a legal move but just putting it here. */
        boolean action6 =firstInstance.check(playerID[3]);
        gameState.append("\nPlayer 4 has checked for this round. - " + action6 + " Because there is a bet that is not 0 in this turn.");
        boolean action7 =firstInstance.call(playerID[3]);
        gameState.append("\nPlayer 4 has called. - " + action7);
        boolean action8 =firstInstance.allIn(playerID[0]);
        gameState.append("\nPlayer 1 has bet all his chips in. - " + action8);

        /*"create a new instance of the gameState*/
        PokerGameState thirdInstance = new PokerGameState(STARTING_CHIPS, STARTING_SMALL, STARTING_BIG, NUM_PLAYERS);
        thirdInstance.deal();
        PokerGameState fourthInstance = new PokerGameState(thirdInstance, playerID[0]);

        /* call the toString method on the fourth and second instance *?*/
        String second = secondInstance.toString();
        String fourth = fourthInstance.toString();

        gameState.append("\n" + second);
        gameState.append("\n"+ fourth);

        /* checking if second and fourth string variables are identical*/
        if(second.equals(fourth)){
            gameState.append("\n\n\nSecond and fourth game state information is identical.");
        }
        // random playerIDs from 0 to 3 (4 players)
    }
}
