package Model.Users;

import Model.AbstractCourse;
import Model.Course;
import Model.Elective;
import Model.Program;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolAdmin extends User implements Serializable {
    private List<Program> programs;

    public SchoolAdmin(String userId, String userName) {
        super(userId, userName);
        programs = new ArrayList<>();

    }

    private void createProgram(String programName){

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


    public void setCoreCourse(Course course) {
        course.setBoolCoreCourse(true);
    }

    public void setSchoolElective(Elective elective) {
        elective.setBoolCoreCourse(false);
    }

    public void setPrerequisites(AbstractCourse selectedSub, AbstractCourse prerequisite) {
        selectedSub.getCoursePrerequisites().add(prerequisite);
        selectedSub.printCoursePrerequisites();
    }
}
