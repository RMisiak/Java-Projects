/*
 * Name: RoundingError
 * Date: February 10, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program finds the rounding error between the square of a 
square root and the value itself.
 */
package part1;

import java.util.Scanner;

/**
 *
 * @author RMisiak
 */
public class RoundingError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner inputNumber = new Scanner(System.in);
        double userNumber  = inputNumber.nextDouble();
        
        double userNumberRoot = Math.sqrt(userNumber);
        double squareOfSquareRoot = Math.pow(userNumberRoot, 2);
        
        double roundingError = userNumber - squareOfSquareRoot;
        System.out.println("The rounding error is: " + roundingError);

    }

}
