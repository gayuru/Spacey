package Model;


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

    public String getSemIdentifier() { return semIdentifier;}

    public List<AbstractCourse> getSemesterSubjects() {
        return semesterSubjects;
    }

    public int getNumSubjects() {
        return numSubjectsAdded;
    }

    public void printSemesterSubjects() {
        int num = 1;
        for(AbstractCourse subject : semesterSubjects) {
            if(subject != null) {
                String courseID = subject.getSubjectId();
                String courseName = subject.getSubjectName();
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
            if(!checkSubjectExist(subject)) {
                semesterSubjects.set(numSubjectsAdded,subject);
                numSubjectsAdded++;
            }
        }
    }

    private boolean checkSubjectExist(AbstractCourse subject) {
        for(AbstractCourse sub : semesterSubjects) {
            if(sub != null) {
                if(sub.getSubjectId().toUpperCase().equals(subject.getSubjectId().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public AbstractCourse findSubject(String subjectID, boolean isFindingPrerequisite) {
        for(AbstractCourse sub : semesterSubjects) {
            if(sub != null) {
                if(sub.getSubjectId().toUpperCase().equals(subjectID.toUpperCase())) {
                    if(!isFindingPrerequisite) {
                        if(semIdentifier.equals("s1y1")) {
                            return new Course("s1y1", "s1y1Subject");
                        }
                    }
                    return sub;
                }
            }
        }
        return null;
    }


}