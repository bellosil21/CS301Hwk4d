package com.example.bellosil21.myapplication;

public class ChipCollection {
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
}

