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
	
	// My tests begin ...
	@Test
	public void testTennisGame_player1Win_4Points() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 4; i++) {
			game.player1Scored();
		}
		
		assertEquals("player1 should have won.", "player1 wins", game.getScore());
	}
	
	@Test
	public void testTennisGame_player2Win_4Points() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 4; i++) {
			game.player2Scored();
		}
		
		assertEquals("player2 should have won.", "player2 wins", game.getScore());
	}
	
	@Test
	public void testTennisGame_player1_advantage() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 3; i++) {
			game.player1Scored();
		}
		
		for(int i = 0; i < 3; i++) {
			game.player2Scored();
		}
		
		game.player1Scored();
		
		assertEquals("player1 should have advantage.", "player1 has advantage", game.getScore());
	}
	
	@Test
	public void testTennisGame_player2_advantage() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 3; i++) {
			game.player2Scored();
		}
		
		for(int i = 0; i < 3; i++) {
			game.player1Scored();
		}
		
		game.player2Scored();
		
		assertEquals("player2 should have advantage.", "player2 has advantage", game.getScore());
	}
	
	@Test
	public void testTennisGame_15_15() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		
		assertEquals("Should be 15 - 15.", "15 - 15", game.getScore());
	}
	
	@Test
	public void testTennisGame_30_30() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 2; i++) {
			game.player1Scored();
		}
		
		for(int i = 0; i < 2; i++) {
			game.player2Scored();
		}
		
		assertEquals("Should be 30 - 30.", "30 - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_p1_40_p2_15() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 2; i++) {
			game.player1Scored();
		}
		
		game.player2Scored();
		game.player1Scored();
		
		// getscore returns p2 - p1
		assertEquals("Should be 15 - 40.", "15 - 40", game.getScore());
	}
	
	@Test
	public void testTennisGame_p1_15_p2_40() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		for(int i = 0; i < 2; i++) {
			game.player2Scored();
		}
		
		game.player1Scored();
		game.player2Scored();
		
		// getscore returns p2 - p1
		assertEquals("Should be 40 - 15.", "40 - 15", game.getScore());
	}
	// My tests end.
	
	// ---------------------------------------------------------------
	
	// examples begin ...
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
		String score = game.getScore();
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
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	// examples end.
}
