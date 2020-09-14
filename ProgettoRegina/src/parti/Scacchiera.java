package parti;

public class Scacchiera {
	private Riga[] righe;
	private Colonna[] colonne;
	private Diagonale[] diagonaliDisc;
	private Diagonale[] diagonaliAsc;

	public Scacchiera(Riga[] righe, Colonna[] colonne, Diagonale[] diagonaliDisc, Diagonale[] diagonaliAsc) {

		this.righe = righe;
		this.colonne = colonne;
		this.diagonaliAsc = diagonaliAsc;
		this.diagonaliDisc = diagonaliDisc;

		for (int i = 0; i < 8; i++) {
			righe[i] = new Riga();
			this.righe[i].setNumero(i);
		}
		for (int i = 0; i < 8; i++) {
			colonne[i] = new Colonna();
			this.colonne[i].setNumero(i);
		}
		for (int i = 0; i < 15; i++) {
			diagonaliAsc[i] = new Diagonale();
			this.diagonaliAsc[i].setNumero(i);
		}
		for (int i = 0; i < 15; i++) {
			diagonaliDisc[i] = new Diagonale();
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
