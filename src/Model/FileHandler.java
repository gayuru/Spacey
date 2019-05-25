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
            System.out.println("Users Saved");
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
           ex.printStackTrace();
       }
        return users;

    }

    public void savePrograms(List<Program> programs) {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("programs.dat",false));
            System.out.println("Saving Programs");
            for(Program pr:programs){
                System.out.println(pr.getCourses().toString());
            }
            oos.writeObject(programs);
            oos.close();
            System.out.println("Programs Saved");
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
//        byte[] bytes = new byte[0];
//        try {
//            bytes = Files.readAllBytes(Paths.get("programs.dat"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String s = new String(bytes);
//        System.out.println(s);
        // Check if the name is contained
//        for (Program program : programs) {
//            if (s.contains(program.getProgramId())) {
//                System.out.println("Name already present!");
//            } else {
//                System.out.println("Name not present");
//                try {
//                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("programs.dat"));
//                    out.writeObject(programs);
//                    out.close();
//                } catch (IOException ex) {
//                    System.err.println("File Not Found");
//                }
//            }
//        }

    }

    public List<Program> readPrograms() {
        List<Program> programs = new ArrayList<>();

        try {
            ObjectInputStream  in = new ObjectInputStream(new FileInputStream("programs.dat"));
            programs = (List<Program>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
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
