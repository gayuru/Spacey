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

/*
    Sogyal -> Program and Semester
 */

public class Console {
    Scanner scanner = new Scanner(System.in);

    Program computerScience = new Program("BP0964","Bachelors of Computer Science");
    AbstractCourse ITP = new Course("COSC1242","Intro To Programming","S1Y1");

    Student student = new Student("s123","ASDAD",computerScience);
    ProgramManager pm = new ProgramManager("E9123","Bob",computerScience);

    private List<Student> students = new ArrayList<>();
    private List<ProgramManager> programManager = new ArrayList<>();

    public void run(){
        students.add(student);
        programManager.add(pm);

        System.out.println("Welcome User. Please log in (Enter your staff/student id) :");

        String userType = scanner.nextLine();

        if(userType.contains("e")){
            System.out.println("Welcome Staff");
            viewMenu(pm);
        }else if(userType.contains("s")) {
            Student st = returnStudent(userType);
            if(st == null) {
                System.exit(0);
            }
            System.out.println("Welcome "+ st.getUserName());
            System.out.println("Program "+ st.getProgram().getProgramId()+" "+ st.getProgram().getProgramName()+"\n");
            viewMenu(st);
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

    private void viewMenu(User s) {
        int choice;
        if (s instanceof ProgramManager) {
            do {
                System.out.println("1) View Program");
                System.out.println("2) Add course offerings");
                System.out.println("Enter an option:");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    if (computerScience.getNumberOfProgramCourses() != 0) {
                        computerScience.printVal();
                    }
                } else if (choice == 2) {
                    if (pm.addCourseOffering(ITP)) {
                        System.out.println(ITP.getCourseName() + " ADDED SUCCESSFULLY");
                    }
                } else {
                    System.exit(0);
                }
                System.out.println();
            } while (choice != 0);
        } else if (s instanceof Student) {
            System.out.println("1) Enrol Course");
            for (Course course : computerScience.getProgramCourse().values()){
                System.out.println(course.toString());
            }
            //View current Courses
        }
    }
    }