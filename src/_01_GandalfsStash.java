import java.util.*;

public class _01_GandalfsStash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moodDegree = Integer.parseInt(scanner.nextLine());
        String[] foods = scanner.nextLine().split("[^a-zA-Z]+");
        for (String food : foods) {
            int foodPoints = getFoodPoints(food);
            moodDegree += foodPoints;
        }
        String mood = getMood(moodDegree);
        System.out.println(moodDegree);
        System.out.println(mood);
    }

    private static String getMood(int moodDegree) {
        String mood;
        if (moodDegree < -5) {
            mood = "Angry";
        }else if (moodDegree >= -5 && moodDegree < 0) {
            mood = "Sad";
        }else if (moodDegree >= 0 && moodDegree <= 15) {
            mood = "Happy";
        } else {
            mood = "Special JavaScript mood";
        }
        return mood;
    }

    private static int getFoodPoints(String food) {
        int points;
        switch (food.toLowerCase()) {
            case "cram": points = 2; break;
            case "lembas": points = 3; break;
            case "apple": points = 1; break;
            case "melon": points = 1; break;
            case "honeycake": points = 5; break;
            case "mushrooms": points = -10; break;
            default: points = -1; break;
        }
        return points;
    }
}
