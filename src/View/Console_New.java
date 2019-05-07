package View;

import Model.*;
import Model.Users.*;
import javafx.concurrent.ScheduledService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Console_New implements Serializable {
    private FileHandler handler;
    private List<User> users;
    private List<AbstractCourse> courses = new ArrayList<>();
    private List<Program> programs;
    private List<Semester> semesters = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int choice;

    public Console_New() {
        this.handler = new FileHandler();
        this.users = handler.readUsers();
        this.programs = handler.readPrograms();
    }


    public void run() {
        populate();
        System.out.println("Welcome User. Please log in (Enter your staff/student id) :");

        String userType = scanner.nextLine();

        if (userType.startsWith("e")) {
            ProgramManager pm = (ProgramManager)returnUser(userType);
            if (pm == null) {
                System.exit(0);
            }
            System.out.println("Welcome " + pm.getUserName());
            System.out.println("Program Manager For " + pm.getProgram().getProgramId() + " " + pm.getProgram().getProgramName() + "\n");
            programManagerMenu(pm);
        } else if (userType.startsWith("s")) {
            Student st = (Student)returnUser(userType);
            if (st == null) {
                System.exit(0);
            }
            System.out.println("Welcome " + st.getUserName());
            System.out.println("Student Of " + st.getProgram().getProgramId() + " " + st.getProgram().getProgramName() + "\n");
            studentMenu(st);
        } else if (userType.startsWith("a")) {
            SchoolAdmin sa = (SchoolAdmin) returnUser(userType);
            if (sa == null) {
                System.exit(0);
            }
            System.out.println("Welcome School Admin " + sa.getUserName());
           schoolAdminMenu(sa);
        } else if (userType.startsWith("c")) {
            CourseCoordinator cc = (CourseCoordinator) returnUser(userType);
            if (cc == null) {
                System.exit(0);
            }
            System.out.println("Welcome Course Coordinator " + cc.getUserName());
           courseCoordinatorMenu();
        }

    }

    private User returnUser(String s) {
        User user = null;
        Boolean userFound = false;

        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i).getUserId().equals(s)) {
                user = users.get(i);
                userFound = true;
            }
        }
        if (userFound == false) {
            System.out.println("User ID : " + s + " not found");
        }
        return user;
    }

    private void populate() {
        Program computerScience = new Program("BP0964", "Bachelor of Computer Science", 3);
        Program informationTechnology = new Program("BP162", "Bachelor of Iss nformation Technology", 3);
        Student student = new Student("s123", "John Appleseed", computerScience);
        ProgramManager computerSciencepm = new ProgramManager("e123", "Bob", computerScience);
        ProgramManager informationTechnologypm = new ProgramManager("e321", "Jack", informationTechnology);
        SchoolAdmin schoolAdmin = new SchoolAdmin("a123", "Sally");
        CourseCoordinator courseCoordinator = new CourseCoordinator("c123", "Bob");

        users.add(student);
        users.add(computerSciencepm);
        users.add(informationTechnologypm);
        users.add(schoolAdmin);
        users.add(courseCoordinator);
        handler.saveUsers(users);

//        Program programOne = new Program("BP0964","Bachelor of Computer Science",3);
//        Program programTwo = new Program("BP0922","Bachelor of Information Technology",3);

        programs.add(computerScience);
        programs.add(informationTechnology);



        handler.savePrograms(programs);

    }

    private void programManagerMenu(ProgramManager pm) {
        do {
            System.out.println("1) View Program");
            System.out.println("2) Add course offerings to Program");
            System.out.println("3) Return to Main Menu");
            System.out.println("0) Exit");
            System.out.println("Enter an option:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                if (pm.getProgram().getNumSubjects() != 0) {
                    pm.getProgram().printProgramSubjects();
                } else {
                    System.out.println("Proceed to option 2, no courses added");
                }
            } else if (choice == 2) {
                int numOfSems = 1;
                for (Semester sem : pm.getProgram().getAllSemesters()) {
                    System.out.println(numOfSems + ")" + "Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
                    numOfSems++;
                }
                System.out.println("Enter an option:");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Course ID: ");
                String courseID = scanner.nextLine();
                System.out.println("Enter Course Name: ");
                String courseName = scanner.nextLine();
                if (choice <= numOfSems && choice > 0) {
                    pm.addCourseOffering(new Course(courseID, courseName,true), pm.getProgram().getAllSemesters().get(choice - 1));
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

    private void studentMenu(Student st) {
        do {
            System.out.println("1) Enrol Course\n" +
                    "2) View Enrolled Courses\n" + "3) Return to Main Menu\n" + "0) Exit\n" + "Please enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                enrolStudent(st);
            } else if (choice == 2) {
                st.printEnrolledSubjects();
            } else if (choice == 3) {
                break;
            } else {
                System.exit(0);
            }
        } while (choice != 0);
        run();
    }

    private void courseCoordinatorMenu() {
        do {
            System.out.println("1) Waive Prerequisite\n" + "2) Return to Main Menu\n" + "0) Exit\n" + "Please enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
            } else if (choice == 2) {
                break;
            } else {
                System.exit(0);
            }
        } while (choice != 0);
        run();
    }

    private void schoolAdminMenu(SchoolAdmin sa) {
        do {
            System.out.println("1) Create Program\n" +"2) View Programs\n" + "3) Set Prerequisites For Subject\n" + "4) Return to Main Menu\n" + "0) Exit\n" + "Please enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    
                    break;
                case 2:
                    for (Program p : programs){
                        System.out.println(p.toString());
                    }

//                    for(User u : users){
//                        System.out.println(u.toString());
//                    }
            }


//            if (choice == 1) {
//
//            } else if (choice == 2) {
//
//
//
//
//
//
//
//                
//            } else if (choice == 3) {
//                System.out.println("Choose a program : ");
//                int numPrograms = 1;
//                for (Program program : programs) {
//                    System.out.println(numPrograms + ") " + program.getProgramName());
//                    numPrograms++;
//                }
//                choice = Integer.parseInt(scanner.nextLine());
//                if (choice <= numPrograms && choice > 0) {
//                    AbstractCourse selectedSub = null;
//                    Semester selectedSem = null;
//                    Program chosenProgram = programs.get(choice - 1);
//                    chosenProgram.printProgramSubjects();
//                    System.out.println("Enter Subject ID To Set Prerequisite For Subject (Sem1Year1 Subjects Are Not Allowed To Have Prerequisites) : ");
//                    String subjectID = scanner.nextLine();
//                    for (Semester sem : chosenProgram.getAllSemesters()) {
//                        if (sem.findSubject(subjectID, false) != null) {
//                            selectedSub = sem.findSubject(subjectID, false);
//                            selectedSem = sem;
//                        }
//                    }
//                    if (selectedSub != null) {
//                        if (selectedSub.getSubjectId().equals("s1y1")) {
//                            System.out.println("Unable to Select Semester 1 Year 1 Subject");
//                        } else {
//                            chosenProgram.printProgramPrerequisiteChoices(selectedSem);
//                            //A course can only have one prerequisite and the prerequisite can be stated as one from a group
//                            System.out.println("Enter Subject ID From Prerequisite Options : ");
//                            String prerequisiteID = scanner.nextLine();
//                            for (int i = 0; i < chosenProgram.getAllSemesters().indexOf(selectedSem); i++) {
//                                if (chosenProgram.getAllSemesters().get(i).findSubject(prerequisiteID, true) != null) {
//                                    AbstractCourse prerequisite = chosenProgram.getAllSemesters().get(i).findSubject(prerequisiteID, true);
//                                   // schoolAdmin.setPrerequisites(selectedSub, prerequisite);
//                                }
//                            }
//                        }
//                    } else {
//                        if (selectedSub == null) {
//                            System.out.println("No Subjects with ID Of " + subjectID);
//                        }
//                    }
//                }
//            } else if (choice == 4) {
//                break;
//            } else {
//                System.exit(0);
//            }
        } while (choice != 0);
    }


    private void enrolStudent(Student student) {

        System.out.println("\n------ Student Enrolment -------" + "\n" + "Select a semester to enrol\n");
        int numOfSems = 1;
        for (Semester sem : student.getProgram().getAllSemesters()) {
            System.out.println(numOfSems + ")" + "Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            numOfSems++;
        }
        System.out.println("Please enter your choice:");
        choice = Integer.parseInt(scanner.nextLine());
        if (choice <= numOfSems && choice > 0) {
            if (student.getProgram().getAllSemesters().get(choice - 1).getNumSubjects() == 0) {
                System.out.println("No Classes Added Yet");
            } else {
                System.out.println("\n\n" + "------ Add Classes  -------\n" + "Select the classes you wish to enrol in\n");
                student.getProgram().getAllSemesters().get(choice - 1).printSemesterSubjects();
                System.out.println("\nPlease enter your choice to add a Class:");
                int courseChoice = Integer.parseInt(scanner.nextLine());

                student.enrolSubject(student.getProgram().getAllSemesters().get(choice - 1).getSemIdentifier(), student.getProgram().getAllSemesters().get(choice - 1).getSubject(courseChoice));
            }
        } else {
            System.out.println("Invalid Option!");
        }
    }

}

