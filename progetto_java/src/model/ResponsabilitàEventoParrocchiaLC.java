package model;

public class ResponsabilitàEventoParrocchiaLC {
	
	private String codiceEvento;
	private String codiceParrocchia;
	private String codiceResponsabile;
	
	public ResponsabilitàEventoParrocchiaLC(String codiceEvento, String codiceParrocchia, String codiceResponsabile) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceResponsabile = codiceResponsabile;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public String getCodiceResponsabile() {
		return codiceResponsabile;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceResponsabile(String codiceResponsabile) {
		this.codiceResponsabile = codiceResponsabile;
	}	

}
