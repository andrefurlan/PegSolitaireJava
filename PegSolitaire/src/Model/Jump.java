package Model;

public class Jump {
	private int from;
	private int over;
	private int to;
	//public static final JUMPS 
	
	public Jump (int f, int o, int t) {
		this.from = f;
		this.over = o;
		this.to = t;
	}
	
	public int getFrom() {
		return from;
	}
	
	public int getOver() {
		return over;
	}
	
	public int getTo() {
		return to;
	}
	
}