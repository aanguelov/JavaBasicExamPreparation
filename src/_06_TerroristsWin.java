import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\|[^|]*\\|)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String match = matcher.group();
            int start = input.indexOf(match);
            int end = start + match.length();
            int bomb = 0;
            for (int i = 1; i < match.length() - 1; i++) {
                bomb += match.charAt(i);
            }
            String b = Integer.toString(bomb);
            char last = b.charAt(b.length() - 1);
            int bombPower = Character.getNumericValue(last);
            if (start >= bombPower) {
                start -= bombPower;
            } else {
                start = 0;
            }
            if (input.length() - end >= bombPower) {
                end += bombPower;
            } else {
                end = input.length();
            }

            String toBeReplaced = input.substring(start, end);
            char[] chars = new char[toBeReplaced.length()];
            Arrays.fill(chars, '.');
            String replace = new String(chars);
            input = input.replace(toBeReplaced, replace);
        }
        System.out.println(input);
    }
}
