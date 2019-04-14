package Model.Users;

import Model.AbstractCourse;
import Model.Program;
import Model.Semester;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private Program program;
    private List<Semester> studentSem; // student enrolled subjects in each sem

    public Student(String userId, String userName, Program program) {
        super(userId, userName);
        this.program = program;
        studentSem = new ArrayList<>();
        program.generateSemesters(studentSem);
    }

    public void enrolSubject(String semIdentifier, AbstractCourse subject) {
        if(subject != null) {
            for(Semester sem : studentSem) {
                if(sem.getSemIdentifier().equals(semIdentifier)) {
                    sem.addSubjectSem(subject);
                }
            }
        }
    }

    public void printEnrolledSubjects() {
        System.out.println("Student: " + super.getUserId() + " " + super.getUserName() + " " + program.getProgramName());
        for(Semester sem: studentSem){
            System.out.println("Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            sem.printSemesterSubjects();
        }
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
