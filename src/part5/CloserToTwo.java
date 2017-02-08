/*
 * Name: CloserToTwo
 * Date: April 1, 2015
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program demonstrates that the result of adding the numbers 1, 1/2, 1/4, 1/16 ...
 and so on gets closer to 2 without ever becoming 2 (Although it ends up getting to two since there are
only so many digits it can remember).
 */
package part5;

/**
 *
 * @author RMisiak
 */
public class CloserToTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Title & explanation of program for user
        System.out.println("Closer to Two");

        System.out.println("This program demonstrates that the result of adding the numbers 1, 1/2, 1/4, 1/16 ...\n"
                + "and so on gets closer to 2 without ever becoming 2.");

        //Making count and totalIncrease variables
        double totalIncrease;
        int count = 0;
        long doubleCount = 1;

        //OUTPUT
        System.out.println("0 + 1/1 = 1.0");

        for (double startValue = 1; startValue < 2; startValue += (Math.pow(2, 1 * count))) {
            totalIncrease = Math.pow(2, 1 * (count - 1));
            doubleCount = doubleCount * 2;
            System.out.println(startValue + " + " + "1/" + doubleCount + " = " + (startValue + totalIncrease));
            count = count - 1;
        }

    }

}
