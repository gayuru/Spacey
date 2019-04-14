package Model;

import Model.Users.ProgramManager;
import Model.Users.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static Student student;

    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelor of Computer Science");
        courseOne = new Course("COSC1242", "Intro To Programming", "S1Y1");
        electiveOne = new Elective("COSC1111", "Data-Communication and Net-Centric Computing", "S1Y1");
        student = new Student("s123456","John Test",computerScience);
    }

    @Test
    public void addCourse() {
        //actions
        computerScience.addCourse(courseOne);
        //expectedResult
        String expectedResult = courseOne.getCourseName();
        //actualResult
        String actualResult = computerScience.getProgramCourses().get(courseOne.getCourseId()).getCourseName();
        //assertions
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addElective() {
        //actions
        computerScience.addElective(electiveOne);
        //expectedResult
        String expectedResult = electiveOne.getCourseName();
        //actualResult
        String actualResult = computerScience.getProgramElectives().get(electiveOne.getCourseId()).getCourseName();
        //assertions
        assertEquals(expectedResult, actualResult);
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
    public void getNumberOfProgramCourses() {
        computerScience.addCourse(courseOne);
        //expected result
        int expectedResult = 1;
        // actual result
        int actualResult = computerScience.getNumberOfProgramCourses();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void addStudentToProgram() {
        assertTrue(computerScience.addStudentToProgram(student));
    }


    @Test
    public void getStudents() {
    computerScience.addStudentToProgram(student);
    System.out.println(computerScience.getStudents());
    }

}