package Tests;
import Model.*;
import Model.Users.ProgramManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class ProgramManagerTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static Semester semester;
    private static ProgramManager computerSciencepm;
    private static List<AbstractCourse> courses;

    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelors of Computer Science",3);
        courseOne = new Course("COSC1242","Intro To Programming",true);
        electiveOne = new Elective("COSC1111","Data-Communication and Net-Centric Computing",false);
        computerSciencepm = new ProgramManager("e123", "Bob", "abc123",computerScience);
        semester = new Semester("s1y1");
        computerScience.addCourses(courseOne);
        courses = computerScience.getCourses();
    }


    @Test
    public void addCourseOffering() {
        for (AbstractCourse course : courses){
            computerSciencepm.addCourseOffering(course,semester);
        }

        if(computerSciencepm.getProgram().getCourses().size()>1){
            String expected = courseOne.getSubjectName();
            for (AbstractCourse course : computerSciencepm.getProgram().getCourses()){
                String actual = course.getSubjectName();
                assertEquals(expected,actual);
            }
        }else {
            String expectedResult = courseOne.getSubjectName();
            String actualResult = computerSciencepm.getProgram().getCourses().get(0).getSubjectName();
            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void getUserId() {
        //expected result
        String expectedResult = "e123456";
        // actual result
        String actualResult = computerSciencepm.getUserId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserName() {
        //expected result
        String expectedResult = "John Doe";
        // actual result
        String actualResult = computerSciencepm.getUserName();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getProgram() {
        //expected result
        Program expectedResult = computerScience;
        // actual result
        Program actualResult = computerSciencepm.getProgram();
        assertEquals(expectedResult, actualResult);
    }
}