package LAB2;

import java.util.Arrays;
import java.util.Scanner;

public class Q7_11 {
    static Scanner sc = new Scanner(System.in);

    static int[] createArray() {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    // Q7: Find duplicate values
    static void findDuplicates() {
        int[] arr = createArray();
        boolean found = false;

        System.out.print("Duplicate values are: ");

        for (int i = 0; i < arr.length; i++) {
            boolean duplicate = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }

            boolean printed = false;
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    printed = true;
                    break;
                }
            }

            if (duplicate && !printed) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }

    // Q8: Find kth smallest and largest
    static void findKth() {
        int[] arr = createArray();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k < 1 || k > arr.length) {
            System.out.println("Invalid k value!");
            return;
        }

        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println(k + "th smallest = " + arr[k - 1]);
        System.out.println(k + "th largest = " + arr[arr.length - k]);
    }

    // Q9: Move negatives to left and positives to right
    static void arrangeNumbers() {
        int[] arr = createArray();
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[right] >= 0) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        System.out.println("Rearranged array: "
                + Arrays.toString(arr));
    }

    // Q10: Three chances to answer
    static void quiz() {
        int answer = 19;

        for (int i = 1; i <= 3; i++) {
            System.out.print("What is the magic number? ");
            int guess = sc.nextInt();

            if (guess == answer) {
                System.out.println("Good");
                return;
            }

            if (i < 3) {
                System.out.println("Try again!");
            }
        }

        System.out.println("Correct answer is: " + answer);
    }

    // Q11(a): Floyd's triangle
    static void floydTriangle() {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        int num = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    // Q11(b): 0-1 Floyd's triangle
    static void binaryTriangle() {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i + j) % 2 == 0 ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n----- LAB 2 MENU -----");
            System.out.println("1. Find duplicate values");
            System.out.println("2. Find kth smallest and largest");
            System.out.println("3. Move negative numbers left");
            System.out.println("4. Java quiz");
            System.out.println("5. Floyd's triangle");
            System.out.println("6. 0-1 Floyd's triangle");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    findDuplicates();
                    break;

                case 2:
                    findKth();
                    break;

                case 3:
                    arrangeNumbers();
                    break;

                case 4:
                    quiz();
                    break;

                case 5:
                    floydTriangle();
                    break;

                case 6:
                    binaryTriangle();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
