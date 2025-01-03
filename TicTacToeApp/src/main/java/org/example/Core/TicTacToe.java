package org.example.Core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


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

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
