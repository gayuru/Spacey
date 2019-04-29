package Model.Users;

import Model.Course;

public class CourseCoordinator extends User{

    public CourseCoordinator(String userId, String userName) {
        super(userId, userName);
    }

    public void waivePrerequisite(Student student, Course coreCourse) {

    }
}
