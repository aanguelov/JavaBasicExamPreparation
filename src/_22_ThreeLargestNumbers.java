import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _22_ThreeLargestNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        BigDecimal[] nums = new BigDecimal[n];
        for (int i = 0; i < nums.length; i++) {
            String num = input.nextLine();
            nums[i] = new BigDecimal(num);
        }
        Arrays.sort(nums);
        int iterations = n >= 3 ? 3 : n;
        for (int i = nums.length - 1, j = 0; j < iterations; i--, j++) {
            System.out.println(nums[i].toPlainString());
        }
    }

    private static int getIndexOfLargestElement(ArrayList<String> arrayList) {
        int index = 0;
        BigDecimal largest = new BigDecimal(Double.MIN_VALUE);
        for (int i = 0; i < arrayList.size(); i++) {
            BigDecimal currentBD = new BigDecimal(arrayList.get(i));
            if (currentBD.compareTo(largest) > 0) {
                largest = currentBD;
                index = i;
            }
        }
        return index;
    }
}
