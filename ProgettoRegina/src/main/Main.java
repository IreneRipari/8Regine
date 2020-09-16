package main;

public class Main {
	public static void main(String[] args) {
		Soluzioni soluzione= new Soluzioni();
		Queen[] queen = new Queen[8];
		for (int i = 0; i < 8; i++) {
			queen[i] = new Queen(i,soluzione);
			queen[i].start();
		}
		while (soluzione.getSize()!=8) {
			
		}
		soluzione.mostraSoluzioni();

	}
}
