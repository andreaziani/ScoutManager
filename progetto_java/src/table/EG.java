package table;

public class EG {
	
	private String codiceEG;
	private int etàIniziale;
	private int etàFinale;
	
	public EG(String codiceEG, int etàIniziale, int etàFinale) {
		super();
		this.codiceEG = codiceEG;
		this.etàIniziale = etàIniziale;
		this.etàFinale = etàFinale;
	}

	public String getCodiceEG() {
		return codiceEG;
	}

	public int getEtaIniziale() {
		return etàIniziale;
	}

	public int getEtaFinale() {
		return etàFinale;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

	public void setEtaIniziale(int etàIniziale) {
		this.etàIniziale = etàIniziale;
	}

	public void setEtaFinale(int etàFinale) {
		this.etàFinale = etàFinale;
	}

}
