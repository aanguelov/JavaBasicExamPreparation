import java.util.Scanner;

public class _23_LongestOddEvenSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String replace = input.replaceAll("\\s+", "");
        String[] arr = replace.substring(1, replace.length() - 1).split("\\)\\(");

        int sequence = 0;
        int total = 0;
        boolean checkIfOdd = Integer.parseInt(arr[0]) % 2 != 0;
        for (String s : arr) {
            boolean isOdd = Integer.parseInt(s) % 2 != 0;

            if (checkIfOdd == isOdd || Integer.parseInt(s) == 0) {
                sequence++;
            } else {
                checkIfOdd = isOdd;
                sequence = 1;
            }

            checkIfOdd = !checkIfOdd;

            if (sequence > total) {
                total = sequence;
            }
        }
        System.out.println(total);
    }
}
