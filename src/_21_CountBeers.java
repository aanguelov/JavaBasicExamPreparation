import java.util.Scanner;

public class _21_CountBeers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int beerCount = 0;
        int stacksCount = 0;
        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            int count = Integer.parseInt(inputArgs[0]);
            String measure = inputArgs[1];

            if (measure.equals("stacks")) {
                stacksCount += count;
            } else {
                beerCount += count;
            }

            input = scanner.nextLine();
        }

        stacksCount += beerCount/20;
        beerCount = beerCount % 20;

        System.out.printf("%d stacks + %d beers", stacksCount, beerCount);
    }
}
