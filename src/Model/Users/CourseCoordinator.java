package Model.Users;

import Model.Course;

import java.io.Serializable;

public class CourseCoordinator extends User implements Serializable {

    public CourseCoordinator(String userId, String userName,String password) {
        super(userId,userName,password);
    }

    public void waivePrerequisite(Student student, Course coreCourse) {

    }
}
