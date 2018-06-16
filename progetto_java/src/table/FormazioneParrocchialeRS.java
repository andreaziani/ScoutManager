package table;

public class FormazioneParrocchialeRS {

	private String codiceEvento;
	private String codiceAttivit�;
	private String codiceParrocchia;
	
	public FormazioneParrocchialeRS(String codiceEvento, String codiceAttivit�, String codiceParrocchia) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttivit� = codiceAttivit�;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceAttivit�() {
		return codiceAttivit�;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceAttivit�(String codiceAttivit�) {
		this.codiceAttivit� = codiceAttivit�;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}
	
}
