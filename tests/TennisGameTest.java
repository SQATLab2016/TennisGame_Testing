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
	public void testTennisGame_player1Score () throws TennisGameException {
		// 15 - 0
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "15 - love", score);	
		
	}
	
	@Test
	public void testTennisGame_player2Score () throws TennisGameException {
		// 0 - 15
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - 15", score);	
		
	}
	
	@Test
	public void testTennisGame_player1ScoreTwo () throws TennisGameException {
		// 30 - love
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "30 - love", score);	
		
	}
	
	
	@Test
	public void testTennisGame_player2ScoreTwo () throws TennisGameException {
		// love - 30
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - 30", score);	
		
		
	}
	
	@Test
	public void testTennisGame_player2ScoreThree () throws TennisGameException {
		// love - 40
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - 40", score);	
		
		
	}
	
	@Test
	public void testTennisGame_player1ScoreThree () throws TennisGameException {
		// 40 - love
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "40 - love", score);	
		
	}

	
	
	@Test
	public void testTennisGame_player1Score_Player2Score () throws TennisGameException {
		// 15 - 15
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "15 - 15", score);	
		
	}
	
	@Test
	public void testTennisGame_player1ScoreTwo_Player2ScoreOne () throws TennisGameException {
		// 30 - 15
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "30 - 15", score);	
		
		
	}
	
	
	@Test
	public void testTennisGame_player1ScoreOne_Player2ScoreTwo () throws TennisGameException {
		// 15 - 30
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "15 - 30", score);	
		
	}
	
	
	
	
	@Test
	public void testTennisGame_player1ScoreTwo_Player2ScoreTwo () throws TennisGameException {
		// 30 - 30
		
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "30 - 30", score);	
		
	}
	
	@Test
	public void testTennisGame_player1ScoreThree_Player2ScoreTwo () throws TennisGameException {
		// 40 -30
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "40 - 30", score);	
		
	}
	

	@Test
	public void testTennisGame_player2ScoreThree_Player1ScoreTwo () throws TennisGameException {
		// 30 - 40
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "30 - 40", score);	
		
	}

	@Test
	public void testTennisGame_player1ScoreThree_Player2Scoreone () throws TennisGameException {
		// 40 -15
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "40 - 15", score);	
		
	}
	
	@Test
	public void testTennisGame_player1Scoreone_Player2Scoretwo () throws TennisGameException {
		// 15 - 40
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "15 - 40", score);	
		
	}
	
	@Test
	public void testTennisGame_player1ScoreThree_Player2ScoreThree () throws TennisGameException {
		// 40 - 40 
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "40 - 40", score);	
		
		
	}
	
	
	// "player1 has advantage"
	@Test
	public void testTennisGame_player1ScoreFour_Player2ScoreThree () throws TennisGameException {
		// 45 - 40 
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "player1 has advantage", score);	
		
		
	}
	
	
	
	
	
	
	
	// "player2 has advantage"
	@Test
	public void testTennisGame_player1ScoreThree_Player2ScoreFour () throws TennisGameException {
		// 40 - 45
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "player2 has advantage", score);	
	}
	
	// "player2 win !!"
	@Test
	public void testTennisGame_player1ScoreThree_Player2ScoreFive () throws TennisGameException {
		// 40 - 50
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "player2 wins", score);
	}
	
	// "player2 win !!"
		@Test
		public void testTennisGame_player1ScoreFive_Player2ScoreFour () throws TennisGameException {
			// 50 - 45
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player2Scored();
			game.player1Scored();
			game.player2Scored();
			game.player1Scored();
			game.player2Scored();
			game.player1Scored();
			game.player1Scored();
			String score = game.getScore() ;
			// Assert
			assertEquals("Initial score incorrect", "player1 wins", score);
		}
		
	
	
	@Test
	public void testTennisGame_player1ScoreFour_Player2ScoreTwo () throws TennisGameException {
		// Player 1 WIN
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "player1 wins", score);
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

}
