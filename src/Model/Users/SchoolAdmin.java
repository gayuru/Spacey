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
        program = new Program("BP094","Bachelor of Compuetr Science",4);

    }

    private void createITProgram(){};

    private void createCustomProgram(){
        System.out.println("Enter program Id: ");
        String programId = scanner.nextLine();
        System.out.println("Enter program name: ");
        String programName = scanner.nextLine();
        System.out.println("Enter number of years: ");
        int years = Integer.parseInt(scanner.nextLine());
        programs.add(new Program(programId,programName,years));

        for (Program program : programs){
            System.out.println(program.toString());
        }
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
