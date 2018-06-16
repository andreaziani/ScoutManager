package table;

public class LCAnno {

	private String codiceLC;
	private String codiceIscritto;
	private int anno;
	
	public LCAnno(String codiceLC, String codiceIscritto, int anno) {
		super();
		this.codiceLC = codiceLC;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public String getCodiceLC() {
		return codiceLC;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public int getAnno() {
		return anno;
	}

	public void setCodiceLC(String codiceLC) {
		this.codiceLC = codiceLC;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}	
	
}
