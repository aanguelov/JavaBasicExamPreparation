import java.util.Scanner;

public class _25_DozenEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLines = 7;
        String input = scanner.nextLine();

        int eggs = 0;
        int dozens = 0;
        for (int i = 0; i < inputLines; i++) {
            String[] inputArgs = input.split("\\s+");
            int measureCount = Integer.parseInt(inputArgs[0]);
            String measure = inputArgs[1];

            if (measure.equals("eggs")) {
                eggs += measureCount;
            } else {
                dozens += measureCount;
            }

            input = scanner.nextLine();
        }

        int dozensOfEggs =  dozens + eggs/12;
        int singleEggs = eggs % 12;

        System.out.printf("%d dozens + %d eggs", dozensOfEggs, singleEggs);
    }
}
