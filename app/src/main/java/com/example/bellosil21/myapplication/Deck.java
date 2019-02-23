package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable{
    ArrayList<Card> deck;

    // TODO: Add Reference
    public Deck(){
        for (Card.Suit s: Card.Suit.values()){
            for (Card.Rank r: Card.Rank.values()){
                Card newCard = new Card(s,r);
                deck.add(newCard);
            }
        }
    }
}
