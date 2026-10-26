package LAB6.Q20_StudentSystem;

import java.util.Scanner;

public class SIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auth auth = new Auth();

        boolean authenticated = false;

        System.out.println("STUDENT INFORMATION SYSTEM");

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (auth.authenticate(username, password)) {
                authenticated = true;
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid username or password.");

                if (attempt < 3) {
                    System.out.println(
                        "Attempts remaining: " + (3 - attempt)
                    );
                }
            }
        }

        if (!authenticated) {
            System.out.println("Three failed attempts. Access denied.");
            scanner.close();
            return;
        }

        Student student = new Student();

        int choice = 0;

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Insert student");
            System.out.println("2. Delete student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    String regNo = scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();

                    student.insertStudentRecord(regNo, name, location);
                    break;

                case 2:
                    student.displayAllStudentNames();

                    System.out.print("Enter student name to delete: ");
                    String deleteName = scanner.nextLine();

                    student.deleteStudentRecord(deleteName);
                    break;

                case 3:
                    student.displayAllStudentRecords();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
