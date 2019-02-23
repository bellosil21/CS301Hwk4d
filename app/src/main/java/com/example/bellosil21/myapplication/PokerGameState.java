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
    Deck playingDeck;          // All cards in deck
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
        playingDeck = new Deck();
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



    /**
     * I have a pretty good feeling this toString will not work
     * but we will find out.
     * @return a description of the game state.
     */
    public String toString(){
        Arrays.toString(communityCards.toArray());
        Arrays.toString(playersChips.toArray());
        Arrays.toString(hands.toArray());
        return "State of the Game: \n" + "Round Number: " + roundNumber +"\n" +
        "Dealer ID: "+dealerID + "\n" + "Small Blind ID: " + smallBlind + "\n" +
        "Big Blind ID: " + bigBlind + "\n" + "Chip pot: " +  pot.getAmount();
    }

    /** PokerGameState
     *
     * Copy Constructor
     * Deep copy of current game state.
     */
    public PokerGameState(PokerGameState toCopy) {
        hands = new ArrayList<Hand>();
        for (Hand h : toCopy.hands) {
            hands.add(new Hand(h));
        }

        communityCards = new ArrayList<Card>();
        for (Card c : toCopy.communityCards) {
            communityCards.add(new Card(c));
        }

        playersChips = new ArraryList<ChipCollection>();
        for (ChipCollection cc : toCopy.playersChips) {
            playersChips.add(new ChipCollection(cc));
        }

        roundNumber = toCopy.roundNumber;

        dealerID = toCopy.dealerID;

        smallBlind = toCopy.smallBlind;
        bigBlind = toCopy.bigBlind;

        playingDeck = new Deck(toCopy.playingDeck);

        pot = new ChipCollection(toCopy.pot)

    }

}
