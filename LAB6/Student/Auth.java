import java.io.*;

public class Auth {

    private File accountFile = new File("login.txt");

    public boolean verifyCredentials(String enteredName, String enteredPassword) {

        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {

            String accountLine;

            while ((accountLine = reader.readLine()) != null) {

                String[] savedData = accountLine.split(",");

                if (enteredName.equals(savedData[0]) &&
                    enteredPassword.equals(savedData[1])) {

                    return true;
                }
            }

        } catch (IOException exception) {
            System.out.println("Error accessing login file: " + exception.getMessage());
        }

        return false;
    }
}