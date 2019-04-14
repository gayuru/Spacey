package Model.Users;

import Model.Program;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private static Student student;
    private static Program informationTechnology;

    @BeforeClass
    public static void setUp() {
        informationTechnology = new Program("BP162", "Bachelor of IT");
        student = new Student("s3255654", "John Test", informationTechnology);
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
}