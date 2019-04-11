package Model;

public class Elective extends AbstractCourse {
    public Elective(String courseId, String courseName, String courseSemester) {
        super(courseId, courseName, courseSemester);
    }

    @Override
    public String getCourseId() {
        return super.getCourseId();
    }

    @Override
    public String getCourseName() {
        return super.getCourseName();
    }

    @Override
    public String getCourseSemester() {
        return super.getCourseSemester();
    }
}
