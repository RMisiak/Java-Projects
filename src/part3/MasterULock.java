/*
 * Name: MasterULock
 * Date: April 28, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a MasterULock object.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class MasterULock extends Lock {

    // MAX VALUE
    public static final int COMBO_MAX = 9;

    // CONSTRUCTOR
    public MasterULock() {
        super(true, 4);
        combo[3] = (int) (Math.random() * 10);
    }

    // SETTING COMBO
    public void setCombo(int[] combo) {
        this.changeCombo(combo);
    }

    // GETTING COMBO MAX
    @Override
    public int getMaxValue() {
        return COMBO_MAX;
    }
}
