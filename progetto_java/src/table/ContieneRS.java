package table;

public class ContieneRS {
	
	private String codiceRS;
	private String codiceParrocchia;
	
	public ContieneRS(String codiceRS, String codiceParrocchia) {
		super();
		this.codiceRS = codiceRS;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceRS() {
		return codiceRS;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
