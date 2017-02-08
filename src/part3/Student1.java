/*
 * Name: Student
 * Date: April 4, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This class creates a student.
 */
package part3;

import java.util.Objects;

/**
 *
 * @author 1misiakrya
 */
public class Student1 {

    // CLASS CONSTANT
    private static final String SCHOOL_NAME = "Garth Webb";
    
    // CLASS VARIABLE
    private static int lastIDUsed = 0;
    
    // OBJECT VARIABLES
    private String firstName;
    private String lastName;
    private int grade;
    private String dob;
    private int oen;
    
    
    public Student1() {
        this.setOen(++lastIDUsed);
    }

    public Student1(String firstName, String lastName, int grade, String dob, int oen) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.dob = dob;
        this.oen = oen;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getOen() {
        return oen;
    }

    public void setOen(int oen) {
        this.oen = oen;
    }


    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if object is null
        if (obj == null) {
            return false;
        }
        // Checks if the class is not equal to the object's class
        if (getClass() != obj.getClass()) {
            return false;
        }
        // Checks if this object is equal to the other one
        final Student1 other = (Student1) obj;
        if (!Objects.equals(this.oen, other.oen)) {
            return false;
        }
        return true;
    }
    
}
