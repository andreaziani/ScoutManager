package table;

public class Residenza {
	
	private String codiceParrocchia;
	private String citt�;
	
	public Residenza(String codiceParrocchia, String citt�) {
		this.codiceParrocchia = codiceParrocchia;
		this.citt� = citt�;
	}

	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getCitt�() {
		return this.citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}
	
	
	
}
