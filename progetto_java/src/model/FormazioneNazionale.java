package model;

public class FormazioneNazionale {
	
	private String codiceEvento;
	private String codiceAttività;
	
	public FormazioneNazionale(String codiceEvento, String codiceAttività) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttività = codiceAttività;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceAttività() {
		return codiceAttività;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceAttività(String codiceAttività) {
		this.codiceAttività = codiceAttività;
	}	

}
