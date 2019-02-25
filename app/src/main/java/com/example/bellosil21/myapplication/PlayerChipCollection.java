package com.example.bellosil21.myapplication;

/**
 * Stores an amount of chips with player data.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class PlayerChipCollection extends ChipCollection {

    private int playerID;
    private boolean hasFolded; //whether or not the player has folded
    private boolean hasCalled; //whether or not the player has called

    /**
     * Assigns player data to a ChipCollection
     *
     * @param amount    the amount of starting chips in the collection
     * @param id    the player's id
     */
    public PlayerChipCollection(int amount, int id) {
        super(amount);
        this.playerID = id;
        hasFolded = false;
        hasCalled = false;
    }

    /**
     * Copy constructor
     */
    public PlayerChipCollection(PlayerChipCollection toCopy) {
        super(toCopy.amount);
        this.playerID = toCopy.playerID;
        hasFolded = toCopy.hasFolded;
        hasCalled = toCopy.hasCalled;
    }

    public boolean hasFolded() {
        return hasFolded;
    }

    public void setHasFolded(boolean hasFolded) {
        this.hasFolded = hasFolded;
    }

    public boolean hasCalled() {
        return hasCalled;
    }

    public void setHasCalled(boolean hasCalled) {
        this.hasCalled = hasCalled;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasFolded is " + hasFolded + ", hasCalled is " + hasCalled;
    }
}
