package Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Program {
    private String programId;
    private String programName;
    private Map<String,Course> programCourses;
    private Map<String, Elective> programElectives;

    public Program(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
        this.programCourses = new HashMap<>();
        this.programElectives = new HashMap<>();
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

    public void printVal(){
        for(String programID:programCourses.keySet()){
            String courseName = programCourses.get(programID).getCourseName();
            System.out.println("Program name: " + courseName);
        }
    }

    @Override
    public String toString() {
        return String.format("Program Id: %s, Program Name: %s", getProgramId(),getProgramName());
    }

}
