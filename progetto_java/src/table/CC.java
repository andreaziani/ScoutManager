package table;

public class CC {

	private String codiceCC;
	private int etàIniziale;
	private int etàFinale;
	
	public CC(String codiceCC, int etàIniziale, int etàFinale) {
		super();
		this.codiceCC = codiceCC;
		this.etàIniziale = etàIniziale;
		this.etàFinale = etàFinale;
	}

	public String getCodiceCC() {
		return codiceCC;
	}

	public int getEtaIniziale() {
		return etàIniziale;
	}

	public int getEtaFinale() {
		return etàFinale;
	}

	public void setCodiceCC(String codiceCC) {
		this.codiceCC = codiceCC;
	}

	public void setEtaIniziale(int etàIniziale) {
		this.etàIniziale = etàIniziale;
	}

	public void setEtaFinale(int etàFinale) {
		this.etàFinale = etàFinale;
	}
	
}
