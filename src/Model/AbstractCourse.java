package Model;

public abstract class AbstractCourse {
    private String courseId;
    private String courseName;
    public final int MAX_COURSE_CREDIT_POINTS = 12;

    public AbstractCourse(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "\nCurrent Enrolled Courses:\n" +courseId+":"+courseName;
    }
}
