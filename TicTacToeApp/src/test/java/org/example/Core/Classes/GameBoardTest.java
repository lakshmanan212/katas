package org.example.Core.Classes;

import org.example.Core.Constants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the GameBoard class.
 */
class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
    }

    @Test
    void testInitializeBoard() {
        gameBoard.initializeBoard();
        char[][] board = gameBoard.getBoard();

        for (int i = 0; i < Constants.SIZE; i++) {
            for (int j = 0; j < Constants.SIZE; j++) {
                assertEquals(Constants.EMPTY, board[i][j], "Board should be initialized with EMPTY values.");
            }
        }
    }

    @Test
    void testIsMoveValid_ValidMove() {
        assertTrue(gameBoard.isMoveValid(0, 0), "A valid move should return true.");
    }

    @Test
    void testIsMoveValid_InvalidMoveOutOfBounds() {
        assertFalse(gameBoard.isMoveValid(-1, 0), "Row index out of bounds should return false.");
        assertFalse(gameBoard.isMoveValid(0, -1), "Column index out of bounds should return false.");
        assertFalse(gameBoard.isMoveValid(Constants.SIZE, 0), "Row index exceeding board size should return false.");
        assertFalse(gameBoard.isMoveValid(0, Constants.SIZE), "Column index exceeding board size should return false.");
    }

    @Test
    void testIsMoveValid_AlreadyOccupiedCell() {
        gameBoard.placeMove(1, 1, 'X');
        assertFalse(gameBoard.isMoveValid(1, 1), "A move to an already occupied cell should return false.");
    }

    @Test
    void testPlaceMove() {
        gameBoard.placeMove(1, 1, 'X');
        char[][] board = gameBoard.getBoard();
        assertEquals('X', board[1][1], "The cell should contain the player's symbol after placing a move.");
    }

    @Test
    void testIsFull_EmptyBoard() {
        assertFalse(gameBoard.isFull(), "An empty board should not be considered full.");
    }

    @Test
    void testIsFull_FullBoard() {
        for (int i = 0; i < Constants.SIZE; i++) {
            for (int j = 0; j < Constants.SIZE; j++) {
                gameBoard.placeMove(i, j, 'X');
            }
        }
        assertTrue(gameBoard.isFull(), "A fully occupied board should return true for isFull().");
    }
}
