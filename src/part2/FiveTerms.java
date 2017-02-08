/*
 * Name: FiveTerms
 * Date: March 21, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program prints the first 5 terms in a sequence.
 */
package part2;

/**
 *
 * @author 1misiakrya
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Printing title
        System.out.println("Sequence 1:");
        //For loop to get the term numbers
        for (int termNumber = 1; termNumber <= 5; termNumber++) {
            System.out.print(sequenceOne(termNumber) + " ");
        }

        //Printing title
        System.out.println("\n\nSequence 2:");
        //For loop to get the term numbers
        for (int termNumber = 1; termNumber <= 5; termNumber++) {
            //Formatting the double to 2 decimal places
            System.out.print(String.format("%.2f", sequenceTwo(termNumber)) + " ");
        }
    }

    public static int sequenceOne(int termNumber) {

        //Checking term's number value, and returning new value
        if (termNumber == 1) {
            return 1;
        } else if (termNumber == 2) {
            return 3;
        } else {
            return (sequenceOne(termNumber - 1) + sequenceOne(termNumber - 2));
        }

    }

    public static double sequenceTwo(int termNumber) {

        if (termNumber == 1) {
            return 2;
        } else {
            return (Math.sqrt(3 * sequenceTwo(termNumber - 1) + 4));
        }
    }

}
