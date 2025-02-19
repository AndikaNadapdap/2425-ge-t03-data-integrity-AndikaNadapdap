package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @author 12S23013 Andika Immanuel Nadapdap
 * @author 12S23033 Oloan Nainggolan
 */
public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length > 0) {
                String command = parts[0];
                switch (command) {
                    case "course-add":
                        if (parts.length == 5) {
                            String code = parts[1];
                            String name = parts[2];
                            String credits = parts[3];
                            String passingGrade = parts[4];
                            courses.add(new Course(code, name, credits, passingGrade));
                        }
                        break;
                    case "student-add":
                        if (parts.length == 5) {
                            String code = parts[1];
                            String name = parts[2];
                            String year = parts[3];
                            String major = parts[4];
                            students.add(new Student(code, name, year, major));
                        }
                        break;
                    case "enrollment-add":
                        if (parts.length == 5) {
                            String courseCode = parts[1];
                            String studentId = parts[2];
                            String year = parts[3];
                            String semester = parts[4];
                            String notes = "None";
                            enrollments.add(new Enrollment(courseCode, studentId, year, semester, notes));
                        }
                        break;
                }
            }
        }
        scanner.close();

        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i));
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}
