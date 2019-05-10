package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourse implements Serializable {
    private String subjectId;
    private String subjectName;
    private boolean boolCoreCourse;
    public final int MAX_COURSE_CREDIT_POINTS = 12;
    private List<AbstractCourse> prerequisites = new ArrayList<>();

    public AbstractCourse(String subjectId, String subjectName,boolean boolCoreCourse) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.boolCoreCourse = boolCoreCourse;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean getBoolCoreCourse(){ return boolCoreCourse; }

    public void setBoolCoreCourse(boolean boolCoreCourse) {
        this.boolCoreCourse = boolCoreCourse;
    }

    public List<AbstractCourse> getCoursePrerequisites() {
        return this.prerequisites;
    }

    public void printCoursePrerequisites() {
        for(AbstractCourse subject : prerequisites) {
            System.out.println(subject.getSubjectId() + " " + subject.getSubjectName());
        }
    }

    @Override
    public String toString() {
        return "\n"+subjectId +":"+ subjectName;
    }
}
