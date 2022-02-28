package com.example.tateti.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Board {
    public char[][] positions;

    public final char PLAYER = 'x';
    public final char OPPONENT = 'o';

    public Board() {
        char[][] b = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        positions = b;
    }

   public int evaluate()
    {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if (positions[row][0] == positions[row][1] &&
                    positions[row][1] == positions[row][2])
            {
                if (positions[row][0] == PLAYER)
                    return +10;
                else if (positions[row][0] == OPPONENT)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (positions[0][col] == positions[1][col] &&
                    positions[1][col] == positions[2][col])
            {
                if (positions[0][col] == PLAYER)
                    return +10;

                else if (positions[0][col] == OPPONENT)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (positions[0][0] == positions[1][1] && positions[1][1] == positions[2][2])
        {
            if (positions[0][0] == PLAYER)
                return +10;
            else if (positions[0][0] == OPPONENT)
                return -10;
        }

        if (positions[0][2] == positions[1][1] && positions[1][1] == positions[2][0])
        {
            if (positions[0][2] == PLAYER)
                return +10;
            else if (positions[0][2] == OPPONENT)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }


    // Returns true if there are moves
    // remaining on the board, otherwise returns false
    public Boolean isMovesLeft() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (positions[i][j] == '_') return true;
        return false;
    }


    @Override
    public String toString() {
        String textMatrix = "\n";
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                textMatrix = textMatrix + positions[i][j] + " ";
            }
            textMatrix = textMatrix + "\n";
        }
        return textMatrix;
    }
}
