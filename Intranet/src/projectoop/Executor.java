package projectoop;

import java.util.Vector;

public class Executor extends Employee {
    Vector<Order> orders = new Vector<>();

    public Executor() {
        super();
    }
    public void acceptOrder(Order o) {

    }
    public void rejectOrder(Order o) {

    }

    @Override
    public boolean view() {
        int num = Util.pickView("action",
                "View orders",
                "View accepted orders",
                "Show my salary",
                "Exit");
        switch (num) {
            case 1:
                viewOrders();
                break;
            case 2:
                viewAcceptedOrders();
                break;
            case 3:
                System.out.println("Salary = " + getSalary());
                break;
            case 4:
                return false;
            default:
                System.out.println("Wrong input");
                break;
        }
        return true;
    }

    @Override
    public double getSalary() {
        return orders.size() * 1000 + super.getSalary();
    }

    private void viewAcceptedOrders() {
        int num = Util.pickView(orders, "order") - 1;
        if (num < 0 || num >= orders.size()) {
            System.out.println("Wrong input");
            return;
        }
        Order pickedOrder = orders.get(num);
        System.out.println(pickedOrder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Executor executor = (Executor) o;

        return orders != null ? orders.equals(executor.orders) : executor.orders == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }

    private void viewOrders() {

        }
      
}
