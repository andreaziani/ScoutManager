package table;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class RegistrazioneParrocchiaEResponsabile {
	Parrocchia parr;
	ResponsabileParrocchia res;
	DBConnection con = new DBConnectionImpl();
	public RegistrazioneParrocchiaEResponsabile(ResponsabileParrocchia res, Parrocchia parr){
		this.parr = parr;
		this.res = res;
	}
	
	public int inserimentoParrocchiaEResponsabile() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date parsed = sdf.parse(res.getDataNascita());
	        Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RESPONSABILE_P(codiceResponsabile, CF, nome, cognome, dataNascita, luogoNascita, numeroTelefono,"
							+ "username, password) VALUES(?, ?, ?, ?, ?, ?, ? ,?, ?) "
							+ "insert into PARROCCHIA(codiceParrocchia, nome, Ind_via, Ind_numCivico) VALUES (?, ?, ? ,?)"
							+ "insert into RS(codiceRS, da, a) values(?, 16, 20) + "); // TODO COMPLETE QUERY.
			st.setString(1, res.getCodiceResponsabile());
			st.setString(2, res.getCodiceFiscale());
			st.setString(3, res.getNome());
			st.setString(4, res.getCognome());
			st.setDate(5, datesql);
			st.setString(6, res.getLuogoNascita());
			st.setString(7, res.getNumTelefono());
			st.setString(8, res.getUsername());
			st.setString(9, res.getPassword());
			st.setString(10, parr.getCodiceParrocchia());
			st.setString(11, parr.getNome());
			st.setString(12, parr.getIndirizzo());
			st.setString(13, parr.getNumeroCivico());
			return st.executeUpdate();
		} catch (SQLException | ParseException e) {
			return 0;
		}
		
	}
}
