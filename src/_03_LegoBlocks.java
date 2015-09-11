import java.util.*;

public class _03_LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[][] firstArray = new String[numberOfRows][];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = scanner.nextLine().trim().split("\\s+");
        }
        String[][] secondArray = new String[numberOfRows][];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = scanner.nextLine().trim().split("\\s+");
            secondArray[i] = reverseArray(secondArray[i]);
        }

        boolean isAPerfectFit = true;
        for (int i = 0; i < numberOfRows - 1; i++) {
            if ((firstArray[i].length + secondArray[i].length) != (firstArray[i + 1].length + secondArray[i + 1].length)) {
                isAPerfectFit = false;
            }
        }

        if (isAPerfectFit) {
            for (int i = 0; i < numberOfRows; i++) {
                List<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(secondArray[i]));
                list.addAll(0, Arrays.asList(firstArray[i]));
                System.out.println(list);
            }
        } else {
            int totalNumberOfCells = 0;
            for (int i = 0; i < numberOfRows; i++) {
                totalNumberOfCells += firstArray[i].length;
                totalNumberOfCells += secondArray[i].length;
            }
            System.out.println("The total number of cells is: " + totalNumberOfCells);
        }
    }

    private static String[] reverseArray(String[] strings) {
        List<String> temp = Arrays.asList(strings);
        Collections.reverse(temp);
        return (String[])temp.toArray();
    }
}
