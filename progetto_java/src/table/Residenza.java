package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class Residenza {
	
	private String codiceParrocchia;
	private String città;
	private DBConnection con = new DBConnectionImpl();
	
	public Residenza(String codiceParrocchia, String città) {
		this.codiceParrocchia = codiceParrocchia;
		this.città = città;
	}

	public int inserisciResidenza() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into RESIDENZA(codiceParrocchia, città) VALUES(?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.città);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getCittà() {
		return this.città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}
	
	
	
}
