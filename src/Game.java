
public class Game {
	
	private int[] a = {15,20,27,32,9,29,1,12,3,6,23,22,26,31,18,5,16,7,28,8,14,24,10,19,17,30,13,25,2,11,21,4,0};
	private Player p1;
	private Player p2;
	private boolean p1Turn;
	private boolean inProgress;
	private Offer offer;
	
	public Game() {
		super();
		p1 = new Player();
		p2 = new Player();
		p1Turn = true;
		inProgress = true;
		offer = new Offer(a);
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
