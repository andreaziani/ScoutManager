package table;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class Iscritto {
	
	private String codiceIscritto;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String luogoNascita;
	private String numTelefono;
	private DBConnection con = new DBConnectionImpl();
	
	public Iscritto(String codiceIscritto, String codiceFiscale, String nome, String cognome, Date dataNascita,
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
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into ISCRITTO(codiceIscritto, CF, nome, cognome, dataNascita, luogoNascita, numeroTelefono) VALUES(?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, codiceIscritto);
			st.setString(2, codiceFiscale);
			st.setString(3, nome);
			st.setString(4, cognome);
			st.setDate(5, dataNascita);
			st.setString(6, luogoNascita);
			st.setString(7, numTelefono);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}
	
}
