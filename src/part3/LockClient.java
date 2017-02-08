/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class LockClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // MASTER LOCK TESTING
        MasterLock m = new MasterLock();
        int[] combo = m.getCombo();
        assert (m.getId() == 1);
        assert (!m.getUnlocked());
        assert (combo.length == 3);
        // CHECKING VALIDITY OF COMBO NUMBERS
        for (int i = 0; i < combo.length; i++) {
            assert (combo[i] >= 0 && combo[i] <= 59);
        }
        assert (m.getMaxValue() == 59);
        // UNLOCKING THE MASTER LOCK
        m.unlock(combo);
        assert (m.getUnlocked());
        // ATTEMPTING TO CHANGE THE COMBOS
        int[] combo1 = new int[3];
        for (int i = 0; i < combo1.length; i++) {
            combo1[i] = 1;
        }
        // GETTING MAX VALUE
        m.changeCombo(combo1);
        assert (combo == combo);
        // LOCKING THE MASTER LOCK
        m.lock();
        assert (!m.getUnlocked());
        // THREE ATTEMPTS TO UNLOCK
        int[] combo2 = new int[3];
        m.unlock(combo2);
        m.unlock(combo2);
        m.unlock(combo2);
        assert (!m.getUnlocked());
        System.out.println("");
        // BRICK THE LOCK
        m.unlock(combo2);
        System.out.println("");

        // DUDLEY LOCK TESTING
        DudleyLock d = new DudleyLock();
        combo = d.getCombo();
        assert (d.getId() == 2);
        assert (!d.getUnlocked());
        assert (combo.length == 3);
        // CHECKING VALIDITY OF COMBO NUMBERS
        for (int i = 0; i < combo.length; i++) {
            assert (combo[i] >= 0 && combo[i] <= 59);
        }
        // GETTING MAX VALUE
        assert (d.getMaxValue() == 39);
        // UNLOCKING THE DUDLEY LOCK
        d.unlock(combo);
        assert (d.getUnlocked());
        // ATTEMPTING TO CHANGE THE COMBOS
        d.changeCombo(combo1);
        assert (combo == combo);
        // LOCKING THE DUDLEY LOCK
        d.lock();
        assert (!d.getUnlocked());
        // THREE ATTEMPTS TO UNLOCK
        d.unlock(combo2);
        d.unlock(combo2);
        d.unlock(combo2);
        assert (!d.getUnlocked());
        System.out.println("");
        // BRICK THE LOCK
        d.unlock(combo2);
        System.out.println("");

        // MASTER U LOCK TESTING
        MasterULock mu = new MasterULock();
        combo = mu.getCombo();
        assert (mu.getId() == 3);
        assert (!mu.getUnlocked());
        assert (combo.length == 4);
        // CHECKING VALIDITY OF COMBO NUMBERS
        for (int i = 0; i < combo.length; i++) {
            assert (combo[i] >= 0 && combo[i] <= 59);
        }
        // GETTING MAX VALUE
        assert (mu.getMaxValue() == 9);
        // UNLOCKING THE MASTER U LOCK
        mu.unlock(combo);
        assert (mu.getUnlocked());
        // ATTEMPTING TO CHANGE THE COMBOS
        combo1 = new int[4];
        for (int i = 0; i < combo1.length; i++) {
            combo1[i] = 1;
        }
        mu.changeCombo(combo1);
        mu.lock();
        mu.unlock(combo1);
        assert (mu.unlocked);
        // LOCKING THE MASTER U LOCK
        mu.lock();
        assert (!mu.getUnlocked());
        // THREE ATTEMPTS TO UNLOCK
        combo2 = new int[4];
        mu.unlock(combo2);
        mu.unlock(combo2);
        mu.unlock(combo2);
        assert (!mu.getUnlocked());
        System.out.println("");
        // BRICK THE LOCK
        mu.unlock(combo2);
        System.out.println("");

        // ANDROID LOCK TESTING
        AndroidLock a = new AndroidLock();
        combo = a.getCombo();
        assert (a.getId() == 4);
        assert (!a.getUnlocked());
        assert (combo.length == 4);
        // CHECKING VALIDITY OF COMBO NUMBERS
        for (int i = 0; i < combo.length; i++) {
            assert (combo[i] >= 0 && combo[i] <= 59);
        }
        // GETTING MAX VALUE
        assert (a.getMaxValue() == 9);
        // UNLOCKING THE ANDROID LOCK
        a.unlock(combo);
        assert (a.getUnlocked());
        // ATTEMPTING TO CHANGE THE COMBOS
        a.changeCombo(combo1);
        a.lock();
        a.unlock(combo1);
        assert (a.unlocked);
        // LOCKING THE ANDROID LOCK
        a.lock();
        assert (!mu.getUnlocked());
        // THREE ATTEMPTS TO UNLOCK
        a.unlock(combo2);
        a.unlock(combo2);
        a.unlock(combo2);
        assert (!a.getUnlocked());
        System.out.println("");
        // BRICK THE LOCK
        a.unlock(combo2);
        System.out.println("");
    }

}
