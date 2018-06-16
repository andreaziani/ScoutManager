package table;

public class RSAnno {

	private String codiceRS;
	private String codiceIscritto;
	private int anno;
	
	public RSAnno(String codiceRS, String codiceIscritto, int anno) {
		super();
		this.codiceRS = codiceRS;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public String getCodiceRS() {
		return codiceRS;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public int getAnno() {
		return anno;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}	
	
}
