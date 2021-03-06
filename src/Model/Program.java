package Model;

import java.io.Serializable;
import java.util.*;

public class Program implements Serializable {
    private String programId;
    private String programName;
    private int programLengthYears;
    private List<Semester> programSem; // allowing program manager to structure the program semesters with different subjects accordingly
    private List<AbstractCourse> courses;

    public Program(String programId, String programName, int programLengthYears) {
        this.programId = programId;
        this.programName = programName;
        this.programLengthYears = programLengthYears;
        programSem = new ArrayList<>();
        courses = new ArrayList<>();
        generateSemesters(programSem);
    }

    //adding courses to a program
    public void addCourses(AbstractCourse course){
        courses.add(course);
    }

    //returns the num of subjects in a program
    public int getNumSubjects() {
        int count = 0;
        for(Semester sem: programSem){
            count += sem.getNumSubjects();
        }
        return count;
    }

    //generating of the semesters according to the program length
    public void generateSemesters(List <Semester> semList) {
        int numSems = programLengthYears * Semester.MAX_NUM_SEM_IN_YEAR;
        int count = 1;
        int semNo = 1;
        int year = 1;
        while(count <= numSems) {
            String semIdentifier = "s" + semNo + "y" + year;
            semList.add(new Semester(semIdentifier));
            if(count % 2 == 0) {
                semNo = 0;
                year++;
            }
            count++;
            semNo++;
        }
    }

    //prints out the program along with the courses in each semester
    public void printProgramSubjects(){
        System.out.println("Program: " + programId + " " + programName);
        for(Semester sem: programSem){
            System.out.println("Semester " + sem.getSemNo() + " Year " + sem.getSemYear());
            sem.printSemesterSubjects();
        }
    }

    //prints the electives in a program
    public void printElectives(){
        System.out.println("Δ Electives for "+programName +" Δ");
        for(AbstractCourse c: this.getCourses()){
            if(!c.getBoolCoreCourse()){
                System.out.println("» "+c.toString());
            }
        }
        System.out.println();
    }

    //prints out the options available for the pre requisites
    public void printProgramPrerequisiteChoices(Semester prerequisiteSem) {
        System.out.println("Prerequisite Options: ");
        for(int i = 0; i < programSem.indexOf(prerequisiteSem); i++) {
            System.out.println("Semester " + programSem.get(i).getSemNo() + " Year " + programSem.get(i).getSemYear());
            programSem.get(i).printSemesterSubjects();
        }
    }

    public List<AbstractCourse> getCourses(){
        return this.courses;
    }
    public String getProgramId() {
        return programId;
    }
    public String getProgramName() {
        return programName;
    }
    public List<Semester> getAllSemesters(){
        return this.programSem;
    }

    @Override
    public String toString() {
        return String.format(getProgramId() + " : "+ getProgramName());
    }
}
