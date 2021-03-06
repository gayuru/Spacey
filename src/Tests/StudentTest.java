package Tests;

import Model.Course;
import Model.Program;
import Model.Semester;
import Model.Users.ProgramManager;
import Model.Users.Student;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private static Student student;
    private static Program informationTechnology;
    private static ProgramManager pm;
    private static Semester semOne;

    @BeforeClass
    public static void setUp() {
        informationTechnology = new Program("BP162", "Bachelor of IT",3);
        student = new Student("s3255654", "John Test","", informationTechnology);
        semOne = new Semester("s1y1");
        pm = new ProgramManager("E123","Tim Cook","",informationTechnology);
    }

    //Test Case : Checks if the system gets the user id correctly
    @Test
    public void testGetUserId() {
        //expected result
        String expectedResult = "s3255654";
        // actual result
        String actualResult = student.getUserId();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the username correctly
    @Test
    public void testGetUserName() {
        //expected result
        String expectedResult = "John Test";
        // actual result
        String actualResult = student.getUserName();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if the system gets the program of the student correctly
    @Test
    public void testGetProgram() {
        //expected result
        Program expectedResult = informationTechnology;
        // actual result
        Program actualResult = student.getProgram();
        assertEquals(expectedResult, actualResult);
    }

    //Test Case : Checks if a student can enrol into the same course twice
    @Test
    public void enrolDuplicateCourse(){
        pm.addCourseOffering(new Course("COC123","SADI",true),semOne);
        pm.addCourseOffering(new Course("COC12333","UCD",true),semOne);

        assertTrue(student.enrolSubject(semOne.getSemIdentifier(), semOne.getSubject(1)));
        assertFalse(student.enrolSubject(semOne.getSemIdentifier(), semOne.getSubject(1)));

    }
}