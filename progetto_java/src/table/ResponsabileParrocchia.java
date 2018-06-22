package table;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ResponsabileParrocchia {

	private String codiceResponsabile;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String luogoNascita;
	private String numTelefono;
	private String username;
	private String password;
	private DBConnection con = new DBConnectionImpl();

	public ResponsabileParrocchia(String codiceResponsabile, String codiceFiscale, String nome, String cognome,
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

	public int registrazioneResponsabile() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int result;
		try {
			java.util.Date parsed = sdf.parse(this.dataNascita);
			Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RESPONSABILE_P(codiceResponsabile, CF, nome, cognome, dataNascita, luogoNascita, numeroTelefono,"
							+ "username, password) VALUES(?, ?, ?, ?, ?, ?, ? ,?, ?) ");
			st.setString(1, this.codiceResponsabile);
			st.setString(2, this.codiceFiscale);
			st.setString(3, this.nome);
			st.setString(4, this.cognome);
			st.setDate(5, datesql);
			st.setString(6, this.luogoNascita);
			st.setString(7, this.numTelefono);
			st.setString(8, this.username);
			st.setString(9, this.password);
			result = st.executeUpdate();
		} catch (SQLException | ParseException e) {
			return 0;
		}
		return result;
	}

	public int modificaResponsabile() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int result;
		try {
			java.util.Date parsed = sdf.parse(this.dataNascita);
			Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"update RESPONSABILE_P set CF = ?, nome = ?, cognome = ?, dataNascita = ?, luogoNascita = ?, numeroTelefono = ?, username = ?, password = ? where codiceResponsabile = ?");
			st.setString(1, this.codiceFiscale);
			st.setString(2, this.nome);
			st.setString(3, this.cognome);
			st.setDate(4, datesql);
			st.setString(5, this.luogoNascita);
			st.setString(6, this.numTelefono);
			st.setString(7, this.username);
			st.setString(8, this.password);
			st.setString(9, this.codiceResponsabile);
			result = st.executeUpdate();
			st.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			return 0;
		}
		return result;
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
