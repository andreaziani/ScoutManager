package table;

public class EG {
	
	private String codiceEG;
	private int et‡Iniziale;
	private int et‡Finale;
	
	public EG(String codiceEG, int et‡Iniziale, int et‡Finale) {
		super();
		this.codiceEG = codiceEG;
		this.et‡Iniziale = et‡Iniziale;
		this.et‡Finale = et‡Finale;
	}

	public String getCodiceEG() {
		return codiceEG;
	}

	public int getEt‡Iniziale() {
		return et‡Iniziale;
	}

	public int getEt‡Finale() {
		return et‡Finale;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

	public void setEt‡Iniziale(int et‡Iniziale) {
		this.et‡Iniziale = et‡Iniziale;
	}

	public void setEt‡Finale(int et‡Finale) {
		this.et‡Finale = et‡Finale;
	}

}
