package com.example.tateti.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Board {
    private char[][] positions;

    public Board(){
        char[][] b = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        positions = b;
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
