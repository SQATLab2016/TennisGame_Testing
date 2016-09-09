import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

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
	private static final String PLAYER1_WINS = "player1 wins";
	private static final String PLAYER1_HAS_ADVANTAGE = "player1 has advantage";
	
	public TennisGame game = new TennisGame();
	

	
	@Before 
	public void test_PlayTillDeuce() throws TennisGameException {

		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
	
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		
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
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {

		//Act
		
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;

		// Assert
		assertEquals("player1 has advantage", PLAYER1_HAS_ADVANTAGE, score);
	}
}
