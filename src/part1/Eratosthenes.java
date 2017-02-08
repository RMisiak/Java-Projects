/*
 * Name: Eratosthenes
 * Date: February 18, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program lists all the prime numbers from 1 to 1000
 */
package part1;

/**
 *
 * @author 1misiakrya
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int counter = 0;
        for (int i = 2; i < 1000; i++) {
            if (counter == 10) {
                System.out.print("\n");
                counter = 0;
            } else {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                    counter++;
                }
            }

        }

    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

}
