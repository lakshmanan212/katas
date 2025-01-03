package org.example.Core.Interfaces;

public interface GameBoardComponent {

    void initializeBoard();
    void displayBoard();
    boolean isFull();
    void placeMove(int row, int col, char player);
    boolean isMoveValid(int row, int col);
    char[][] getBoard();
}
