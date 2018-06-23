package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ContieneEG {
	
	private String codiceEG;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public ContieneEG(String codiceEG, String codiceParrocchia) {
		super();
		this.codiceEG = codiceEG;
		this.codiceParrocchia = codiceParrocchia;
	}

	public int inserisciContieneEG() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into Contiene_EG(codiceParrocchia, codiceEG) VALUES(?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.codiceEG);
			result = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	public String getCodiceEG() {
		return codiceEG;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
