/**
 * 
 */
/**
 * @author Andre Furlan
 *
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class PegSolitaire {
			
	private LinkedList<Board> nextBoards;
	private static final int[] INITIALPEGS = {0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1};
	private static int[] noPegs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private static final Board INITALBOARD = new Board(INITIALPEGS);
	private static Board solvedBoard = new Board(noPegs);
	private boolean solved;
	private List<Jump> JUMPS;
	private List<Jump> validJumps;
	
	public static void main(String[] args) {
		
		new PegSolitaire();
		int[] solvedPegs = solvedBoard.getPegs();
		if (solvedBoard.getPegs() != noPegs) {
			for (int i = 0; i < INITALBOARD.boardLength; i++) {
				System.out.println(solvedPegs[i]);	
			}
			System.out.println(INITALBOARD.boardLength);
		}	else {
				System.out.println("There is no solution.");
			}
	 }
	

	private PegSolitaire() {

		defineJUMP();
		nextBoards = new LinkedList<Board>();
		validJumps = new ArrayList<Jump>();
		nextBoards.add(INITALBOARD);
		solve(INITALBOARD);
		
	}
	
	private void defineJUMP() {

		JUMPS = new ArrayList<Jump>();
		JUMPS.add(new Jump(14, 13, 12));
		JUMPS.add(new Jump(13, 12, 11));
		JUMPS.add(new Jump(12, 13, 14));
		JUMPS.add(new Jump(12,  8,  5));
		JUMPS.add(new Jump(11, 12, 13));
		JUMPS.add(new Jump(10, 11, 12));
		JUMPS.add(new Jump(9,   8,  7));
		JUMPS.add(new Jump(8,   7,  6));
		JUMPS.add(new Jump(7,   8,  9));
		JUMPS.add(new Jump(6,   7,  8));
		JUMPS.add(new Jump(5,   9, 14));
		JUMPS.add(new Jump(5,   4,  3));
		JUMPS.add(new Jump(4,   8, 13));
		JUMPS.add(new Jump(3,   7, 12));
		JUMPS.add(new Jump(3,   4,  5));
		JUMPS.add(new Jump(2,   5,  9));
		JUMPS.add(new Jump(1,   4,  8));
		JUMPS.add(new Jump(0,   2,  5));
		JUMPS.add(new Jump(14,  9,  5));
		JUMPS.add(new Jump(13,  8,  4));
		JUMPS.add(new Jump(12, 11, 10));
		JUMPS.add(new Jump(12,  7,  3));
		JUMPS.add(new Jump(11,  7,  4));
		JUMPS.add(new Jump(10,  6,  3));
		JUMPS.add(new Jump(9,   5,  2));
		JUMPS.add(new Jump(8,   4,  1));
		JUMPS.add(new Jump(7,   4,  2));
		JUMPS.add(new Jump(6,   3,  1));
		JUMPS.add(new Jump(5,   8, 12));
		JUMPS.add(new Jump(5,   2,  0));
		JUMPS.add(new Jump(4,   7, 11));
		JUMPS.add(new Jump(3,   6, 10));
		JUMPS.add(new Jump(3,   1,  0));
		JUMPS.add(new Jump(2,   4,  7));
		JUMPS.add(new Jump(1,   3,  6));
		JUMPS.add(new Jump(0,   1,  3));
	}


	public void solve(Board board) {
		//board.updatePegs(onePeg);
		won(board);
		 if (solved) {
			 solvedBoard.updatePegs(board.getPegs());
			 nextBoards.clear();
		 }	else {
			solveListOfBoards();
		 	}
			
		}

	
	private void solveListOfBoards() {
		if (nextBoards.size() == 0) {
			solvedBoard.updatePegs(noPegs);
			return;
		} else {
			Board board = nextBoards.pollFirst();
			//removeBoard(board);
			getValidJumps(board);
			appendNextBoards(board);
			solve(board);
		}
	}

	private void removeBoard(Board board) {
		nextBoards.remove(board);
	}


	private void getValidJumps(Board board) {
		
		validJumps.clear();
		for (Jump next : JUMPS) {
			int from = next.getFrom();
			int to   = next.getTo();
			int over = next.getOver();
			
			int boardFrom = board.getPos(from);
			int boardOver = board.getPos(over);
			int boardTo   = board.getPos(to);

			if (boardFrom == 1 && boardOver == 1 && boardTo == 0) {		
				validJumps.add(next);
			}
		}
	}

	private void appendNextBoards(Board board) {
		
		for (Jump next : validJumps) {
			Board board2 = new Board(board.doJump(next));
			nextBoards.addFirst(board2);
			
		}
	}

	private void won(Board board) {
		int[] p = board.getPegs();
		int soma = 0;
		int i = 0;
		while(i < board.boardLength) {
			soma += p[i];
			i++;
		}
		solved = (soma == 1);
	}

	
}
	