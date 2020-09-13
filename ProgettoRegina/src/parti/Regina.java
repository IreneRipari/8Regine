package parti;

public class Regina extends Thread {

	private int col;
	private int solutions;
	private boolean[] colonnaOccupata, diagAscOccupata, diagDiscOccupata;
	private static int n; 
		
	 public Regina(int col) {
		this.col = col;
		colonnaOccupata = new boolean[n];
		diagAscOccupata = new boolean[2 * n - 1];
		diagDiscOccupata = new boolean[2 * n -1];
	}

		public void run() {
			colonnaOccupata[col] = diagAscOccupata[col] = diagDiscOccupata[col + n - 1] = true;
			 tryRow(1);
		 }
		 
	void tryRow(int j) {
		 for (int i= 0; i < n; i++) {
		 if (!colonnaOccupata[col] && !diagAscOccupata[j + i] && !diagDiscOccupata[i - j + n - 1]) {
			 if (j == n - 1)
				 solutions++;
			 else {
				 colonnaOccupata[i] = diagAscOccupata[j+ i] = diagDiscOccupata[i - j + n - 1] = true;
				 tryRow(j + 1);
				 colonnaOccupata[i] = diagAscOccupata[j + i] = diagDiscOccupata[j - j + n - 1] = false;
			 }
		 	}	
		 }
		}
	 
	public int getSolutions() {
		 try {
			 join();
			 return solutions;
		 } 
		 catch (InterruptedException e) {
			 throw new RuntimeException("Internal task error\n");
		 }
		 
	}
	
	
	 
}
