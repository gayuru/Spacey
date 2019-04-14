package Model;

import Model.Users.Student;

import java.util.*;

public class Semester {
    private List<AbstractCourse> semesterSubjects;
    private String semIdentifier; // Format: s1y1
    public static final int MAX_NUM_COURSES_IN_SEM = 4;
    public static final int MAX_NUM_SEM_IN_YEAR = 2;
    private int numSubjectsAdded = 0;

    public Semester(String semIdentifier) {
        this.semesterSubjects = Arrays.asList(new Course[MAX_NUM_COURSES_IN_SEM]);
        this.semIdentifier = semIdentifier;
    }

    public String getSemYear() {
        return String.valueOf(semIdentifier.charAt(3));
    }

    public String getSemNo() {
        return String.valueOf(semIdentifier.charAt(1));
    }

    public String getSemIdentifier() { return semIdentifier; }

    public int getNumSubjects() {
        return numSubjectsAdded;
    }

    public void printSemesterSubjects() {
        int num = 1;
        for(AbstractCourse subject : semesterSubjects) {
            if(subject != null) {
                String courseID = subject.getCourseId();
                String courseName = subject.getCourseName();
                System.out.println(num + ") " + courseID +" : " + courseName);
                num++;
            }
        }
    }

    public AbstractCourse getSubject(int subjectIndex) {
        if(subjectIndex-1 < numSubjectsAdded && subjectIndex-1 >= 0) {
            return semesterSubjects.get(subjectIndex-1);
        }
        return null;
    }

    public void addSubjectSem(AbstractCourse subject) {
        if(numSubjectsAdded < MAX_NUM_COURSES_IN_SEM) {
            semesterSubjects.set(numSubjectsAdded,subject);
            numSubjectsAdded++;
        }
    }
}