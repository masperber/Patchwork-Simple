
public class Game {
	
	private final int[] A = {12,1,14,29,4,27,30,20,16,11,17,31,25,2,13,9,23,21,28,6,8,24,7,10,18,3,26,32,19,5,22,15,0};
	private Player p1;
	private Player p2;
	private boolean p1Turn;
	private boolean inProgress;
	private Offer offer;
	
	public Game() {
		super();
		newGame();
	}
	
	public void newGame() {
		p1 = new Player();
		p2 = new Player();
		p1Turn = true;
		inProgress = true;
		offer = new Offer(A);
	}
	
	public String getStatus() {
		Piece piece1 = getOffer().peek(0);
		Piece piece2 = getOffer().peek(1);
		Piece piece3 = getOffer().peek(2);
		String result = "Player 1 \t\tPlayer 2"
		+ "\nMoney: " + getP1Money() + "\t\tMoney: " + getP2Money()
		+ "\nTime: " + getP1TimeRemaining() + " \t\tTime: " + getP2TimeRemaining()
		+ "\nSpaces: " + getP1UncoveredSpaces() + "\t\tSpaces: " + getP2UncoveredSpaces()
		+ "\nButtons: " + getP1Buttons() + "\t\tButtons: " + getP2Buttons()
		+ "\nScore: " + getP1Score() + "\t\tScore: " + getP2Score()
		+ "\n\nPlayer " + (isP1Turn() ? "1" : "2") + "'s turn"
		+ "\nOffer:"
		+ "\n\nPiece 1 \t\tPiece 2 \t\tPiece 3"
		+ "\nCost: " + piece1.getCost() + "  \t\tCost: " + piece2.getCost() + "  \t\tCost: " + piece3.getCost()
		+ "\nTime: " + piece1.getTime() + "   \t\tTime: " + piece2.getTime() + "   \t\tTime: " + piece3.getTime()
		+ "\nSpaces: " + piece1.getSpaces() + "\t\tSpaces: " + piece2.getSpaces() + "\t\tSpaces: " + piece3.getSpaces()
		+ "\nButtons: " + piece1.getButtons() + "\t\tButtons: " + piece2.getButtons() + "\t\tButtons: " + piece3.getButtons();
		
		return result;
	}

	public boolean isP1Turn() {
		return p1Turn;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public Offer getOffer() {
		return offer;
	}
	
	public int getP1Score() {
		return p1.getScore();
	}
	
	public int getP2Score() {
		return p2.getScore();
	}
	
	public int getP1Money() {
		return p1.getMoney();
	}
	
	public int getP2Money() {
		return p2.getMoney();
	}
	
	public int getP1TimeRemaining() {
		return p1.getTimeRemaining();
	}
	
	public int getP2TimeRemaining() {
		return p2.getTimeRemaining();
	}
	
	public int getP1UncoveredSpaces() {
		return p1.getUncoveredSpaces();
	}
	
	public int getP2UncoveredSpaces() {
		return p2.getUncoveredSpaces();
	}
	
	public int getP1Buttons() {
		return p1.getButtons();
	}
	
	public int getP2Buttons() {
		return p2.getButtons();
	}
	
	// player to move tries to buy piece at index b if possible
	// player to move flag is changed if they pass the other player
	public boolean buy(int b) {
		Piece p = offer.peek(b);						// get the piece to be purchased
		boolean result = false;							// assume purchase unsuccessful
		if(p1Turn) { 									// if it's p1's turn
			if(p1.placePiece(p)) { 						// p1 tries to buy the piece
				result = true;							// purchase successful
				offer.buy(b);
				if (p1.isDone() && p2.isDone())			// check if game is done
					inProgress = false;
				else if (p1.getTimeRemaining() < p2.getTimeRemaining())
					p1Turn = false;						// set player to move if necessary
			}
		} else if(p2.placePiece(p)) {				// else p2 tries to buy the piece
				result = true;							// purchase successful
				offer.buy(b);
				if (p1.isDone() && p2.isDone())			// check if game is done
					inProgress = false;
				else if (p2.getTimeRemaining() < p1.getTimeRemaining())
					p1Turn = true;						// set player to move if necessary		
		}
		
		return result;
	}
	
	// player to move advances one space past their opponent
	public void advance() {
		if(p1Turn) {
			if (p2.isDone())
				p1.advance(p1.getTimeRemaining());
			else
				p1.advance(p1.getTimeRemaining()-p2.getTimeRemaining()+1);
		} else {
			if (p1.isDone())
				p2.advance(p2.getTimeRemaining());
			else
				p2.advance(p2.getTimeRemaining()-p1.getTimeRemaining()+1);
		}
		
		if (p1.isDone() && p2.isDone())
			inProgress = false;
		else
			p1Turn = !p1Turn;
	}
}
