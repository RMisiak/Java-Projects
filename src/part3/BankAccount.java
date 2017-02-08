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
public class BankAccount {
    
    private double balance;
    private int pinNumber;

    @Override
    public String toString() {
        return "BankAccount{" + "balance=" + balance + ", pinNumber=" + pinNumber + '}';
    }

    public BankAccount(double balance, int pinNumber) {
        this.balance = balance;
        this.pinNumber = pinNumber;
    }
    
    // SETTERS / GETTERS
    // ACCESSORS / MODIFIERS
    
}
