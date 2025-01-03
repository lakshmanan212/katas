package org.example.Core.Classes;


import org.example.Core.Constants.Constants;
import org.example.Core.Interfaces.GameLogicComponent;

/**
 * Handles game rules and winning logic for TicTacToe.
 */

public class GameLogic implements GameLogicComponent {

    private final GameBoard board;

    public GameLogic(GameBoard board) {
        this.board = board;
    }

    /**
     * Checks if the current player has won.
     * @param player the current player's symbol.
     * @return true if the player wins, false otherwise.
     */
    @Override
    public boolean isWinningMove(char player) {
        for (int i = 0; i < Constants.SIZE; i++) {
            if (isRowWin(i, player) || isColumnWin(i, player)) {
                return true;
            }
        }
        return isDiagonalWin(player);
    }

    @Override
    public boolean isRowWin(int row, char player) {
        char[][] b = board.getBoard();
        return b[row][0] == player && b[row][1] == player && b[row][2] == player;
    }

    @Override
    public boolean isColumnWin(int col, char player) {
        char[][] b = board.getBoard();
        return b[0][col] == player && b[1][col] == player && b[2][col] == player;
    }

    @Override
    public boolean isDiagonalWin(char player) {
        char[][] b = board.getBoard();
        return (b[0][0] == player && b[1][1] == player && b[2][2] == player) ||
                (b[0][2] == player && b[1][1] == player && b[2][0] == player);
    }
}
