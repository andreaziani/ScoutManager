package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ContieneRS {
	
	private String codiceRS;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public ContieneRS(String codiceRS, String codiceParrocchia) {
		super();
		this.codiceRS = codiceRS;
		this.codiceParrocchia = codiceParrocchia;
	}

	public int inserisciContieneRS() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into Contiene_RS(codiceParrocchia, codiceRS) VALUES(?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.codiceRS);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceRS() {
		return codiceRS;
	}

	public String getCodiceParrocchia() {
		return codiceParrocchia;
	}

	public void setCodiceRS(String codiceRS) {
		this.codiceRS = codiceRS;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}	

}
