package Model;

import Model.Users.Student;

import java.util.HashMap;
import java.util.*;

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

    public String getStudentSubjects(Student student) {
        if (semSubjects.get(student.getUserId()) == null) {
            return "Student not enrolled in any subject.";
        } else {
            String id=student.getUserId();
            StringBuilder sb = new StringBuilder();
            sb.append("\n"+student.getUserName()+"s Enrolled Courses\n");
            for(String key : semSubjects.keySet()){
                if(key.equals(id)){
                    sb.append(semSubjects.get(key).getCourseId() + " : "+ semSubjects.get(key).getCourseName()+"\n");
                }
            }
            return sb.toString();
        }
    }
}