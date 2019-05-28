package Model.Users;

import Model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {

    private Program program;
    private List<Semester> studentSem; // student enrolled subjects in each sem

    public Student(String userId,String userName,String password, Program program) {
        super(userId,userName,password);
        this.program = program;
        studentSem = new ArrayList<>();
        program.generateSemesters(studentSem);
    }

    public void showStudentMap(){
        //testing();
        StringBuilder strCore = new StringBuilder();
        StringBuilder strElective = new StringBuilder();

        System.out.println("\nStudent's enrolled Program : "+ this.program.toString());
        System.out.println("---------------------------");

        for(int i =0;i<studentSem.size();i++){
            System.out.println("Year "+studentSem.get(i).getSemYear() + " Semester " + studentSem.get(i).getSemNo());

            //classifies the core courses and the electives
            for(AbstractCourse crNew: this.getProgram().getAllSemesters().get(i).getSemesterSubjects()){
                if(crNew !=null){
                    if(crNew.getBoolCoreCourse()){
                        strCore.append("» "+crNew.toString());
                    }else{
                        strElective.append("» "+crNew.toString());
                    }
                }

            }
            //prints out the core Courses
            System.out.println("\n• Core Courses;\n"+ strCore.toString());
            if(!strElective.toString().equals("")){
                System.out.println("\n• Electives;" + strElective.toString());
            }

            //reset the stringbuilders
            strCore.setLength(0);
            strElective.setLength(0);

            System.out.println("\n-----------------------\n");
        }

    }

        //delete this after testing
        public void testing(){
            ProgramManager test = new ProgramManager("e949","Testing PM","123",this.program);

            //this.program.addCourses(new Course("COSC192","User Centered Design",true));
            program.getAllSemesters().get(0).addSubjectSem(new Course("COSC192","User Centered Design",true));
            program.getAllSemesters().get(0).addSubjectSem(new Course("COSC132","Further Programming",false));

            test.addCourseOffering(new Course("COSC192","User Centered Design",true),new Semester("s1y1"));
            test.addCourseOffering(new Course("COSC132","Further Programming",true),new Semester("s1y1"));
            test.addCourseOffering(new Course("COSC332","Intro to Systems",true),new Semester("s1y1"));
            test.addCourseOffering(new Course("COSC254","Advanced Programming Techniques",true),new Semester("s1y1"));
            test.addCourseOffering(new Course("COSC222","Algorithms Analysis",true),new Semester("s1y1"));

            test.addCourseOffering(new Course("COSC192","User Centered Design",true),new Semester("s2y1"));
            test.addCourseOffering(new Course("COSC132","Further Programming",true),new Semester("s2y1"));
            test.addCourseOffering(new Course("COSC332","Intro to Systems",true),new Semester("s2y1"));
            test.addCourseOffering(new Course("COSC254","Advanced Programming Techniques",true),new Semester("s2y1"));
            test.addCourseOffering(new Course("COSC222","Algorithms Analysis",true),new Semester("s2y1"));

        }


    public boolean enrolSubject(String semIdentifier, AbstractCourse subject) {
        if(subject != null) {
            for(Semester sem : studentSem) {
                if(sem.getSemIdentifier().equals(semIdentifier)) {
                    if(!checkStudentEnrolledExisting(sem, subject)) {
                        sem.addSubjectSem(subject);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasEnrolledSubjects() {
        boolean isStudentEnrolled = false;
        for(Semester sem : studentSem) {
            if(!sem.getSemesterSubjects().isEmpty()) {
                isStudentEnrolled = true;
            }
        }
        return isStudentEnrolled;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void printEnrolledSubjects() {
        System.out.println("Student: " + super.getUserId() + " " + super.getUserName() + " " + program.getProgramName());
        for(Semester sem: studentSem){
            System.out.println("Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            sem.printSemesterSubjects();
        }
    }

    public AbstractCourse findSelectedSubject(String selectedSubID) {
        AbstractCourse selectedSubject = null;
        for(Semester sem: studentSem) {
            for(AbstractCourse sub : sem.getSemesterSubjects()) {
                if(sub != null) {
                    if(sub.getSubjectId().toUpperCase().equals(selectedSubID)) {
                        selectedSubject = sub;
                    }
                }
            }
        }
        return selectedSubject;
    }

    private boolean checkStudentEnrolledExisting(Semester sem, AbstractCourse subject) {
        for(AbstractCourse sub : sem.getSemesterSubjects()) {
            if(sub != null) {
                if(sub.getSubjectId().toUpperCase().equals(subject.getSubjectId().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getUserId() {
        return super.getUserId();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return String.format("Student ID: %s\nStudent Name: %s\nCurrent Program: %s \n",getUserId(),getUserName(),getProgram().toString());
    }



}
