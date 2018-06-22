package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ContieneCC {
	
	private String codiceCC;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public ContieneCC(String codiceCC, String codiceParrocchia) {
		super();
		this.codiceCC = codiceCC;
		this.codiceParrocchia = codiceParrocchia;
	}
	
	public int inserisciContieneCC() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into Contiene_CC(codiceParrocchia, codiceCC) VALUES(?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.codiceCC);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceCC() {
		return codiceCC;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceCC(String codiceCC) {
		this.codiceCC = codiceCC;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
