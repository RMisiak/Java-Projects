/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 1misiakrya
 */
public class HappySad {

    /**
     * @param args the command line arguments
     */
    static String H = ":-)";
    static String S = ":-(";

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(new File("HappySad.txt"));

        while (input.hasNext()) {
            System.out.println(input.nextLine());
            count(input.nextLine());
        }

    }

    public static int count(String s) {
        String mood = "";
        String copyS = "s";

        // HAPPY
        int happyCount = 0;
        int index = s.indexOf(H);
        if (index < 0) {
            mood = "none";
        } else {
            do {
                happyCount++;
                s.substring(index + 3);
                index = s.indexOf(H);
            } while(index> 0);
        }
        
        // SAD
        int sadCount = 0;
        index = s.indexOf(S);
        if (index < 0) {
            mood = "none";
        } else {
            do {
                happyCount++;
                s.substring(index + 3);
                index = s.indexOf(S);
                //System.out.println("happyCount");
            } while(index> 0);
        }
        
        System.out.println(happyCount + " " + sadCount);

        if (happyCount == 0 && sadCount == 0){
            mood = "none";
        } else if (happyCount == sadCount){
            mood = "unknown";
        } else if (happyCount >= sadCount){
            mood = "happy";
        } else{
            mood = "sad";
        }
        System.out.println(mood);
        
        return 0;
    }

}
