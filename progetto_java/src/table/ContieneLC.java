package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ContieneLC {
	
	private String codiceLC;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public ContieneLC(String codiceLC, String codiceParrocchia) {
		super();
		this.codiceLC = codiceLC;
		this.codiceParrocchia = codiceParrocchia;
	}
	
	public int inserisciContieneLC() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into Contiene_LC(codiceParrocchia, codiceLC) VALUES(?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.codiceLC);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceLC() {
		return codiceLC;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceLC(String codiceLC) {
		this.codiceLC = codiceLC;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
