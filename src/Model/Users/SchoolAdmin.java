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


    public SchoolAdmin(String userId, String userName,String password){
        super(userId,userName,password);
        this.programs = new ArrayList<>();
    }

    public void createCustomProgram(String programId,String programName,int years){

        program = new Program(programId,programName,years);
        programs.add(program);
    }

    public List<Program> getPrograms(){
        return this.programs;
    }


    public void addCourses(Program program, String courseId,String courseName,boolean y){
        this.program = program;
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


    public void populateCourses(Program program){
        //common courses
        program.addCourses(new Course("COSC192","User Centered Design",true));
        program.addCourses(new Course("COSC2473","Intro to Computer Systems",true));
        program.addCourses(new Course("ISYS1057","Database Concepts",true));
        program.addCourses(new Course("ISYS1118","Software Engineering Fundamentals",true));
        program.addCourses(new Course("COSC1147","Professional Computing Practise",true));
        program.addCourses(new Course("COSC2408","Programming Project 1",true));
        program.addCourses(new Course("COSC2536","Security in Computing",true));
        //common electives
        program.addCourses(new Elective("COSC111","Data Communication and Net-Centric",false));
        program.addCourses(new Elective("COSC2406","Web Systems",false));
        program.addCourses(new Elective("COSC1187","Interactive 3D Graphics",false));
        program.addCourses(new Elective("COSC2309","Mobile Computing",false));
        program.addCourses(new Elective("COSC2738","Data Science",false));
        program.addCourses(new Elective("COSC2471","iPhone Software Engineering",false));
        program.addCourses(new Elective("COSC2673","Machine Learning",false));
        program.addCourses(new Elective("COSC1179","Network Programming",false));
        if(program.getProgramId().equals("BP0964")){
            //all core courses in computerScience
            program.addCourses(new Course("COSC1284","Programming Techniques",true));
            program.addCourses(new Course("COSC2627","Discrete Structures in Computing",true));
            program.addCourses(new Course("MATH2350","Intro to Data Analytics",true));
            program.addCourses(new Course("COSC2391","Further Programming",true));
            program.addCourses(new Course("COSC1076","Advanced Programming Techniques",true));
            program.addCourses(new Course("COSC1107","Computing Theory",true));
            program.addCourses(new Course("COSC2299","Software Engineering Process and Tools",true));
            program.addCourses(new Course("COSC1114","Operating Systems",true));
            program.addCourses(new Course("COSC1127","Artificial Intelligence",true));
            program.addCourses(new Course("COSC2626","Cloud Computing",true));
        }else{
            //all core courses in IT
            program.addCourses(new Course("COSC2625","Building IT Systems",true));
            program.addCourses(new Course("COSC1078","Introduction to Information Technology",true));
            program.addCourses(new Course("COSC1519","Introduction to Programming",true));
            program.addCourses(new Course("COSC2413","Web Programming",true));
            program.addCourses(new Course("ISYS1108","Software Engineering Project Management",true));
            program.addCourses(new Course("COSC2409","Programming Project 2",true));
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
