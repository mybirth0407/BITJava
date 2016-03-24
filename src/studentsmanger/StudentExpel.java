package studentmanager;

import java.util.ArrayList;

public class StudentExpel {
    ArrayList<Student> expelStudents;

    public StudentExpel() {
        expelStudents = new ArrayList<Student>();
    }

    public void addExpelStudent(
        String name, int age, int studentId, String major) {
        Student newStudent = new Student(name, age, studentId, major);
        expelStudents.add(newStudent);
    }
}
