package Model;

import java.util.HashMap;
import java.util.Map;

public class Semester {
    private static final int MAX_SEMESTER_CREDIT_POINTS = 48;
    private Map<String, Course> semSubjects;
    private String belongToProgram;
    private String specificYear; // Format: s1y1

    public Semester(String belongToProgram, String specificYear) {
        this.semSubjects = new HashMap<>();
        this.belongToProgram = belongToProgram;
        this.specificYear = specificYear;
    }


}