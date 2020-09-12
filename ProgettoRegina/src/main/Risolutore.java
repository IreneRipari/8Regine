package main;

import parti.Colonna;
import parti.Diagonale;
import parti.Riga;
import parti.Scacchiera;

public class Risolutore {
	public static void main(String[] args) {

	Riga[] riga=new Riga[8];
	Colonna[] colonna=new Colonna[8];
	Diagonale[] diagAsc=new Diagonale[2 * 8 - 1];
	Diagonale[] diagDisc=new Diagonale[2 * 8 -1];
	Scacchiera scacchiera=new Scacchiera(riga,colonna,diagAsc,diagDisc);
	
	Task[] task = new Task[8];
	 
	 for (int col=0; col < 8; col++) {
		 (task[col] = new Task(col)).start();
	 }
	 int soluzioni = 0;
	 for (int col = 0; col < 8; col++) {
		 soluzioni += task[col].getSolutions();
	 }
	 System.out.println("Le soluzioni sono: " + soluzioni);
	 }
	
	
	 static class Task extends Thread {
		 private int col;
		 private int solutions;
	 
		 Task(int col) {
			 this.col = col;
		 }
	 
		 
		 public void run() {
			 colonna.isFree[col] = diagAsc.isFree[col] = diagDisc.isFree[col + 8 - 1] = true;
			 tryRow(1);
		 }
		 
	void tryRow(int r) {
		 for (int c = 0; c < 8; c++) {
		 if (!q[col] && !up[r + c] && !down[c - r + 8 - 1]) {
			 if (r == 8 - 1)
				 solutions++;
			 else {
				 q[c] = up[r + c] = down[c - r + 8 - 1] = true;
				 tryRow(r + 1);
				 q[c] = up[r + c] = down[c - r + 8 - 1] = false;
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
	 

}

