import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

	public void NewGame(){
		TennisGame game= new TennisGame();
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
	public void testTennisGame_deuce_at3points() throws TennisGameException{
		TennisGame game= new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score=game.getScore();
		assertEquals("Deuce score is incorrect","deuce",score);
		
	}
	
	@Test
	public void testTennisGame_Player2_adv() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score=game.getScore();
		assertEquals("Player2 adv is incorrect","player2 has advantage", score);
		
		
		
	}
	@Test
	public void testTennisGame_Player2win() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score= game.getScore();
		assertEquals("Player 2 did not win", "player2 wins", score);
		
	}
	
	@Test
	public void testTennisGame_Player2_scores() throws TennisGameException{
		TennisGame game= new TennisGame();
		
		game.player2Scored();
		String score = game.getScore();
		
		assertEquals("Player2 did not scores","love - 15",score);
		
	}
	
	@Test
	public void testTennisGame_Player1_scores() throws TennisGameException{
		TennisGame game= new TennisGame();
		
		game.player1Scored();
		String score = game.getScore();
		
		assertEquals("Player1 did not scores","15 - love",score);
		
	}
	
}