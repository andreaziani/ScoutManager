package table;

public class ContieneLC {
	
	private String codiceLC;
	private String codiceParrocchia;
	
	public ContieneLC(String codiceLC, String codiceParrocchia) {
		super();
		this.codiceLC = codiceLC;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceLC() {
		return codiceLC;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceLC(String codiceLC) {
		this.codiceLC = codiceLC;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
