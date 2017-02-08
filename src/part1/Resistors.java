/*
 * Name: Resistors
 * Date: February 18, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program calculates the ohms of a list of colours.
 */
package part1;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author 1misiakrya
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog("What is your resistors colour code?\nSeparate each c"
                + "colour by hyphens\nEx: Red-Orange-Black").toUpperCase();

        String[] colours = {"BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET", "GREY", "WHITE"};
        String[] chosenColours = new String[3];
        int[] coloursNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int exponent = 0;
        String number = "";
        int numberFromString;
        StringTokenizer st = new StringTokenizer(s, "-");

        double ohms;
        int h = 0;
        
        while (st.hasMoreTokens()) {
            chosenColours[h] = st.nextToken();
            h++;
        }
        
        for(int i = 0; i < chosenColours.length; i++){
            if (i == 2) {
                for (int j = 0; j < colours.length; j++) {
                    if (chosenColours[i].equals(colours[j])) {
                        exponent = coloursNumbers[j];
                    }
                }
            } else {
                for (int j = 0; j < colours.length; j++) {
                    if (chosenColours[i].equals(colours[j])) {
                        number = number + coloursNumbers[j];
                    }
                }
            }
            
        }
        
        numberFromString = Integer.parseInt(number);
        ohms = (numberFromString * (Math.pow(10, exponent)));
        
        System.out.println("You entered: " + s + "\nThe value of the resistor is " + ohms + " ohms");

        
    }

}
