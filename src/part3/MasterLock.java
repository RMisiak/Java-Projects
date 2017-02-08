/*
 * Name: MasterLock
 * Date: April 28, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a MasterLock object.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class MasterLock extends Lock {

    // COMBO MAX
    public static final int COMBO_MAX = 59;

    // CONSTRUCTOR
    public MasterLock() {
        super(false, 3);
    }

    // GETTING MAX VALUE
    @Override
    public int getMaxValue() {
        return COMBO_MAX;
    }
}
