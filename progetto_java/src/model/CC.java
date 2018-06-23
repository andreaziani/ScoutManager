package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class CC {

	private String codiceCC;
	private DBConnection con = new DBConnectionImpl();

	public CC(String codiceCC) {
		super();
		this.codiceCC = codiceCC;
	}

	public int inserisciCC() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement("insert into CC(codiceCC) VALUES(?) ");
			st.setString(1, this.codiceCC);
			result = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}

	public String getCodiceCC() {
		return codiceCC;
	}

	public void setCodiceCC(String codiceCC) {
		this.codiceCC = codiceCC;
	}

}
