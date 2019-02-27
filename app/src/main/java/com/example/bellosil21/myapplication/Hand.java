package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Defines the cards in a player's hand.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class Hand implements Serializable{

    // Declares the cards in a player's hand
    private Card hole1;
    private Card hole2;
    // Declares the player's left card hidden from the other players
    private boolean showLeft;
    // Declares the player's right card hidden from the other players
    private boolean showRight;

    /**
     * A player's hand is composed of two cards from the deck.
     *
     * @param hole1     the first card in the player's hand
     * @param hole2     the second card in the player's hand
     */
    public Hand(Card hole1, Card hole2){
        this.hole1 = hole1;
        this.hole2 = hole2;
        showLeft = false;
        showRight = false;
    }

    /**
     * Copy constructor
     * Copies the cards into a new hand.
     *
     * @param toCopy    the Hand to copy
     */
    public Hand(Hand toCopy) {
        hole1 = new Card(toCopy.hole1);
        hole2 = new Card(toCopy.hole2);
        showLeft = toCopy.showLeft;
        showRight = toCopy.showRight;
    }

    /**
     * Describes the hand.
     *
     * @return a string describing the cards in hand
     */
    public String toString(){
        return "Player Hand => Card1:" + hole1.toString() + "\n" +
                "Card2: " + hole2.toString();
    }

}
