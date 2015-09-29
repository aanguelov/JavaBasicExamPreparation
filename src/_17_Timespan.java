import java.util.Scanner;

public class _17_Timespan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] start = scanner.nextLine().split(":");
        String[] end = scanner.nextLine().split(":");

        int seconds = Integer.parseInt(start[2]) - Integer.parseInt(end[2]);
        boolean hasLessMinutes = false;
        if (seconds < 0) {
            seconds += 60;
            hasLessMinutes = true;
        }
        String sec;
        if (seconds > 9) {
            sec = String.valueOf(seconds);
        } else {
            sec = "0" + String.valueOf(seconds);
        }

        boolean hasLesHours = false;
        int minutes = Integer.parseInt(start[1]) - Integer.parseInt(end[1]);
        if (minutes < 0) {
            minutes += 60;
            hasLesHours = true;
        }
        if (hasLessMinutes) {
            minutes--;
        }
        String min;
        if (minutes > 9) {
            min = String.valueOf(minutes);
        } else {
            min = "0" + String.valueOf(minutes);
        }

        int hours = Integer.parseInt(start[0]) - Integer.parseInt(end[0]);
        if (hasLesHours) {
            hours--;
        }

        System.out.println(hours + ":" + min + ":" + sec);
    }
}
