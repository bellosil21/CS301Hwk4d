package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Defines the game state to play Poker.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class PokerGameState implements Serializable {

    /** instance vars */
    private Deck playingDeck;      // All cards in deck
    private ArrayList<Hand> hands; //Array of Players hand
    private ArrayList<Card> communityCards; // Array of Cards shared for community

    private int roundNumber;       // Current round
    private int dealerID;          // Place holder to define who has BB, SB, and first better and
                                   // a number between 0 and number of players minus 1

    private int smallBlind;        // Current small blind betting amount
    private int bigBlind;          // Current big blind betting amount

    private ArrayList<ChipCollection> playersChips; // Array of chip amount for players
    private ChipCollection pot;    // Current winnings


    /** constants */
    private static final int INIT_ROUND_NUM = 1;

    /**
     * Creates and initialize a new PokerGameState from given options.
     * The starting dealerID is assigned to a random playerID that is
     * between 1 and 1 minus the total amount of players.
     *
     * @param startingChips     starting amount of chips for each player
     * @param startingSmall     starting mandatory betting amount for small blind
     * @param startingBig       starting mandatory betting amount for big blind
     * @param numPlayers        number of players in game
     */
    public PokerGameState(int startingChips, int startingSmall, int startingBig,int numPlayers){
        playingDeck = new Deck();
        hands = new ArrayList<Hand>();
        communityCards = new ArrayList<Card>();

        roundNumber = INIT_ROUND_NUM;
        dealerID = (int) Math.random() * numPlayers;

        smallBlind = startingSmall;
        bigBlind = startingBig;

        playersChips = new ArrayList<ChipCollection>();
        for (int i = 0; i < numPlayers; i++){
            playersChips.add(new ChipCollection(startingChips));
        }
        pot = new ChipCollection(startingChips);
    }

    /**
     * Copy Constructor
     * Deep copy of current game state.
     *
     * @param toCopy    the PokerGameState to copy
     */
    public PokerGameState(PokerGameState toCopy) {
        playingDeck = new Deck(toCopy.playingDeck);

        hands = new ArrayList<Hand>();
        for (Hand h : toCopy.hands) {
            hands.add(new Hand(h));
        }

        communityCards = new ArrayList<Card>();
        for (Card c : toCopy.communityCards) {
            communityCards.add(new Card(c));
        }

        roundNumber = toCopy.roundNumber;
        dealerID = toCopy.dealerID;

        smallBlind = toCopy.smallBlind;
        bigBlind = toCopy.bigBlind;

        playersChips = new ArrayList<ChipCollection>();
        for (ChipCollection cc : toCopy.playersChips) {
            playersChips.add(new ChipCollection(cc));
        }

        pot = new ChipCollection(toCopy.pot);
    }

    /**
     * Description of a game state
     *
     * @return a string that contains the description of the game state.
     */
    public String toString() {
        // creates toReturn string variable
        String toReturn = playingDeck.toString();
        // for loop iterates the player's hand array to determine which cards the player has
        for (int i = 0; i < hands.size(); i++) {
            // prints out the cards that are in the player's hand
            toReturn += "\nPlayer One's Hand: " + hands.get(i);
        }
        // states which community cards are currently on the table
        toReturn += "\n\nCommunity Cards:";
        // iterates through the community cards array and prints them out
        for (Card d : communityCards) {
            toReturn += " " + d.toString();
        }
        // states the current round number
        toReturn += "\nRound Number: " + roundNumber;
        // states who the current dealer is
        toReturn += "\nCurrent Dealer: " + dealerID;
        // states the cost of the small blind
        toReturn += "\nSmall Blind: " + smallBlind;
        // states the cost of the big blind
        toReturn += "\nBig Blind: " + bigBlind;
        // iterates through the player's chip amount and states how much money they have
        for (int i = 0; i < playersChips.size(); i++) {
            toReturn += "\nPlayer One's Chips: " + playersChips.get(i);
        }
        // states the current amount of the pot
        toReturn += "\nCurrent Pot: " + pot;

        return toReturn;
    }

    /** Game Actions */

    public boolean placeBets(int chipsBetIn, ChipCollection player){
        if (chipsBetIn > player.getChips()){ return false; }

        int newChipAmount = player.getChips() - chipsBetIn;
        player.setChips(newChipAmount);

        return true;
    }

    // TODO: Change all methods to reflect parameter of PlayerID
    public boolean fold(boolean isTurn, boolean inGame){
        if (isTurn) {
            return true;
        }
        if (inGame){
            return true;
        }
        return false;
    }

    public boolean showCards(boolean wonRound){
        if (wonRound){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean hideCards(boolean wonRound){
        if (wonRound){
            return true;
        }
        else{
            return false;
        }
    }

    /**added by gabe
     * turn will be an intID.
     * if id = 0 than its the first person's turn
     * @param placedBet will be true if someone in the current round has
     *                  placed a bet, meeaning the action
     * @return
     */
    public boolean Check(boolean placedBet){
        if(placedBet) //a place has been checked.
        {
            //than have it print: "Illegal move" or something.
            return false;
        }

        return true;

    }

    public boolean call(int leftToBet, ChipCollection player){
        if (player.getChips() >= leftToBet){
            int newChipAmount = player.getChips() - leftToBet;
            player.setChips(newChipAmount);
            return true;
        }
        return false;
    }

    public boolean allIn(boolean inGame){
        if (inGame){
            return true;
        }
        return false;
    }

    /**
     * these methods should probably return true uncondtionally,
     * since they arent techniquelly ever illegal moves but they
     * are still actions.
     */
    public boolean menu(){
        return true;
    }

    public boolean exit(){
        return true;
    }

    public boolean help(){
        return true;
    }

}
