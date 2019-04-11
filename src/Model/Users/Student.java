package Model.Users;

import Model.Program;

public class Student extends User {

    Program program;
    public Student(String userId, String userName, Program program) {
        super(userId, userName);
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

    public Program getProgram() {
        return program;
    }
}
