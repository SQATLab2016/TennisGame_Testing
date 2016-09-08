import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

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
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
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
		// This statement should cause an exception
		game.player1Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Player1 Win Score incorrect","player1 wins", score);	
	}	
	
	@Test
	public void testTennisGame_Player2WinsPointAfterGameEnded() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Player2 Win Score incorrect","player2 wins", score);	
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Player1 Has Advantage incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_15_15() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - 15 incorrect", "15 - 15", score);
	}
	
	@Test
	public void testTennisGame_30_love() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("30 - 15 incorrect", "30 - 15", score);
	}
}