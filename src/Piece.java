
public class Piece {
	
	private int cost;
	private int time;
	private int spaces;
	private int buttons;
	private int id;
	
	public Piece(int cost, int time, int spaces, int buttons, int id) {
		super();
		this.cost = cost;
		this.time = time;
		this.spaces = spaces;
		this.buttons = buttons;
		this.id = id;
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
	
	public int getId() {
		return id;
	}
	
}
