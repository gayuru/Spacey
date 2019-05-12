package Model.Users;

import Model.Program;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class UserLoginTest {
    private static Program program;
    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static List<User> users;

    @BeforeClass
    public static void setup(){
        program = new Program("BP162","BIT",3);
        user1 = new Student("s123","Sam","sam123",program);
        user2 = new ProgramManager("p123","Paul","paul123",program);
        user3 = new CourseCoordinator("c123","Cary","c123");
        user4 = new SchoolAdmin("sa123","Bary","b123");
        users = new ArrayList<>();
        addUsers();
    }

    private static void addUsers(){
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    private boolean logInUser(String username,String password){
        for (User user : users){
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void testStudentLogin(){
        boolean actual = logInUser(user1.getUserName(),user1.getPassword());
        assertTrue(actual);
    }

    @Test
    public void testPmLogin(){
        boolean actual = logInUser(user2.getUserName(),user2.getPassword());
        assertTrue(actual);
    }

    @Test
    public void testCCLogin(){
        boolean actual = logInUser(user3.getUserName(),user3.getPassword());
        assertTrue(actual);
    }
    @Test
    public void testSaLogin(){
        boolean actual = logInUser(user4.getUserName(),user4.getPassword());
        assertTrue(actual);
    }

}
