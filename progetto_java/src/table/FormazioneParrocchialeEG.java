package table;

public class FormazioneParrocchialeEG {
	
	private String codiceEvento;
	private String codiceAttività;
	private String codiceParrocchia;
	
	public FormazioneParrocchialeEG(String codiceEvento, String codiceAttività, String codiceParrocchia) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttività = codiceAttività;
		this.codiceParrocchia = codiceParrocchia;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceAttività() {
		return codiceAttività;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceAttività(String codiceAttività) {
		this.codiceAttività = codiceAttività;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}
	
}
