package com.example.tateti.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class HumanPlayer implements Player{

    @Autowired
    private Board board;

    public void play(Position position) {
        if(board.getPositions()[position.row][position.col] == '_') {
            board.getPositions()[position.row][position.col] = 'o';
        }
    }
}
