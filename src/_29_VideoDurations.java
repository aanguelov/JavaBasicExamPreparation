import java.util.Scanner;

public class _29_VideoDurations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int totalHours = 0;
        int totalMins = 0;
        while (!input.equals("End")) {
            String[] inputArgs = input.split(":");
            int hours = Integer.parseInt(inputArgs[0]);
            int minutes = Integer.parseInt(inputArgs[1]);

            totalHours += hours;
            totalMins += minutes;
            input = scanner.nextLine();
        }

        totalHours += totalMins/60;
        totalMins = totalMins % 60;

        String minutes = null;
        if (totalMins < 10) {
            minutes = "0" + totalMins;
        } else {
            minutes = String.valueOf(totalMins);
        }

        System.out.printf("%d:%s", totalHours, minutes);
    }
}
