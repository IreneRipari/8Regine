package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Soluzioni soluzione= new Soluzioni();
		Queen[] queen = new Queen[8];
		List<Queen> threadList =  new ArrayList<Queen>();
		int threadId = 0;
		
		for (int i = 0; i < 8; i++) {
			queen[i] = new Queen(i,soluzione);
			queen[i].start();
			threadList.add(queen[i]);
			threadId++;
		}
		for(Queen q : threadList) {
			try {
				q.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		soluzione.mostraSoluzioni();

	}
}
