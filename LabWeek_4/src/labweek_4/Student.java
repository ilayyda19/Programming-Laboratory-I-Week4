package labweek_4;


public class Student {
    
    String studentId;
    String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "Student Id: " + studentId + " Student Name: " + name;
    }
    
}
