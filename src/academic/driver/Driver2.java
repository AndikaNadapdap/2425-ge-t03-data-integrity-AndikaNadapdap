package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

/**
 * @author 12S23009_Dina Marlina Siagian
 * @author 12S23028_Daniel Situmorang
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);

        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int courseCount = 0;
        int studentCount = 0;
        int enrollmentCount = 0;

        StringBuilder invalidEntries = new StringBuilder();

        while (true) {
            String line = input.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            switch (data[0]) {
                case "course-add":
                    if (data.length == 5) {
                        String code = data[1];
                        String name = data[2];
                        int credits = Integer.parseInt(data[3]);
                        String grade = data[4];
                        courses[courseCount++] =  new Course(code, name, credits, grade);     
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String code = data[1];
                            String name = data[2];
                            String year = data[3];
                            String major = data[4];
                            students[studentCount++] = new Student(code, name, year, major);
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String coursecode = data[1];
                        String studentnim = data[2];
                        
                        boolean courseExists = false;
                        boolean studentExists = false;
                        
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getCode().equals(coursecode)) {
                                courseExists = true;
                                break;
                            }
                        }
                        
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getCode().equals(studentnim)) {
                                studentExists = true;
                                break;
                            }
                        }
                        
                        if (!courseExists) {
                            invalidEntries.append("invalid course|").append(coursecode).append("\n");
                        } else if (!studentExists) {
                            invalidEntries.append("invalid student|").append(studentnim).append("\n");
                        } else {
                            String courseCode = data[1];
                            String studentId = data[2];
                            String year = data[3];
                            String semester = data[4];
                            String[] defaultNotes = {"None"};
                            enrollments[enrollmentCount++] = new Enrollment(courseCode, studentId, year, semester, defaultNotes);
                           
                        }
                    }
                    break;
                default:
                    System.out.println("Error: Perintah tidak dikenali.");
            }
        }

        input.close();

        System.out.print(invalidEntries.toString());

      
        for (int i = courseCount - 1; i >= 0; i--) {
            System.out.println(courses[i].toString());
        }


        for (int i = 0 ; i < studentCount ; i++) {
            System.out.println(students[i].toString());
        }


        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }
        
    }
}