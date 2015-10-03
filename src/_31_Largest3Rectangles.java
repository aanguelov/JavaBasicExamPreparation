import java.util.Scanner;

public class _31_Largest3Rectangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("[\\s\\[\\]x]+", " ");
        String[] arr = input.trim().split("\\s+");

        int[] arrNums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNums[i] = Integer.parseInt(arr[i]);
        }

        int largestSum = 0;
        for (int i = 0; i < arrNums.length - 5; i += 2) {
            int firstRect = arrNums[i]*arrNums[i + 1];
            int secondRect = arrNums[i + 2]*arrNums[i + 3];
            int thirdRect = arrNums[i + 4]*arrNums[i + 5];

            int currentSum = firstRect + secondRect + thirdRect;
            if (currentSum > largestSum) {
                largestSum = currentSum;
            }
        }
        System.out.println(largestSum);
    }
}
