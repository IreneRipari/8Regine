package parti;

public class Casella {
	private boolean isFree;
	private int idRiga;
	private int idColonna;

	public Casella() {
		this.isFree = true;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getIdRiga() {
		return idRiga;
	}

	public void setIdRiga(int idRiga) {
		this.idRiga = idRiga;
	}

	public int getIdColonna() {
		return idColonna;
	}

	public void setIdColonna(int idColonna) {
		this.idColonna = idColonna;
	}
	
	
}
