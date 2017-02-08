/*
 * Name: LocksInterface
 * Date: May 2, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a lock interface.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public interface LocksInterface {
    
    public void unlock(int[] combo);
    
    public void lock();
    
    public int getId();
    
    public int[] getCombo();
    
}
