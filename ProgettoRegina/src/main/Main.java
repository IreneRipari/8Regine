package main;

import java.io.IOException;
import parti.Colonna;
import parti.Diagonale;
import parti.Karalienes;
import parti.Regina;
import parti.Riga;
import parti.Scacchiera;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int n = 8;
		int maxThreads = 8;
		Karalienes.setMaxGSK(maxThreads);
		Karalienes queens = new Karalienes(n, 1, new int[n + 1]);
		long startedTime = System.currentTimeMillis();
		queens.start();
		queens.join();
		System.out.println("Solutions: " + Karalienes.getVariantuSkaiciu());
		System.out.println("Working time: " + (float) (System.currentTimeMillis() - startedTime) / 1000 + " s.");
	}
}
