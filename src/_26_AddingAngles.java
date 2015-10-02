import java.util.Scanner;

public class _26_AddingAngles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputLine = scanner.nextLine().split("\\s+");

        boolean hasCircle = false;
        if (n >= 3) {
            for (int i = 0; i < inputLine.length; i++) {
                for (int j = i + 1; j < inputLine.length; j++) {
                    for (int k = j + 1; k < inputLine.length; k++) {
                        int first = Integer.parseInt(inputLine[i]);
                        int second = Integer.parseInt(inputLine[j]);
                        int third = Integer.parseInt(inputLine[k]);

                        int sum = first + second + third;
                        if (sum % 360 == 0) {
                            System.out.printf("%d + %d + %d = %d degrees", first, second, third, sum);
                            System.out.println();
                            hasCircle = true;
                        }
                    }

                }

            }
        }

        if (!hasCircle) {
            System.out.println("No");
        }
    }
}
