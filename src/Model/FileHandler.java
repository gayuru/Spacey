package Model;

import Model.Users.*;

import java.io.*;
import java.util.*;

public class FileHandler implements Serializable {

    public void saveUsers(List<User> users) {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"));
            oos.writeObject(users);
            oos.close();
            System.out.println("File saved");
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<User> readUsers()  {
        List<User> users = null;

       try {

           FileInputStream fis = new FileInputStream("users.dat");
           ObjectInputStream ois = new ObjectInputStream(fis);

           users = (List<User> )ois.readObject();

           ois.close();

       }
       catch (Exception ex){
           ex.printStackTrace();
       }
        return users;

    }

    public void savePrograms(List<Program> programs) {
        try {


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("programs.dat"));


            out.writeObject(programs);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<Program> readPrograms() {
        ArrayList<Program> programs = new ArrayList<Program>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("programs.dat"));

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


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("programManagers.dat"));


            out.writeObject(programManagers);
            out.close();
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
    }

    public ArrayList<ProgramManager> readProgramManagers() {
        ArrayList<ProgramManager> programManagers = new ArrayList<ProgramManager>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("programManagers.dat"));

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
