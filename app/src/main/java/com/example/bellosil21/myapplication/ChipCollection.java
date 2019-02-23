package com.example.bellosil21.myapplication;

import java.io.Serializable;

public class ChipCollection implements Serializable{
    private int amount;

    public ChipCollection(int amount){
        this.amount = amount;
    }

    public int getChips(){
        return amount;
    }

    public void setChips(int newChipAmount){
        amount = newChipAmount;
    }

    /**
     * this is just for the toString method in pokerGamestate
     * @return just returns the only instance variable in
     * this class.
     */
    public String getAmount(){
        return ""+amount;
    }
}

