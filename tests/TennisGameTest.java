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
		// This statement should cause an exception
		game.player2Scored();			
	}	
	
	@Test
	public void testTennisGame_Player1WinsPointAfterDeuce_Score_Player1HasAdvantage() throws TennisGameException{
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
		
		game.player1Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Advantage for player1 incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsPointAfterDeuce_Score_Player2HasAdvantage() throws TennisGameException{
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
		
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Advantage for player2 incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsAfterHavingAdvantage_Score_Player1Wins() throws TennisGameException{
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
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Player1 wins after advantage incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsAfterHavingAdvantage_Score_Player2Wins() throws TennisGameException{
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
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Player2 wins after advantage incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1ScoresAfterAdvantageForPlayer2_Score_Deuce() throws TennisGameException{
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
		
		game.player2Scored();
		game.player1Scored();
				
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score after advantage for player2 incorrect", "deuce", score);
	}
	
	@Test
	public void testTennisGame_Player2ScoresAfterAdvantageForPlayer1_Score_Deuce() throws TennisGameException{
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
		
		game.player1Scored();
		game.player2Scored();
				
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score after advantage for player1 incorrect", "deuce", score);
	}
	
	@Test
	public void testTennisGame_Player1ScoresFirst_Score_15love() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
				
		String score = game.getScore() ;
		// Assert
		assertEquals("Score when player1 scores first incorrect", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_Player2ScoresFirst_Score_love15() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
				
		String score = game.getScore() ;
		// Assert
		assertEquals("Score when player2 scores first incorrect", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsAdvantage_Score_Player1HasAdvantage() throws TennisGameException{
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
				
		String score = game.getScore() ;
		// Assert
		assertEquals("advantage for player1 incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsAdvantage_Score_Player2HasAdvantage() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
				
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
				
		game.player2Scored();
				
		String score = game.getScore() ;
		// Assert
		assertEquals("advantage for player2 incorrect", "player2 has advantage", score);
	}
	
}