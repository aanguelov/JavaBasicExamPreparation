import java.util.*;

public class _12_Weightlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Long>> playerByExercises = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            String playerName = inputLine[0];
            String exercise = inputLine[1];
            long weight = Long.parseLong(inputLine[2]);

            if (!playerByExercises.containsKey(playerName)) {
                playerByExercises.put(playerName, new TreeMap<>());
                playerByExercises.get(playerName).put(exercise, weight);
            } else {
                Long value = playerByExercises.get(playerName).get(exercise);
                if (value == null) {
                    value = 0l;
                }
                playerByExercises.get(playerName).put(exercise, value + weight);
            }
        }

        for (Map.Entry<String, Map<String, Long>> stringMapEntry : playerByExercises.entrySet()) {
            System.out.print(stringMapEntry.getKey() + " : ");
            Map<String, Long> temp = stringMapEntry.getValue();
            List<String> values = new ArrayList<>();
            for (Map.Entry<String, Long> stringIntegerEntry : temp.entrySet()) {
                String tempString = stringIntegerEntry.getKey() + " - " + String.valueOf(stringIntegerEntry.getValue()) + " kg";
                values.add(tempString);
            }
            System.out.println(String.join(", ", values));
        }
    }
}
