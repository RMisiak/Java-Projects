/*
 * Name: Palindrome1
 * Date: February 12, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program determines if multiple words are palindromes.
 */
package part1;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author 1misiakrya
 */
public class Palindrome1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Getting the word that will be checked
        String s = JOptionPane.showInputDialog("Enter a line").toLowerCase();

        boolean pal = true;
        StringTokenizer st = new StringTokenizer(s, ", !.");

        String[] words = new String[st.countTokens()];
        
        String[] palindromes = new String[st.countTokens()];
        
        System.out.print("Palindromes are: ");
        
        int counter = 0;

        for (int pass = 0; pass < words.length; pass++) {
            words[pass] = st.nextToken();
            for (int i = 0; i < words[pass].length(); i++) {
                if (words[pass].charAt(i) != words[pass].charAt(words[pass].length() - i - 1)) {
                    pal = false;
                }
            }
            if(pal){
                palindromes[pass] = words[pass];
                System.out.print(palindromes[pass] + " ");
                counter++;
            }
            pal = true;
        }

        
        System.out.println("\nNumber of palindromes: " + counter);

    }

}
