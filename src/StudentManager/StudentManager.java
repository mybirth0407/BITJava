package StudentManager;

import com.sun.xml.internal.ws.util.Pool;

import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<Student>();
    StudentExpel studentExpel = new StudentExpel();

    public static void main(String args[]) {
        StudentManager studentManager = new StudentManager();

        studentManager.addStudent("가", 22, 2013011424, "수학");
        studentManager.addStudent("나", 22, 2013024, "철학");
        studentManager.addStudent("다", 22, 2013012, "자율");
        studentManager.addStudent("라", 22, 201344, "컴퓨터");

        System.out.println(studentManager.students.get(0).getName());
        System.out.println(studentManager.students.get(0).getMajor());
        System.out.println(studentManager.students.get(3).getName());
        System.out.println(studentManager.students.get(3).getMajor());
        System.out.println(studentManager.students.get(2).getName());
        System.out.println(studentManager.students.get(2).getMajor());
    }

    public boolean addStudent(
        String name, int age, int studentId, String major) {

        if (name == null) {
            return false;
        }
        else if (age < 1) {
            return false;
        }
        else if (studentId < 1) {
            return false;
        }
        else if (major == null) {
            return false;
        }

        Student newStudent = new Student(name, age, studentId, major);
        students.add(newStudent);
        return true;
    }
}
