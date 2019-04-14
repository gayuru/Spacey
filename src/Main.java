import Model.Course;
import Model.Program;
import Model.Semester;
import Model.Users.Student;
import View.Console;

public class Main {

    public static void main(String[] args) {
//        Program program = new Program("BP162","Bachelors of IT");
//        Student user = new Student("s3692351","Sogyal",program);
//        Semester semester = new Semester(program.getProgramId());
//        program.addStudentToProgram(user);
////
////        for(Student student : program.getStudents().values()){
////            System.out.println(student.toString());
////        }
//
//        semester.addStudentSubjects(user,new Course("COSC123","SADI","ASD"));
//        System.out.println(semester.getStudentSubjects(user));


        Console console = new Console();
        console.run();

    }

}
