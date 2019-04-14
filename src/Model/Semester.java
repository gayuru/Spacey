package Model;

import Model.Users.Student;

import java.util.HashMap;
import java.util.Map;

public class Semester {
    private Student student;
    private Map<String, AbstractCourse> semSubjects;
//    private String belongToProgram;
    private String specificYear; // Format: s1y1
    private static final int MAX_SEMESTER_CREDIT_POINTS = 48;

    public Semester(String specificYear) {
        this.semSubjects = new HashMap<>();
//        this.belongToProgram = belongToProgram;
        this.specificYear = specificYear;
    }

    public void addStudentSubjects(Student student,AbstractCourse course){
        semSubjects.put(student.getUserId(),course);
    }

    public String getStudentSubjects(Student student){
        return semSubjects.get(student.getUserId()).toString();
    }


}