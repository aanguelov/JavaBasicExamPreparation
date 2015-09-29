import java.util.ArrayList;
import java.util.Scanner;

public class _15_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[\\s)(\\\\/]+");

        ArrayList<String> usernames = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            if (s.length() > 3 && s.length() < 25) {
                if (!Character.isDigit(s.charAt(0))) {
                    usernames.add(s);
                }
            }
        }

        int sum = 0;
        int pos = 0;
        for (int i = 0; i < usernames.size() - 1; i++) {
            String first = usernames.get(i);
            String second = usernames.get(i + 1);
            if (first.length() + second.length() > sum) {
                sum = first.length() + second.length();
                pos = i;
            }
        }
        System.out.println(usernames.get(pos));
        System.out.println(usernames.get(pos + 1));
    }
}
