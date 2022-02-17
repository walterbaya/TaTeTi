package com.example.tateti.model;

public class HumanPlayer implements Player{
    public void play(int i, int j, Board board) {
        if(board.getPositions()[i][j] != '_') {
            board.getPositions()[i][j] = 'x';
        }
    }
}
