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
	public void testTennisGame_15Love() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score incorrect", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_30Love() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score incorrect", "30 - love", score);
	}
	
	@Test
	public void testTennisGame_40Love() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score incorrect", "40 - love", score);
		}
	
	@Test
	public void testTennisGame_Love15() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score incorrect", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_3015() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score incorrect", "30 - 15", score);
	}
	
	
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
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException{
	//Arrange
	TennisGame game = new TennisGame();
	//Act
	game.player2Scored();
	game.player2Scored();
	game.player2Scored();
	game.player2Scored();
	//Act
	//This statement should cause an exception
	game.player2Scored();
	}
	@Test
	public void testTennisGame_Player1WinsWithTheAdvantage() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();	
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//the game should be on deuce now
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Tie score incorrect", "player1 wins", score);
		
	}
	public void testTennisGame_Player2WinsByTakingPlayer1AdvantageAndScoring() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//the game should be on deuce now
		game.player1Scored();
		//player1 gets the advantage, player2 takes it
		game.player2Scored();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Tie score incorrect", "player2 wins", score);
	}
	public void testTennisGame_PlayersKeepTakingtheAdvantage() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//the game should be on deuce now
		game.player1Scored();
		//player1 gets the advantage, player2 takes it
		game.player2Scored();
		game.player2Scored();
		//player2 gets the advantage, player1 takes it
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Tie score incorrect", "players takes the advantage", score);
	}
}
