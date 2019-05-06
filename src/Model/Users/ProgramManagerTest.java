package Model.Users;
import Model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class ProgramManagerTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static Semester semester;
    private static ProgramManager johnDoe;

    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelors of Computer Science",3);
        courseOne = new Course("COSC1242","Intro To Programming",true);
        electiveOne = new Elective("COSC1111","Data-Communication and Net-Centric Computing","S1Y1",false);
        johnDoe = new ProgramManager("e123456", "John Doe", computerScience);
        semester = new Semester("s1y1");
    }
    @Test
    public void addCourseOffering() {
        johnDoe.addCourseOffering(courseOne,semester);
        String expectedResult = courseOne.getSubjectName();
        String actualResult = semester.getSubject(1).getSubjectName();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getUserId() {
        //expected result
        String expectedResult = "e123456";
        // actual result
        String actualResult = johnDoe.getUserId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserName() {
        //expected result
        String expectedResult = "John Doe";
        // actual result
        String actualResult = johnDoe.getUserName();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getProgram() {
        //expected result
        Program expectedResult = computerScience;
        // actual result
        Program actualResult = johnDoe.getProgram();
        assertEquals(expectedResult, actualResult);
    }
}