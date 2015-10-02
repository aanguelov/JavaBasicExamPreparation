import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _27_Biggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("[\\s()]+", " ");
        String[] inputArr = input.trim().split("\\s+");

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (!inputArr[i].equals("")) {
                numbers.add(Integer.parseInt(inputArr[i]));
            }
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);

        ArrayList<Integer> primes = gerPrimes(numbers);
        if (primes.size() < 3) {
            System.out.println("No");
        } else {
            for (int i = 0; i < primes.size() - 1; i++) {
                if (primes.get(i) == primes.get(i + 1)) {
                    primes.remove(i + 1);
                    i--;
                }
            }
            if (primes.size() < 3) {
                System.out.println("No");
            } else {
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    sum += primes.get(i);
                }
                System.out.println(sum);
            } 
        } 
    }

    private static ArrayList<Integer> gerPrimes(ArrayList<Integer> array) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (isPrime(array.get(i))) {
                primes.add(array.get(i));
            }

        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if ((num != 2) && (num < 2 ||num % 2 == 0)) {
            return false;
        }
        for (int i = 3; i*i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
