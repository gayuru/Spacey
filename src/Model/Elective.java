package Model;

public class Elective extends AbstractCourse {
    public Elective(String courseId, String courseName, String courseSemester) {
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
