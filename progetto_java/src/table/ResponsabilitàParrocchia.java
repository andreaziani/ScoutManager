package table;

public class ResponsabilitàParrocchia {
	
	private String codiceParrocchia;
	private String codiceResponasbile;
	
	public ResponsabilitàParrocchia(String codiceParrocchia, String codiceResponasbile) {
		this.codiceParrocchia = codiceParrocchia;
		this.codiceResponasbile = codiceResponasbile;
	}

	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getCodiceResponasbile() {
		return this.codiceResponasbile;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceResponasbile(String codiceResponasbile) {
		this.codiceResponasbile = codiceResponasbile;
	}
	
	
	
	
	
	

}
