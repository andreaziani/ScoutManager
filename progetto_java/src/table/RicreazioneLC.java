package table;

public class RicreazioneLC {
	
	private String codiceEvento;
	private String codiceParrocchia;
	private String codiceAttivit�;
	
	public RicreazioneLC(String codiceEvento, String codiceParrocchia, String codiceAttivit�) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceAttivit� = codiceAttivit�;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public String getCodiceAttivit�() {
		return codiceAttivit�;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceAttivit�(String codiceAttivit�) {
		this.codiceAttivit� = codiceAttivit�;
	}

}
