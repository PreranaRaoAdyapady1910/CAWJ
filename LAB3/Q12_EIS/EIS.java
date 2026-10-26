package LAB3.Q12_EIS;
import java.util.ArrayList;
import java.util.List;

public class EIS {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(String id, String name,
                               String designation, double salary) {
        if (!searchByID(id).getId().equals("-1")) {
            return false;
        }

        Employee employee =
                new Employee(id, name, designation, salary);

        employees.add(employee);
        return true;
    }

    public Employee searchByID(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }

        return new Employee("-1", "Not Found", "NA", 0);
    }

    public Employee salaryIncrement(String id) {
        Employee emp = searchByID(id);

        if (!emp.getId().equals("-1")) {
            emp.incrementSalary();
        }

        return emp;
    }

    public Employee deleteEmployee(String id) {
        Employee emp = searchByID(id);

        if (!emp.getId().equals("-1")) {
            employees.remove(emp);
        }

        return emp;
    }
}
