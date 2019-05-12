package Model.Users;

import Model.*;

import java.io.Serializable;

public class ProgramManager extends User implements Serializable {
    private Program program;

    public ProgramManager(String userId, String userName, String password,Program program) {
        super(userId, userName, password);
        this.program = program;
    }


    public void addCourseOffering(AbstractCourse course, Semester sem){
        sem.addSubjectSem(course);
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
