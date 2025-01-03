package org.example.Core.Interfaces;

/**
 * Represents the game logic operations declaration.
 */


public interface GameLogicComponent {

    boolean isWinningMove(char player);
    boolean isRowWin(int row, char player);
    boolean isColumnWin(int col, char player);
    boolean isDiagonalWin(char player);
}
