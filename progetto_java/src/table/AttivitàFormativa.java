package table;

public class AttivitàFormativa{

	private String codiceAttività;
	private String descrizione;
	
	public AttivitàFormativa(String codice, String descrizione) {
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
