package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Hand implements Serializable{
    Card hole1;
    Card hole2;


    public Hand(Card hole1, Card hole2){
        this.hole1 = hole1;
        this.hole2 = hole2;
    }

    /** Hand
     *
     * Copy constructor
     * Copies the cards into a new hand
     */
    public Hand(Hand toCopy) {
        hole1 = new Card(toCopy.hole1);
        hole2 = new Card(toCopy.hole2);
    }

    /** method is incomplete
     * Must find a way to be able to print the
     * given cards. we can either pass a string id
     * in the constructor or whatever anyone else
     * opninionates.
     * @return
     */
    public String toString(){
        return "Player Hand => Card1:" hole1.toString() + "\n" +
                "Card2: " + hole2.toString();
    }
}
