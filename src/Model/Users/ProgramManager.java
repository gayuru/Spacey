package Model.Users;

import Model.*;

import java.io.Serializable;

public class ProgramManager extends User implements Serializable {
    private Program program;

    public ProgramManager(String userId, String userName, String password,Program program) {
        super(userId, userName, password);
        this.program = program;
    }

    //adds a course into a semester
    public void addCourseOffering(AbstractCourse course, Semester sem){
        sem.addSubjectSem(course);
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    @Override
    public String getUserId() {
        return super.getUserId();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public Program getProgram() {return this.program; }
}
