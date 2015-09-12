import java.util.Scanner;

public class _07_FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[] rows = new String[numberOfRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = scanner.nextLine();
        }

        int cols = rows[0].length();
        char[][] matrix = new char[numberOfRows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String currentRow = rows[row];
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow.charAt(col);
            }
        }

        boolean hasMoved = true;
        while (hasMoved) {
            boolean innerMove = false;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == '>' && col < cols - 1 && matrix[row][col + 1] == 'o') {
                        matrix[row][col] = 'o';
                        matrix[row][col + 1] = '>';
                        innerMove = true;
                    }else if (matrix[row][col] == '<' && col > 0 && matrix[row][col - 1] == 'o') {
                        matrix[row][col] = 'o';
                        matrix[row][col - 1] = '<';
                        innerMove = true;
                    }else if (matrix[row][col] == 'v' && row < matrix.length - 1 && matrix[row + 1][col] == 'o') {
                        matrix[row][col] = 'o';
                        matrix[row + 1][col] = 'v';
                        innerMove = true;
                    }else if (matrix[row][col] == '^' && row > 0 && matrix[row - 1][col] == 'o') {
                        matrix[row][col] = 'o';
                        matrix[row - 1][col] = '^';
                        innerMove = true;
                    }

                }

            }
            if (!innerMove) {
                hasMoved = false;
            }
        }

        printMatrix(cols, matrix);
    }

    private static void printMatrix(int cols, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
