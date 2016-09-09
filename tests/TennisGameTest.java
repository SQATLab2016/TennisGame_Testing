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
	@Test
	public void test_Deuce_after_3_wins_row_with_p1_first() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("Deuce not handled properly", "deuce", game.getScore());
		
	}
	@Test
	public void test_Deuce_after_3_wins_row_with_p2_first() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("Deuce not handled properly", "deuce", game.getScore());
		
	}
	@Test
	public void test_love_love(){
		TennisGame game = new TennisGame();
		
		assertEquals("Deuce not handled properly", "love - love", game.getScore());
	}
	@Test
	public void test_long_game_with_p1_advantage() throws TennisGameException{
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
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		
		game.player1Scored();
		assertEquals("P1 advantage not handled correctly in long game", "player1 has advantage", game.getScore());
		
	}
	@Test
	public void test_game_with_p2_advantage() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		assertEquals("P2 advantage not handled correctly in game", "player2 has advantage", game.getScore());
		
	}
	@Test
	public void test_game_with_p1_advantage() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player1Scored();
		
		assertEquals("P2 advantage not handled correctly in game", "player1 has advantage", game.getScore());
		
	}
	@Test
	public void test_30_30() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		assertEquals("30 - 30 not handled correctly", "30 - 30", game.getScore());
	}
	@Test
	public void test_30_15() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		assertEquals("30 - 15 not handled correctly", "30 - 15", game.getScore());
	}
	@Test
	public void test_15_30() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player1Scored();
		
		game.player1Scored();
		assertEquals("15 - 30 not handled correctly", "15 - 30", game.getScore());
	}
	@Test 
	public void test_p1_wins_4_row() throws TennisGameException{
		TennisGame game = new TennisGame();
		

		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("P1 win conditions not handled properly", "player1 wins", game.getScore());
	}
	@Test 
	public void test_p2_wins_4_row() throws TennisGameException{
		TennisGame game = new TennisGame();
		

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("P2 win conditions not handled properly", "player2 wins", game.getScore());
	}
}
