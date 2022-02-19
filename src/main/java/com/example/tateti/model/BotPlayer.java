package com.example.tateti.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotPlayer implements Player {

    @Autowired
    private Board board;

    private char player = 'x';
    private char opponent = 'o';

    // Returns true if there are moves
    // remaining on the board, otherwise returns false
    private Boolean isMovesLeft(Board board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board.getPositions()[i][j] == '_') return true;
        return false;
    }

    private int evaluate(Board board) {
        for (int i = 0; i < 3; i++) {
            if (board.getPositions()[i][0] == board.getPositions()[i][1] && board.getPositions()[i][1] == board.getPositions()[i][2]) {
                if (board.getPositions()[i][0] == player) return +10;
                else if (board.getPositions()[i][0] == opponent) return -10;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board.getPositions()[0][col] == board.getPositions()[1][col] && board.getPositions()[1][col] == board.getPositions()[2][col]) {
                if (board.getPositions()[0][col] == player) return +10;
                else if (board.getPositions()[0][col] == opponent) return -10;
            }
        }
        // Checking for Diagonals for X or O victory.
        if (board.getPositions()[0][0] == board.getPositions()[1][1] && board.getPositions()[1][1] == board.getPositions()[2][2] || board.getPositions()[0][2] == board.getPositions()[1][1] && board.getPositions()[1][1] == board.getPositions()[2][0]) {
            if (board.getPositions()[0][0] == player) return +10;
            else if (board.getPositions()[0][0] == opponent) return -10;
        }
        // Else if none of them have won then return 0
        return 0;
    }

    // It considers all the possible ways the game can go and returns
    // the value of the board
    private int minimax(Board board, int depth, Boolean isMax) {
        int score = evaluate(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10) return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10) return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (isMovesLeft(board) == false) return 0;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board.getPositions()[i][j] == '_') {
                        // Make the move
                        board.getPositions()[i][j] = player;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board, depth + 1, !isMax));

                        // Undo the move
                        board.getPositions()[i][j] = '_';
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board.getPositions()[i][j] == '_') {
                        // Make the move
                        board.getPositions()[i][j] = opponent;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board, depth + 1, !isMax));

                        // Undo the move
                        board.getPositions()[i][j] = '_';
                    }
                }
            }
            return best;
        }
    }

    // Return the best possible move for the player
    private Position findBestMove(Board board) {
        int bestVal = -1000;
        Position bestMove = new Position();
        bestMove.row = -1;
        bestMove.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board.getPositions()[i][j] == '_') {
                    // Make the move
                    board.getPositions()[i][j] = player;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(board, 0, false);

                    // Undo the move
                    board.getPositions()[i][j] = '_';

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

    public Position play() {
        Position bestMove = findBestMove(board);
        board.getPositions()[bestMove.row][bestMove.col] = 'x';
        return bestMove;
    }

    public void play(Position position) {
        if(board.getPositions()[position.row][position.col] == '_') {
            board.getPositions()[position.row][position.col] = 'x';
        }
    }
}
