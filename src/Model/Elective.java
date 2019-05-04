package Model;

import java.io.Serializable;

public class Elective extends AbstractCourse implements Serializable {
    public Elective(String courseId, String courseName, String courseSemester) {
        super(courseId, courseName);
    }

    @Override
    public String getSubjectId() {
        return super.getSubjectId();
    }

    @Override
    public String getSubjectName() {
        return super.getSubjectName();
    }
}
