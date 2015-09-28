import java.util.Scanner;

public class _11_LabyrinthDash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] labyrinth = new char[rows][];

        for (int i = 0; i < labyrinth.length; i++) {
            labyrinth[i] = scanner.nextLine().toCharArray();
        }

        String moves = scanner.nextLine();

        int initialRow = 0;
        int initialCol = 0;
        int initialLives = 3;
        int totalMoves = 0;
        for (int i = 0; i < moves.length(); i++) {
            char currentMove = moves.charAt(i);
            char currentPos = labyrinth[initialRow][initialCol];

            if (currentMove == '>') {
                if (initialCol < labyrinth[initialRow].length - 1) {
                    if (labyrinth[initialRow][initialCol + 1] == '|' || labyrinth[initialRow][initialCol + 1] == '_') {
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[initialRow][initialCol + 1] == '@' ||
                            labyrinth[initialRow][initialCol + 1] == '*' || labyrinth[initialRow][initialCol + 1] == '#') {
                        initialCol++;
                        initialLives--;
                        totalMoves++;
                        System.out.printf("Ouch! That hurt! Lives left: %d", initialLives).println();
                        if (initialLives == 0) {
                            System.out.println("No lives left! Game Over!");
                            //System.out.printf("Total moves made: %d", totalMoves);
                            break;
                        }
                    } else if (labyrinth[initialRow][initialCol + 1] == '$') {
                        labyrinth[initialRow][initialCol + 1] = '.';
                        initialCol++;
                        initialLives++;
                        totalMoves++;
                        System.out.printf("Awesome! Lives left: %d", initialLives).println();

                    } else if (labyrinth[initialRow][initialCol + 1] == ' ') {
                        totalMoves++;
                        System.out.println("Fell off a cliff! Game Over!");
                        //System.out.printf("Total moves made: %d", totalMoves);
                        break;
                    } else if (labyrinth[initialRow][initialCol + 1] == '.') {
                        initialCol++;
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                } else {
                    totalMoves++;
                    System.out.println("Fell off a cliff! Game Over!");
                    //System.out.printf("Total moves made: %d", totalMoves);
                    break;
                }
            }else if (currentMove == 'v') {
                if (initialRow < labyrinth.length - 1) {
                    if (labyrinth[initialRow + 1][initialCol] == '|' || labyrinth[initialRow + 1][initialCol] == '_') {
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[initialRow + 1][initialCol] == '@' ||
                            labyrinth[initialRow + 1][initialCol] == '*' || labyrinth[initialRow + 1][initialCol] == '#') {
                        initialRow++;
                        initialLives--;
                        totalMoves++;
                        System.out.printf("Ouch! That hurt! Lives left: %d", initialLives).println();
                        if (initialLives == 0) {
                            System.out.println("No lives left! Game Over!");
                            //System.out.printf("Total moves made: %d", totalMoves);
                            break;
                        }
                    } else if (labyrinth[initialRow + 1][initialCol] == '$') {
                        labyrinth[initialRow + 1][initialCol] = '.';
                        initialRow++;
                        initialLives++;
                        totalMoves++;
                        System.out.printf("Awesome! Lives left: %d", initialLives).println();

                    } else if (labyrinth[initialRow + 1][initialCol] == ' ') {
                        totalMoves++;
                        System.out.println("Fell off a cliff! Game Over!");
                        System.out.printf("Total moves made: %d", totalMoves);
                        break;
                    } else if (labyrinth[initialRow + 1][initialCol] == '.') {
                        initialRow++;
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                } else {
                    totalMoves++;
                    System.out.println("Fell off a cliff! Game Over!");
                    //System.out.printf("Total moves made: %d", totalMoves);
                    break;
                }
            }else if (currentMove == '^') {
                if (initialRow > 0 || initialCol <= labyrinth[initialRow - 1].length - 1) {
                    if (labyrinth[initialRow - 1][initialCol] == '|' || labyrinth[initialRow - 1][initialCol] == '_') {
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[initialRow - 1][initialCol] == '@' ||
                            labyrinth[initialRow - 1][initialCol] == '*' || labyrinth[initialRow - 1][initialCol] == '#') {
                        initialRow--;
                        initialLives--;
                        totalMoves++;
                        System.out.printf("Ouch! That hurt! Lives left: %d", initialLives).println();
                        if (initialLives == 0) {
                            System.out.println("No lives left! Game Over!");
                            //System.out.printf("Total moves made: %d", totalMoves);
                            break;
                        }
                    } else if (labyrinth[initialRow - 1][initialCol] == '$') {
                        labyrinth[initialRow - 1][initialCol] = '.';
                        initialRow--;
                        initialLives++;
                        totalMoves++;
                        System.out.printf("Awesome! Lives left: %d", initialLives).println();

                    } else if (labyrinth[initialRow - 1][initialCol] == ' ') {
                        totalMoves++;
                        System.out.println("Fell off a cliff! Game Over!");
                        //System.out.printf("Total moves made: %d", totalMoves);
                        break;
                    } else if (labyrinth[initialRow - 1][initialCol] == '.') {
                        initialRow--;
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                } else {
                    totalMoves++;
                    System.out.println("Fell off a cliff! Game Over!");
                    //System.out.printf("Total moves made: %d", totalMoves);
                    break;
                }
            }else if (currentMove == '<') {
                if (initialCol > 0) {
                    if (labyrinth[initialRow][initialCol - 1] == '|' || labyrinth[initialRow][initialCol - 1] == '_') {
                        System.out.println("Bumped a wall.");
                    }else if (labyrinth[initialRow][initialCol - 1] == '@' ||
                            labyrinth[initialRow][initialCol - 1] == '*' || labyrinth[initialRow][initialCol - 1] == '#') {
                        initialCol--;
                        initialLives--;
                        totalMoves++;
                        System.out.printf("Ouch! That hurt! Lives left: %d", initialLives).println();
                        if (initialLives == 0) {
                            System.out.println("No lives left! Game Over!");
                            //System.out.printf("Total moves made: %d", totalMoves);
                            break;
                        }
                    }else if (labyrinth[initialRow][initialCol - 1] == '$') {
                        labyrinth[initialRow][initialCol - 1] = '.';
                        initialCol--;
                        initialLives++;
                        totalMoves++;
                        System.out.printf("Awesome! Lives left: %d", initialLives).println();

                    }else if (labyrinth[initialRow][initialCol - 1] == ' ') {
                        totalMoves++;
                        System.out.println("Fell off a cliff! Game Over!");
                        //System.out.printf("Total moves made: %d", totalMoves);
                        break;
                    }else if (labyrinth[initialRow][initialCol - 1] == '.') {
                        initialCol--;
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                }else {
                    totalMoves++;
                    System.out.println("Fell off a cliff! Game Over!");
                    //System.out.printf("Total moves made: %d", totalMoves);
                    break;
                }
            }
        }
        System.out.printf("Total moves made: %d", totalMoves);
    }
}
