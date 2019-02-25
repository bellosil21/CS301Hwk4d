package com.example.bellosil21.myapplication;

import java.util.ArrayList;

/**
 * Keeps track of the pot, bets, the players who have called the maximum bet.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class BetTracker {

    private ArrayList<PlayerChipCollection> players; //all player chip collections
    private int maxBet; // the maximum bet that has taken place before everyone has called in
                        // order to move on to the next playing phase
    private ChipCollection pot; // the winnings

    public static final int DEFAULT_POT_SIZE = 0;

    public BetTracker(ArrayList<PlayerChipCollection> players) {
        this.players = players;
        this.pot = new ChipCollection(DEFAULT_POT_SIZE);
    }

    /**
     * Copy constructor
     */
    public BetTracker(BetTracker toCopy) {
        this.players = new ArrayList<PlayerChipCollection>();

        for (PlayerChipCollection p : toCopy.players) {
            this.players.add(new PlayerChipCollection(p));
        }

        this.maxBet = toCopy.maxBet;
        this.pot = toCopy.pot;
    }

    /**
     * To be used with the GameAction. If the bet is valid, we prompt the other players to
     * respond to the new bet.
     * A bet is valid if it is greater than the maximum bet for the phase and if the player has
     * enough chips to bet.
     *
     * @param playerID  the ID of the player that's betting
     * @param betAmount the amount that the player is betting
     * @return  true if the bet is valid
     */
    public boolean submitBet(int playerID, int betAmount) {
        if (betAmount <= maxBet) {
            return false;
        }

        if (players.get(playerID).getChips() < betAmount) {
            return false;
        }

        maxBet = betAmount;

        promptOtherPlayers(playerID);

        return true;
    }

    /**
     * After everyone has called the maximum bet, we take everyone's bets and place them into the
     * pot.
     */
    public void moveBetsToPot() {
        for (PlayerChipCollection p : players) {
            if (!p.hasFolded() && p.hasCalled()) {
                p.removeChips(maxBet);
                pot.addChips(maxBet);
            }
        }
    }

    /**
     * Sets the hasCalled variable of the current players to false, besides the player that
     * placed the bet.
     *
     * @param playerID  the ID of the player who placed the bet and does not need to call
     */
    private void promptOtherPlayers(int playerID) {
        for (PlayerChipCollection p : players) {
            if (!p.hasFolded()) {
                p.setHasCalled(false);
            }
        }

        players.get(playerID).setHasCalled(true);
    }

    @Override
    public String toString() {
        return "Pot: " + pot + "\nMaximum Bet: " + maxBet;
    }
}
