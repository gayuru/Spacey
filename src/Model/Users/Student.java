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

    //prints out the studentMap
    public void showStudentMap(){
        StringBuilder strCore = new StringBuilder();
        System.out.println("\nStudent's enrolled Program : "+ this.program.toString());
        System.out.println("------");

        for(int i =0;i<studentSem.size();i++){
            int coreCourseCount=0;
            int electiveCount;
            System.out.println("Δ Year "+studentSem.get(i).getSemYear() + " Semester " + studentSem.get(i).getSemNo()+" Δ");
            //classifies the core courses and the electives
            for(AbstractCourse crNew: this.getProgram().getAllSemesters().get(i).getSemesterSubjects()){
                if(crNew !=null){
                    if(crNew.getBoolCoreCourse()){
                        strCore.append("» "+crNew.toString()+"\n");
                        coreCourseCount++;
                    }
                }
            }
            if(strCore.toString().equals(""))
                System.out.println("• No Courses added yet");
            //prints out the Courses
            if(!strCore.toString().equals("")) {
                System.out.println("\n• Core Courses\n" + strCore.toString());
            }
            //checks if the semester can have electives
            if(coreCourseCount != 4){
                electiveCount = 4 - coreCourseCount;
                System.out.println("• "+electiveCount + " Elective/Electives can be chosen •");
            }
            //reset the string builders
            strCore.setLength(0);
            System.out.println("\n•••••••••••\n");
        }
        this.program.printElectives();
    }

    //student enrols in a subject
    public boolean enrolSubject(String semIdentifier, AbstractCourse subject) {
        if(subject != null) {
            for(Semester sem : studentSem) {
                if(sem.getSemIdentifier().equals(semIdentifier)) {
                    //checks if the student has been already enrolled in the subject
                    if(!checkStudentEnrolledExisting(sem, subject)) {
                        //checks if it has a pre requisite
                        if(checkPrerequisite(subject)){
                            sem.addSubjectSem(subject);
                            return true;
                        }else{
                            System.out.println("\n• Student Haven't completed one of "+subject.getSubjectName()+"'s Prerequisite;");
                            System.out.println(subject.getCoursePrerequisites().toString()+"\n");
                        }
                    }
                }
            }
        }
        return false;
    }

    //checks for the prerequisites in the subject
    private boolean checkPrerequisite(AbstractCourse subject){
        if(subject.getCoursePrerequisites().isEmpty()){
            return true;
        }
        for(AbstractCourse c : subject.getCoursePrerequisites()){
            if(checkSubjectEnrolled(c)) return true;
        }
        return false;
    }

    //checks for the enrolled subjects by a student
    private boolean checkSubjectEnrolled(AbstractCourse subject){
        for(Semester s : studentSem){
            for(AbstractCourse c: s.getSemesterSubjects()){
                if(c != null){
                    if(c.getSubjectId().equals(subject.getSubjectId())){
                    return true;
                    }
                }
            }
        }
        return false;
    }

    //checks if the student has enrolled in any subjects
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

    //prints all the enrolled subjects of a student
    public void printEnrolledSubjects() {
        System.out.println("Student: " + super.getUserId() + " " + super.getUserName() + " " + program.getProgramName());
        for(Semester sem: studentSem){
            System.out.println("Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            sem.printSemesterSubjects();
        }
    }

    //returns the course in a semester
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

    //checks if the student has already enrolled in a subject
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
