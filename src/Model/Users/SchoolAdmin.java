package Model.Users;

import Model.AbstractCourse;
import Model.Course;
import Model.Elective;

import java.io.Serializable;

public class SchoolAdmin extends User implements Serializable {

    public SchoolAdmin(String userId, String userName) {
        super(userId, userName);
    }

    public void setCoreCourse(Course course) {

    }

    public void setSchoolElective(Elective elective) {

    }

    public void setPrerequisites(AbstractCourse selectedSub, AbstractCourse prerequisite) {
        selectedSub.getCoursePrerequisites().add(prerequisite);
        selectedSub.printCoursePrerequisites();
    }
}