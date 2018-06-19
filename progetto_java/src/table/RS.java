package table;

public class RS {

	private String codiceRS;
	private int etàIniziale;
	private int etàFinale;
	
	public RS(String codiceRS, int etàIniziale, int etàFinale) {
		super();
		this.codiceRS = codiceRS;
		this.etàIniziale = etàIniziale;
		this.etàIniziale = etàIniziale;
	}

	public String getCodiceRS() {
		return codiceRS;
	}

	public int getEtàIniziale() {
		return etàIniziale;
	}

	public int getEtàFinale() {
		return etàFinale;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

	public void setEtàIniziale(int etàIniziale) {
		this.etàIniziale = etàIniziale;
	}

	public void setEtàFinale(int etàFinale) {
		this.etàFinale = etàFinale;
	}
	
}
