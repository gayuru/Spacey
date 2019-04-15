import Model.*;


import Model.Users.ProgramManager;
import Model.Users.Student;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class StudentEnrolmentSystemTest {
    //fixtures
    private static Program computerScience;
    private static Course courseOne;
    private static Elective electiveOne;
    private static Student student;
    private static Semester semester;

    private static ProgramManager johnDoe;




    @Before
    public void init() {
        computerScience = new Program("BP160", "Bachelor of Computer Science", 3);
        courseOne = new Course("COSC1242", "Intro To Programming");
        student = new Student("s123456", "John Test", computerScience);
        johnDoe = new ProgramManager("e123456", "John Doe", computerScience);
        semester = johnDoe.getProgram().getAllSemesters().get(0);
        johnDoe.addCourseOffering(courseOne, semester);

    }

    @Test
    public void testNotEnrolOutOfSemester() {
        //actions
       student.enrolSubject(student.getProgram().getAllSemesters().get(1).getSemIdentifier(), student.getProgram().getAllSemesters().get(1).getSubject(1));
        //can't automatically check student enrolment yet, will have to manually look at the output of printEnrolledSubjects
        //expected result
        //expect result is no courses show when enrolment is printed

        //actual result
        student.printEnrolledSubjects();
    }
    @Test
    public void testEnrolInCorrectSemester() {
        //actions
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));

        //can't automatically check student enrolment yet, will have to manually look at the output of printEnrolledSubjects
        //expected result
        //expect result is 1 courses show when enrolment is printed

        //actual result
        student.printEnrolledSubjects();
    }




    @Test
    public void testStudentNotEnrolWithoutPrerequisites() {
        fail("The test is yet to be implemented, prerequisites yet to be implemented in program");
    }

    @Test
    public void testStudentExemptions() {
        fail("This test is yet to be implemented, exemptions yet to be implemented in program");
    }
    @Test
    public void testOverlappingCourseOffering() {
        fail("This test is yet to be implemented");
    }
    @Test
    public void programMapNoIdenticalCourses() {
        johnDoe.addCourseOffering(courseOne,semester);
        johnDoe.addCourseOffering(courseOne,semester);

        //again have to manually check output, in this case it allows multiples of the same subject so test fails
        semester.printSemesterSubjects();
        fail("Duplicate Courses in Program Map, code not implemented yet");
    }
    @Test
    public void semesterNoMoreThan48CreditsProgramManagerVersion() {
       johnDoe.addCourseOffering(courseOne,semester);
       johnDoe.addCourseOffering(courseOne,semester);
       johnDoe.addCourseOffering(courseOne,semester);
       johnDoe.addCourseOffering(courseOne,semester);
       johnDoe.addCourseOffering(courseOne,semester);
       johnDoe.addCourseOffering(courseOne,semester);

       //again have to manually check output, in this case it doesn't add any more than 4 (which total 48 credit points)
       semester.printSemesterSubjects();
    }
    @Test
    public void semesterNoMoreThan48CreditsStudentVersion() {
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));
        student.enrolSubject(student.getProgram().getAllSemesters().get(0).getSemIdentifier(), student.getProgram().getAllSemesters().get(0).getSubject(1));


        //again have to manually check output, in this case it doesn't add any more than 4 (which total 48 credit points)
        student.printEnrolledSubjects();
    }
    @Test
    public void testGraduateEarliest() {
     fail("Test not implemented yet, no prerequsites so can't yet implement student graduating earliest");
    }
}

