package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttivitàLudica {

	private String codiceAttività;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public AttivitàLudica(String codice, String descrizione) {
		this.codiceAttività = codice;
		this.descrizione = descrizione;
	}
	
	public int inserimentoAttività() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into ATT_LUDICA(codiceAttività, descrizione) VALUES(?, ?)");
			st.setString(1, codiceAttività);
			st.setString(2, descrizione);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}
}
