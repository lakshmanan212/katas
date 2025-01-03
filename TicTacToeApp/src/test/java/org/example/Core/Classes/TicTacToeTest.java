package org.example.Core.Classes;

import org.example.Core.Interfaces.GameBoardComponent;
import org.example.Core.Interfaces.GameLogicComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the TicTacToe class.
 */
class TicTacToeTest {

    private TicTacToe ticTacToe;
    private GameBoard mockBoard;
    private GameLogic mockLogic;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        mockBoard = mock(GameBoard.class);
        mockLogic = mock(GameLogic.class);

        // Create the TicTacToe object with mocked dependencies
        ticTacToe = new TicTacToe(mockBoard, mockLogic);
    }

    @Test
    void testStartGame_PlayerXWins() {
        // Arrange: Set up the behavior of mocked components
        when(mockBoard.isMoveValid(0, 0)).thenReturn(true);
        when(mockBoard.isMoveValid(0, 1)).thenReturn(true);
        when(mockBoard.isMoveValid(0, 2)).thenReturn(true);
        when(mockBoard.isFull()).thenReturn(false);
        when(mockLogic.isWinningMove('X')).thenReturn(true);

        // Act: Simulate the start of the game
        ticTacToe.startGame();

        // Verify: Check that methods were called
        verify(mockBoard, times(3)).placeMove(anyInt(), anyInt(), eq('X'));
        verify(mockLogic, times(1)).isWinningMove('X');
        verify(mockBoard, times(1)).displayBoard();
    }

    @Test
    void testStartGame_Draw() {
        // Arrange: Set up the behavior for a draw scenario
        when(mockBoard.isMoveValid(anyInt(), anyInt())).thenReturn(true);
        when(mockBoard.isFull()).thenReturn(true);
        when(mockLogic.isWinningMove(anyChar())).thenReturn(false);

        // Act: Simulate the start of the game
        ticTacToe.startGame();

        // Verify: Verify that the game loop ended with a draw
        verify(mockBoard, times(9)).placeMove(anyInt(), anyInt(), anyChar());
        verify(mockBoard, times(1)).displayBoard();
        verify(mockBoard, times(1)).isFull();
    }

    @Test
    void testStartGame_PlayerOWins() {
        // Arrange: Set up the behavior of mocked components
        when(mockBoard.isMoveValid(0, 0)).thenReturn(true);
        when(mockBoard.isMoveValid(0, 1)).thenReturn(true);
        when(mockBoard.isMoveValid(0, 2)).thenReturn(true);
        when(mockBoard.isFull()).thenReturn(false);
        when(mockLogic.isWinningMove('O')).thenReturn(true);

        // Act: Simulate the start of the game
        ticTacToe.startGame();

        // Verify: Check that methods were called for player O winning
        verify(mockBoard, times(3)).placeMove(anyInt(), anyInt(), eq('O'));
        verify(mockLogic, times(1)).isWinningMove('O');
        verify(mockBoard, times(1)).displayBoard();
    }

    @Test
    void testStartGame_InvalidMove() {
        // Arrange: Simulate an invalid move by player X
        when(mockBoard.isMoveValid(0, 0)).thenReturn(false);
        when(mockBoard.isFull()).thenReturn(false);
        when(mockLogic.isWinningMove('X')).thenReturn(false);

        // Act: Simulate the start of the game
        ticTacToe.startGame();

        // Verify: Check that invalid moves are handled correctly
        verify(mockBoard, times(1)).displayBoard();
        verify(mockBoard, times(0)).placeMove(0, 0, 'X');
        verify(mockBoard, times(1)).isMoveValid(0, 0);
    }

    @Test
    void testTogglePlayer() {
        // Arrange
        char currentPlayer = 'X';

        // Act: Toggle the player from 'X' to 'O'
        ticTacToe.togglePlayer();

        // Assert: The player should now be 'O'
        assertNotEquals(currentPlayer, ticTacToe.getCurrentPlayer());
        assertEquals('O', ticTacToe.getCurrentPlayer());
    }
}
