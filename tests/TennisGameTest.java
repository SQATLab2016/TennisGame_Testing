import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	private static final String PLAYER1_HAS_ADVANTAGE = "player1 has advantage";
	private static final String PLAYER2_HAS_ADVANTAGE = "player2 has advantage";
	private static final String PLAYER2_WINS = "player2 wins";
	private static final String PLAYER1_WINS = "player1 wins";
	TennisGame game;
	
	public TennisGameTest() {
		game = new TennisGame();
	}
	
	@Before
	public void init() {}
	
	private void createDeuce_PointsEachP(int p) throws TennisGameException {
		for (int i = 0; i < p; i++) {
			game.player1Scored();
			game.player2Scored();
		}
	}
	
	private void p1Scores(int times) throws TennisGameException {
		for (int i = 0; i < times; i++) {
			game.player1Scored();
		}
	}
	
	private void p2Scores(int times) throws TennisGameException {
		for (int i = 0; i < times; i++) {
			game.player2Scored();
		}
	}
	
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
		game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	/*
	 * Test for deuce
	 */
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		game = new TennisGame();
		
		p1Scores(3);
		
		p2Scores(3);
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin3Points_Deuce() throws TennisGameException {		
		p1Scores(3);
		p2Scores(3);
		
		String score = game.getScore();
		
		assertEquals("No deuce statement after 3 Points each", "deuce", score);
	}
	
	/*
	 * Test advantage situations
	 */
	
	@Test
	public void testTennisGame_P1Scores3Points_P2Scores4Points_AdvantageP2() throws TennisGameException {
		p1Scores(3);
		p2Scores(4);
		
		String score = game.getScore();
		
		assertEquals("Advantage statement incorrect", PLAYER2_HAS_ADVANTAGE, score);
	}
	
	@Test
	public void testTennisGame_P2Scores3Points_P1Scores4Points_AdvantageP1() throws TennisGameException {
		p2Scores(3);
		p1Scores(4);
		
		String score = game.getScore();
		
		assertEquals("Advantage statement incorrect", PLAYER1_HAS_ADVANTAGE, score);
	}
	
	
	/*
	 * Test win situations
	 */
	
	@Test
	public void testTennisGame_Player1Scores4Points_Player2Zero_P1Wins() throws TennisGameException {		
		p1Scores(4);
		
		String score = game.getScore();
		
		assertEquals("No win statement for P1", PLAYER1_WINS, score);
	}
	
	@Test
	public void testTennisGame_Player2Scores4Points_Player1Zero_P2Wins() throws TennisGameException {
		p2Scores(4);
		
		String score = game.getScore();
		
		assertEquals("No win statement for P2", PLAYER2_WINS, score);
	}
	
	@Test
	public void testTennisGame_Player1ScoresTwoPointsAfterDeuceWithFourPointsForEachP_P1Wins() throws TennisGameException {		
		createDeuce_PointsEachP(4);
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("No win statement for P1 after deuce", PLAYER1_WINS, score);
	}
	
	@Test
	public void testTennisGame_Player2ScoresTwoPointsAfterDeuceWithFourPointsForEachP_P2Wins() throws TennisGameException {		
		createDeuce_PointsEachP(4);
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("No win statement for P2 after deuce", PLAYER2_WINS, score);
	}
	
	@Test
	public void testTennisGame_P1Scores5PointsAfterOnlyP2Scored3Points_P1Wins() throws TennisGameException {		
		p2Scores(3);
		p1Scores(5);
		
		String score = game.getScore();
		
		assertEquals("No win statement", PLAYER1_WINS, score);
	}
	
	@Test
	public void testTennisGame_P2Scores5PointsAfterOnlyP1Scored3Points_P2Wins() throws TennisGameException {		
		p1Scores(3);
		p2Scores(5);
		
		String score = game.getScore();
		
		assertEquals("No win statement", PLAYER2_WINS, score);
	}
	
	
	/*
	 * Check error situations
	 */
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		game = new TennisGame();
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
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();
	}
	
}
