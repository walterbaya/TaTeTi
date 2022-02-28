package com.example.tateti.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Board {
    private char[][] positions;

    public Board() {
        char[][] b = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        positions = b;
    }

    public boolean isGameOver() {
        return isARowFull() || isAColumnFull() || isADiagonalFull();
    }

    private boolean isARowFull() {
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                res = res && positions[i][j] == positions[i][j + 1] && (positions[i][j] != '_');
            }
            if (res) {
                return true;
            }
        }
        return false;
    }

    private boolean isAColumnFull() {
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                res = res && positions[j][i] == positions[j + 1][i] && (positions[j][i] != '_');
            }
            if (res) {
                return true;
            }
        }
        return false;
    }

    private boolean isADiagonalFull(){
        return isFirstDiagonalFull() || isSecondDiagonalFull();
    }
    private boolean isFirstDiagonalFull(){
        boolean res = true;
        for (int i = 0; i < 2; i++) {
            res = res && positions[i][i] == positions[i + 1][i + 1] && (positions[i][i] != '_');
        }
        return res;
    }

    private boolean isSecondDiagonalFull(){
        boolean res = true;
        for (int i = 0; i < 2; i++) {
            res = res && positions[i][2-i] == positions[i+1][2 - (i+1)] && (positions[i][2-i] != '_');
        }
        return res;
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
