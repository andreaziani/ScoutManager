package table;

public class ContieneEG {
	
	private String codiceEG;
	private String codiceParrocchia;
	
	public ContieneEG(String codiceEG, String codiceParrocchia) {
		super();
		this.codiceEG = codiceEG;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceEG() {
		return codiceEG;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
