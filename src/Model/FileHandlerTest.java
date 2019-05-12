package Model;

import Model.Users.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

    //fixtures
    private static Program computerScience;
    private static Program informationTechnology;
    private static Student student;
    private static ProgramManager computerSciencepm;
    private static ProgramManager informationTechnologypm;
    private static SchoolAdmin schoolAdmin;
    private static CourseCoordinator courseCoordinator;
    private static FileHandler handler;
    private static List<User> users;
    private static List<Program> programs;

    @BeforeClass
    public static void setup(){
     computerScience = new Program("BP0967", "Bachelor of Computer Science", 3);
     informationTechnology = new Program("BP162", "Bachelor of Information Technology", 3);
     student = new Student("s123", "John Appleseed","", computerScience);
     computerSciencepm = new ProgramManager("e123", "Bob", "abc123",computerScience);
     informationTechnologypm = new ProgramManager("e321", "Jack", "abc321",informationTechnology);
     schoolAdmin = new SchoolAdmin("a123", "Sally","sally");
     courseCoordinator = new CourseCoordinator("c123", "Bob","");
     readFile();
     writeToFile();

    }

    private static void readFile(){
        handler = new FileHandler();
        users = handler.readUsers();
        programs = handler.readPrograms();
    }

    private static void writeToFile(){
        programs.add(computerScience);
        programs.add(informationTechnology);
        users.add(student);
        users.add(computerSciencepm);
        users.add(informationTechnologypm);
        users.add(schoolAdmin);
        users.add(courseCoordinator);

        handler.saveUsers(users);
        handler.savePrograms(programs);
    }

    @Test
    public void readProgram() {
        //expected result
        String expectedResult = "BP0967";
        String tempProgramId="";
        // actual result
        for (Program p : programs) {
            if(p.getProgramId().equals(expectedResult)){
                tempProgramId =  p.getProgramId();
            }
        }
        assertEquals(expectedResult,tempProgramId);
    }

    @Test
    public void readProgramManager() {
        //expected result
        String expectedResult = "e123";
        String tempPMid="";
        // actual result
        for (User u : users) {
            if(u.getUserId().equals(expectedResult)){
                tempPMid =  u.getUserId();
            }
        }
        assertEquals(expectedResult,tempPMid);
    }

    @Test
    public void readCourseCoordinator() {
        //expected result
        String expectedResult = "c123";
        String tempCCid="";
        // actual result
        for (User u : users) {
            if(u.getUserId().equals(expectedResult)){
                tempCCid =  u.getUserId();
            }
        }
        assertEquals(expectedResult,tempCCid);
    }

    @Test
    public void readSchoolAdmin() {
        //expected result
        String expectedResult = "a123";
        String tempSA="";
        // actual result
        for (User u : users) {
            if(u.getUserId().equals(expectedResult)){
                tempSA =  u.getUserId();
            }
        }
        assertEquals(expectedResult,tempSA);
    }

    @Test
    public void readStudent() {
        //expected result
        String expectedResult = "s123";
        String tempStudentID="";
        // actual result
        for (User u : users) {
            if(u.getUserId().equals(expectedResult)){
                tempStudentID =  u.getUserId();
            }
        }
        assertEquals(expectedResult,tempStudentID);
    }



}
