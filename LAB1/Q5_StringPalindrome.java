import java.util.Scanner;

public class Q5_StringPalindrome {

    private static String reverse(String text) {
        char[] letters = text.toCharArray();
        int n = letters.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = letters[i];
            letters[i] = letters[n - i - 1];
            letters[n - i - 1] = temp;
        }

        return new String(letters);
    }

    private static boolean checkPalindrome(String text) {
        String original = text.replace(" ", "").toLowerCase();
        String reversed = reverse(original);

        return original.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = input.nextLine();

        System.out.println("Is " + word + " palindrome? "
                + (checkPalindrome(word) ? "YES" : "NO"));

        input.close();
    }
}
