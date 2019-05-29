package View;

import Model.*;
import Model.Users.*;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Console_New implements Serializable {

    private FileHandler handler;
    private List<User> users;
    private List<Program> programs;
    private Scanner scanner = new Scanner(System.in);
    private int choice;
    private boolean flag;
    private String programName;
    private String programId;

    public Console_New() {
        startUp();
    }

    private void startUp() {
        this.handler = new FileHandler();
        this.users = handler.readUsers();
        this.programs = handler.readPrograms();

        //populate only if they are null to avoid duplicate issues
        if (this.users.size() == 0 && this.programs.size() == 0) {
            populate();
        }
    }

    public void run() {
        System.out.println("Welcome User. Please log in (Enter your staff/student id) :");

        String userType = scanner.nextLine();
        String password = "";
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        if (userType.startsWith("e")) {
            ProgramManager pm = (ProgramManager) returnUser(userType, password);
            if (pm == null) {
                System.out.println("\nΔ Username / Password Invalid!\nΔ Please Log in again!");
                run();
            }
            System.out.println("Welcome " + pm.getUserName());
            System.out.println("Program Manager For " + pm.getProgram().getProgramId() + " " + pm.getProgram().getProgramName() + "\n");
            programManagerMenu(pm);
        } else if (userType.startsWith("s")) {
            Student st = (Student) returnUser(userType, password);
            if (st == null) {
                System.out.println("\nΔ Username / Password Invalid!\nΔ Please Log in again!");
                run();
            }
            System.out.println("Welcome " + st.getUserName());
            System.out.println("Student Of " + st.getProgram().getProgramId() + " " + st.getProgram().getProgramName() + "\n");
            studentMenu(st);
        } else if (userType.startsWith("a")) {
            SchoolAdmin sa = (SchoolAdmin) returnUser(userType, password);
            if (sa == null) {
                System.out.println("\nΔ Username / Password Invalid!\nΔ Please Log in again!");
                run();
            }
            System.out.println("Welcome School Admin " + sa.getUserName());
            schoolAdminMenu(sa);
        } else if (userType.startsWith("c")) {
            CourseCoordinator cc = (CourseCoordinator) returnUser(userType, password);
            if (cc == null) {
                System.out.println("\nΔ Username / Password Invalid!\nΔ Please Log in again!");
                run();
            }
            System.out.println("Welcome Course Coordinator " + cc.getUserName());
            courseCoordinatorMenu(cc);
        } else {
            System.out.println("\nΔ Username / Password Invalid!\nΔ Please Log in again!");
            run();
        }

    }

    private User returnUser(String s, String password) {
        User user = null;
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i).getUserId().equals(s) && users.get(i).getPassword().equals(password)) {
                user = users.get(i);
            }
        }
        return user;
    }

    private void populate() {
        Program computerScience = new Program("BP0964", "Bachelor of Computer Science", 3);
        Program informationTechnology = new Program("BP162", "Bachelor of Information Technology", 3);

        Student studentOne = new Student("s001", "John Appleseed", "123", computerScience);
        Student studentTwo = new Student("s002", "David Cook", "123", computerScience);
        Student studentThree = new Student("s003", "Sean Stevenson", "123", computerScience);
        Student studentFour = new Student("s004", "George Martin", "123", informationTechnology);
        Student studentFive = new Student("s005", "Lewis Stephan", "123", informationTechnology);

        ProgramManager computerSciencepm = new ProgramManager("e123", "Bob Francis", "123", computerScience);
        ProgramManager informationTechnologypm = new ProgramManager("e321", "Jack Legend", "123", informationTechnology);
        SchoolAdmin schoolAdmin = new SchoolAdmin("a123", "Sally Stevenson", "123");
        CourseCoordinator courseCoordinator = new CourseCoordinator("c123", "Bob Frank", "123");

        programs.add(computerScience);
        programs.add(informationTechnology);

        users.add(studentOne); users.add(studentTwo); users.add(studentThree); users.add(studentFour); users.add(studentFive);
        users.add(computerSciencepm);
        users.add(informationTechnologypm);
        users.add(schoolAdmin);
        users.add(courseCoordinator);

        schoolAdmin.populateCourses(computerScience);
        schoolAdmin.populateCourses(informationTechnology);
        System.out.println("Populating the system");
        handler.saveUsers(users);
        handler.savePrograms(programs);

        /*
         * to be called when creating new project to populate data.*/
    }

    private void programManagerMenu(ProgramManager pm) {
        do {
            handler.readPrograms();
            //update the object of the program manager
            updateObjectState(pm);

            System.out.println("1) View Program");
            System.out.println("2) Add course offerings to Program");
            System.out.println("3) Log Out");
            System.out.println("0) Exit");
            System.out.println("Enter an option:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viewProgramMenu(pm);
                    break;
                case 2:
                    System.out.println("\nCourses for " + pm.getProgram().getProgramName() + " are below;");
                    for (AbstractCourse course : pm.getProgram().getCourses()) {
                        System.out.println(course);
                    }
                    System.out.println();
                    int numOfSems = 1;
                    for (Semester sem : pm.getProgram().getAllSemesters()) {
                        System.out.println(numOfSems + ") " + "Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
                        System.out.println("Δ Subjects which are already in the semester");
                        for(AbstractCourse c : sem.getSemesterSubjects()){
                            if(c != null)
                                System.out.println("» "+c.toString());
                        }
                        if(sem.getNumSubjects() ==  0){
                            System.out.println("• None •");
                        }
                        System.out.println();
                        numOfSems++;
                    }

                    System.out.println("Enter the selected Semester:");
                    choice = Integer.parseInt(scanner.nextLine());

                    //valid
                    if (choice <= numOfSems && choice > 0) {
                        System.out.println("Enter Course ID of the Course to add into the Semester: ");
                        String courseID = scanner.nextLine();
                        //returns null if the course doesnt exist
                        AbstractCourse course = courseExists(courseID, pm.getProgram());
                        if (course != null) {
                            pm.addCourseOffering(course, pm.getProgram().getAllSemesters().get(choice - 1));
                        } else {
                            System.out.println("\nCourse Doesn't exist in the Program!");
                        }
                    } else {
                        System.out.println("Invalid Option!");
                    }
                    break;

                case 3:
                    handler.savePrograms(programs);
                    run();
            }

        } while (choice != 0);
        run();
    }

    private AbstractCourse courseExists(String courseId, Program pr) {
        AbstractCourse cr = null;
        for (AbstractCourse c : pr.getCourses()) {
            if (courseId.equals(c.getSubjectId())) {
                cr = c;
            }
        }
        return cr;
    }

    private void viewProgramMenu(ProgramManager pm) {
        System.out.println(pm.getProgram().toString());

        StringBuilder coreCourses= new StringBuilder();
        StringBuilder electives=  new StringBuilder();
        Program currProgram = pm.getProgram();
        System.out.println("------------------");
        for (Program curr : handler.readPrograms()) {
            if (curr.getProgramId().equals(currProgram.getProgramId())) {
                for (AbstractCourse course : curr.getCourses()) {
                    if(course.getBoolCoreCourse()){
                        coreCourses.append("» "+course.toString()+"\n");
                    }else{
                        electives.append("» "+course.toString()+"\n");
                    }
                }
            }
        }

        System.out.println("\nΔ Core Courses Δ");
        System.out.println(coreCourses.toString());

        System.out.println("\nΔ Electives Δ");
        System.out.println(electives.toString());

    }

    private void updateObjectState(User u) {
        //updates the state of the object to the one in the readFile
        for (Program pr : programs) {
            if (u instanceof ProgramManager) {
                if (pr.getProgramId().equals(((ProgramManager) u).getProgram().getProgramId())) {
                    ((ProgramManager) u).setProgram(pr);
                }
            } else if (u instanceof Student) {
                if (pr.getProgramId().equals(((Student) u).getProgram().getProgramId())) {
                    ((Student) u).setProgram(pr);
                }
            }
        }
    }

    private void studentMenu(Student st) {
        do {
            System.out.println("1) Enrol Course\n" +
                    "2) View Enrolled Courses\n" + "3) Show program map\n" + "4) Log Out\n" + "0) Exit\n" + "Please enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());
            updateObjectState(st);
            for (User u : users) {
                if (st.getUserId().equals(u.getUserId())) {
                    st = (Student) u;
                }
            }
            if (choice == 1) {
                enrolStudent(st);
            } else if (choice == 2) {
                st.printEnrolledSubjects();
            } else if (choice == 3) {
                st.showStudentMap();
            } else if (choice == 4) {
                break;
            } else {
                System.exit(0);
            }
        } while (choice != 0);
        run();
    }

    private void courseCoordinatorMenu(CourseCoordinator courseCoordinator) {
        do {
            System.out.println("1) Waive Prerequisite\n" + "2) Return to Main Menu\n" + "0) Exit\n" + "Please enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            //Check whether student is in the arraylist
            //Check whether student has enrolled in a subject
            //Print all enrolled subjects if Student checks has passed
            //Check whether inputted subject is a valid enrolled subject which the student has done
            //If it is, proceed to delete all the prerequisites of the enrolled subject which the student is doing
            if (choice == 1) {
                Student selectedStudent = getSelectStudent();
                if (selectedStudent != null && selectedStudent.hasEnrolledSubjects()) {
                    AbstractCourse selectedSubject = null;
                    selectedStudent.printEnrolledSubjects();
                    System.out.println("Enter a valid Subject ID: ");
                    String subjectID = scanner.nextLine();
                    //TODO: prepopulate with subjects of dummy data
                    selectedSubject = selectedStudent.findSelectedSubject(subjectID);
                    if (selectedSubject != null) {
                        courseCoordinator.waivePrerequisite(selectedSubject);
                    } else {
                        System.out.println("Invalid Subject ID! Returning To Main Menu");
                        courseCoordinatorMenu(courseCoordinator);
                    }
                } else if (!selectedStudent.hasEnrolledSubjects()) {
                    System.out.println("Student Has Not Enrolled! Returning To Main Menu");
                    courseCoordinatorMenu(courseCoordinator);
                } else {
                    System.out.println("Invalid Student ID! Returning To Main Menu");
                    courseCoordinatorMenu(courseCoordinator);
                }
            } else if (choice == 2) {
                break;
            } else {
                System.exit(0);
            }
        } while (choice != 0);
        run();
    }

    private Student getSelectStudent() {
        Student selectedStudent = null;
        System.out.println("Enter a valid Student ID: ");
        String studentID = scanner.nextLine();
        for (User user : users) {//TODO: check all student IDs in an arraylist of students in order to validate entered studentID
            if (studentID.equals(user.getUserId())) {
                selectedStudent = (Student) user;
            }
        }
        return selectedStudent;
    }


    private void schoolAdminMenu(SchoolAdmin sa) {

        do {
            System.out.println("1) Create Program\n" + "2) View Programs & Add Courses\n" + "3) Set Prerequisites For Subject\n" + "4) Return to Main Menu\n" + "0) Exit\n" + "Please enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter the Program ID:");
                    this.programId = scanner.nextLine();
                    System.out.println("Enter the Program name:");
                    this.programName = scanner.nextLine();
                    System.out.println("Enter the length of the program:");
                    int lengthYears = Integer.parseInt(scanner.nextLine());

                    sa.createCustomProgram(programId, programName, lengthYears);
                    programs.add(new Program(programId, programName, lengthYears));
                    System.out.println(programName + " program successfully created!");

                    System.out.println("\nEnter number of courses to add: ");
                    int num = Integer.parseInt(scanner.nextLine());

                    handler.savePrograms(programs);
                    addCourses(num, sa, programId);

                    break;
                case 2:
                    System.out.println();
                    for (Program p : programs) {
                        System.out.println(p.toString());
                        System.out.println("\n• Current Courses");

                        if (p.getCourses().size() == 0) {
                            System.out.println("- No Courses added yet");
                        }
                        for (AbstractCourse c : p.getCourses()) {
                            System.out.println(c.toString());
                        }
                        System.out.println();
                    }

                    System.out.println("Do you wish you to add Courses into any of the programs? (Y/N)");
                    String inp = scanner.nextLine().toUpperCase();
                    flag = inp.equals("Y");
                    if (flag) {
                        System.out.println("Adding Courses into the Program");
                        System.out.println("-------------------------------");
                        System.out.println("Enter Program ID:");
                        inp = scanner.nextLine();
                        boolean found = false;
                        for (Program program : programs) {
                            if (inp.equals(program.getProgramId())) {
                                found = true;
                                programId = program.getProgramId();
                                programName = program.getProgramName();
                            }
                        }
                        while (!found) {
                            System.out.println("Program not found! Please enter again:");
                        }

                        System.out.println("\nEnter number of courses to add: ");
                        num = Integer.parseInt(scanner.nextLine());

                        addCourses(num, sa, programId);

                        //call the add course method

                    }
                    break;
//                    run();
                case 3:
                    System.out.println("Choose a program : ");
                    int numPrograms = 1;
                    for (Program program : programs) {
                        System.out.println(numPrograms + ") " + program.getProgramName());
                        numPrograms++;
                    }
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice <= numPrograms && choice > 0) {
                        AbstractCourse selectedSub = null;
                        Semester selectedSem = null;
                        Program chosenProgram = programs.get(choice - 1);
                        chosenProgram.printProgramSubjects();
                        System.out.println("Enter Subject ID To Set Prerequisite For Subject (Sem1Year1 Subjects Are Not Allowed To Have Prerequisites) : ");
                        String subjectID = scanner.nextLine();
                        for (Semester sem : chosenProgram.getAllSemesters()) {
                            if (sem.findSubject(subjectID, false) != null) {
                                selectedSub = sem.findSubject(subjectID, false);
                                selectedSem = sem;
                            }
                        }
                        if (selectedSub != null) {
                            if (selectedSub.getSubjectId().equals("s1y1")) {
                                System.out.println("Unable to Select Semester 1 Year 1 Subject");
                            } else {
                                chosenProgram.printProgramPrerequisiteChoices(selectedSem);
                                //A course can only have one prerequisite and the prerequisite can be stated as one from a group
                                System.out.println("Enter Subject ID From Prerequisite Options : ");
                                String prerequisiteID = scanner.nextLine();
                                for (int i = 0; i < chosenProgram.getAllSemesters().indexOf(selectedSem); i++) {
                                    if (chosenProgram.getAllSemesters().get(i).findSubject(prerequisiteID, true) != null) {
                                        AbstractCourse prerequisite = chosenProgram.getAllSemesters().get(i).findSubject(prerequisiteID, true);
                                        sa.setPrerequisites(selectedSub, prerequisite);
                                    }
                                }
                            }
                        } else {
                            if (selectedSub == null) {
                                System.out.println("No Subjects with ID Of " + subjectID);
                            }
                        }
                    }
                    break;
                case 4:
                    run();
                    break;
            }
        } while (choice != 0);
    }


    private void addCourses(int num, SchoolAdmin sa, String programId) {
        Program program = null;
        for (Program program1 : programs) {
            if (program1.getProgramId().equals(programId)) {
                program = program1;
            }
        }

        if (program != null) {
            int j = 1;
            while (j <= num) {
                System.out.println("Enter Course Id: ");
                String courseId = scanner.nextLine();
                System.out.println("Enter Course Name: ");
                String courseName = scanner.nextLine();
                System.out.println("Is it a Core Course or Elective: (Y/N)");
                String course = scanner.nextLine().toUpperCase();
                flag = course.equals("Y");
                if (flag) {
//                    sa.addCourses(program,courseId, courseName, true);
                    System.out.println(courseName + " successfully added into " + programName + " as a Core Course ! \n");
                    program.addCourses(new Course(courseId, courseName, true));
                } else {
                    System.out.println(courseName + " successfully added into " + programName + " as an Elective! \n");
                    program.addCourses(new Elective(courseId, courseName, false));
                }
                j++;
            }

            System.out.println(programName + " program and " + num + " courses are added successfully !");
            Program program2 = null;
            for (Program program1 : programs) {
                if (program1.getProgramId().equals(programId)) {
                    program2 = program1;
                }
            }

            programs.remove(program2);
            programs.add(program);
            handler.savePrograms(programs);
        }
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

                User u2 = null;
                for (User u : users) {
                    if (u.getUserId().equals(student.getUserId())) {
                        u2 = u;
                    }
                }

                users.remove(u2);
                users.add(student);
                handler.saveUsers(users);

            }
        } else {
            System.out.println("Invalid Option!");
        }
    }
}

