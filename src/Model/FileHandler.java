package Model;

import Model.Users.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public void saveStudents(ArrayList<Student> students) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.txt"));
            out.writeObject(students);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<Student> readStudents()  {
        ArrayList<Student> students = new ArrayList<Student>();
       try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.txt"));

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

    public void savePrograms(ArrayList<Program> programs) {
        try {


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("programs.txt"));


            out.writeObject(programs);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<Program> readPrograms() {
        ArrayList<Program> programs = new ArrayList<Program>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("programs.txt"));

            programs = (ArrayList<Program>) in.readObject();

            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return programs;

    }

    public void saveProgramManagers(ArrayList<ProgramManager> programManagers) {
        try {


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("programManagers.txt"));


            out.writeObject(programManagers);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<ProgramManager> readProgramManagers() {
        ArrayList<ProgramManager> programManagers = new ArrayList<ProgramManager>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("programManagers.txt"));

            programManagers = (ArrayList<ProgramManager>) in.readObject();

            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return programManagers;

    }

}
