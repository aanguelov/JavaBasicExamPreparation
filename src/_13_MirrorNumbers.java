import java.util.Scanner;

public class _13_MirrorNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] numbers = scanner.nextLine().split("\\s+");

        boolean hasMirrorNumbers = false;
        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                String s = numbers[j];
                String reversed = new StringBuilder(s).reverse().toString();
                if (number.equals(reversed) && !number.equals(s)) {
                    System.out.println(number + "<!>" + s);
                    hasMirrorNumbers = true;
                }
            }
        }
        if (!hasMirrorNumbers) {
            System.out.println("No");
        }
    }
}
