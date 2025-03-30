import java.util.Scanner;

public class TicTacToe {


    private static final int ROWS = 3;
    private static final int COLS = 3;


    private static char[][] board = new char[ROWS][COLS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard();

            boolean gameWon = false;
            int moves = 0;

            while (!gameWon && moves < ROWS * COLS) {
                showBoard();
                System.out.println("Player " + currentPlayer + "'s turn.");

                int row = getRangedInt(scanner, "Enter row (1-3): ", 1, 3) - 1;
                int col = getRangedInt(scanner, "Enter column (1-3): ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    placeMove(row, col);
                    moves++;
                    gameWon = checkWinner();
                    if (!gameWon) {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            showBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }


            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }


    private static void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = '-';
            }
        }
    }


    private static void showBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);
                if (col < COLS - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }


    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == '-';
    }


    private static void placeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }


    private static boolean checkWinner() {

        for (int i = 0; i < ROWS; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }


    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static int getRangedInt(Scanner scanner, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Invalid input. " + prompt);
            }
            input = scanner.nextInt();
        } while (input < low || input > high);
        return input;
    }
}
