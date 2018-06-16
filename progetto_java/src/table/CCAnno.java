package table;

public class CCAnno {
	
	private String codiceCC;
	private String codiceIscritto;
	private int anno;
	
	public CCAnno(String codiceCC, String codiceIscritto, int anno) {
		super();
		this.codiceCC = codiceCC;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public String getCodiceCC() {
		return codiceCC;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public int getAnno() {
		return anno;
	}

	public void setCodiceCC(String codiceCC) {
		this.codiceCC = codiceCC;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}	

}
