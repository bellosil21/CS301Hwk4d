package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class GameActions implements Serializable {


    public boolean placeBets(int chipsBetIn, ChipCollection playersChips){
        if (chipsBetIn > playersChips.getChips()){ return false; }

        int newChipAmount = playersChips.getChips() - chipsBetIn;
        playersChips.setChips(newChipAmount);

        return true;
    }

    public boolean fold(boolean isTurn, boolean inGame){
        if (isTurn) {
            return true;
        }
        if (inGame){
            return true;
        }
        return false;
    }

    public boolean showCards(boolean wonRound){
        if (wonRound){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean hideCards(boolean wonRound){
        if (wonRound){
            return true;
        }
        else{
            return false;
        }
    }

    /**added by gabe
     *
     * @return
     */
    public boolean Check(){
        return false;
    }

    public boolean call(int leftToBet, ChipCollection playerChips){
        if (playerChips.getChips() >= leftToBet){
            int newChipAmount = playerChips.getChips() - leftToBet;
            playerChips.setChips(newChipAmount);
            return true;
        }
        return false;
    }

    public boolean allIn(boolean inGame){
        if (inGame){
            return true;
        }
        return false;
    }
    public boolean Menu(){
        return false;
    }
    public boolean Exit(){
        return false;
    }
    public boolean Help(){
        return false;
    }
}
