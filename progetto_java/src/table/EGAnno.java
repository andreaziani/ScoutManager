package table;

public class EGAnno {
	
	private String codiceEG;
	private String codiceIscritto;
	private int anno;
	
	public EGAnno(String codiceEG, String codiceIscritto, int anno) {
		super();
		this.codiceEG = codiceEG;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public String getCodiceEG() {
		return codiceEG;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public int getAnno() {
		return anno;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}	

}
