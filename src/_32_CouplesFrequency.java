import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _32_CouplesFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        int couples = nums.length - 1;

        Map<String, Double> frequencies = new LinkedHashMap<>();

        for (int i = 0; i < couples; i++) {
            String couple = nums[i] + " " + nums[i + 1];
            if (!frequencies.containsKey(couple)) {
                frequencies.put(couple, 1d);
            } else {
                double frequency = frequencies.get(couple);
                frequencies.put(couple, frequency + 1);
            }
        }

        for (Map.Entry<String, Double> stringIntegerEntry : frequencies.entrySet()) {
            System.out.print(stringIntegerEntry.getKey() + " -> ");
            double d1 = stringIntegerEntry.getValue()*100/couples;
            System.out.printf("%.2f%%",d1).println();
        }
    }
}
