/*
 * Name: Eratosthenes2
 * Date: February 22, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program lists all the prime numbers from 1 to 1000
 */
package part1;

/**
 *
 * @author 1misiakrya
 */
public class Eratosthenes2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean numbers[] = new boolean[1000];
        
        int[] primes = new int[1000];
        
        for(int i = 0; i < primes.length; i++){
            numbers[i] = true;
            for(int divisor = 2; divisor < primes.length; divisor++){
                if(primes[i] % divisor == 0){
                    numbers[i] = false;
                }
            }
            if(numbers[i]){
                System.out.print(primes[i] + " ");
            }
        }
        
        
        
    }
    
}
