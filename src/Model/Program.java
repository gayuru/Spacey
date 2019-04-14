package Model;

import Model.Users.Student;
import Model.Users.User;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private String programId;
    private String programName;
    private Map<String,Course> programCourses;
    private Map<String, Elective> programElectives;
    private Map<String,Student> students;

    public Program(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
        this.programCourses = new HashMap<>();
        this.programElectives = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addCourse(Course course){
        programCourses.put(course.getCourseId(),course);
    }

    public void addElective(Elective elective){
        programElectives.put(elective.getCourseId(),elective);
    }

    public String getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }

    public Map<String,Course> getProgramCourse(){
        return this.programCourses;
    }

    public Map<String,Elective> getProgramElectives(){
        return this.programElectives;
    }

    public int getNumberOfProgramCourses() {
        return programCourses.size();
    }

    public boolean addStudentToProgram(Student student){
        return this.students.put(student.getUserId(),student)!=null;
    }


    public Map<String,Student> getStudents(){
        return this.students;
    }


    public void printVal(){
        for(String programID:programCourses.keySet()){
            String courseName = programCourses.get(programID).getCourseName();
            System.out.println("Program name: " + courseName);
        }
    }

    @Override
    public String toString() {
        return String.format("\nProgram Id: %s,\nProgram Name: %s", getProgramId(),getProgramName());
    }

}
