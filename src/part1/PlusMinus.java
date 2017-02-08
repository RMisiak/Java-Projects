/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author 1misiakrya
 */
public class PlusMinus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the array size"));
        String a = JOptionPane.showInputDialog("Enter the numbers in the array\n(with space between)");

        StringTokenizer st = new StringTokenizer(a);

        int data;
        int positives = 0;
        int negatives = 0;
        int zeroes = 0;
        double percentPositive;
        double percentNegative;
        double percentZero;

        for (int i = 0; i < n; i++) {
            data = Integer.parseInt(st.nextToken());
            if (data > 0) {
                positives = positives + 1;
            } else if (data < 0) {
                negatives = negatives + 1;
            } else {
                zeroes = zeroes + 1;
            }
        }

        percentZero = zeroes / n;
        percentPositive = positives / n;
        percentNegative = negatives / n;

        System.out.println(percentPositive + "\n" + percentNegative + "\n" + percentZero);

    }

}
