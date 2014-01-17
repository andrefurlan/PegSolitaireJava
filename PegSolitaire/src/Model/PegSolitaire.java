/**
 * 
 */
/**
 * @author Andre Furlan
 *
 */
package Model;


	public class PegSolitaire {
		
		
		public static int[] initialBoard = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		//public static int[] initialBoard = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		public static void main(String[] args) {
			int[] solvedBoard = Board.solve(initialBoard);
			for (int i = 0; i < initialBoard.length; i++) {
				System.out.println(solvedBoard[i]);	
			}	
			 
		 }
		 

		 
		 
		
	}
	