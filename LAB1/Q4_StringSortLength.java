import java.util.Scanner;

public class Q4_StringSortLength {

    public record Result(String sorted, int size) {}

    private static void merge(char[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        char[] temp = new char[end + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int x = start; x <= end; x++) {
            arr[x] = temp[x];
        }
    }

    private static void sort(char[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(arr, start, middle);
            sort(arr, middle + 1, end);

            merge(arr, start, middle, end);
        }
    }

    private static Result sortString(String input) {
        char[] letters = input.toCharArray();
        int count = input.length();

        sort(letters, 0, count - 1);

        String ordered = new String(letters);

        return new Result(ordered, count);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        Result output = sortString(text);

        System.out.println("Sorted string: " + output.sorted());
        System.out.println("String length: " + output.size());

        input.close();
    }
}
