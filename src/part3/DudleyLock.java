/*
 * Name: DudleyLock
 * Date: April 28, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a DudleyLock object.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class DudleyLock extends Lock {

    // COMBO MAX
    public static final int COMBO_MAX = 39;

    // CONSTRUCTOR
    public DudleyLock() {
        super(false, 3);
    }

    // GETTING COMBO MAX
    @Override
    public int getMaxValue() {
        return COMBO_MAX;
    }
}
