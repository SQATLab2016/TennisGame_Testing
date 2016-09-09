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
	public void testTennisGame_Player1AdvantageAfter4Points() throws TennisGameException {
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
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 advantage score incorrect", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player1DeuceAfterAdvantage() throws TennisGameException {
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
		game.player2Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);			
	}
	
	@Test
	public void testTennisGame_Player2DeuceAfterAdvantage() throws TennisGameException {
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
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);			
	}
	
	@Test
	public void testTennisGame_Player2AdvantageAfter4Points() throws TennisGameException {
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
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 advantage score incorrect", "player2 has advantage", score);		
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
	public void testTennisGame_Player1ScoreCondition() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();	
		//Act
		game.player1Scored();
		String score = game.getScore();		
		assertEquals("Player 1 Score incorrect 15", "15 - love", score);
		
		game.player1Scored();
		score = game.getScore();
		assertEquals("Player 1 Score incorrect 30", "30 - love", score);
		
		game.player1Scored();
		score = game.getScore();
		assertEquals("Player 1 Score incorrect 40", "40 - love", score);				
	}
	
	@Test 
	public void testTennisGamePlayer1WinCondition() throws TennisGameException {
		
		// Arrange
		TennisGame game = new TennisGame();
		
		// Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		// Assert
		assertEquals("Player 1 win condition not met", "player1 wins", score);
	}
	
	@Test 
	public void testTennisGamePlayer2WinCondition() throws TennisGameException {
		
		// Arrange
		TennisGame game = new TennisGame();
		
		// Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		// Assert
		assertEquals("Player 2 win condition not met", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2ScoreCondition() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();	
		//Act
		game.player2Scored();
		String score = game.getScore();		
		assertEquals("Player 2 Score incorrect 15", "love - 15", score);
		
		game.player2Scored();
		score = game.getScore();
		assertEquals("Player 2 Score incorrect 30", "love - 30", score);
		
		game.player2Scored();
		score = game.getScore();
		assertEquals("Player 2 Score incorrect 40", "love - 40", score);				
	}
	
	@Test 
	public void testTennisGame_15_15_EqualScores() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		
		// Act
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore();
		
		//Assert
		assertEquals("Player scores not equal at 15 15", "15 - 15", score);
		
	}
	
	@Test 
	public void testTennisGame_30_30_EqualScores() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		
		// Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		
		//Assert
		assertEquals("Player scores not equal at 30 30", "30 - 30", score);
		
	}
}
