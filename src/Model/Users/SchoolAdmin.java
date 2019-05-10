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
    private Program program;


    public SchoolAdmin(String userId, String userName){
        super(userId,userName);
        this.programs = new ArrayList<>();
    }

    public void createCustomProgram(String programId,String programName,int years){

        program = new Program(programId,programName,years);
        programs.add(program);

    }


    public void addCourses(String courseId,String courseName,boolean y){

        if(y){
            program.addCourses(new Course(courseId,courseName,true));
        }else {
            program.addCourses(new Elective(courseId,courseName,false));
        }

    }




    public void printCustomProgram(){
        for(Program program  : programs){
            System.out.println(program.toString()+"\n"+program.getCourses().toString());
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
