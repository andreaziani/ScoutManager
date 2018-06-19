package table;

public class RicreazioneEG {
	
	private String codiceEvento;
	private String codiceParrocchia;
	private String codiceAttività;
	
	public RicreazioneEG(String codiceEvento, String codiceParrocchia, String codiceAttività) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceAttività = codiceAttività;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public String getCodiceAttività() {
		return codiceAttività;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceAttività(String codiceAttività) {
		this.codiceAttività = codiceAttività;
	}

}
