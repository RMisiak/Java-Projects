/*
 * Name: AndroidLock
 * Date: April 28, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a AndroidLock object.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class AndroidLock extends Lock {

    // COMBO MAX
    public static final int COMBO_MAX = 9;

    // 
    public AndroidLock() {
        super(true, 4);
        combo[3] = (int) (Math.random() * 10);
    }

    public void setCombo(int[] combo) {
        this.changeCombo(combo);
    }

    @Override
    public int getMaxValue() {
        return COMBO_MAX;
    }
}
