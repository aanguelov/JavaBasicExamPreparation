import java.util.ArrayList;
import java.util.Scanner;

public class _18_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divider = Integer.parseInt(scanner.nextLine());
        String number = scanner.nextLine();

        ArrayList<Integer> numbers = new ArrayList<>();
        while (!number.equals("End")) {
            numbers.add(Integer.parseInt(number));
            number = scanner.nextLine();
        }

        int sum = Integer.MIN_VALUE;
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        boolean hasMagicSum = false;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                for (int k = j; k < numbers.size(); k++) {
                    if ((numbers.get(i) + numbers.get(j) + numbers.get(k)) % divider == 0 &&
                            i != j && j != k) {
                        hasMagicSum = true;
                        if ((numbers.get(i) + numbers.get(j) + numbers.get(k)) > sum) {

                            sum = (numbers.get(i) + numbers.get(j) + numbers.get(k));
                            pos1 = i;
                            pos2 = j;
                            pos3 = k;
                        }
                    }

                }

            }

        }
        if (hasMagicSum) {
            System.out.printf("(%d + %d + %d) %% %d = 0", numbers.get(pos1), numbers.get(pos2), numbers.get(pos3), divider);
        } else {
            System.out.println("No");
        }
    }
}
