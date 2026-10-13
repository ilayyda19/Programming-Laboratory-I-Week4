package labweek_4;

import java.util.ArrayList;
import java.util.Scanner;

public class LabWeek_4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        
        System.out.println("How many courses do you want to create ?");
        int courseNum = scan.nextInt();
        scan.nextLine(); 

        System.out.println("Please enter courses Name and Capacity respectively:");
        for (int i = 0; i < courseNum; i++) {
            System.out.print((i + 1) + ". Course Name: ");
            String courseName = scan.nextLine();

            System.out.print((i + 1) + ". Course Capacity: ");
            int capa = scan.nextInt();
            scan.nextLine();

            courses.add(new Course(courseName, capa));
        }

        
        boolean running = true;
        while (running) {
            System.out.println("\n========= MENU =========");
            System.out.println("1) Registration");
            System.out.println("2) Available Courses");
            System.out.println("3) All Informations");
            System.out.println("4) Exit");
            System.out.print("Please choose an operation: ");

            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    
                    System.out.println("\n--- Student Registration ---");
                    System.out.print("Student Name: ");
                    String sName = scan.nextLine();

                    System.out.print("Student ID: ");
                    String sId = scan.nextLine();

                    System.out.print("Enrollment course: ");
                    String enCourse = scan.nextLine();

                    
                    Course foundCourse = null;
                    for (Course c : courses) {
                        if (c.courseName.equalsIgnoreCase(enCourse)) {
                            foundCourse = c;
                            break;
                        }
                    }

                  
                    if (foundCourse == null) {
                        System.out.println("No course found with that name.");
                    } else if (foundCourse.enrolledStudents.size() >= foundCourse.capacity) {
                        System.out.println("This course is full. Registration failed.");
                    } else {
                        
                        boolean alreadyRegistered = false;
                        for (Student s : foundCourse.enrolledStudents) {
                            if (s.studentId.equals(sId)) {
                                alreadyRegistered = true;
                                break;
                            }
                        }

                        if (alreadyRegistered) {
                            System.out.println("This student is already registered for this course.");
                        } else {
                            foundCourse.enrolledStudents.add(new Student(sId, sName));
                            System.out.println("Registration successful.");
                        }
                    }
                    break;

                case 2:
                   
                    System.out.println("\n--- Available Courses ---");
                    boolean anyAvailable = false;
                    for (Course c : courses) {
                        if (c.enrolledStudents.size() < c.capacity) {
                            int emptySlots = c.capacity - c.enrolledStudents.size();
                            System.out.println("- " + c.courseName + " (Available Seats: " + emptySlots + ")");
                            anyAvailable = true;
                        }
                    }
                    if (!anyAvailable) {
                        System.out.println("All courses are currently full!");
                    }
                    break;

                case 3:
                   
                    System.out.println("\n--- All Courses & Enrolled Students ---");
                    for (Course c : courses) {
                        System.out.println(c);
                        System.out.println("----------------------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Have a good day!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose 1, 2, 3, or 4.");
            }
        }

        scan.close();
    }
}