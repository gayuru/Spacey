package View;

import Model.AbstractCourse;
import Model.Course;
import Model.Program;
import Model.Users.ProgramManager;
import Model.Users.Student;
import Model.Users.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Console {

    private List<Student> students = new ArrayList<>();

    public void run(){

        Scanner scanner = new Scanner(System.in);

        Program computerScience = new Program("BP0964","Bachelors of Computer Science");
        AbstractCourse ITP = new Course("COSC1242","Intro To Programming","S1Y1");

        Student student = new Student("s123","ASDAD",computerScience);
        ProgramManager pm = new ProgramManager("E9123","Bob",computerScience);

        students.add(student);

        //pm.addCourseOffering(ITP);
        //computerScience.printVal();

        System.out.println("Welcome User. Please log in (Enter your staff/student id) :");

        String userType = scanner.nextLine();

        int choice;
        if(userType.contains("e")){
            System.out.println("Welcome Staff");
            //viewMenu("staff");

        }else if(userType.contains("s")){

            Student st = returnStudent(userType);
            System.out.println("Welcome "+ st.getUserName());

            System.out.println("Program "+ st.getProgram().getProgramId()+" "+ st.getProgram().getProgramName()+"\n");

            viewMenu(st);
            System.out.println("Enter an option:");
            choice = Integer.parseInt(scanner.nextLine());
            method2(choice);
        }

    }

    private Student returnStudent(String s){
        Student st= null;

        for(int i=0;i<students.size();++i ){
            if(students.get(i).getUserId().equals(s)){
                st = students.get(i);
            }else{
                System.out.println("User ID : "+ s + " not found");
            }
        }

       return st;
    }

    private  void method2(int choice){
        switch (choice){
            case 1:


        }
    }

    private  void viewMenu(User s){

        if(s instanceof ProgramManager) {
            System.out.println("1) View Program");
            System.out.println("2) Add course offerings");
        }else if(s instanceof Student){
            System.out.println("1) Enrol Course");

        }
    }






}
