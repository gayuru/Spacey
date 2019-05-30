package Tests;

import Model.Course;
import Model.Elective;
import Model.Program;
import Model.Semester;
import Model.Users.ProgramManager;
import Model.Users.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class ProgramTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static Student student;
    private static Semester semester;
    private static ProgramManager johnDoe;



    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelor of Computer Science", 3);
        courseOne = new Course("COSC1242", "Intro To Programming",true);
        electiveOne = new Elective("COSC1111", "Data-Communication and Net-Centric Computing",false);
        student = new Student("s123456", "John Test","", computerScience);
        johnDoe = new ProgramManager("e123456", "John Doe","", computerScience);
        semester = johnDoe.getProgram().getAllSemesters().get(0);
    }


    @Test
    public void getProgramId() {
        //expected result
        String expectedResult = "BP160";
        // actual result
        String actualResult = computerScience.getProgramId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getProgramName() {
        //expected result
        String expectedResult = "Bachelor of Computer Science";
        // actual result
        String actualResult = computerScience.getProgramName();
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void getNumberOfSubjects() {

        johnDoe.addCourseOffering(courseOne, semester);
        //expected result
        int expectedResult = 1;
        // actual result
        int actualResult = computerScience.getNumSubjects();
        assertEquals(expectedResult, actualResult);

    }
}

