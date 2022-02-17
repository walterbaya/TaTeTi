package com.example.tateti;

import com.example.tateti.model.Board;
import com.example.tateti.model.BotPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TatetiApplication implements CommandLineRunner {

	@Autowired
	Board board;

	Logger log = LoggerFactory.getLogger(TatetiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TatetiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BotPlayer bot = new BotPlayer();
		//HumanPlayer hp = new HumanPlayer();
		bot.play(0,0,board);
		bot.play(board);
		bot.play(board);
		//hp.play(2,1);
		//board.setPosition(0,0,true);
		log.info("se imprime tablero de posiciones: " + board.toString());
	}
}
