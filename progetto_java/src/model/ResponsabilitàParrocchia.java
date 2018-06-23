package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResponsabilitàParrocchia {
	
	private String codiceParrocchia;
	private String codiceResponasbile;
	private DBConnection con = new DBConnectionImpl();
	public ResponsabilitàParrocchia(String codiceParrocchia, String codiceResponasbile) {
		this.codiceParrocchia = codiceParrocchia;
		this.codiceResponasbile = codiceResponasbile;
	}
	public int inserisciResponsabilitàParrocchia() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"insert into REsponsabilità_Parrocchia(codiceResponsabile, codiceParrocchia) VALUES(?, ?) ");
			st.setString(1, this.codiceResponasbile);
			st.setString(2, this.codiceParrocchia);
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getCodiceResponasbile() {
		return this.codiceResponasbile;
	}

	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setCodiceResponasbile(String codiceResponasbile) {
		this.codiceResponasbile = codiceResponasbile;
	}
	
	
	
	
	
	

}
