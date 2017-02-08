package part4;

/**
 * Simple Student Object
 */
public class Student {
  
    private int studentID;
    private String name;
    private String lastName;

    public Student( int studentID, String name, String lastName ) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
    }
    
    // TO DO
    public int getKey() {
        return studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID( int studentID ) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", lastName=" + lastName + '}';
    }

    
    
}
