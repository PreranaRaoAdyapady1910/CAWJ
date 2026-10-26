import java.util.Scanner;

public class Q6_VowelCount {

    public static int countVowels(String text) {
        int count = 0;
        String word = text.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int result = countVowels(text);

        System.out.println("Number of vowels: " + result);

        sc.close();
    }
}
