package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable{
    ArrayList<Card> deckOfCards;

    // TODO: Add Reference
    public Deck(){
        for (Card.Suit s: Card.Suit.values()){
            for (Card.Rank r: Card.Rank.values()){
                Card newCard = new Card(s,r);
                deckOfCards.add(newCard);
            }
        }
    }

    /** Deck
     *
     * Copy constsructor
     * Copies all cards in the deck into a new deck.
     */
    public Deck(Deck toCopy) {
        deckOfCards = new ArrayList<Card>();

        for (Card c : toCopy.deckOfCards) {
            deckOfCards.add(new Card(c));
        }
    }

}
