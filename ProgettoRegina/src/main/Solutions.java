package main;

import java.util.ArrayList;
import java.util.List;

public  class Solutions {
	private List<int [][]> solution;

	public Solutions() {
		solution = new ArrayList<int [][]>();
	}

	public boolean addSolution(int [][] board) {
		 
			solution.add(board);
			return true;
		
		
		
	}

	public int getSize() {
		return solution.size();
	}
	public void showSolutions() {
		for (int[][] is : solution) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(is[i][j]+" ");
				}
				System.out.println("");
			}
			System.out.println("\n\n\n");
		}
	}
	
	
}
