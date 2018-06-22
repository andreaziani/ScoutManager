package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class LC {

	private String codiceLC;
	private DBConnection con = new DBConnectionImpl();
	
	public LC(String codiceLC) {
		super();
		this.codiceLC = codiceLC;

	}

	public int inserisciLC() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into LC(codiceLC) VALUES(?) ");
			st.setString(1, this.codiceLC);
			result = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceLC() {
		return codiceLC;
	}

	public void setCodiceLC(String codiceLC) {
		this.codiceLC = codiceLC;
	}
	
}
