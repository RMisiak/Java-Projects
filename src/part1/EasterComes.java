/*
 * Name: EasterComes
 * Date: February 10, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program calculates when easter will fall in an inputted year.
 */
package part1;

import java.util.Scanner;

/**
 *
 * @author 1misiakrya
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Scanning the user's inputted year
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please input the year");
        long year = input.nextLong();
        
        // Declaring variables
        String monthStr;
        long a, b, c, d, e, f, g, h, i, j, k, m, month, p, day;

        // Calculations
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        j = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + 11 * h + 22 * j) / 451;
        month = (h + j - 7 * m + 114) / 31;
        p = (h + j - 7 * m + 114) % 31;
        day = p + 1;

        // Determine month
        if (month == 3) {
            monthStr = "March";
        } else {
            monthStr = "April";
        }

        System.out.println("Easter will occur on Sunday, " + monthStr + " " + day + " " + year);

    }

}
