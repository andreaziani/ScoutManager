package table;

import java.sql.Connection;

public class ResponsabileEventoNazionale {
	
	private String codiceResponsabile;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String luogoNascita;
	private String numTelefono;
	private String username;
	private String password;
	
	public ResponsabileEventoNazionale(String codiceResponsabile, String codiceFiscale, String nome, String cognome,
			String dataNascita, String luogoNascita, String numTelefono, String username, String password) {
		this.codiceResponsabile = codiceResponsabile;
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.numTelefono = numTelefono;
		this.username = username;
		this.password = password;
	}
	
	public ResponsabileEventoNazionale(Connection con) {
		
	}
	public String getCodiceResponsabile() {
		return this.codiceResponsabile;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getDataNascita() {
		return this.dataNascita;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public String getNumTelefono() {
		return this.numTelefono;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setCodiceResponsabile(String codiceResponsabile) {
		this.codiceResponsabile = codiceResponsabile;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
