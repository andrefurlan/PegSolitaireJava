/**
 * 
 */
/**
 * @author Andre Furlan
 *
 */
package Model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Board {

		private static int[] solvedBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		private static List<Board> nextBoards;
		
		public static int[] solve(int[] initialBoard) {
			
			 //int[] solvedBoard = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
			
						
			 if (won(initialBoard) == true) {
				 solvedBoard = initialBoard;
			 }	else {
				 solvedBoard = solveListOfBoards(initialBoard);
			 	}
			 	
			return solvedBoard;
		}

		
		
		
		private static int[] solveListOfBoards(int[] initialBoard) {
			// TODO Auto-generated method stub
			int[] solvedBoard = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
			
			nextBoards = new ArrayList<Board>();
			getNextBoards(initialBoard);
			
			return solvedBoard;
		}




		private static Object getNextBoards(int[] initialBoard) {
			// TODO Auto-generated method stub
			return null;
		}




		private static boolean won(int[] initialBoard) {
			
			int soma = 0;
			int i = 0;
			while(i < initialBoard.length) {
				soma += initialBoard[i];
				i++;
			}
			
			return (soma == 1);
		}
		
		
		
		
		
	}
	