import java.io.*;

public class Student {

    private File detailsFile = new File("student_details.txt");
    private File replacementFile = new File("temp.txt");

    public void addRecord(String studentId, String studentName, String city) {

    try {

        if (detailsFile.exists() && detailsFile.length() > 0) {

            try (RandomAccessFile file = new RandomAccessFile(detailsFile, "r")) {

                file.seek(file.length() - 1);
                int lastCharacter = file.read();

                if (lastCharacter != '\n') {
                    try (FileWriter writer = new FileWriter(detailsFile, true)) {
                        writer.write(System.lineSeparator());
                    }
                }
            }
        }

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(detailsFile, true))) {

            writer.write(studentId + "," + studentName + "," + city);
            writer.newLine();
        }

        System.out.println("Student record inserted successfully!");

    } catch (IOException exception) {

        System.out.println("Insertion error: " + exception.getMessage());
    }
}

    public void showNames() {

        try (BufferedReader reader = new BufferedReader(new FileReader(detailsFile))) {

            String data;

            System.out.println("\n------ Student Names ------");

            while ((data = reader.readLine()) != null) {
                String[] studentData = data.split(",");
                System.out.println(studentData[1]);
            }

        } catch (IOException exception) {
            System.out.println("Error displaying names: " + exception.getMessage());
        }
    }

    public void deleteRecord(String selectedName) {

        boolean deleted = false;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(detailsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(replacementFile))
        ) {

            String data;

            while ((data = reader.readLine()) != null) {

                String[] studentData = data.split(",");

                if (studentData[1].equalsIgnoreCase(selectedName) && !deleted) {
                    deleted = true;
                } else {
                    writer.write(data);
                    writer.newLine();
                }
            }

        } catch (IOException exception) {
            System.out.println("Deletion error: " + exception.getMessage());
            return;
        }

        if (deleted) {

            if (detailsFile.delete() && replacementFile.renameTo(detailsFile)) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("Unable to update the student file.");
            }

        } else {

            replacementFile.delete();
            System.out.println("Student record not found!");
        }
    }

    public void displayRecords() {

        try (BufferedReader reader = new BufferedReader(new FileReader(detailsFile))) {

            String data;

            System.out.println("\n---------- Student Details ----------");

            while ((data = reader.readLine()) != null) {

                String[] studentData = data.split(",");

                System.out.printf("| %-8s | %-15s | %-15s |%n",
                        studentData[0], studentData[1], studentData[2]);
            }

            System.out.println("--------------------------------------");

        } catch (IOException exception) {
            System.out.println("Error displaying records: " + exception.getMessage());
        }
    }
}