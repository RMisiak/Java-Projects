/*
 * Name: HangMan
 * Date: February 18, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program creates the game HangMan.
 */
package part1;

import javax.swing.JOptionPane;

/**
 *
 * @author 1misiakrya
 */
public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String chosenWord;
        String dashes = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String s;
        boolean gameContinues = true;

        String[][] words = {
            {"TV Shows", "Movies", "Sports"},
            {"the sopranos", "deadpool", "soccer"},
            {"the walking dead", "the intern", "baseball"},
            {"the cosby show", "the godfather", "volleyball"}
        };

        int chooseCol = (int) Math.random() * 3;
        int chooseRow = ((int) Math.random() * 2) + 1;

        chosenWord = words[chooseRow][chooseCol];
        System.out.println("Category: " + words[0][chooseCol]);

        for (int i = 0; i < chosenWord.length(); i++) {
            if (alphabet.contains("" + chosenWord.charAt(i))) {
                dashes = dashes + "-";
            } else {
                dashes = dashes + " ";
            }
        }

        while (gameContinues) {
            System.out.println(dashes);
            s = JOptionPane.showInputDialog("Enter a letter");
            if (s.length() > 1) {
                System.out.println("Error - one letter at a time.");
            } else {
                if (chosenWord.contains(s)) {
                    
                } else {

                }
            }
        }

    }

}
