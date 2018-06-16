package table;

public class RS {

	private String codiceRS;
	private int et‡Iniziale;
	private int et‡Finale;
	
	public RS(String codiceRS, int et‡Iniziale, int et‡Finale) {
		super();
		this.codiceRS = codiceRS;
		this.et‡Iniziale = et‡Iniziale;
		this.et‡Finale = et‡Finale;
	}

	public String getCodiceRS() {
		return codiceRS;
	}

	public int getEt‡Iniziale() {
		return et‡Iniziale;
	}

	public int getEt‡Finale() {
		return et‡Finale;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

	public void setEt‡Iniziale(int et‡Iniziale) {
		this.et‡Iniziale = et‡Iniziale;
	}

	public void setEt‡Finale(int et‡Finale) {
		this.et‡Finale = et‡Finale;
	}
	
}
