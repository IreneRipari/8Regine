package parti;

public class Scacchiera {
	private Riga[] righe;
	private Colonna[] colonne;
	private Diagonale[] diagonaliDisc;
	private Diagonale[] diagonaliAsc;
	
	public Scacchiera() {
		for(int i=0;i<7;i++) {
			this.righe[i].setNumero(i);
		}
		for(int i=0;i<7;i++) {
			this.colonne[i].setNumero(i);
		}
		for(int i=0;i<15;i++) {
			this.diagonaliAsc[i].setNumero(i);
		}
		for(int i=0;i<15;i++) {
			this.diagonaliDisc[i].setNumero(i);
		}
		
	}

	public Riga[] getRighe() {
		return righe;
	}

	public void setRighe(Riga[] righe) {
		this.righe = righe;
	}

	public Colonna[] getColonne() {
		return colonne;
	}

	public void setColonne(Colonna[] colonne) {
		this.colonne = colonne;
	}

	public Diagonale[] getDiagonaliDisc() {
		return diagonaliDisc;
	}

	public void setDiagonaliDisc(Diagonale[] diagonaliDisc) {
		this.diagonaliDisc = diagonaliDisc;
	}

	public Diagonale[] getDiagonaliAsc() {
		return diagonaliAsc;
	}

	public void setDiagonaliAsc(Diagonale[] diagonaliAsc) {
		this.diagonaliAsc = diagonaliAsc;
	}
	
	
	
}
