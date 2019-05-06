package Model;

import java.io.Serializable;

public class Course extends AbstractCourse implements Serializable {

    public Course(String courseId, String courseName,boolean boolCoreCourse ) {
        super(courseId, courseName,boolCoreCourse);
    }

    @Override
    public String getSubjectId() {
        return super.getSubjectId();
    }

    @Override
    public String getSubjectName() {
        return super.getSubjectName();
    }

    @Override
    public boolean getBoolCoreCourse() {
        return super.getBoolCoreCourse();
    }

    @Override
    public void setBoolCoreCourse(boolean boolCoreCourse) {
        super.setBoolCoreCourse(boolCoreCourse);
    }
}
