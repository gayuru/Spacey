package Model;

import java.io.Serializable;

public class Course extends AbstractCourse implements Serializable {

    public Course(String courseId, String courseName) {
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
