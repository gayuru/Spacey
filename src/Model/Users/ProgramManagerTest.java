package Model.Users;
import Model.Course;
import Model.Elective;
import Model.Program;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class ProgramManagerTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static ProgramManager johnDoe;

    @BeforeClass
    public static void setUp() {
        computerScience = new Program("BP160", "Bachelors of Computer Science");
        courseOne = new Course("COSC1242","Intro To Programming","S1Y1");
        electiveOne = new Elective("COSC1111","Data-Communication and Net-Centric Computing","S1Y1");
        johnDoe = new ProgramManager("e123456", "John Doe", computerScience);
    }
    @Test
    public void addCourseOffering() {
        johnDoe.addCourseOffering(courseOne);
    }

    @Test
    public void getUserId() {
        fail("This test is yet to be implemented");
    }

    @Test
    public void getUserName() {
        fail("This test is yet to be implemented");
    }
}