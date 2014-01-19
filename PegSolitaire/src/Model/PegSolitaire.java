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


public class PegSolitaire {
		
	
	//Initial Board
	public static final int[] initialBoard = 
		{0, 
		1, 1, 
		1, 1, 1, 
		1, 1, 1, 1, 
		1, 1, 1, 1, 1};
	public static List<int[]> nextBoards;
	//public static int[] solvedBoard = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		
	public static void main(String[] args) {
		
		int[] solvedBoard = solve(initialBoard);
		for (int i = 0; i < initialBoard.length; i++) {
			System.out.println(solvedBoard[i]);	
		}	
	 }
		
	public static int[] solve(int[] board) {
			
		int[] solvedBoard = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		 if (won(board) == true) {
			 solvedBoard = board;
		 }	else {
			 solvedBoard = solveListOfBoards(board);
		 	}	 	
			return solvedBoard;
		}

		
		private static int[] solveListOfBoards(int[] initialBoard) {
			// TODO Auto-generated method stub
			int[] solvedBoard = {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
			List<int[]> nextBoards = new ArrayList<int[]>();
			//Board nextBoard = {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
			//nextBoards = new List<>();
			//getNextBoards(initialBoard);
			
			//nextBoards.add(board.nextBoard);
			
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
	