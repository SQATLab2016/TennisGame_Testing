import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameException extends Exception {
	
	
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
		public void testTennisGame_Player1Win3Points_Score_40_love() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "40 - love", score);		
		}	
		
		@Test
		public void testTennisGame_EahcPlayerWin1Points_Score_15_15() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "15 - 15", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win3Points_Score_40_30() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "40 - 30", score);		
		}
		
		@Test
		public void testTennisGame_EachPlayerWin3Points_Score_Deuce1() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "deuce", score);		
		}
		
		@Test
		public void testTennisGame_EachPlayerWin3Points_Score_Deuce2() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();			
			game.player2Scored();

			game.player1Scored();			
			game.player2Scored();
			
			game.player1Scored();			
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "deuce", score);		
		}
		
		@Test
		public void testTennisGame_EachPlayerWin3Points_Score_Deuce3() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
					
			game.player2Scored();
			
			game.player2Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player1Scored();
			
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "deuce", score);		
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
		public void testTennisGame_EachPlayerWin5Points_Score_Deuce() throws TennisGameException {
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
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "deuce", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win4Points_Score_Player1HasAdv() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 has advantage", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win5Points_Score_Player1HasAdv() throws TennisGameException {
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
			
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 has advantage", score);		
		}
		
		@Test
		public void testTennisGame_Player2Win4Points_Score_Player2HasAdv() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player2 has advantage", score);		
		}
		
		@Test
		public void testTennisGame_Player2Win5Points_Score_Player2HasAdv() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			game.player2Scored();
			game.player1Scored();
			
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player2 has advantage", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win4Points_Score_Player1Wins1() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 wins", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win4Points_Score_Player1Wins2() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 wins", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win5Points_Score_Player1Wins() throws TennisGameException {
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
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 wins", score);		
		}
		
		@Test
		public void testTennisGame_Player1Win6Points_Score_Player1Wins() throws TennisGameException {
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
			
			game.player1Scored();
			game.player1Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player1 wins", score);		
		}
		
		@Test
		public void testTennisGame_Player2Win4Points_Score_Player2Wins() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player2 wins", score);		
		}
		
		@Test
		public void testTennisGame_Player2Win5Points_Score_Player2Wins() throws TennisGameException {
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
			String score = game.getScore() ;
			// Assert
			assertEquals("Tie score incorrect", "player2 wins", score);		
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
