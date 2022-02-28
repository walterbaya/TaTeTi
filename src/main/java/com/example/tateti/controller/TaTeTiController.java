package com.example.tateti.controller;

import com.example.tateti.model.Board;
import com.example.tateti.model.BotPlayer;
import com.example.tateti.model.HumanPlayer;
import com.example.tateti.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaTeTiController {

    @Autowired
    Board board;

    @Autowired
    HumanPlayer humanPlayer;

    @Autowired
    BotPlayer botPlayer;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/isGameOver")
    public ResponseEntity<Integer> isGameOver() {
        Integer res = 0;
        HttpHeaders headers = new HttpHeaders();
        if(!board.isMovesLeft()){
            if(board.evaluate() == 0){
                res = 1;
            }
            else if(board.evaluate() == 10){
                res = 10;
            }
            else if(board.evaluate() == -10){
                res = -10;
            }
        }
        return ResponseEntity.ok().headers(headers).body(res);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/humanPlay", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Position> humanPlay(@RequestBody Position position) {
        humanPlayer.play(position);
        Position pcPosition = botPlayer.play();
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(pcPosition);
    }
}
