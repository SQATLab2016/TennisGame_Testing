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
	public void testTennisGame_Player1_Advantage() throws TennisGameException {
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

		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 has advantage", score);		
	}

	@Test
	public void testTennisGame_Player2_Advantage() throws TennisGameException {
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

		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 has advantage", score);		
	}

	@Test
	public void testTennisGame_fifteen() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "15 - 15", score);		
	}
	@Test
	public void testTennisGame_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - 30", score);		
	}
	@Test
	public void testTennisGame_30_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - 15", score);		
	}
	
	@Test
	public void testTennisGame_15_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "15 - 30", score);		
	}
	@Test
	public void testTennisGame_40_30() throws TennisGameException {
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
		assertEquals("Tie score incorrect", "player2 has advantage", score);		
	}
}