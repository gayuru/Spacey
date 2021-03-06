package Tests;

import Model.AbstractCourse;
import Model.Course;
import Model.Program;
import Model.Semester;
import Model.Users.ProgramManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class SemesterTest {
    //fixtures
    private static Program computerScience;
    private static AbstractCourse courseOne;
    private static AbstractCourse courseTwo;
    private static Semester semester;
    private static ProgramManager johnDoe;

    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelors of Computer Science", 3);
        courseOne = new Course("COSC1242", "Intro To Programming",true);
        courseTwo = new Course("COSC1232", "Programming 1",true);
        johnDoe = new ProgramManager("e123456", "John Doe", "",computerScience);

    }

    @Before
    public void init(){
        //resets semester object before each test
        semester = new Semester("s1y1");
    }

    //Test Case : Checks if the system gets the semester year correctly
    @Test
    public void getSemYear() {
        //expected result
        String expectedResult = "1";
        // actual result
        String actualResult = semester.getSemYear();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the semester no correctly
    @Test
    public void getSemNo() {
        //expected result
        String expectedResult = "1";
        // actual result
        String actualResult = semester.getSemNo();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the semester identifier correctly
    @Test
    public void getSemIdentifier() {
        //expected result
        String expectedResult = "s1y1";
        // actual result
        String actualResult = semester.getSemIdentifier();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the subjects in the semester correctly
    @Test
    public void getNumSubjects() {
        //actions
        semester.addSubjectSem(courseOne);
        //expected result
        int expectedResult = 1;
        // actual result
        int actualResult = semester.getNumSubjects();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the subjects in the semester correctly
    @Test
    public void getNumSubjects2() {
        //actions
        semester.addSubjectSem(courseOne);
        semester.addSubjectSem(courseTwo);
        //expected result
        int expectedResult = 2;
        // actual result
        int actualResult = semester.getNumSubjects();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system returns the subject correctly
    @Test
    public void getSubject() {
        //actions
        semester.addSubjectSem(courseOne);
        //expected result
        AbstractCourse expectedResult = courseOne;
        // actual result
        AbstractCourse actualResult = semester.getSubject(1);
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system adds a subject into the semester correctly
    @Test
    public void addSubjectSem() {
        //actions
        semester.addSubjectSem(courseOne);
        //expected result
        String expectedResult = courseOne.getSubjectName();
        // actual result
        String actualResult = semester.getSubject(1).getSubjectName();
        assertEquals(expectedResult, actualResult);
    }
}