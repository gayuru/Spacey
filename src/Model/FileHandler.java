package Model;

import Model.Users.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public void saveStudents(ArrayList<Student> students) {
        try {


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));


            out.writeObject(students);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<Student> readStudents()  {
        ArrayList<Student> students = new ArrayList<Student>();
       try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"));

           students = (ArrayList<Student>) in.readObject();

           in.close();

       }
       catch (IOException ex){
           ex.printStackTrace();
       }
       catch (ClassNotFoundException ex){
           ex.printStackTrace();
       }
        return students;

    }

}
