package Model;

public abstract class AbstractCourse {
    private String courseId;
    private String courseName;
    public static final int MAX_COURSE_CREDIT_POINTS = 12;
    private String courseSemester;

    public AbstractCourse(String courseId, String courseName, String courseSemester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseSemester = courseSemester;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseSemester() {
        return courseSemester;
    }
}
