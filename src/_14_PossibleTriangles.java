import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _14_PossibleTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<Double> numbers = new ArrayList<>();
        boolean isPossible = false;
        while (!input.equals("End")) {
            String[] inputArr = input.split("\\s+");
            for (int i = 0; i < inputArr.length; i++) {
                numbers.add(Double.parseDouble(inputArr[i]));
            }

            Collections.sort(numbers);
            if (numbers.get(0) + numbers.get(1) > numbers.get(2)) {
                System.out.printf("%.2f+%.2f>%.2f", numbers.get(0), numbers.get(1), numbers.get(2)).println();
                isPossible = true;
            }

            numbers.clear();
            input = scanner.nextLine();
        }

        if (!isPossible) {
            System.out.println("No");
        }
    }
}
