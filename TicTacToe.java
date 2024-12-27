import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard(board);

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + "'s turn:");
            int row = -1;
            int col = -1;

            while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.print("Enter your move (row and column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            board[row][col] = currentPlayer;
            printBoard(board);

            if (checkWinner(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull(board)) {
                System.out.println("The game is a tie!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}