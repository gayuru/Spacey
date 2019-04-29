package Model;

public class Elective extends AbstractCourse {
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
