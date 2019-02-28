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

    private ArrayList<PlayerChipCollection> playersChips; // Array of chip amount for players

    private BetTracker bets;       // tracks the pot and maximum bet
    private TurnTracker turn;      // tracks whose turn it is



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

        playersChips = new ArrayList<PlayerChipCollection>();
        for (int i = 0; i < numPlayers; i++){
            playersChips.add(new PlayerChipCollection(startingChips, i));
        }

        bets = new BetTracker(playersChips);

        turn = new TurnTracker(playersChips, dealerID);
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

        playersChips = new ArrayList<PlayerChipCollection>();
        for (PlayerChipCollection cc : toCopy.playersChips) {
            playersChips.add(new PlayerChipCollection(cc));
        }

        bets = new BetTracker(toCopy.bets);

        turn = new TurnTracker(toCopy.turn);
    }

    /**
     * Copy Constructor that only gives players their hand and does not give them the deck. All
     * other instance vars are given.
     *
     * @param toCopy    the PokerGameState to copy
     * @param playerID  the playerID that is given this copy of the game state
     */
    public PokerGameState(PokerGameState toCopy, int playerID) {
        playingDeck = null;

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

        playersChips = new ArrayList<PlayerChipCollection>();
        for (PlayerChipCollection cc : toCopy.playersChips) {
            playersChips.add(new PlayerChipCollection(cc));
        }

        bets = new BetTracker(toCopy.bets);

        turn = new TurnTracker(toCopy.turn);
    }

    /**
     * Description of a game state
     *
     * @return a string that contains the description of the game state.
     */
    @Override
    public String toString() {
        // creates toReturn string variable
        String toReturn = playingDeck.toString();
        // for loop iterates the player's hand array to determine which cards the player has
        for (int i = 0; i < hands.size(); i++) {
            // prints out the cards that are in the player's hand
            toReturn += "\nPlayer " + (i + 1) + "'s Hand: " + hands.get(i).toString();
        }
        // states which community cards are currently on the table
        toReturn += "\n\nCommunity Cards:";
        // iterates through the community cards array and prints them out
        for (Card c : communityCards) {
            toReturn += " " + c.toString();
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
            toReturn += "\nPlayer " + (i + 1) + ": " + playersChips.toString();
        }
        // states the current amount of the pot and
        toReturn += "\n" + bets.toString();
        toReturn += "\n" + turn.toString();

        return toReturn;
    }

    /** Game Actions */

    public boolean placeBets(int playerID, int amount){
        return bets.submitBet(playerID, amount);
    }

    public boolean fold(int playerID){
        //TODO: use the TurnTacker to see if it's the players current turn. If it is, set the
        if (turn.getActivePlayerID() != playerID){
            return false;
        }

        playersChips.get(playerID).setHasFolded(true);

        // player's hasFolded to true.
        return true;
    }

    /* we need to find a way to assign 'hands'
     * do inividual players
      * */
    public boolean showCards(int playerID, boolean isLeftCard, boolean isRightCard){
        //TODO: make two booleans in Hand.java that correlated if the left and right card has
        // been shown. Then set that boolean appropriately in this method.

        if (playerID != turn.getActivePlayerID()){
            return false;
        }

        hands.get(playerID).setShowRight(false);
        hands.get(playerID).setShowLeft(false);

        // method.
        return true;
    }

    public boolean hideCards(int playerID, boolean isLeftCard, boolean isRightCard){
        //TODO: see the TODO in showCards; set the boolean in Hand.java appropriately in this
        if (playerID != turn.getActivePlayerID()){
            return false;
        }

        hands.get(playerID).setShowRight(false);
        hands.get(playerID).setShowLeft(false);

        // method.
        return true;
    }

    /**
     *
     * Checks to see if it is the current player's turn and if there any current bets. If not
     * return true.
     * @param playerID
     * @return
     */
    public boolean check(int playerID){
        if(turn.getActivePlayerID() == playerID && bets.getMaxBet() == 0){
            return true;
        }
        return false;
    }

    public boolean call(int playerID){
        //TODO: submit a placeBet() with the current maxBet from the BetTracker
        return true;
    }

    public boolean allIn(int playerID){
        //TODO: reference placeBets() with the player's max bet amount
        if(turn.getActivePlayerID() == playerID){

        }
        return true;
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
