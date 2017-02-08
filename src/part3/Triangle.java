/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class Triangle {

    // Object Variables or
    // Instance Variables
    private int sideLengthA;
    private int sideLengthB;
    private int sideLengthC;

    // RIGHT CLICK, INSERT CODE, CONSTRUCTOR
    // CONSTRUCTOR
    // "special method"
    // it is called ONCE, only ONCE!
    @Override
    public String toString() {
        return "Triangle{" + "sideLengthA=" + sideLengthA + ", sideLengthB=" + sideLengthB + ", sideLengthC=" + sideLengthC + '}';
    }

    // when a NEW object is created.
    public Triangle() {
        System.out.println("Triangle Created!");
        System.out.println(sideLengthA);
        System.out.println(sideLengthB);
        System.out.println(sideLengthC);
    }

    public Triangle(int sideLengthA, int sideLengthB, int sideLengthC) {
        this.setSideLengthA(sideLengthA);
        this.sideLengthB = sideLengthB;
        this.sideLengthC = sideLengthC;
        sideLengthA = sideLengthA * 10;
        // this - Referring to itself
        // In this case, it is referring to the object variable, not the parameter.
        System.out.println("Triangle Created!");
        System.out.println(this.sideLengthA);
        System.out.println(sideLengthB);
        System.out.println(sideLengthC);
    }

    public int getSideLengthA() {
        return sideLengthA;
    }

    public void setSideLengthA(int sideLengthA) {
        if (sideLengthA <= 0) {
            System.out.println("Invalid Side Length!");
        } else {
            this.sideLengthA = sideLengthA;
        }

    }

    public int getSideLengthB() {
        return sideLengthB;
    }

    public void setSideLengthB(int sideLengthB) {
        this.sideLengthB = sideLengthB;
    }

    public int getSideLengthC() {
        return sideLengthC;
    }

    public void setSideLengthC(int sideLengthC) {
        this.sideLengthC = sideLengthC;
    }

}
