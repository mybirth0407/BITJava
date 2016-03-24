package studentmanager;

public class Student {
    private String name;
    private int age;
    private int studentId;
    private String major;

    public Student(String name, int age, int studentId, String major) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.major = major;
    }

    public boolean updateInfo(int i, String info) {
        if (i == 1) {
            setName(info);
        }
        else if (i == 2) {
            setAge(Integer.parseInt(info));
        }
        else if (i == 3) {
            setStudentId(Integer.parseInt(info));
        }
        else if (i == 4) {
            setMajor(info);
        }
        else {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
