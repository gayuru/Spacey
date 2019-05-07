package View;

import Model.AbstractCourse;
import Model.FileHandler;
import Model.Program;
import Model.Semester;
import Model.Users.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Console_New implements Serializable {
    private FileHandler handler;
    private List<User> users = new ArrayList<>();
    private List<AbstractCourse> courses = new ArrayList<>();
    private List<Program> programs = new ArrayList<>();
    private List<Semester> semesters = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public Console_New() {
        this.handler = new FileHandler();
        populate();
        this.users = handler.readUsers();
    }


    public void run() {

        

    }

    private void populate() {
        Program computerScience = new Program("BP0964", "Bachelor of Computer Science", 3);
        Program informationTechnology = new Program("BP162", "Bachelor of Information Technology", 3);
        Student student = new Student("s123", "John Appleseed", computerScience);
        ProgramManager computerSciencepm = new ProgramManager("e123", "Bob", computerScience);
        ProgramManager informationTechnologypm = new ProgramManager("e321", "Jack", informationTechnology);
        SchoolAdmin schoolAdmin = new SchoolAdmin("a123", "Sally");
        CourseCoordinator courseCoordinator = new CourseCoordinator("c123", "Bob");

        users.add(student);
        users.add(computerSciencepm);
        users.add(informationTechnologypm);
        users.add(schoolAdmin);
        users.add(courseCoordinator);
        handler.saveUsers(users);

        Program programOne = new Program("BP0964","Bachelor of Computer Science",3);
        Program programTwo = new Program("BP0922","Bachelor of Information Technology",3);

        programs.add(programOne);
        programs.add(programTwo);
        handler.savePrograms(programs);

    }

}

