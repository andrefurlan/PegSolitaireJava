/**
 * 
 */
/**
 * @author Andre Furlan
 *
 */
package Model;

public class Board {

	public final int boardLength = 15;
	private int[] pegs;
	
	public Board (int[] b) {
		this.pegs = b;
	}
	
	int[] getPegs () {
		return pegs;
	}
	public int getPos(int p) {
		int[] peg = this.getPegs();
		return peg[p];
	}
	public void updatePegs (int[] newPegs) {
		this.pegs = newPegs;
		
	}
	public int[] doJump(Jump next) {
		final int[]  peg = this.getPegs(); 
		int from = next.getFrom();
		int to   = next.getTo();
		int over = next.getOver();
		
		int[] peg1 = peg.clone();
		peg1[from] = 0;
		peg1[over] = 0;
		peg1[to]   = 1;
		
		return peg1;
		
	}					
}
	