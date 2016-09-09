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
	public void testTennisGame_Player1_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//This should cause the player1 to gain advantage
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 advantage incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//This should cause the player1 to gain advantage
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player2 advantage incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisgame_love_player1_and_player2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 and 2 love incorrect", "love - love", score);
	}
	
	@Test
	public void testTennisgame_fifteen_player1_and_player2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 and 2 score fifteen incorrect", "15 - 15", score);
	}
	
	@Test
	public void testTennisgame_thirty_player1_and_player2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 and 2 thirty incorrect", "30 - 30", score);
	}
	
	@Test
	public void testTennisgame_fourty_player1_and_player2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 and 2 fourty incorrect", "40 - 40", score);
	}
	
	@Test
	public void testTennisgame_player1_love_and_player2_fifteen() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 love and player2 fifteen incorrect", "love - 15", score);
	}
	
	@Test
	public void testTennisgame_player1_love_and_player2_thirty() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 love and player2 thirty incorrect", "love - 30", score);
	}
	
	@Test
	public void testTennisgame_player1_love_and_player2_forty() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 love and player2 forty incorrect", "love - 40", score);
	}
	
	@Test
	public void testTennisgame_player1_fifteen_and_player2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 fifteen and player2 love incorrect", "15 - love", score);
	}
	
	@Test
	public void testTennisgame_player1_thirty_and_player2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 thirty and player2 love incorrect", "30 - love", score);
	}
	
	@Test
	public void testTennisgame_player1_forty_and_player2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 forty and player2 love incorrect", "40 - love", score);
	}
	
	@Test
	public void testTennisgame_player1_wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player1 wins incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisgame_player2_wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Player2 wins incorrect", "player2 wins", score);
	}
	
	
	
}
