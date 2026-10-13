package labweek_4;

import java.util.ArrayList;

public class Course {
    
    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        return "Course Name: " + courseName + " Capacity: " + enrolledStudents.size()+ "/" + capacity;
    }
    
    
}
