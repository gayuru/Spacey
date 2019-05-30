package Model;


import java.io.Serializable;
import java.util.*;

public class Semester implements Serializable {
    private List<AbstractCourse> semesterSubjects;
    private String semIdentifier; // Format: s1y1
    public static final int MAX_NUM_COURSES_IN_SEM = 4;
    public static final int MAX_NUM_SEM_IN_YEAR = 2;
    private int numSubjectsAdded = 0;

    public Semester(String semIdentifier) {
        this.semesterSubjects = Arrays.asList(new AbstractCourse[MAX_NUM_COURSES_IN_SEM]);
        this.semIdentifier = semIdentifier;
    }

    //prints out the subjects in the semester
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

    //returns the course in the specific index of the semester
    public AbstractCourse getSubject(int subjectIndex) {
        if(subjectIndex-1 < numSubjectsAdded && subjectIndex-1 >= 0) {
            return semesterSubjects.get(subjectIndex-1);
        }
        return null;
    }

    //prints out the subjects in the semester without numbering
    public void printSemesterSubjectsPlain() {
        for(AbstractCourse subject : semesterSubjects) {
            if(subject != null) {
                System.out.println("» " + subject.toString());
            }
        }
    }

    //adds a subject into the semester
    public void addSubjectSem(AbstractCourse subject) {
        //checks if there already 4 subjects in the semester
        if(numSubjectsAdded < MAX_NUM_COURSES_IN_SEM) {
            //checks if the subject already exists
            if(!checkSubjectExist(subject)) {
                semesterSubjects.set(numSubjectsAdded,subject);
                numSubjectsAdded++;
                System.out.println();
                System.out.println(subject.getSubjectName()+" added successfully to Semester " + this.getSemNo() + " Year "+this.getSemYear() +"\n");
            }else{
                System.out.println(subject.toString() + " already exists in the semester!\n");
            }
        }else{
            System.out.println("Error : Maximum Amount of Courses Reached in the Semester");
        }
    }

    //checking if subject exists in the semester
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

    //returns the subject from the semester
    public AbstractCourse findSubject(String subjectID, boolean isFindingPrerequisite) {
        for(AbstractCourse sub : semesterSubjects) {
            if(sub != null) {
                if(sub.getSubjectId().toUpperCase().equals(subjectID.toUpperCase())) {
                    if(!isFindingPrerequisite) {
                        if(semIdentifier.equals("s1y1")) {
                            return new Course("s1y1", "s1y1Subject",sub.getBoolCoreCourse());
                        }
                    }
                    return sub;
                }
            }
        }
        return null;
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
}