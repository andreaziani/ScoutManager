package table;

public class FormazioneNazionale {
	
	private String codiceEvento;
	private String codiceAttivit�;
	
	public FormazioneNazionale(String codiceEvento, String codiceAttivit�) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttivit� = codiceAttivit�;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceAttivit�() {
		return codiceAttivit�;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceAttivit�(String codiceAttivit�) {
		this.codiceAttivit� = codiceAttivit�;
	}	

}
