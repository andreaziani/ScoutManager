package table;

public class RegistrazioneEventoNazionale {
	
	private String codiceEvento;
	private String codiceIscritto;
	private String codiceRegistrazione;
	
	public RegistrazioneEventoNazionale(String codiceEvento, String codiceIscritto, String codiceRegistrazione) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceIscritto = codiceIscritto;
		this.codiceRegistrazione = codiceRegistrazione;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
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

	public void setCodiceRegistrazione(String codiceRegistrazione) {
		this.codiceRegistrazione = codiceRegistrazione;
	}	
 
}
