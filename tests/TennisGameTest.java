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
	
	@Test
	public void testTennisGame_Player1Win5Points_Player2Win4points_Score_player1_has_advantage() throws TennisGameException {
		
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
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "player1 has advantage", score);	
	}
	
	@Test
	public void testTennisGame_Player2Win5Points_Player1Win4points_Score_player2_has_advantage() throws TennisGameException {
		
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
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "player2 has advantage", score);	
	}
	
	@Test
	public void testTennisGame_Player2Win4Points_Player1Win3points_Score_player2_has_advantage() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "player2 has advantage", score);	
	}
	
	@Test
	public void testTennisGame_NoPointsForEachPlayer_score_love_love() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "love - love", score);	
	}
	
	
	
	@Test
	public void testTennisGame_Player1WinPoint_Player2NoPoints_Score_15_love() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
	
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "15 - love", score);	
	}
	
	@Test
	public void testTennisGame_Player1Win2Point_Player2NoPoints_Score_30_love() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
	
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "30 - love", score);	
	}

	@Test
	public void testTennisGame_Player2WinPoint_Player1NoPoints_Score_love_15() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player2Scored();
	
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "love - 15", score);	
	}
	
	@Test
	public void testTennisGame_EachPlayerWinOnePoint_Score_15_15() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
	
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "15 - 15", score);	
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
