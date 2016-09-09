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
	public void testTennisGame_Player1Scores3_Player2Scores1_Score_40_15 () throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("3v1 score incorrect","40 - 15",score);
	}
	
	@Test
	public void testTennisGame_Player1Scores1AfterDeuce_Score_player1hasadvantage() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1´s score is incorrect!","player1 has advantage",score);
	}
	
	@Test
	public void testTennisGame_Player1Scores1_Score_15_love () throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1´s score is incorrect!","15 - love",score);
	}
	
	@Test
	public void testTennisGame_Player1AndPlayer2ScoresOneByOneFor5Times_Score_deuce() throws TennisGameException{
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
		game.player2Scored();

		//Act
		String score = game.getScore();
		//Assert
		assertEquals("deuce",score);
	}
	
	@Test
	public void testTennisGame_EachPlayerScores3_Score_deuce() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("deuce",score);
	}
	
	@Test
	public void testTennisGame_Player1AndPlayer2ScoresOneByOneFor5TimesThenPlayer2Scores2_Score_player2wins() throws TennisGameException{
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
		game.player2Scored();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("player2 wins",score);
	}
}
