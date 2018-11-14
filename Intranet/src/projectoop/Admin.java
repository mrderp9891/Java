package projectoop;

import java.util.Scanner;

public class Admin extends Employee {
    StorageSingletone storage = StorageSingletone.getInstance();
    public void createEntity() {
        int num = projectoop.Util.pickView("entity",
                "Student",
                "Teacher",
                "Admin",
                "Manager",
                "Executor",
                "Cancel");
        if (num > 6) System.out.println("Wrong input");
        if (num >= 6) return;
        Person p = null;
        if (num == 1) p = new Student();
        if (num == 2) p = new Teacher();
        if (num == 3) p = new Admin();
        if (num == 4) p = new Manager();
        if (num == 5) p = new Executor();

    }

    public void removeEntity() {
        projectoop.Util.Scanner sc = projectoop.Util.getReadingScanner();
        System.out.println("Enter login: ");
        String login = sc.next();
    }

    public void updateEntity() throws UserNotFoundException {
        Util.Scanner sc = Util.getReadingScanner();
        System.out.println("Enter login: ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        return storage != null ? storage.equals(admin.storage) : admin.storage == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "salary=" + salary +
                "} " + super.toString();
    }

    @Override
    public boolean view() {

        switch (projectoop.Util.pickView("action",
                "Create",
                "Update",
                "Delete",
                "Exit")) {
            case 1:
                break;
            case 2:
                try {
                    updateEntity();
                } catch (UserNotFoundException e) {
                    // e.printStackTrace();
                    System.out.println("No such user");
                }
                break;
            case 3:
                break;
            case 4:
                return false;
            default:
                System.out.println("Incorrect command!");
                break;
        }
        return true;
    }

}

