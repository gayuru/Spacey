package Model.Users;

import Model.AbstractCourse;
import Model.Program;
import Model.Semester;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable {

    private Program program;
    private List<Semester> studentSem; // student enrolled subjects in each sem

    public Student(String userId,String userName, Program program) {
        super(userId,userName);
        this.program = program;
        studentSem = new ArrayList<>();
        program.generateSemesters(studentSem);
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

    public void printEnrolledSubjects() {
        System.out.println("Student: " + super.getUserId() + " " + super.getUserName() + " " + program.getProgramName());
        for(Semester sem: studentSem){
            System.out.println("Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            sem.printSemesterSubjects();
        }
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
