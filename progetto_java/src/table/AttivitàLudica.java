package table;

public class AttivitàLudica {

	private String codiceAttività;
	private String descrizione;
	
	public AttivitàLudica(String codice, String descrizione) {
		this.codiceAttività = codice;
		this.descrizione = descrizione;
	}

	public String getCodiceAttivita() {
		return this.codiceAttività;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setCodiceAttivita(String codiceAttività) {
		this.codiceAttività = codiceAttività;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
