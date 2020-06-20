import java.util.ArrayList;

public class Offer {
	
	private ArrayList<Piece> offer;
	
	public Offer(int[] setup) {
		offer = new ArrayList<Piece>();
		for(int i : setup) {
			offer.add(pieceKey(i));
		}
	}
	
	public ArrayList<Piece> viewOffer() {
		return offer;
	}
	
	public Piece peek(int b) {
		return offer.get(b);
	}
	
	public Piece buy(int b) {
		if (b == 0)
			return (offer.remove(0));
		else if (b == 1) {
			offer.add(offer.remove(0));
			return (offer.remove(0));
		} else if (b == 2) {
			offer.add(offer.remove(0));
			offer.add(offer.remove(0));
			return (offer.remove(0));
		} else return null;
	}
	
	private Piece pieceKey(int i) {
		if (i == 0)
			return new Piece (2,1,2,0);
		else if (i == 1)
			return new Piece (1,3,3,0);
		else if (i == 2)
			return new Piece (2,2,3,0);
		else if (i == 3)
			return new Piece (3,1,3,0);
		else if (i == 4)
			return new Piece (2,2,4,0);
		else if (i == 5)
			return new Piece (2,2,5,0);
		else if (i == 6)
			return new Piece (1,2,5,0);
		else if (i == 7)
			return new Piece (4,2,6,0);
		else if (i == 8)
			return new Piece (1,2,6,0);
		else if (i == 9)
			return new Piece (2,1,6,0);
		else if (i == 10)
			return new Piece (2,3,7,0);
		else if (i == 11)
			return new Piece (3,2,4,1);
		else if (i == 12)
			return new Piece (3,3,4,1);
		else if (i == 13)
			return new Piece (4,2,4,1);
		else if (i == 14)
			return new Piece (2,3,5,1);
		else if (i == 15)
			return new Piece (3,4,5,1);
		else if (i == 16)
			return new Piece (7,1,5,1);
		else if (i == 17)
			return new Piece (0,3,6,1);
		else if (i == 18)
			return new Piece (1,5,6,1);
		else if (i == 19)
			return new Piece (1,4,7,1);
		else if (i == 20)
			return new Piece (5,3,8,1);
		else if (i == 21)
			return new Piece (4,6,4,2);
		else if (i == 22)
			return new Piece (5,4,4,2);
		else if (i == 23)
			return new Piece (6,5,4,2);
		else if (i == 24)
			return new Piece (5,5,5,2);
		else if (i == 25)
			return new Piece (10,3,5,2);
		else if (i == 26)
			return new Piece (3,6,6,2);
		else if (i == 27)
			return new Piece (7,2,6,2);
		else if (i == 28)
			return new Piece (7,4,6,2);
		else if (i == 29)
			return new Piece (7,6,4,3);
		else if (i == 30)
			return new Piece (10,4,5,3);
		else if (i == 31)
			return new Piece (8,6,6,3);
		else if (i == 32)
			return new Piece (10,5,6,3);
		else return null;
	}
}
