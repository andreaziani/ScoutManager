package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class AttivitàLudica {

	private String codiceAttività;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public AttivitàLudica(String codice, String descrizione) {
		this.codiceAttività = codice;
		this.descrizione = descrizione;
	}
	
	public int inserimentoAttività() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into ATT_LUDICA(codiceAttività, descrizione) VALUES(?, ?)");
			st.setString(1, codiceAttività);
			st.setString(2, descrizione);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
}
