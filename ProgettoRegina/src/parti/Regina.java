package parti;

public class Regina {
	private int id;
	private static Casella posizione;
	private Scacchiera scacchiera;
	
	public Regina(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Casella getPosizione() {
		return posizione;
	}

	public static void setPosizione(Casella posizione) {
		Regina.posizione = posizione;
	}
	
	
	
	
	
}
