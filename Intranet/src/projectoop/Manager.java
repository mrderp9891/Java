package projectoop;

import java.util.*;

public class Manager extends Employee {
    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        OfficeRegister, Department
    }

    private Type type;

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return type == manager.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public void update() {
        super.update();
        switch (projectoop.Util.pickView("Manager type",
                "Office Register",
                "Faculty")) {
            case 1:
                setType(Type.OfficeRegister);
                break;
            case 2:
                setType(Type.Department);
                break;
            default:
                break;
        }
    }

    public Manager() {
        super();
    }

    public Manager(String id, String password, String name, int salary, Type type) {
        super(id, password, name, salary);
        this.type = type;
    }


    @Override
    public boolean view() {
        System.out.println(toString());
        switch (projectoop.Util.pickView("action",
                "View registrations",
                "Create report",
                "Manage news",
                "Create course",
                "Send order",
                "Exit")) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                manageNews();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return false;
            default:
                break;
        }
        return true;
    }

    private void manageNews() {
        switch (projectoop.Util.pickView("action",
                "View news",
                "Add news",
                "Cancel")) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                manageNews();
                break;
            default:
                break;
        }
    }


}