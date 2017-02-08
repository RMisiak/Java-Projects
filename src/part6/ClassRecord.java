/*
 * Name: ClassRecord
 * Date: May 27, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a ClassRecord object.
 */
package part6;

/**
 *
 * @author 1misiakrya
 */
public class ClassRecord {

    public static final int FIELD_LENGTH_TEACHER = 15;
    public static final int FIELD_LENGTH_COURSE_CODE = 12;
    public static final char UNIVERSITY = 'U';
    public static final char COLLEGE = 'C';
    public static final char OPEN = 'O';

    private static int lastIDUsed = 0;

    private String teacherName;
    private String courseCode;
    private char courseLevel;
    private int classSize;
    private double numCredits;
    private int id;
    private int dbId;
    private boolean fullSemester;

    public ClassRecord() {
        this(++lastIDUsed);
    }

    public ClassRecord(int id) {
        this("Unknown", "Unknown", 'O', -1, 1.0, true);
        this.id = id;
    }

    public ClassRecord(String teacherName, String courseCode, char courseLevel, int classSize, double numCredits, boolean fullSemester) {
        this.setTeacherName(teacherName);
        this.setCourseCode(courseCode);
        this.setCourseLevel( courseLevel );
        this.classSize = classSize;
        this.numCredits = numCredits;
        this.fullSemester = fullSemester;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getId() {
        return this.id;
    }

    public char getCourseLevel() {
        return this.courseLevel;
    }

    public void setCourseLevel(char courseLevel) {
        String st = "" + courseLevel;
        st = st.toUpperCase();
        if (st.length() == 1) {
            courseLevel = st.charAt(0);
        }
        if (courseLevel == UNIVERSITY || courseLevel == COLLEGE || courseLevel == OPEN) {
            this.courseLevel = courseLevel;
        } else {
            System.out.println("ERROR - INVALID COURSE LEVEL");
        }
    }

    public double getNumCredits() {
        return this.numCredits;
    }

    public void setNumCredits(double numCredits) {
        this.numCredits = numCredits;
    }

    public boolean isFullSemester() {
        return fullSemester;
    }

    public void setFullSemester(boolean fullSemesterCourse) {
        this.fullSemester = fullSemesterCourse;
    }

    public void setTeacherName(String teacherName) {
        StringBuilder temp = new StringBuilder();
        if (teacherName != null) {
            temp.append(teacherName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(FIELD_LENGTH_TEACHER);
        this.teacherName = temp.toString();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        StringBuilder temp = new StringBuilder();
        if (courseCode != null) {
            temp.append(courseCode.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(FIELD_LENGTH_COURSE_CODE);
        this.courseCode = temp.toString();
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    @Override
    public String toString() {
        return "ClassRecord{" + "teacherName=" + teacherName + ", courseCode=" + courseCode + ", courseLevel=" + courseLevel + ", classSize=" + classSize + ", numCredits=" + numCredits + ", id=" + id + ", fullSemester=" + fullSemester + '}';
    }

}
