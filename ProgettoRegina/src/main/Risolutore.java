package main;

import parti.Scacchiera;

public class Risolutore {
	public static void main(String[] args) {

	Scacchiera scacchiera=new Scacchiera();
	
	Task[] task = new Task[8];
	 
	 for (int col = 0; col < 8; col++) {
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
		 private boolean[] q, up, down;
		 private int solutions;
	 
		 Task(int col) {
			 this.col = col;
			 q = new boolean[8];
			 up = new boolean[2 * 8 - 1];
			 down = new boolean[2 * 8 -1];
		 }
	 
	 public void run() {
		 q[col] = up[col] = down[col + 8 - 1] = true;
		 tryRow(1);
		 }
		 
	 void tryRow(int r) { ... }
	 
	 
	public int getSolutions() {
		 try {
			 join();
			 return solutions;
		 } 
		 catch (InterruptedException e) {
			 throw new RuntimeException("Internal task error\n");
		 }
		 
	}
	static void tryRow(int r) {
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
	 }
	 

}

