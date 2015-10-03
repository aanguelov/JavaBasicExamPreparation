import java.util.ArrayList;
import java.util.Scanner;

public class _30_PythagoreanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if (n < 3) {
            System.out.println("No");
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

            boolean hasPythNums = false;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    for (int k = 0; k < numbers.size(); k++) {
                        if (numbers.get(i) * numbers.get(i) + numbers.get(j) * numbers.get(j) == numbers.get(k) * numbers.get(k) &&
                                (numbers.get(i) <= numbers.get(j))) {
                            String result = numbers.get(i) + "*" + numbers.get(i) + " + " + numbers.get(j) + "*" + numbers.get(j)
                                    + " = " + numbers.get(k) + "*" + numbers.get(k);
                            System.out.println(result);
                            hasPythNums = true;
                        }

                    }

                }

            }

            if (!hasPythNums) {
                System.out.println("No");
            }
        }
    }
}
