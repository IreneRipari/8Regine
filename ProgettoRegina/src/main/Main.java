package main;

import java.io.IOException;
import parti.Colonna;
import parti.Diagonale;
import parti.Regina;
import parti.Riga;
import parti.Scacchiera;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

	int n=4;	
	Riga[] riga=new Riga[8];
	Colonna[] colonna=new Colonna[n];
	Diagonale[] diagAsc=new Diagonale[2 * n - 1];
	Diagonale[] diagDisc=new Diagonale[2 * n -1];
	Scacchiera scacchiera=new Scacchiera(riga,colonna,diagAsc,diagDisc);

	Regina[] regina = new Regina[n];
	 
	 for (int col=0; col < n; col++) {
		 (regina[col] = new Regina(col)).start();
	 }
	 int soluzioni = 0;
	 for (int col = 0; col < n; col++) {
		 soluzioni += regina[col].getSolutions();
	 }
	 System.out.println("Le soluzioni sono: " + soluzioni);
	 }
	
	
	 

}

