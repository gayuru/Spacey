package Model;

import Model.Users.Student;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private String programId;
    private String programName;
    private Map<String,Course> programCourses;
    private Map<String, Elective> programElectives;
    private Map<String,Student> students;

    public Program(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
        this.programCourses = new HashMap<>();
        this.programElectives = new HashMap<>();
        this.students = new HashMap<>();
        addCoursesToProgram();
    }

    public void addCourse(Course course){
        programCourses.put(course.getCourseId(),course);
    }

    public void addElective(Elective elective){
        programElectives.put(elective.getCourseId(),elective);
    }

    public String getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }

    public Map<String,Course> getProgramCourse(){
        return this.programCourses;
    }

    public Map<String,Elective> getProgramElectives(){
        return this.programElectives;
    }

    public int getNumberOfProgramCourses() {
        return programCourses.size();
    }

    public boolean addStudentToProgram(Student student){
        return this.students.put(student.getUserId(),student)!=null;
    }

    public void addCoursesToProgram(){
        programCourses.put("BP162",new Course("COSC123","Further Programming","S1Y1"));
        programCourses.put("BP0965",new Course("COSC131","Mobile Application Development","S1Y1"));
        programCourses.put("BP112",new Course("COSC451","Cloud Computing","S1Y2"));
        programCourses.put("BP1362",new Course("COSC653","User Centered Design","S1Y2"));
        programCourses.put("BP1462",new Course("COSC145","Rapid Application Development","S1Y1"));
    }

    public Map<String,Student> getStudents(){
        return this.students;
    }

    public void printVal(){
        int num=1;
        for(String programID:programCourses.keySet()){
            String courseCode = programCourses.get(programID).getCourseId();
            String courseName = programCourses.get(programID).getCourseName();

            System.out.println(num+") "+ courseCode +" : "+ courseName);
            num++;
        }
    }

    @Override
    public String toString() {
        return String.format(getProgramId() + " : "+ getProgramName());
    }

}
