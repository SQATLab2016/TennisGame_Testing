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
	public void testTennisGame_EachPlayerHasFifteen() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals("Fifteen does not work", "15 - 15", score);
	}
	@Test
	public void testTennisGame_Player2Forty_Player1Love() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals("0 - 40 fails", "love - 40", score);
	}
	@Test
	public void testTennisGame_Player1Forty() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		
		assertEquals("Forty-fifteen does not work", "40 - 15", score);
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
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
	public void testTennisGame_PlayerOneWinsAfterDeuce() throws TennisGameException{
		//Assert
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Win is not correct after advantage", "player1 wins", score);
	}
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals("Win is not correct", "player1 wins", score);
	}
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals("Win is not correct", "player2 wins", score);
	}
	@Test
	public void testTennisGame_LongGame() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < Integer.MAX_VALUE; i++){
			game.player1Scored();
			game.player2Scored();
		}
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals("Long game fails", "deuce", score);
	}
	@Test
	public void testTennisGame_PlayerTwoHasAdvantage() throws TennisGameException{
		//Assert
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
		assertEquals("Player 2 advantage is not correct", "player2 has advantage" , score);
		
	}
	@Test
	public void testTennisGame_PlayerOneHasAdvantage() throws TennisGameException{
		//Assert
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player 1 advantage is not correct", "player1 has advantage" , score);
		
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
