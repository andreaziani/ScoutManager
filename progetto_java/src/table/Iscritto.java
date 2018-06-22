package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class Iscritto {
	
	private String codiceIscritto;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String luogoNascita;
	private String numTelefono;
	private DBConnection con = new DBConnectionImpl();
	
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

	public int registrazioneIscritto() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into ISCRITTO(codiceIscritto, codiceFiscale, nome, cognome, dataNascita, luogoNascita, numeroTelefono) VALUES(?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, codiceIscritto);
			st.setString(2, codiceFiscale);
			st.setString(3, nome);
			st.setString(4, cognome);
			st.setString(5, dataNascita);
			st.setString(6, luogoNascita);
			st.setString(7, numTelefono);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
	
}
