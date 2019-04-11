import Model.AbstractCourse;
import Model.Course;
import Model.Program;
import Model.Users.ProgramManager;
import Model.Users.Student;
import Model.Users.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        Program computerScience = new Program("BP0964","Bachelors of Computer Science");
        AbstractCourse ITP = new Course("COSC1242","Intro To Programming","S1Y1");

        User student = new Student("S123","ASDAD");
        ProgramManager pm = new ProgramManager("E9123","Bob",computerScience);

        pm.addCourseOffering(ITP);
        computerScience.printVal();
//        System.out.println("Welcome user. Please log in (Enter your staff/student id) :");
//        String user = scanner.nextLine();
//        int choice;
//        if(user.contains("e")){
//            System.out.println("Welcome Staff");
//            method1("staff");
//        }else if(user.contains("s")){
//            System.out.println("Welcome Student");
//            method1("student");
//            System.out.println("Enter an option");
//            choice = Integer.parseInt(scanner.nextLine());
//            method2(choice);
//        }

    }

    private static void method2(int choice){
        switch (choice){
            case 1:

        }
    }




    private static void method1(String s){
        if(s.equals("staff")) {
            System.out.println("1) View Program");
            System.out.println("2) Add course offerings");
        }else {
            System.out.println("1) View Program");
            System.out.println("2) Add Core Course");
            System.out.println("3) Add Elective");
        }
    }
}
