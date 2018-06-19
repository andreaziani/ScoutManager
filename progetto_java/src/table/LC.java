package table;

public class LC {

	private String codiceLC;
	private int etàIniziale;
	private int etàFinale;
	
	public LC(String codiceLC, int etàIniziale, int etàFinale) {
		super();
		this.codiceLC = codiceLC;
		this.etàIniziale = etàIniziale;
		this.etàIniziale = etàFinale;
	}

	public String getCodiceLC() {
		return codiceLC;
	}

	public int getEtàIniziale() {
		return etàIniziale;
	}

	public int getEtàFinale() {
		return etàFinale;
	}

	public void setCodiceLC(String codiceLC) {
		this.codiceLC = codiceLC;
	}

	public void setEtàIniziale(int etàIniziale) {
		this.etàIniziale = etàIniziale;
	}

	public void setEtàFinale(int etàFinale) {
		this.etàFinale = etàFinale;
	}
	
}
