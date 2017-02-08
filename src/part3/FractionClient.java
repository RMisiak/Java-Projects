/*
 * Name: FractionClient
 * Date: April 4, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This class prints out fractions created by Fraction.java
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class FractionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fraction a = new Fraction(3, 7);
        Fraction b = new Fraction(7, 2);
        Fraction c = new Fraction();

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }

}
