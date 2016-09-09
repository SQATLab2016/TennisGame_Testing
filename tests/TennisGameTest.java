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
	public void testTennisGame_player1ShouldHaveAdvantage() throws TennisGameException{
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
		
		String score = game.getScore();
		
		assertEquals("Player 1 Advantage not detected", "player1 has advantage", score);
		
	}
	
	@Test
	public void testTennisGame_player2ShouldHaveAdvantage() throws TennisGameException{
TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 2 Advantage not detected", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_player1ShouldWinWithPlayer2NotScoring() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 1 doesn't win.", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_player2ShouldWinWithPlayer1NotScoring() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 2 doesn't win.", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_player1ShouldWinWithPlayer2alsoScoring() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 1 doesn't win with player 2 also scoring.", "player1 wins", score);

	}
	
	@Test
	public void testTennisGame_player2ShouldWinWithPlayer1alsoScoring() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 2 doesn't win with player 1 also scoring.", "player2 wins", score);

	}
	
	@Test
	public void testTennisGame_player1ShouldScore1Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 1 didn't score 1 point.", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_player2ShouldScore1Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 2 didn't score 1 point.", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_player1ScoresHigherThanPlayer2() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Player 1 score is not higher than player 2", "30 - 15", score);
	}
}
