/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

/**
 *
 * @author RMisiak
 */
public class TestPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String str = "*****************";
//        int e = 4;
//        christmasTree(str, 0, e);
//        e = 6;
//        christmasTree(str, 0, e);
//        e = 8;
//        christmasTree(str, 0, e);
        System.out.println(gcd(54,90));
        
    }

    public static String xmasTree(String str, int numSpaces, int numStars) {
        System.out.println();
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(" ");
        }
        if (numStars <= str.length()) {
            System.out.print(str.substring(str.length() - numStars));
            xmasTree(str, numSpaces - 1, numStars + 2);
        }

        return str;
    }
    
    public static int pi(String str){
        if(str.length() < 2){
            return 0;
        }
        if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return 1 + pi(str.substring(2));
        } else {
            return 0 + pi(str.substring(1));
        }
    }

    public static String christmasTree(String str, int i, int e) {
        String format;
        if (i > e) {
            return "";
        } else {
            format = "%" + (15 + i) + "s";
            System.out.println(String.format(format, str.substring(str.length() - i - (i + 1))));
            return christmasTree(str, i + 1, e);
        }

    }

    public static int gcd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m > n) {
            return gcd(n, m - n);
        } else {
            return gcd(n, m);
        }
    }
}
