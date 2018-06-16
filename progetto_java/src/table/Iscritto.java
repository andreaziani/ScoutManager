package table;

public class Iscritto {
	
	private String codiceIscritto;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String luogoNascita;
	private String numTelefono;
	
	public Iscritto(String codiceIscritto, String codiceFiscale, String nome, String cognome, String dataNascita,
			String luogoNascita, String numTelefono) {
		super();
		this.codiceIscritto = codiceIscritto;
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.numTelefono = numTelefono;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	
}
