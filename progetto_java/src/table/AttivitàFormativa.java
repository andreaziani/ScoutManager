package table;

public class Attivit‡Formativa{

	private String codiceAttivit‡;
	private String descrizione;
	
	public Attivit‡Formativa(String codice, String descrizione) {
		this.codiceAttivit‡ = codice;
		this.descrizione = descrizione;
	}

	public String getCodiceAttivit‡() {
		return this.codiceAttivit‡;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setCodiceAttivit‡(String codiceAttivit‡) {
		this.codiceAttivit‡ = codiceAttivit‡;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
