import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_player1WinsGame() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//act
		String score = game.getScore();
		//assert
		assertEquals("player 1 win score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Score4TimesPlayer1Score6TimesAndWins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		//act
		String score = game.getScore();
		//assert
		assertEquals("player 1 win score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//act
		String score = game.getScore();
		//assert
		assertEquals("player 2 advantage incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		//act
		String score = game.getScore();
		//assert
		assertEquals("player 1 advantage incorrect", "player1 has advantage", score);
	}
	 
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}		
	
	@Test
	public void testTennisGame_Player1Wins1Point() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("score 15 - love incorrect", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins3points_results_Love_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("score love - 40 incorrect", "love - 40", score);
	}
	
	@Test
	public void testTennisGame_reallyLongGame_Results_Player2_Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		for (int i = 0; i < 1000;  i++){
			game.player1Scored();
			game.player2Scored();
		}
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("player 2 wins long game incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1Gets3PointsPlayer2Gets4Points_Score_Player2_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("score player2 advantage incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2gets3PointsPlayer1Gets4Points_Score_player1_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("score player1 advantage incorrect", "player1 has advantage", score);
	}
	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
}
