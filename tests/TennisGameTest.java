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
	
	@Test
	public void testTennisGame_Player1WinsAfterDeuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();		
		//Situation now is deuce
		
		game.player1Scored();	
		//Advantage to player 1
		
		game.player1Scored();
		//Player 1 wins
		
		String score = game.getScore();
		//Assert
		assertEquals("Win after deuce incorrect" ,"player1 wins", score);		
	}
	
	@Test
	public void testTennisGame_SituationLoveLove() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//No acting because we want to test situation before any points are played
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation love-love", "love - love", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Situation now is deuce
		
		game.player1Scored();
		//Advantage to player 1
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation player1 has advantage", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1_15_Player2_Love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		//Situation 15 - love
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation 15 - love", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1AdvantageAfterTwoDeuces() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Situation is now deuce
		
		game.player1Scored();
		game.player2Scored();
		//Situation is again deuce
		
		game.player1Scored();
		//Advantage to player 1
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation player1 has advantage after two deuces", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsLoveGame() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Win for player 1
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect after player 1 wins lovegame", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsLoveGame() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect after player 2 wins lovegame", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1_Love_Player2_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation love - 15", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1_15_Player2_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation 15 - 30", "15 - 30", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer2Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Situation is now deuce
		
		game.player2Scored();
		//Advantage to player 2
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation player2 has advantage", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer2AdvantageAfterTwoDeuces() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Situation is now deuce
		
		game.player2Scored();
		game.player1Scored();
		//Situation is again deuce
		
		game.player2Scored();
		//Advantage to player 2
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation player2 has advantage after two deuces", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_SituationPlayer1_15_Player2_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore();
		//Assert
		assertEquals("Score printing incorrect in situation 15 - 40", "15 - 40", score);
	}
}