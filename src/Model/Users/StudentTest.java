package Model.Users;

import Model.Course;
import Model.Program;
import Model.Semester;
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
        student = new Student("s3255654", "John Test", informationTechnology);
semOne = new Semester("s1y1");

        pm = new ProgramManager("E123","Tim Cook",informationTechnology);

    }

    @Test
    public void testGetUserId() {
        //expected result
        String expectedResult = "s3255654";
        // actual result
        String actualResult = student.getUserId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetUserName() {
        //expected result
        String expectedResult = "John Test";
        // actual result
        String actualResult = student.getUserName();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetProgram() {

        //expected result
        Program expectedResult = informationTechnology;
        // actual result
        Program actualResult = student.getProgram();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void enrolDuplicateCourse(){

        pm.addCourseOffering(new Course("COC123","SADI"),semOne);
        pm.addCourseOffering(new Course("COC12333","UCD"),semOne);

        assertTrue(student.enrolSubject(semOne.getSemIdentifier(), semOne.getSubject(1)));
        assertFalse(student.enrolSubject(semOne.getSemIdentifier(), semOne.getSubject(1)));


    }
}