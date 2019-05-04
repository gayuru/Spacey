package Model.Users;

import Model.Course;

import java.io.Serializable;

public class CourseCoordinator extends User implements Serializable {

    public CourseCoordinator(String userId, String userName) {
        super(userId, userName);
    }

    public void waivePrerequisite(Student student, Course coreCourse) {

    }
}
