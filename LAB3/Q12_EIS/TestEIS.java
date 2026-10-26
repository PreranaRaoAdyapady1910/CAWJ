package LAB3.Q12_EIS;
import java.util.Scanner;

public class TestEIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EIS eis = new EIS();

        // Adding sample employees
        eis.addEmployee("E201", "Meera", "HR Executive", 32000);
        eis.addEmployee("E202", "Kiran", "Software Tester", 28000);

        int choice;

        do {
            System.out.println("\n--- Employee Information System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Increment Salary");
            System.out.println("4. Display Employee by ID");
            System.out.println("5. Display All Employees");
            System.out.println("6. Delete Employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter designation: ");
                    String designation = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    if (eis.addEmployee(id, name, designation, salary)) {
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Employee ID already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter employee ID to search: ");
                    Employee found = eis.searchByID(sc.nextLine());

                    if (found.getId().equals("-1")) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println(found);
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID: ");
                    Employee updated = eis.salaryIncrement(sc.nextLine());

                    if (updated.getId().equals("-1")) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println("Salary increased by 10%.");
                        System.out.println(updated);
                    }
                    break;

                case 4:
                    System.out.print("Enter employee ID: ");
                    Employee emp = eis.searchByID(sc.nextLine());

                    if (emp.getId().equals("-1")) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println(emp);
                    }
                    break;

                case 5:
                    if (eis.getEmployees().isEmpty()) {
                        System.out.println("No employees available.");
                    } else {
                        for (Employee e : eis.getEmployees()) {
                            System.out.println("\n" + e);
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter employee ID to delete: ");
                    Employee deleted = eis.deleteEmployee(sc.nextLine());

                    if (deleted.getId().equals("-1")) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println("Employee deleted successfully.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting Employee Information System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}

