package main;

import java.util.Stack;

class Queen extends Thread {
	final int N = 8;
	private int posizionePrima;
	private Soluzioni soluzione;

	public Queen(int posizionePrima, Soluzioni soluzione) {
		this.posizionePrima = posizionePrima;
		this.soluzione = soluzione;
	}

	boolean isSafe(int board[][], int row, int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	boolean solveNQUtil(int board[][], int col) {

		if (col >= N)
			return true;

		for (int i = 0; i < N; i++) {

			if (isSafe(board, i, col)) {

				board[i][col] = 1;
				if (solveNQUtil(board, col + 1) == true)
					return true;

				board[i][col] = 0; // BACKTRACK
			}
		}

		return false;
	}

	boolean solveNQ() {
		int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
		board[posizionePrima][0] = 1;
		if (solveNQUtil(board, 1) == false) {
			System.out.print("Solution does not exist");
			return false;
		}
		addSolution(board);
		return true;
	}

	public void run() {
		solveNQ();
	}

	public boolean addSolution(int board[][]) {
		
		soluzione.addSolution(board,posizionePrima);
		
		return true;
	}

}
