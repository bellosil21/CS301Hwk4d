package com.example.bellosil21.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText currentPlayer;
    EditText playerAction;
    EditText playerBet;
    EditText player1Stack;
    EditText player2Stack;
    EditText player3Stack;
    EditText player4Stack;
    EditText currentPot;
    EditText currentBigBlind;
    EditText currentSmallBlind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentPlayer = findViewById(R.id.playerTurn);
        playerAction = findViewById(R.id.actionMade);
        playerBet = findViewById(R.id.betMade);
        player1Stack = findViewById(R.id.player1Chips);
        player2Stack = findViewById(R.id.player2Chips);
        player3Stack = findViewById(R.id.player3Chips);
        player4Stack = findViewById(R.id.player4Chips);
        currentPot = findViewById(R.id.potAmount);
        currentBigBlind = findViewById(R.id.bigBlindPlayer);
        currentSmallBlind = findViewById(R.id.smallBlindPlayer);

        Button runTest = findViewById(R.id.runTest);
            runTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        currentPlayer.setText("Clear");
        playerAction.setText("Clear");
        playerBet.setText("Clear");
        player1Stack.setText("Clear");
        player2Stack.setText("Clear");
        player3Stack.setText("Clear");
        player4Stack.setText("Clear");
        currentPot.setText("Clear");
        currentBigBlind.setText("Clear");
        currentSmallBlind.setText("Clear");

    }
}
