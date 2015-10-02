import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _28_ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<Integer, Map<String, Double>> months = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputArgs = scanner.nextLine().split("\\s+");
            String date = inputArgs[0];
            int month = getMonth(date);
            String name = inputArgs[1];
            double distance = Double.parseDouble(inputArgs[2]);

            if (!months.containsKey(month)) {
                months.put(month, new TreeMap<>());
                months.get(month).put(name, distance);
            } else {
                Double userDistance = months.get(month).get(name);
                if (userDistance == null) {
                    userDistance = 0d;
                }
                months.get(month).put(name, userDistance + distance);
            }
        }

        for (Map.Entry<Integer, Map<String, Double>> integerMapEntry : months.entrySet()) {
            System.out.print(integerMapEntry.getKey() + ": ");
            Map<String, Double> users = integerMapEntry.getValue();
            ArrayList<String> usersAndDistance = new ArrayList<>();
            for (Map.Entry<String, Double> stringDoubleEntry : users.entrySet()) {
                String distance = getDistance(stringDoubleEntry.getValue());
                usersAndDistance.add(stringDoubleEntry.getKey() + "(" + distance + ")");
            }
            System.out.println(String.join(", ", usersAndDistance));
        }
    }

    private static int getMonth(String date) {
        String[] dateArgs = date.split("/");
        int month = Integer.parseInt(dateArgs[1]);
        return month;
    }

    private static String getDistance(double d) {
        if (d % 1 == 0) {
            int num = (int)d;
            return String.valueOf(num);
        }
        return String.valueOf(d);
    }
}
