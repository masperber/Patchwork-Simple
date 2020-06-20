
public class Piece {
	
	private int cost;
	private int time;
	private int spaces;
	private int buttons;
	
	public Piece(int cost, int time, int spaces, int buttons) {
		super();
		this.cost = cost;
		this.time = time;
		this.spaces = spaces;
		this.buttons = buttons;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getSpaces() {
		return spaces;
	}
	
	public int getButtons() {
		return buttons;
	}
	
}
