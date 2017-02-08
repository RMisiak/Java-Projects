/*
 * Name: Actor
 * Date: April 19, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates an Actor object.
 */
package part3;

public class Actor {

    // VARIABLE DECLARATION
    private static final int MALE = 0;
    private static final int FEMALE = 1;

    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private static int lastID = 0;
    private int sex;

    // EMPTY CONSTRUCTOR
    public Actor() {
        this("Unknown", "Unknown", -1, -1);
    }

    // PRIMARY KEY CONSTRUCTOR
    public Actor(int id) {
        this();
        this.id = id;
    }

    // SECONDARY KEYs CONSTRUCTOR
    public Actor(String firstName, String lastName, int age, int sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        if (this.id < 1) {
            this.id = ++lastID;
        }
    }

    // GETTER / SETTER FOR FIRST NAME
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "Unknown";
        } else {
            this.firstName = firstName;
        }
    }

    // GETTER / SETTER FOR LAST NAME
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "Unknown";
        } else {
            this.lastName = lastName;
        }
    }

    // GETTER AND SETTER FOR SEX
    public String getSex() {
        if (sex == MALE) {
            return "Male";
        } else if (sex == FEMALE) {
            return "Female";
        } else {
            return "Unknown";
        }
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    // GETTER / SETTER FOR ID
    public int getID() {
        return id;
    }

    public void setID(int id) {
        if (id < 0) {
            System.out.println("ERROR - Invalid Entry");
        } else {
            this.id = id;
        }
    }

    // GETTER / SETTER FOR AGE
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("ERROR - INVALID AGE");
        } else {
            this.age = age;
        }
    }

    // CHECKS IF ACTOR IS AN ADULT
    public boolean isAnAdult() {
        if (this.age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    // CHECKS IF ACTOR IS VALID
    public boolean isValid() {
        if (firstName == null || firstName.length() < 1) {
            return false;
        } else if (lastName == null || lastName.length() < 1) {
            return false;
        } else if (id < 0) {
            return false;
        }
        return true;
    }

    // CHECKS IF ONE ACTOR EQUALS ANOTHER
    public boolean equals(Actor actor) {
        if (actor == null) {
            return false;
        }
        if (this.id != actor.getID()) {
            return false;
        }
        return (actor.getFirstName().equals(firstName) && actor.getLastName().equals(lastName) && actor.getAge() == age && actor.getSex().equals(this.getSex()));
    }

}
