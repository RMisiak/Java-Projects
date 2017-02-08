/*
 * Name: RAFExample
 * Date: May 27, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: 
 */
package part6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 1misiakrya
 */
public class RAFExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        ClassRecord c = new ClassRecord();
//        System.out.println("!" + c.getTeacherName() + "!");
//        RandomAccessFile file = new RandomAccessFile("courses.dat", "rw");
//
//        ClassRecord d = new ClassRecord("Computer Science", "ICS4U1", 'U', 15, 1.0, true);
//        System.out.println("!" + d.getTeacherName() + "!");
//
////        file.seek(0);
////        file.writeChars(c.getTeacherName());
////        file.writeChars(c.getCourseCode());
////        file.writeInt(c.getClassSize());
////
////        file.writeChars(d.getTeacherName());
////        file.writeChars(d.getCourseCode());
////        file.writeInt(d.getClassSize());
////        file.close();
//
//        RandomAccessFile raf = new RandomAccessFile("courses.dat", "rw");
//
//        raf.writeBoolean(false);
//        raf.writeBoolean(d.isFullSemester());
//        raf.writeChars(d.getTeacherName());
//        raf.writeChars(d.getCourseCode());
//        raf.write(d.getClassSize());
//        raf.writeDouble(d.getNumCredits());
//        raf.writeChar(d.getCourseLevel());
//        
//        System.out.println(raf.length());
//        raf.close();
        ClassRecord teacher1 = new ClassRecord("Ryan Misiak12345", "COMPUTER SCIENCE", 'U', 10, 1.0, true);
        ClassRecord teacher2 = new ClassRecord("Ryan", "COMPUTER SCIENCE", 'U', 10, 1.0, true);
        ClassRecord teacher3 = new ClassRecord("Ildar Nasirov", "COMPUTER SCIENCE", 'C', 10, 0.5, false);

        ClassStore cs = new ClassStore();
        cs.add(teacher1);
        cs.add(teacher2);
        cs.add(teacher3);

        System.out.println(cs.read(2));
        System.out.println(cs.read(1));
        System.out.println(cs.read(3));

        cs.delete(teacher2);

        System.out.println(cs.read(2));

        //ClassRecord teacher4 = new ClassRecord("Ryan Misiak", "COMPUTER SCIENCE", 'U', 10, 1.0, true);
        teacher1.setTeacherName("Marwan Mekhemer");
        cs.update(teacher1);
        System.out.println(cs.read(1));
        cs.close();
    }

}
