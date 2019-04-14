package Model.Users;

import Model.*;

public class ProgramManager extends User {
    private Program program;

    public ProgramManager(String userId, String userName, Program program) {
        super(userId, userName);
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
