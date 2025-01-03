package org.example.Core.Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the GameLogic class.
 */
class GameLogicTest {

    private GameBoard gameBoard;
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
        gameLogic = new GameLogic(gameBoard);
    }

    @Test
    void testIsRowWin_WinningRow() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(0, 1, 'X');
        gameBoard.placeMove(0, 2, 'X');
        assertTrue(gameLogic.isRowWin(0, 'X'), "Player X should win with a complete row.");
    }

    @Test
    void testIsRowWin_NoWinningRow() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(0, 1, 'O');
        gameBoard.placeMove(0, 2, 'X');
        assertFalse(gameLogic.isRowWin(0, 'X'), "Player X should not win if the row is not complete.");
    }

    @Test
    void testIsColumnWin_WinningColumn() {
        gameBoard.placeMove(0, 0, 'O');
        gameBoard.placeMove(1, 0, 'O');
        gameBoard.placeMove(2, 0, 'O');
        assertTrue(gameLogic.isColumnWin(0, 'O'), "Player O should win with a complete column.");
    }

    @Test
    void testIsColumnWin_NoWinningColumn() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(1, 0, 'O');
        gameBoard.placeMove(2, 0, 'X');
        assertFalse(gameLogic.isColumnWin(0, 'O'), "Player O should not win if the column is not complete.");
    }

    @Test
    void testIsDiagonalWin_WinningMainDiagonal() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(1, 1, 'X');
        gameBoard.placeMove(2, 2, 'X');
        assertTrue(gameLogic.isDiagonalWin('X'), "Player X should win with a complete main diagonal.");
    }

    @Test
    void testIsDiagonalWin_WinningAntiDiagonal() {
        gameBoard.placeMove(0, 2, 'O');
        gameBoard.placeMove(1, 1, 'O');
        gameBoard.placeMove(2, 0, 'O');
        assertTrue(gameLogic.isDiagonalWin('O'), "Player O should win with a complete anti-diagonal.");
    }

    @Test
    void testIsDiagonalWin_NoWinningDiagonal() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(1, 1, 'O');
        gameBoard.placeMove(2, 2, 'X');
        assertFalse(gameLogic.isDiagonalWin('X'), "Player X should not win if the diagonal is not complete.");
    }

    @Test
    void testIsWinningMove_WinningRow() {
        gameBoard.placeMove(1, 0, 'X');
        gameBoard.placeMove(1, 1, 'X');
        gameBoard.placeMove(1, 2, 'X');
        assertTrue(gameLogic.isWinningMove('X'), "Player X should win with a complete row.");
    }

    @Test
    void testIsWinningMove_NoWin() {
        gameBoard.placeMove(0, 0, 'X');
        gameBoard.placeMove(1, 1, 'O');
        gameBoard.placeMove(2, 2, 'X');
        assertFalse(gameLogic.isWinningMove('X'), "Player X should not win with an incomplete win condition.");
    }
}
