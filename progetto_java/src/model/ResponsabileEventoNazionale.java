package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	private DBConnection con = new DBConnectionImpl();

	public ResponsabileEventoNazionale(String codiceFiscale, String nome, String cognome,
			String dataNascita, String luogoNascita, String numTelefono, String codiceResponsabile, String username, String password) {
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

	public int inserimentoResponsabile() {
		int rs;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsed = sdf.parse(dataNascita);
	        Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RESPONSABILE_E_N(CF, nome, cognome, dataNascita, luogoNascita, numeroTelefono,"
							+ "codiceResponsabile, username, password) VALUES(?, ?, ?, ?, ?, ?, ? ,?, ?)");
			st.setString(1, codiceFiscale);
			st.setString(2, nome);
			st.setString(3, cognome);
			st.setDate(4, datesql);
			st.setString(5, luogoNascita);
			st.setString(6, numTelefono);
			st.setString(7, codiceResponsabile);
			st.setString(8, username);
			st.setString(9, password);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		} catch (ParseException e) {
			return 0;
		}
		return rs;
	}
}
