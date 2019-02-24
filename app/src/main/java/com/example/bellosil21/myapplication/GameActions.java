package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The actions a player can make.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
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
     * turn will be an intID.
     * if id = 0 than its the first person's turn
     * @param placedBet will be true if someone in the current round has
     *                  placed a bet, meeaning the action
     * @return
     */
    public boolean Check(boolean placedBet){
        if(placedBet) //a place has been checked.
        {
            //than have it print: "Illegal move" or something.
            return false;
        }

        return true;

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
        return true;
    }
    public boolean Exit(){
        return true;
    }
    public boolean Help(){
        return true;
    }
}
