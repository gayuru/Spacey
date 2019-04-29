package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourse {
    private String subjectId;
    private String subjectName;
    public final int MAX_COURSE_CREDIT_POINTS = 12;
    private List<AbstractCourse> prerequisites = new ArrayList<>();

    public AbstractCourse(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
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
        return "\nCurrent Enrolled Courses:\n" + subjectId +":"+ subjectName;
    }
}
