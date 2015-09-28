import java.util.Scanner;

public class _09_Enigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String[] lines = new String[number];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = scanner.nextLine();
        }

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int m = line.replaceAll("[\\s\\d]+", "").length()/2;
            for (int j = 0; j < line.length(); j++) {
                char current = line.charAt(j);
                char decrypted;
                if (current != ' ' && !Character.isDigit(current)) {
                    decrypted = (char) (current + m);
                } else {
                    decrypted = current;
                }
                System.out.print(decrypted);
            }
            System.out.println();
        }
    }
}
