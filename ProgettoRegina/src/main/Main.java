package main;

import parti.Queen;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int n = 8;
		int[] places =  new int[n + 1];
		Queen queens = new Queen(n, 1, places);
		queens.start();
		queens.join();
		System.out.println("Solutions: " + Queen.getVariantuSkaiciu());
	}
}
