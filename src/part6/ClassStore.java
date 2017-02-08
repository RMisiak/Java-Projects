/*
 * Name: ClassStore
 * Date: May 30, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a ClassStore object.
 */
package part6;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1misiakrya
 */
public class ClassStore {

    private final static int LENGTH_OF_ONE_RECORD = 70;
    private RandomAccessFile file;

    public ClassStore() {
        this.open();
    }

    public ClassRecord add(ClassRecord cRec) {
        return write(cRec);
    }

    public ClassRecord update(ClassRecord cRec) {
        return write(cRec);
    }

    public void delete(ClassRecord cRec) {
        try {
            if (cRec.getDbId() - 1 < 0 || (cRec.getDbId() - 1) * LENGTH_OF_ONE_RECORD > this.file.length()) {
                System.out.println("ERROR - Record does not exist in the file!");
            } else {
                this.file.seek((cRec.getDbId() - 1) * LENGTH_OF_ONE_RECORD);
                this.file.writeBoolean(true);
            }

            // BOOLEAN deleted - true = deleted, false = not deleted
        } catch (IOException ex) {
            Logger.getLogger(ClassStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClassRecord write(ClassRecord cRec) {
        try {
            if (cRec.getDbId() - 1 < 0 || (cRec.getDbId() - 1) * LENGTH_OF_ONE_RECORD > this.file.length()) {
                this.file.seek(this.file.length());
                cRec.setDbId((int) ((this.file.length() / LENGTH_OF_ONE_RECORD) + 1));
            } else {
                this.file.seek((cRec.getDbId() - 1) * LENGTH_OF_ONE_RECORD);
            }
            this.file.writeBoolean(false);
            this.file.writeBoolean(cRec.isFullSemester());
            this.file.writeChars(cRec.getTeacherName());
            this.file.writeChars(cRec.getCourseCode());
            this.file.writeInt(cRec.getClassSize());
            this.file.writeDouble(cRec.getNumCredits());
            this.file.writeChar(cRec.getCourseLevel());
            System.out.println(this.file.length());
            return cRec;
        } catch (IOException ex) {
            Logger.getLogger(ClassStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ClassRecord read(int j) {
        try {
            ClassRecord cRec = new ClassRecord();
            long locPointer = (j - 1) * LENGTH_OF_ONE_RECORD;
            if (locPointer < 0 || locPointer > file.length()) {
                System.out.println("ERROR - File pointer does not exist!!!");
            } else {
                file.seek(locPointer);
                if (this.file.readBoolean()) {
                    System.out.println("ERROR - Record has been deleted!!!");
                    cRec = null;
                } else {
                    cRec.setFullSemester(file.readBoolean());
                    char teacherName[] = new char[ClassRecord.FIELD_LENGTH_TEACHER];
                    for (int i = 0; i < ClassRecord.FIELD_LENGTH_TEACHER; i++) {
                        teacherName[i] = file.readChar();
                    }
                    System.out.println("TEACHER: " + new String(teacherName));
                    char courseCode[] = new char[ClassRecord.FIELD_LENGTH_COURSE_CODE];
                    for (int i = 0; i < ClassRecord.FIELD_LENGTH_COURSE_CODE; i++) {
                        courseCode[i] = file.readChar();
                    }
                    cRec.setTeacherName(new String(teacherName));
                    cRec.setCourseCode(new String(courseCode));
                    cRec.setClassSize(file.readInt());
                    cRec.setNumCredits(file.readDouble());
                    cRec.setCourseLevel(file.readChar());
                }
            }
            return cRec;
        } catch (IOException ex) {
            Logger.getLogger(ClassStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void open() {
        try {
            this.file = new RandomAccessFile("txt.dat", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClassStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            this.file.close();
        } catch (IOException ex) {
            Logger.getLogger(ClassStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
