package table;

public class RegistrazioneEventoParrocchiaLC {
	
	private String codiceEvento;
	private String codiceIscritto;
	private String codiceParrocchia;
	private String codiceRegistrazione;
	
	public RegistrazioneEventoParrocchiaLC(String codiceEvento, String codiceIscritto, String codiceParrocchia,
			String codiceRegistrazione) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceIscritto = codiceIscritto;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceRegistrazione = codiceRegistrazione;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public String getCodiceRegistrazione() {
		return codiceRegistrazione;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceRegistrazione(String codiceRegistrazione) {
		this.codiceRegistrazione = codiceRegistrazione;
	}	

}
