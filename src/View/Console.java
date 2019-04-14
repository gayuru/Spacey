package View;

import Model.AbstractCourse;
import Model.Course;
import Model.Program;
import Model.Semester;
import Model.Users.ProgramManager;
import Model.Users.Student;
import Model.Users.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Console {
    Scanner scanner = new Scanner(System.in);
    int choice;
    Program computerScience = new Program("BP0964","Bachelors of Computer Science", 3);
    AbstractCourse ITP = new Course("COSC1242","Intro To Programming");

    Semester sem1 = new Semester("s1y1");
    Student student = new Student("s123","John Appleseed",computerScience);
    ProgramManager computerSciencepm = new ProgramManager("E9123","Bob",computerScience);

    private List<Student> students = new ArrayList<>();
    private List<ProgramManager> programManager = new ArrayList<>();

    public void run(){
        students.add(student);
        programManager.add(computerSciencepm);

        System.out.println("Welcome User. Please log in (Enter your staff/student id) :");

        String userType = scanner.nextLine();

        if(userType.contains("e")){
            System.out.println("Welcome Staff");
            viewMenu(computerSciencepm);
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
            programManagerMenu();
        } else if (s instanceof Student) {
            studentMenu();
        }
    }

    private void programManagerMenu() {
        do {
            System.out.println("1) View Program");
            System.out.println("2) Add course offerings to Program");
            System.out.println("3) Return to Main Menu");
            System.out.println("0) Exit");
            System.out.println("Enter an option:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                if (computerSciencepm.getProgram().getNumSubjects() != 0) {
                    computerScience.printProgramSubjects();
                } else {
                    System.out.println("Proceed to option 2, no courses added");
                }
            } else if (choice == 2) {
                int numOfSems = 1;
                for (Semester sem : computerSciencepm.getProgram().getAllSemesters()) {
                    System.out.println(numOfSems + ")" + "Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
                    numOfSems++;
                }
                System.out.println("Enter an option:");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Course ID: ");
                String courseID = scanner.nextLine();
                System.out.println("Enter Course Name: ");
                String courseName = scanner.nextLine();
                if(choice <= numOfSems  && choice > 0) {
                    computerSciencepm.addCourseOffering(new Course(courseID, courseName), computerSciencepm.getProgram().getAllSemesters().get(choice - 1));
                } else {
                    System.out.println("Invalid Option!");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.exit(0);
            }
            System.out.println();
        } while (choice != 0);
        run();
    }

    private void studentMenu() {
        do {
            System.out.println("1) Enrol Course\n" +
                    "2) View Enrolled Courses\n" + "3) Return to Main Menu\n" + "0) Exit\n" +  "Please enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            if(choice == 1) {
                enrolStudent(student);
            } else if(choice == 2) {
                student.printEnrolledSubjects();
            } else if(choice == 3) {
                break;
            } else {
                System.exit(0);
            }
        } while (choice != 0);
        run();
    }

    private void enrolStudent(Student student){

        System.out.println("\n------ Student Enrolment -------" + "\n"+ "Select a semester to enrol\n" );
        int numOfSems = 1;
        for (Semester sem : student.getProgram().getAllSemesters()) {
            System.out.println(numOfSems + ")" + "Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            numOfSems++;
        }
        System.out.println("Please enter your choice:");
        choice = Integer.parseInt(scanner.nextLine());
        if(choice <= numOfSems && choice > 0) {
            if(student.getProgram().getAllSemesters().get(choice - 1).getNumSubjects() == 0) {
                System.out.println("No Classes Added Yet");
            } else {
                System.out.println("\n\n"+"------ Add Classes  -------\n"+ "Select the classes you wish to enrol in\n" );
                student.getProgram().getAllSemesters().get(choice - 1).printSemesterSubjects();
                System.out.println("\nPlease enter your choice to add a Class:");
                int courseChoice= Integer.parseInt(scanner.nextLine());

                student.enrolSubject(student.getProgram().getAllSemesters().get(choice - 1).getSemIdentifier(), student.getProgram().getAllSemesters().get(choice - 1).getSubject(courseChoice));
            }
        } else {
            System.out.println("Invalid Option!");
        }
    }

}