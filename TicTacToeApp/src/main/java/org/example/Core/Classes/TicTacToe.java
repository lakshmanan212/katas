package org.example.Core.Classes;

import org.example.Core.Interfaces.GameBoardComponent;
import org.example.Core.Interfaces.GameLogicComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


/**
 * Main game controller class for TicTacToe.
 */

public class TicTacToe {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToe.class);

    private final GameBoard board;
    private final GameLogic logic;
    private char currentPlayer;

    public TicTacToe() {
        this.board = new GameBoard();
        this.logic = new GameLogic(board);
        this.currentPlayer = 'X';
    }

    public TicTacToe(GameBoard mockBoard, GameLogic mockLogic) {

        this.board = mockBoard;
        this.logic = mockLogic;
    }


    /**
     * Starts the game and manages the game loop.
     */
    public void startGame() {
        LOGGER.info("Welcome to Tic-Tac-Toe!");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                board.displayBoard();
                LOGGER.info("Player {}: Enter your move (row and column): ", currentPlayer);
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (!board.isMoveValid(row, col)) {
                    LOGGER.info("Invalid move. Try again.");
                    continue;
                }

                board.placeMove(row, col, currentPlayer);

                if (logic.isWinningMove(currentPlayer)) {
                    board.displayBoard();
                    LOGGER.info("Player {} wins!", currentPlayer);
                    break;
                }

                if (board.isFull()) {
                    board.displayBoard();
                    LOGGER.info("It's a draw!");
                    break;
                }

                togglePlayer();
            }
        }
    }

    void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
