package projectoop;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Student extends Person {

    public Student(Person p){
        super(p.login, p.password, p.name);
    }

    public Student (){ super();}

    private double gpa = 0.0;

    private Faculty faculty;



    public Teacher getTeacher(Course c) {
        return c.getTeacher();
    }

    @Override
    public boolean view() {
        System.out.println(toString());
        switch (projectoop.Util.pickView("action",
                "View courses",
                "Register to course",
                "View transcript",
                "Exit")) {
            case 1:
                viewCourses();
                break;
            case 2:
                registerCourse();
                break;
            case 3:
                viewTranscript();
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void viewTranscript() {
    }

    private void registerCourse() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (Double.compare(student.gpa, gpa) != 0) return false;
        return faculty != student.faculty;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }

    private void viewCourses() {

        }




    private void viewTeacher(Course course) {
        Teacher t = getTeacher(course);
        System.out.println(t);
        switch (projectoop.Util.pickView("action",
                "Rate teacher",
                "Cancel")) {
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }



    public Faculty getFaculty() {
        return faculty;
    }



    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}

