package Model.Users;

import Model.AbstractCourse;
import Model.Course;
import Model.Elective;
import Model.Program;

public class ProgramManager extends User {
    private Program program;

    public ProgramManager(String userId, String userName, Program program) {
        super(userId, userName);
        this.program = program;
    }

    public boolean addCourseOffering(AbstractCourse course){
        if(course instanceof Course) {
            program.addCourse((Course) course);
            return true;
        }else{
            program.addElective((Elective) course);
            return true;
        }
    }

    @Override
    public String getUserId() {
        return super.getUserId();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
