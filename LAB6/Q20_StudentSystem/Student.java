package LAB6.Q20_StudentSystem;

import java.io.*;

public class Student {
    private final File studentFile =
            new File("LAB6/Q20_StudentSystem/student_details.txt");

    public void insertStudentRecord(String regNo, String name, String location) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(studentFile, true))) {
            writer.write(regNo + "," + name + "," + location);
            writer.newLine();
            System.out.println("Student record inserted successfully.");
        } catch (IOException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }

    public void displayAllStudentNames() {
        try (BufferedReader reader = new BufferedReader(new FileReader(studentFile))) {
            String line;
            boolean found = false;

            System.out.println("\nStudent Names:");

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",", -1);

                if (details.length == 3) {
                    System.out.println(details[1]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading records: " + e.getMessage());
        }
    }

    public void deleteStudentRecord(String studentName) {
        File tempFile = new File(
                "LAB6/Q20_StudentSystem/student_details_temp.txt");

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(studentFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",", -1);

                if (details.length == 3 &&
                    details[1].equalsIgnoreCase(studentName) && !found) {
                    found = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error deleting record: " + e.getMessage());
            tempFile.delete();
            return;
        }

        if (found) {
            if (studentFile.delete() && tempFile.renameTo(studentFile)) {
                System.out.println("Student record deleted successfully.");
            } else {
                System.out.println("Could not update the student file.");
            }
        } else {
            tempFile.delete();
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudentRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(studentFile))) {
            String line;
            boolean found = false;

            System.out.println("\nRegistration No. | Name | Location");

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",", -1);

                if (details.length == 3) {
                    System.out.println(
                            details[0] + " | " + details[1] + " | " + details[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading records: " + e.getMessage());
        }
    }
}