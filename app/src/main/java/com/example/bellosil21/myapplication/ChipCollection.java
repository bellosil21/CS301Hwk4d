package com.example.bellosil21.myapplication;

import java.io.Serializable;

/**
 * Stores an amount of chips.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class ChipCollection implements Serializable{

    private int amount; // the amount of chips contains in the collection.

    public ChipCollection(int amount){
        this.amount = amount;
    }

    /**
     * Copy constructor
     * Copies the chip amount in a new ChipCollection.
     *
     * @param toCopy    the ChipCollection to copy
     */
    public ChipCollection(ChipCollection toCopy) {
        amount = toCopy.amount;
    }

    public int getChips(){
        return amount;
    }

    public void setChips(int newChipAmount){
        amount = newChipAmount;
    }

    /**
     * this is just for the toString method in pokerGamestate
     *
     * @return just returns the only instance variable in
     * this class.
     */
    public String getAmount(){
        return "" + amount;
    }
}

