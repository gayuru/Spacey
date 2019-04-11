package Model.Users;

public class Student extends User {
    public Student(String userId, String userName) {
        super(userId, userName);
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
