package projectoop;

public abstract class Employee extends Person implements Comparable<Employee> {
    protected double salary;

    public Employee(String login, String password, String name, double salary) {
        super(login, password, name);
        this.salary = salary;
    }

    public Employee() {}


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(hashCode(), o.hashCode());
    }

    @Override
    public void update() {
        super.update();

        Util.Scanner sc = Util.getReadingScanner();

        System.out.println("Enter desired salary: ");
        setSalary(sc.nextDouble());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString();
    }

    @Override
    public Person create(Person s) {
        Employee result = (Employee) super.create(s);
        Util.Scanner sc = Util.getReadingScanner();

        System.out.println("Enter salary: ");
        result.setSalary(sc.nextDouble());
        return result;
    }
}