package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class AttivitàFormativa{

	private String codiceAttività;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public AttivitàFormativa(String codice, String descrizione) {
		this.codiceAttività = codice;
		this.descrizione = descrizione;
	}

	public int inserimentoAttività() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into ATT_FORMATIVA(codiceAttività, descrizione) VALUES(?, ?)");
			st.setString(1, codiceAttività);
			st.setString(2, descrizione);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}

}
