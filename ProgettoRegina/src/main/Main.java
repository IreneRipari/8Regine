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
	Colonna[] colonna=new Colonna[8];
	Diagonale[] diagAsc=new Diagonale[15];
	Diagonale[] diagDisc=new Diagonale[15];
	Scacchiera scacchiera=new Scacchiera(riga,colonna,diagAsc,diagDisc);

	Regina[] regina = new Regina[8];
	 
	 for (int col=0; col < 8; col++) {
		 (regina[col] = new Regina(col)).start();
	 }
	 int soluzioni = 0;
	 for (int col = 0; col < 8; col++) {
		 soluzioni += regina[col].getSolutions();
	 }
	 System.out.println("Le soluzioni sono: " + soluzioni);
	 }
	
	
	 

}

