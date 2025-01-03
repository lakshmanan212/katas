package org.example.Core;

/**
 * Represents the game board and provides related operations.
 */

public class GameBoard {
    private final char[][] board;

    public GameBoard() {
        board = new char[Constants.SIZE][Constants.SIZE];
        initializeBoard();
    }

    /**
     * Initializes the board with empty values.
     */
    private void initializeBoard() {
        for (int i = 0; i < Constants.SIZE; i++) {
            for (int j = 0; j < Constants.SIZE; j++) {
                board[i][j] = Constants.EMPTY;
            }
        }
    }

    /**
     * Displays the current state of the board.
     */

    public void displayBoard() {
        for (int i = 0; i < Constants.SIZE; i++) {
            for (int j = 0; j < Constants.SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < Constants.SIZE - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < Constants.SIZE - 1) System.out.println("--+---+--");
        }
    }

    /**
     * Checks if the board is full.
     * @return true if full, false otherwise.
     */
    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == Constants.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Places a player's move on the board.
     * @param row the row index.
     * @param col the column index.
     * @param player the current player's symbol.
     */
    public void placeMove(int row, int col, char player) {
        board[row][col] = player;
    }


    /**
     * Checks if a move is valid.
     * @param row the row index.
     * @param col the column index.
     * @return true if valid, false otherwise.
     */
    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < Constants.SIZE &&
                col >= 0 && col < Constants.SIZE &&
                board[row][col] == Constants.EMPTY;
    }

    public char[][] getBoard() {
        return board;
    }
}
