package Model;

public class Course extends AbstractCourse {
    public Course(String courseId, String courseName) {
        super(courseId, courseName);
    }

    @Override
    public String getCourseId() {
        return super.getCourseId();
    }

    @Override
    public String getCourseName() {
        return super.getCourseName();
    }


}
