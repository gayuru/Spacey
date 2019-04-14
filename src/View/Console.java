package View;

import Model.AbstractCourse;
import Model.Course;
import Model.Program;
import Model.Semester;
import Model.Users.ProgramManager;
import Model.Users.Student;
import Model.Users.User;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Console {
    Scanner scanner = new Scanner(System.in);
    int choice;
    Program computerScience = new Program("BP0964","Bachelors of Computer Science");
    AbstractCourse ITP = new Course("COSC1242","Intro To Programming","S1Y1");

    Semester sem1 = new Semester("s1y1");
    Student student = new Student("s123","John Appleseed",computerScience);
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

            System.out.println("1) Enrol Course\n" +
                    "2) View Enrolled Courses\nPlease enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1:
                    enrolStudent(student);
                    break;
                case 2:
                    System.out.println(sem1.getStudentSubjects(student));
                    break;
                 default:
                     System.out.println("Please enter a correct input!");
                     System.exit(0);
            }

        }
    }

    private void enrolStudent(Student student){

        System.out.println("\n------ Student Enrolment -------" + "\n"+ "Select a semester to enrol\n" );
        //adjust later according to his semesters
        System.out.println("1) Semester 2 2019\n\nPlease enter your choice;");

        choice = Integer.parseInt(scanner.nextLine());

        //do a switch case for the semesters after
       if(choice == 1){
          System.out.println("\n\n"+"------ Add Classes  -------\n"+ "Select the classes you wish to enrol in\n" );
          student.getProgram().printVal();
          System.out.println("\nPlease enter the Course Code to add a Class;");

          String courseId = scanner.nextLine();


          enrolSubjects(student,courseId);
      }

    }

    private void enrolSubjects(Student student,String choice){
        AbstractCourse currentCourse=null;

        for(AbstractCourse course : student.getProgram().getProgramCourse().values()){
            if (choice.equals(course.getCourseId())){
                    currentCourse =course;
            }
        }
        //adds the course to the student
        sem1.addStudentSubjects(student,currentCourse);
        System.out.println("\n"+student.getUserName() + " Successfully enrolled in;\n"+currentCourse.getCourseName());
        System.out.println();
        viewMenu(student);
    }


}