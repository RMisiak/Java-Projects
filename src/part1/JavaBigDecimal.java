/*
 * Name: JavaBigDecimal
 * Date: February 10, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program sorts numbers in descending order.
 */
package part1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author RMisiak
 */
public class JavaBigDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Receiving user input
        System.out.println("How many numbers would you like to sort?");
        int totalAmount = Integer.parseInt( input.nextLine() );

        BigDecimal[] numbers = new BigDecimal[totalAmount];

        System.out.println("Please enter a set of numbers.");

        // Putting user's input into 
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new BigDecimal( input.nextLine() );
        }

        int numbersWhenHighestValue = 0;

        for (int pass = 0; pass < numbers.length - 1; pass++) {
            numbersWhenHighestValue = 0;
            for (int j = 1; j < numbers.length - pass; j++) {
                int decimalChecker;
                decimalChecker = numbers[j].compareTo(numbers[numbersWhenHighestValue]);
                if (decimalChecker == -1) {
                    numbersWhenHighestValue = j;
                }
            }
            BigDecimal temp = numbers[numbersWhenHighestValue];
            numbers[numbersWhenHighestValue] = numbers[numbers.length-1-pass];
            numbers[numbers.length-1-pass] = temp;            

        }
        
        System.out.println( "---- SORTED VALUES ----" );
        displayArray(numbers);

    }
    
    public static void displayArray( BigDecimal[] numbers ) {
        for( int i = 0; i < numbers.length; i++ ) {
            System.out.println( numbers[i].toString() );
        }
    }

}
