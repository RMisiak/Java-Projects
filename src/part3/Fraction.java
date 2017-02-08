/*
 * Name: Fraction
 * Date: April 4, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This class creates a fraction.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class Fraction {

    // OBJECT / INSTANCE VARIABLES
    private int numerator;
    private int denominator;

    @Override
    public String toString() {
        return "Fraction{" + "" + numerator + "/" + denominator + '}';
    }

    public Fraction() {
        this.denominator = 1;
    }

    /**
     *
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.setDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;

        System.out.println(numerator + "/" + denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("INVALID Denominator: setting to 1");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }
}
