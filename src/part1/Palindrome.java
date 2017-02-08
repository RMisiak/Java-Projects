/*
 * Name: Palindrome
 * Date: February 11, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program determines if a word is a palindrome.
 */
package part1;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author 1misiakrya
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Getting the word that will be checked
        String s = JOptionPane.showInputDialog("Enter a word");

        boolean pal = true;

        int stringLength = s.length();

        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                pal = false;
            }
        }

        System.out.println("Is it a palindrome?? ------- " + pal);


    }

}
