import java.math.BigDecimal;
import java.util.Scanner;

public class _02_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStrings = scanner.nextLine().split("\\s+");
        double totalSum = 0;
        for (int i = 0; i < inputStrings.length; i++) {
            String currentString = inputStrings[i];
            char frontLetter = currentString.charAt(0);
            char rearLetter = currentString.charAt(currentString.length() - 1);
            double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));
            if (Character.isUpperCase(frontLetter)) {
                double divider = frontLetter - 64;
                number /= divider;
            } else {
                double multiplier = frontLetter - 96;
                number *= multiplier;
            }

            if (Character.isUpperCase(rearLetter)) {
                double substractor = rearLetter - 64;
                number -= substractor;
            } else {
                double numberToAdd = rearLetter - 96;
                number += numberToAdd;
            }
            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);
    }
}
