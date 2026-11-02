import java.util.Scanner;

public class SIS {

    private static Scanner keyboard = new Scanner(System.in);

    private static boolean loginProcess() {

        Auth authentication = new Auth();
        int chances = 3;

        while (chances > 0) {

            System.out.print("Enter username: ");
            String userId = keyboard.nextLine();

            System.out.print("Enter password: ");
            String passcode = keyboard.nextLine();

            if (authentication.verifyCredentials(userId, passcode)) {

                System.out.println("\nLogin successful!");
                return true;

            } else {

                chances--;
                System.out.println("Invalid username or password!");

                if (chances > 0) {
                    System.out.println("Attempts remaining: " + chances);
                }
            }
        }

        System.out.println("\nMaximum login attempts reached!");
        return false;
    }

    private static void studentMenu() {

        Student studentData = new Student();
        int selection;

        do {

            System.out.println("\n===== Student Information System =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            selection = keyboard.nextInt();
            keyboard.nextLine();

            switch (selection) {

                case 1:

                    System.out.print("Enter student ID: ");
                    String id = keyboard.nextLine();

                    System.out.print("Enter student name: ");
                    String name = keyboard.nextLine();

                    System.out.print("Enter student location: ");
                    String place = keyboard.nextLine();

                    studentData.addRecord(id, name, place);
                    break;

                case 2:

                    studentData.showNames();

                    System.out.print("Enter the student name to delete: ");
                    String removeName = keyboard.nextLine();

                    studentData.deleteRecord(removeName);
                    break;

                case 3:
                    studentData.displayRecords();
                    break;

                case 4:
                    System.out.println("Exiting Student Information System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (selection != 4);
    }

    public static void main(String[] args) {

        System.out.println("===== Student Information System =====");

        if (loginProcess()) {
            studentMenu();
        } else {
            System.out.println("Access denied!");
        }

        keyboard.close();
    }
}