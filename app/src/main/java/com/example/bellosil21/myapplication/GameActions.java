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
     * @param turn will be incremented with something to show
     *             who's turn it is in the current round.
     * @param placedBet will be true if someone in the current round has
     *                  placed a bet, meeaning the action
     * @return
     */
    public boolean Check(int turn, boolean placedBet){
        if(turn == 0){
            //meaning that the player was allowed to check
            return true;
        }
        else if(placedBet) //a place has been checked.
        {
            //than have it print: "Illegal move" or something.
            return false;
        }


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

    /**
     * these methods should probably return true uncondtionally,
     * since they arent techniquelly ever illegal moves but they
     * are still actions.
     */
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
