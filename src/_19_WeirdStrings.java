import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _19_WeirdStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("[\\s)(\\\\\\/|]+", "");

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        int sum = 0;
        int pos = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            String nextWord = words.get(i + 1);
            if (getWeight(word) + getWeight(nextWord) >= sum) {
                sum = getWeight(word) + getWeight(nextWord);
                pos = i;
            }
        }
        System.out.println(words.get(pos));
        System.out.println(words.get(pos + 1));
    }

    private static int getWeight(String str) {
        int weight = 0;
        String temp = str.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            int charWeight = temp.charAt(i) - 96;
            weight += charWeight;
        }
        return weight;
    }
}
