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
public class TriangleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Triangle a = new Triangle(-1, -2, -3);
        System.out.println(a.toString());
        a.setSideLengthA(0);
        System.out.println(a.toString());
        a.setSideLengthA(10);
        System.out.println(a.getSideLengthA());
        
//        BankAccount a = new BankAccount(100, 1234);
//        System.out.println(a.pinNumber);
//        a.balance = 1000000;
//        System.out.println(a.toString());
        
//        String name = new String("Muir");
//        Triangle small = new Triangle(1, 2, 3);
//        Triangle large = new Triangle(11, 12, 13);
        
    }
    
}
