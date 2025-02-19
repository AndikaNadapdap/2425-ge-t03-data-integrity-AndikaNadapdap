package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author
 * 12S23013 Andika Immanuel Nadapdap
 * 12S23033 Oloan Nainggolan
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

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
                        String credits = data[3];
                        String grade = data[4];
                        courses.add(new Course(code, name, credits, grade));
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String code = data[1];
                        String name = data[2];
                        String year = data[3];
                        String major = data[4];
                        students.add(new Student(code, name, year, major));
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String coursecode = data[1];
                        String studentnim = data[2];

                        boolean courseExists = false;
                        boolean studentExists = false;

                        for (Course course : courses) {
                            if (course.getCode().equals(coursecode)) {
                                courseExists = true;
                                break;
                            }
                        }

                        for (Student student : students) {
                            if (student.getCode().equals(studentnim)) {
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
                            String Notes = "None";
                            enrollments.add(new Enrollment(courseCode, studentId, year, semester, Notes));
                        }
                    }
                    break;
            }
        }

        input.close();

        System.out.print(invalidEntries.toString());

        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i));
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }
    }
}
