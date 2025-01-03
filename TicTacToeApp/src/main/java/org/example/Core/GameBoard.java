package org.example.Core;


public class GameBoard {
    private final char[][] board;

    public GameBoard() {
        board = new char[Constants.SIZE][Constants.SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < Constants.SIZE; i++) {
            for (int j = 0; j < Constants.SIZE; j++) {
                board[i][j] = Constants.EMPTY;
            }
        }
    }

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


    public void placeMove(int row, int col, char player) {
        board[row][col] = player;
    }


    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < Constants.SIZE &&
                col >= 0 && col < Constants.SIZE &&
                board[row][col] == Constants.EMPTY;
    }

    public char[][] getBoard() {
        return board;
    }
}
