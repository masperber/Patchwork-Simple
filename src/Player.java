
public class Player {
	
	private final int STARTINGMONEY = 5;
	private final int STARTINGSPACES = 81;
	private final int STARTINGTIME = 53;
	
	private int money;
	private int uncoveredSpaces;
	private int buttons;
	private int timeRemaining;
	private boolean done;
	
	public Player() {
		super();
		money = STARTINGMONEY;
		uncoveredSpaces = STARTINGSPACES;
		buttons = 0;
		timeRemaining = STARTINGTIME;
		done = false;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getUncoveredSpaces() {
		return uncoveredSpaces;
	}
	
	public int getButtons() {
		return buttons;
	}
	
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public int getScore() {
		return (money - uncoveredSpaces * 2);
	}
	
	public void awardSpecialPatch() {
		uncoveredSpaces--;
	}
	
	public boolean placePiece(Piece piece) {
		if(money >= piece.getCost() && uncoveredSpaces >= piece.getSpaces()) {
			money -= piece.getCost(); 				// pay cost of piece
			uncoveredSpaces -= piece.getSpaces(); 	// cover spaces
			buttons += piece.getButtons(); 			// get buttons
			if ((timeRemaining - 1) / 6 > (timeRemaining - piece.getTime() - 1) / 6)
				payout(); 							// payout if button crossed
			timeRemaining -= piece.getTime(); 		// advance time
			if (timeRemaining < 0)
				timeRemaining = 0;
			if (timeRemaining == 0) {
				payout(); 							// payout if out of time
				done = true;
			}
			return true;
		} else
			return false;
	}
	
	public boolean advance(int a) {
		if(timeRemaining >= a) {
			money += a; // gain money
			if ((timeRemaining - 1) / 6 > (timeRemaining - a - 1) / 6)
				payout(); // payout if button crossed
			timeRemaining -= a; // advance time
			if (timeRemaining == 0) {
				payout(); // payout if out of time
				done = true;
			}
			return true;
		} else
			return false;
	}
	
	public int payoutsLeft() {
		if (!done)
			return((timeRemaining - 1) / 6) + 1;
		else 
			return 0;
	}
	
	private void payout() {
		money += buttons;
	}
}
