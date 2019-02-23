package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class PokerGameState implements Serializable {
    ArrayList<Hand> hands; //Array of Players hand
    ArrayList<Card> communityCards; // Array of Cards shared for community
    ArrayList<ChipCollection> playersChips;   // Array of chip amount for players
    int roundNumber;    // Current round
    int dealerID;       // Place holder to define who has BB, SB, and first better
                        // and a number between 0 and number of players minus 1
    int smallBlind;     // Current small blind betting amount
    int bigBlind;       // Current big blind betting amount
    Deck deck;          // All cards in deck
    ChipCollection pot; // Current winnings

    /** PokerGameState
     *
     * Creates and Initialize current Game State
     *
     * @param startingChips - starting amount of Chips for each player
     * @param startingBig - starting mandatory betting amount for big blind
     * @param numPlayers - number of players in game
     */
    public PokerGameState(int startingChips, int startingBig, int startingSmall,int numPlayers){
        deck = new Deck();
        hands = new ArrayList<Hand>();
        communityCards = new ArrayList<Card>();
        playersChips = new ArrayList<ChipCollection>();
        for (int i = 0; i < numPlayers; i++){
            playersChips.add(new ChipCollection(startingChips));
        }
        dealerID = (int) Math.random() * numPlayers;
        bigBlind = startingBig;
        smallBlind = startingSmall;
        roundNumber = 1;
        pot = new ChipCollection(startingChips);

    }

}
