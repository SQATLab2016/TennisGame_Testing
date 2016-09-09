// This implementation is used for practicing unit tests. 
// NOTE THAT it may contain bugs
// Write unit tests in TennisGameTest.java and try to find the errors in the code

public class TennisGame {
	private int player1Points;
	private int player2Points;
	
	private boolean gameEnded;
	
	public TennisGame() {
		player1Points = 0;
		player2Points = 0;
		gameEnded = false ;
	}
	
	private void checkGameEnded() {
		if (player1Points>=4 && player1Points-player2Points>=2)
			gameEnded = true;
		else if (player2Points>=4 && player2Points-player1Points>=2)
			gameEnded = true;
	}
	
	private String getScore(int points) {
		switch (points)	{
		case 0: return "love";
		case 1: return "15" ;
		case 2: return "30" ;
		case 3: return "40";
		default: return "40" ;
		} 		
	}
	
	public void player1Scored() throws TennisGameException {
		if (gameEnded) {
			throw new TennisGameException();
		}
		else {
			player1Points++;
			checkGameEnded();
		}			
	}
	
	public void player2Scored() throws TennisGameException {
		if (gameEnded) {
			throw new TennisGameException();
		}
		else {
			player2Points++;
			checkGameEnded();
		}			
	}
	
	public String getScore() {
// Here is the format of the scores:
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
		
			String player1Score = getScore(player1Points);
			String player2Score = getScore(player2Points);
			
			if (gameEnded) {
				if (player1Points > player2Points)
					return "player1 wins";
				else
					return "player2 wins";
			}
			
			if (player1Points >= 3 && player1Points == player2Points) //correction made, it should be equal and greater than 3 instead of 4 using test case 'testTennisGame_EachPlayerWin3Points_Score_Deuce()'
																	 // By Aniqa Rehman - 9-9-2016
				return "deuce";
			
			if (player1Points >= 4 && player1Points - player2Points == 1)
				return "player1 has advantage";
			
			if (player2Points >= 4 && player2Points - player1Points == 1) //correction made, it should be equal and greater using test case 'testTennisGame_Player2hasAdvantage()'
																		 // By Aniqa Rehman - 9-9-2016
				return "player2 has advantage";							
			
			return  player1Score + " - " + player2Score ;   //correction made, it should be player1Score + " - " + player2Score instead of player2Score + " - " + player1Score
															// using test case 'testTennisGame_Score15_40()'
			 												// By Aniqa Rehman - 9-9-2016
	}
}