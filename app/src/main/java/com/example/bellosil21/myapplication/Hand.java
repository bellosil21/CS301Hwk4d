package com.example.bellosil21.myapplication;

import java.io.Serializable;

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
    private CardSlot hole1;
    private CardSlot hole2;
    // Determines if other players can see this player's cards
    private boolean showCards;

    /**
     * A player's hand is composed of two cards from the deck.
     *
     * @param hole1     the first card in the player's hand
     * @param hole2     the second card in the player's hand
     */
    public Hand(Card hole1, Card hole2){
        this.hole1 = hole1;
        this.hole2 = hole2;
        showCards = false;
    }

    /**
     * Copy constructor
     * Copies the cards into a new hand. Will only pass a Card if show(Left/Right) is true. Else,
     * a BlankCard is copied.
     *
     * @param toCopy    the Hand to copy
     */
    public Hand(Hand toCopy) {
        if (toCopy.showCards) {
            hole1 = new Card((Card)toCopy.hole1);
            hole2 = new Card((Card)toCopy.hole2);
        } else {
            hole1 = new BlankCard();
            hole2 = new BlankCard();
        }
        showCards = toCopy.showCards;
    }

    /**
     * Sets the boolean value if the cards are to be shown
     *
     * @param isShown - boolean if the cards are to be shown
     */
    public void setShowCards(boolean isShown) {
        showCards = isShown;
    }

    /**
     * Describes the hand.
     *
     * @return a string describing the cards in hand
     */
    public String toString(){
        return "Card1:" + hole1.toString() + "\n" +
                "Card2: " + hole2.toString() +
                "showCards: " + showCards;
    }

}
