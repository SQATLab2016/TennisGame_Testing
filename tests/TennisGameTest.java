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
	public void testTennisGame_test_score_possibilities() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		String score1 = game.getScore() ;
		assertEquals("Tie score incorrect", "15 - love", score1);		
		game.player2Scored();
		String score2 = game.getScore() ;
		assertEquals("Tie score incorrect", "30 - love", score2);		
		game.player2Scored();
		String score3 = game.getScore() ;
		assertEquals("Tie score incorrect", "40 - love", score3);		
		game.player1Scored();
		String score4 = game.getScore() ;
		assertEquals("Tie score incorrect", "40 - 15", score4);	
		game.player2Scored();
		String score5 = game.getScore() ;
		assertEquals("Player2 wins", "player2 wins", score5);	


	}

	@Test (expected = TennisGameException.class)
	public void testTennisGame_Test_Player2_win_endgame_player2score_exception() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score1 = game.getScore() ;
		assertEquals("Player2 wins", "player2 wins", score1);
		//Act
		// This statement should cause an exception
		game.player2Scored();
		
	}
	@Test
	public void testTennisGame_Test_advantage_for_players() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		String score1 = game.getScore() ;
		assertEquals("Tie", "deuce", score1);
		game.player2Scored();
		String score2 = game.getScore() ;
		assertEquals("Player2 Advantage", "player2 has advantage", score2);
		game.player1Scored();
		game.player1Scored();
		String score3 = game.getScore() ;
		assertEquals("Player1 Advantage", "player1 has advantage", score3);
		game.player1Scored();
		String score4 = game.getScore() ;
		assertEquals("Player1 Advantage", "player1 wins", score4);
		
	}
}
