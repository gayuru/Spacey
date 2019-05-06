package Model.Users;

import Model.AbstractCourse;
import Model.Course;
import Model.Elective;
import Model.Program;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolAdmin extends User implements Serializable {
    private List<Program> programs;
    private Program program;
    private Scanner scanner;

    public SchoolAdmin(String userId, String userName){
        super(userId, userName);
        this.programs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void createProgram(String programName){
        switch(programName){
            case "CS":
                createCSProgram();
                break;
            case "IT":
                createITProgram();
                break;
            default:
                createCustomProgram();
                break;
        }
    }

    private void createCSProgram(){
        program = new Program("BP094","Bachelor of Computer Science",3);
        programs.add(program);
        populateCourses(program);

    }

    private void createITProgram(){
        program = new Program("BP162","Bachelor of Information Technology",3);
        programs.add(program);
        populateCourses(program);
    };

    private void createCustomProgram(){
        System.out.println("Enter program Id  : ");
        String programId = scanner.nextLine();
        System.out.println("Enter program name: ");
        String programName = scanner.nextLine();
        System.out.println("Enter number of years: ");
        int years = Integer.parseInt(scanner.nextLine());
        Program program = new Program(programId,programName,years);
        programs.add(program);


        System.out.println("Enter number of courses to add: ");
        int num = Integer.parseInt(scanner.nextLine());
        int i = 1;
        while (i<=num){
            System.out.println("Enter Course Id: ");
            String courseId = scanner.nextLine();
            System.out.println("Enter Course Name: ");
            String courseName = scanner.nextLine();
            System.out.println("Is it a Core Course or Elective: (Y/N)");
            String course = scanner.nextLine().toUpperCase();
            boolean flag = course.equals("Y");
            if(flag){
                program.addCourses(new Course(courseId,courseName,true));
            }else{
                program.addCourses(new Elective(courseId,courseName,false));
            }
            i++;
        }
        printCustomProgram();
    }

    private void printCustomProgram(){
        for(Program program  : programs){
            System.out.println(program.getCourses().toString());
        }
    }


    private void populateCourses(Program program){

        program.addCourses(new Course("COSC192","User Centered Design",true));
        program.addCourses(new Course("COSC132","Further Programming",true));
        program.addCourses(new Course("COSC332","Intro to Systems",true));
        program.addCourses(new Course("COSC254","Advanced Programming Techniques",true));
        program.addCourses(new Course("COSC222","Algorithms Analysis",true));
        program.addCourses(new Course("COSC118","Software Engineering Fundamentals",true));
        program.addCourses(new Course("COSC154","Web Programming",true));

        program.addCourses(new Elective("COSC993","Security Systems",false));
        program.addCourses(new Elective("COSC913","Web Systems",false));
        program.addCourses(new Elective("COSC943","Games and Graphics",false));
        program.addCourses(new Elective("COSC090","Mobile Computing",false));
        program.addCourses(new Elective("COSC004","Data Science",false));
        program.addCourses(new Elective("COSC121","iOS Programming",false));
        program.addCourses(new Elective("COSC987","Games Design",false));
        program.addCourses(new Elective("COSC570","Artificial Intelligence (AI)",false));

    }

  /*

    Program[] p = new Program[];
      void createProgram (String programName){
        switch(pm){
            case "CS":
                void createCSProgram();
                .
                .
                .
                .
                .
         }


         void createCsProgram(){

            p.get(0).add(cs)

            array of courses inside the program

            when we add the course we tell its core  or elective
            cs.addCourses()

         }

         createNewProrgram(){



         }




   */


//    public void setCoreCourse(Course course) {
//        course.setBoolCoreCourse(true);
//    }
//
//    public void setSchoolElective(Elective elective) {
//        elective.setBoolCoreCourse(false);
//    }

    public void setPrerequisites(AbstractCourse selectedSub, AbstractCourse prerequisite) {
        selectedSub.getCoursePrerequisites().add(prerequisite);
        selectedSub.printCoursePrerequisites();
    }
}
