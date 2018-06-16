package table;

public class Residenza {
	
	private String codiceParrocchia;
	private String città;
	
	public Residenza(String codiceParrocchia, String città) {
		this.codiceParrocchia = codiceParrocchia;
		this.città = città;
	}

	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getCittà() {
		return this.città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}
	
	
	
}
