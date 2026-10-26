package LAB6.Q20_StudentSystem;

import java.io.*;

public class Auth {
    private final File loginFile = new File("LAB6/Q20_StudentSystem/login.txt");

    public boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(loginFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");

                if (details.length == 2 &&
                    username.equals(details[0]) &&
                    password.equals(details[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading login file: " + e.getMessage());
        }

        return false;
    }
}