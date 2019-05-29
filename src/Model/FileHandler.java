package Model;

import Model.Users.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileHandler implements Serializable {

    public void saveUsers(List<User> users) {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat",false));
            oos.writeObject(users);
            oos.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<User> readUsers()  {
        List<User> users = new ArrayList<>();

       try {
           FileInputStream fis = new FileInputStream("users.dat");
           ObjectInputStream ois = new ObjectInputStream(fis);
           users = (List<User>)ois.readObject();
           ois.close();
       }
       catch (Exception ex){
           System.out.println(ex.getMessage());
       }
        return users;

    }

    public void savePrograms(List<Program> programs) {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("programs.dat",false));
            oos.writeObject(programs);
            oos.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public List<Program> readPrograms() {
        List<Program> programs = new ArrayList<>();

        try {
            ObjectInputStream  in = new ObjectInputStream(new FileInputStream("programs.dat"));
            programs = (List<Program>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return programs;

    }
}
