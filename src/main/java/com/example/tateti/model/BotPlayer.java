package com.example.tateti.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BotPlayer implements Player {

    @Autowired
    private Board board;

    // This is the minimax function. It considers all
    // the possible ways the game can go and returns
    // the value of the board
    private int minimax(int depth, Boolean isMax)
    {
        int score = board.evaluate();

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!board.isMovesLeft())
            return 0;

        // If this maximizer's move
        int best;
        if (isMax)
        {
            best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board.positions[i][j]=='_')
                    {
                        System.out.println("Se esta haciendo la recursion" + i +""+ j);
                        // Make the move
                        board.positions[i][j] = board.PLAYER;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, this.minimax(depth + 1, false));

                        // Undo the move
                        board.positions[i][j] = '_';
                    }
                }
            }
        }

        // If this minimizer's move
        else
        {
            best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board.positions[i][j] == '_')
                    {
                        // Make the move
                        board.positions[i][j] = board.OPPONENT;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, this.minimax(
                                depth + 1, true));

                        // Undo the move
                        board.positions[i][j] = '_';
                    }
                }
            }
        }
        return best;
    }


    // Return the best possible move for the player
    private Position findBestMove() {
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
                if (board.positions[i][j] == '_') {
                    // Make the move
                    board.positions[i][j] = board.OPPONENT;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(6, false);

                    // Undo the move
                    board.positions[i][j] = '_';

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
        Position bestMove = findBestMove();
        board.positions[bestMove.row][bestMove.col] = 'x';
        System.out.println(bestMove.row);
        System.out.println(bestMove.col);
        System.out.println(board);
        return bestMove;
    }

    public void play(Position position) {
        if(board.positions[position.row][position.col] == '_') {
            board.positions[position.row][position.col] = 'x';
        }
    }
}
