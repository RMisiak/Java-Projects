/*
 * Name: Lock
 * Date: April 25, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a Lock object.
 */
package part3;

import java.util.Arrays;

public abstract class Lock implements LocksInterface {

    // CONSTANT VARIABLES
    public static final int COMBO_MIN = 0;

    // INSTANCE VARIABLES
    public int numTries = 0;
    public int[] combo;
    public boolean canReset;
    public boolean unlocked = false;
    private int id;
    public static int lastID;
    public int numGets = 0;

    // CONSTRUCTOR
    public Lock(boolean canReset, int numCombos) {
        this.canReset = canReset;
        this.combo = new int[numCombos];
        setInitialCombo();
        this.unlocked = false;
        setId(++lastID);
    }

    // GETTING UNLOCKED
    public boolean getUnlocked() {
        return this.unlocked;
    }

    // SETTERS & GETTERS FOR ID
    @Override
    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    // LOCKING THE LOCK
    @Override
    public void lock() {
        if (!this.unlocked) {
            System.out.println("ALREADY LOCKED");
        } else {
            this.unlocked = false;
        }
    }

    // SETTING INITIAL COMBO VALUES
    private void setInitialCombo() {
        for (int i = 0; i < combo.length; i++) {
            combo[i] = (int) (Math.random() * this.getMaxValue());
        }
    }

    // ATTEMPTING TO UNLOCK THE LOCK
    @Override
    public void unlock(int[] combo) {
        int numWrong = 0;
        if (numTries < 3) {
            for (int i = 0; i < combo.length; i++) {
                if (!(this.combo[i] == combo[i])) {
                    numWrong++;
                    if (numWrong == 1) {
                        numTries++;
                        System.out.println("ERROR - INVALID COMBOS");
                    }
                } else {
                    this.unlocked = true;
                }
            }
        } else {
            System.out.println("BRICKED");
        }
    }

    // GETTING COMBO
    @Override
    public int[] getCombo() {
        if ((numTries == 0 || unlocked) && numGets == 0) {
            numGets++;
            if (combo.length == 4 || combo.length == 3) {
                int[] aCopy = Arrays.copyOf(this.combo, combo.length);
                return aCopy;
            }
        }
        numGets++;
        return null;
    }

    // ABSTRACT METHOD REQUIRED
    public abstract int getMaxValue();

    // CHANGING COMBO
    public void changeCombo(int[] combo) {
        boolean changeable = true;
        for(int i = 0; i < combo.length; i++){
            if(combo[i] < COMBO_MIN || combo[i] > this.getMaxValue()){
                changeable = false;
            }
        }
        if (this.canReset && changeable) {
            if (this.unlocked) {
                this.combo = combo;
            }
        }
    }
}
