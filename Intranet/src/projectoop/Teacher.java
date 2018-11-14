package projectoop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.*;

public class Teacher extends Employee {

    private enum Degree implements Serializable {
        BACHELOR, MASTER, PHD
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    private Degree degree;

    public Teacher() { }
    public Teacher(String id, String password, String name, int salary, Degree degree) {
        super(id, password, name, salary);
        this.degree = degree;
    }

    @Override
    public Person create(Person s) {
        return  s;
    }

    @Override
    public void update() {
        super.update();
    }

    private HashMap<Course, Student> students = new HashMap<>();

    public void addStudent(Course c, Student s) {
        students.put(c, s);
    }




    @Override
    public boolean view() {
        System.out.println(toString());
        switch (Util.pickView("action",
                "View courses",
                "View students",
                "Send order",
                "Exit")) {
            case 1:
                break;
            case 2:
                viewStudents();
                break;
            case 3:
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void viewStudents() {
    }




    private void manageCourseFile(Course course) {
        switch (Util.pickView("action",
                "Create",
                "View",
                "Cancel")) {
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    private void viewStudent(Course course) {
        HashSet<Student> s = course.getStudents();
        int num = Util.pickView(s, "student") - 1;
        if (num < 0 || num >= s.size()) {
            System.out.println("Wrong input");
            return;
        }
        Student picked = (Student) Util.getPicked(s, num);
        switch (Util.pickView("action",
                "Put mark",
                "Cancel")) {
            case 1:
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "degree=" + degree +
                ", rate=" +
                "} " + super.toString();
    }
}

