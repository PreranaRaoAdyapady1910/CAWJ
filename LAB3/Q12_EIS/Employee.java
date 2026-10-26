package LAB3.Q12_EIS;

public class Employee {
    private String id;
    private String name;
    private String designation;
    private double salary;

    public Employee(String id, String name,
                    String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void incrementSalary() {
        salary = salary + salary / 10;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id
                + "\nName: " + name
                + "\nDesignation: " + designation
                + "\nSalary: " + salary;
    }
}
