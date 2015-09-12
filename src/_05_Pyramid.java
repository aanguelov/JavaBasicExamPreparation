import java.util.*;

public class _05_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        List<String> result = new ArrayList<>();
        int number = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().trim().split("\\s+");
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < row.length; j++) {
                temp.add(Integer.parseInt(row[j]));
            }
            Collections.sort(temp);
            boolean hasBiggerNumber = false;
            for (int j = 0; j < temp.size(); j++) {
                int currentNumber = temp.get(j);
                if (currentNumber > number) {
                    result.add(temp.get(j).toString());
                    number = currentNumber;
                    hasBiggerNumber = true;
                    break;
                }
            }
            if (!hasBiggerNumber) {
                number++;
            }
        }
        System.out.println(String.join(", ", result));
    }
}
