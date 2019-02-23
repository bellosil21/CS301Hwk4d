package com.example.bellosil21.myapplication;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> playerHand = null;
    private int chips;

    public Player(int startingChips){
        chips = startingChips;
    }

    public boolean placeBets(int chipsBetIn){
        if (chipsBetIn > chips){ return false; }

        chips -= chipsBetIn;

        return true;
    }

    public boolean fold (boolean isTurn, boolean inGame){
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

    public boolean call(int leftToBet){
        if (chips >= leftToBet){
            chips -= leftToBet;
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
}
