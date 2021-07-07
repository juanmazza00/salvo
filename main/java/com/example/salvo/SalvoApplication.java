package com.example.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.stream.Location;
import java.time.LocalDate;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class SalvoApplication {

	private Object Game;


	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}


	public SalvoApplication() {
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository  PlayerRepo, GameRepository GameRepo, GamePlayerRepository GmplyrRepo, ShipRepository ShipRepo, SalvoRepository SalRepo, ScoreRepository ScRepo){
		return (args) -> {


			Player player1 = new Player("jj@gmail.com");
			Player player2 = new Player("jj12312@gmail.com");
			Player player3 = new Player("121312@gmail.com");
			Player player4 = new Player("jjLOpez@gmail.com");
			Player player5 = new Player("EnzoPerez@gmail.com");
			Player player6 = new Player("MarecloGallardo@gmail.com");
			PlayerRepo.save(player1);
			PlayerRepo.save(player2);
			PlayerRepo.save(player3);
			PlayerRepo.save(player4);
			PlayerRepo.save(player5);
			PlayerRepo.save(player6);

			var game1 = new Game(new Date());
			var game2 = new Game(new Date());
			var game3 = new Game(new Date());
			var game4 = new Game(new Date());
			var game5 = new Game(new Date());
			var game6 = new Game(new Date());
			GameRepo.save(game1);
			GameRepo.save(game2);
			GameRepo.save(game3);
			GameRepo.save(game4);
			GameRepo.save(game5);
			GameRepo.save(game6);

			Score sc1 = new Score(1.0, new Date(),player1, game1);
			Score sc2 = new Score(0.0, new Date(),player2, game1);
			Score sc3 = new Score(0.0, new Date(),player3, game2);
			Score sc4 = new Score(1.0, new Date(),player4, game2);
			Score sc5 = new Score(0.5, new Date(),player5, game3);
			Score sc6 = new Score(0.5, new Date(),player6, game3);
			ScRepo.save(sc1);
			ScRepo.save(sc2);
			ScRepo.save(sc3);
			ScRepo.save(sc4);
			ScRepo.save(sc5);
			ScRepo.save(sc6);


			var gamePlayer1 = new GamePlayer(game1, player1, new Date());
			var gamePlayer2 = new GamePlayer(game1, player2, new Date());
			var gamePlayer3 = new GamePlayer(game2, player3, new Date());
			var gamePlayer4 = new GamePlayer(game2, player4, new Date());
			var gamePlayer5 = new GamePlayer(game3, player5, new Date());
			var gamePlayer6 = new GamePlayer(game3, player6, new Date());
			var gamePlayer7 = new GamePlayer(game4, player4, new Date());
			var gamePlayer8 = new GamePlayer(game4, player5, new Date());
			var gamePlayer9 = new GamePlayer(game5, player6, new Date());
			var gamePlayer10 = new GamePlayer(game5, player4, new Date());
			var gamePlayer11 = new GamePlayer(game6, player5, new Date());
			var gamePlayer12 = new GamePlayer(game6, player6, new Date());
			GmplyrRepo.save(gamePlayer1);
			GmplyrRepo.save(gamePlayer2);
			GmplyrRepo.save(gamePlayer3);
			GmplyrRepo.save(gamePlayer4);
			GmplyrRepo.save(gamePlayer5);
			GmplyrRepo.save(gamePlayer6);
			GmplyrRepo.save(gamePlayer7);
			GmplyrRepo.save(gamePlayer8);
			GmplyrRepo.save(gamePlayer9);
			GmplyrRepo.save(gamePlayer10);
			GmplyrRepo.save(gamePlayer11);
			GmplyrRepo.save(gamePlayer12);

			Ship s1 = new Ship("Batlleship", Arrays.asList("A10", "B10", "C10"), gamePlayer1 );
			Ship s2 = new Ship("Batlleship", Arrays.asList("A1", "A2", "A3"), gamePlayer2);
			Ship s3 = new Ship("Cruise", Arrays.asList("D4", "D5" ,"D6"),  gamePlayer1);
			Ship s4 = new Ship("Cruise", Arrays.asList("F3","F4", "F5"),  gamePlayer2);
			Ship s5 = new Ship("Submarine", Arrays.asList("F1", "E1","D1" ),  gamePlayer1);
			Ship s6 = new Ship("Submarine", Arrays.asList("C7", "D7" , "E7"),  gamePlayer2);
			ShipRepo.save(s1);
			ShipRepo.save(s2);
			ShipRepo.save(s3);
			ShipRepo.save(s4);
			ShipRepo.save(s5);
			ShipRepo.save(s6);

			Salvo sal1 = new Salvo( 1, Arrays.asList("A1","B1"), gamePlayer1);
			Salvo sal2 = new Salvo( 2, Arrays.asList("A10","A5"), gamePlayer2);
			Salvo sal3 = new Salvo( 3, Arrays.asList("B3","B4"), gamePlayer1);
			Salvo sal4 = new Salvo( 4, Arrays.asList("E1","E2"), gamePlayer2);
			Salvo sal5 = new Salvo( 5, Arrays.asList("D7","D8"), gamePlayer1);
			Salvo sal6 = new Salvo( 6, Arrays.asList("C6","B6"), gamePlayer2);
			SalRepo.save(sal1);
			SalRepo.save(sal2);
			SalRepo.save(sal3);
			SalRepo.save(sal4);
			SalRepo.save(sal5);
			SalRepo.save(sal6);





		};

	}}