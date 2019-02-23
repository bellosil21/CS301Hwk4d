package com.example.bellosil21.myapplication;

import java.io.Serializable;

public class Card implements Serializable{

    public enum Suit{
        DIAMONDS,
        SPADES,
        CLUBS,
        HEART;

        public static final int numOfSuits = 4;
    }

    // TODO: Add Reference
    public enum Rank{
        TWO(1),
        THREE(2),
        FOUR(3),
        FIVE(4),
        SIX(5),
        SEVEN(6),
        EIGHT(7),
        NINE(8),
        TEN(9),
        JACK(10),
        QUEEN(11),
        KING(12),
        ACE(13);

        public static final int numOfRanks = 13;
        private int numVal;

        Rank(int numVal){
            this.numVal = numVal;
        }

        public int getValue(){
            return numVal;
        }
    }
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit suit(){
        return suit;
    }

}
