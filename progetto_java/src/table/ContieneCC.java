package table;

public class ContieneCC {
	
	private String codiceCC;
	private String codiceParrocchia;
	
	public ContieneCC(String codiceCC, String codiceParrocchia) {
		super();
		this.codiceCC = codiceCC;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceCC() {
		return codiceCC;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceCC(String codiceCC) {
		this.codiceCC = codiceCC;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
