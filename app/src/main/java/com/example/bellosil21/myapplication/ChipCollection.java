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

    /**
     * Gets the amount of chips a player has
     *
     * @return The amount of Chips a Player has
     */
    public int getChips(){
        return amount;
    }

    public void setChips(int newChipAmount){
        amount = newChipAmount;
    }

    /**
     * Describes the chip collection.
     *
     * @return a string describing the amount of chips in this chip collection
     */
    @Override
    public String toString(){
        return amount + " chips";
    }
}

